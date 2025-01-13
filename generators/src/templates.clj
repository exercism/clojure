(ns templates
  (:require [hbs.core :refer [*hbs* render]]
            [hbs.helper :refer [defhelper register-helper! safe-str]]
            [hbs.ext :refer :all :exclude [hash]]
            [clojure.string :as str]
            [log]
            [paths])
  (:import [com.github.jknack.handlebars EscapingStrategy]))

(defhelper list-helper [ctx options]
  (let [s (seq ctx)]
    (safe-str (str "'" (if (empty? s) "()" s)))))

(defhelper string-helper [ctx options]
  (safe-str (str "\"" (str/escape ctx char-escape-string) "\"")))

(def reg (. *hbs* with EscapingStrategy/NOOP))

(register-helper! reg "list" list-helper)
(register-helper! reg "string" string-helper)
(register-helper! reg "ifequals" ifequals)
(register-helper! reg "ifgreater" ifgreater)
(register-helper! reg "ifless" ifless)
(register-helper! reg "ifcontains" ifcontains)
(register-helper! reg "ifempty" ifempty)

(def exercises-with-template
  (->> paths/exercises-dir
       (file-seq)
       (filter #(.isFile %))
       (filter #(= "generator.tpl" (.getName %)))
       (map #(-> % (.getParentFile) (.getParentFile) (.getName)))
       (set)))

(defn- test-case->data [idx node]
  (-> node
      (assoc :idx (inc idx)
             :description (str/join " - " (:path node))
             :error (get-in node [:expected :error]))
      (dissoc :reimplements :comments :scenarios)))

(defn- transform [slug test-cases]
  (let [transform-file (paths/generator-clojure-file slug)]
    (if (.exists transform-file)
      (let [generator-ns (symbol (str slug "-generator"))]
        (load-file (str transform-file))
        (if-let [transform-fn (ns-resolve generator-ns (symbol "transform"))]
          (transform-fn test-cases)
          test-cases))
      test-cases)))

(defn- test-cases->data [slug test-cases]
  (let [transformed (transform slug test-cases)
        grouped (group-by :property transformed)
        data (update-vals grouped #(map-indexed test-case->data %))]
    {:test_cases data}))

(defn generate-test-files [slug test-cases]
  (let [template (slurp (paths/generator-template-file slug))
        data (test-cases->data slug test-cases)]
    (->> (render reg template data)
         (spit (paths/tests-file slug)))))
