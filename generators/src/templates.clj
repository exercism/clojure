(ns templates
  (:require [hbs.core :refer [*hbs* render]]
            [hbs.helper :refer [defhelper register-helper! block-body else-body]]
            [hbs.ext :refer :all :exclude [hash]]
            [clojure.string :as str]
            [log]
            [paths])
  (:import [com.github.jknack.handlebars Formatter EscapingStrategy]))

(defn format-string [s _next]
  (str "\"" (str/escape s char-escape-string) "\""))

(defn format-list [coll next]
  (let [formatted-elements (str/join " " (map #(. next format %) coll))]
    (str "'(" formatted-elements ")")))

(defn formatter [test conv]
  (proxy [Formatter] []
    (format [value next]
      (if (test value)
        (conv value next)
        (. next format value)))))

(def reg
  (-> *hbs*
      (. with (formatter list? format-list))
      (. with (formatter string? format-string))
      (. with EscapingStrategy/NOOP)))

(defhelper ifzero [ctx options]
  (if (zero? ctx)
    (block-body options ctx)
    (else-body options ctx)))

(register-helper! reg "ifequals" ifequals)
(register-helper! reg "ifgreater" ifgreater)
(register-helper! reg "ifless" ifless)
(register-helper! reg "ifcontains" ifcontains)
(register-helper! reg "ifempty" ifempty)
(register-helper! reg "ifzero" ifzero)

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
