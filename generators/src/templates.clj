(ns templates
  (:require [hbs.core :refer [*hbs* render]]
            [hbs.helper :refer [defhelper register-helper! block-body else-body]]
            [hbs.ext :refer :all :exclude [hash]]
            [clojure.string :as str]
            [log]
            [paths]
            [formatting])
  (:import [com.github.jknack.handlebars Formatter EscapingStrategy]))

(defn format-string [s _next]
  (str "\"" (str/escape s char-escape-string) "\""))

(defn format-collection [coll next open close]
  (let [formatted-elements (str/join " " (map #(. next format %) coll))]
    (str open formatted-elements close)))

(defn format-list [coll next]
  (format-collection coll next "'(" ")"))

(defn format-set [coll next]
  (format-collection coll next "#{" "}"))

(defn formatter [test conv]
  (proxy [Formatter] []
    (format [value next]
      (if (test value)
        (conv value next)
        (. next format value)))))

(def reg
  (-> *hbs*
      (. with (formatter set? format-set))
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
             :description (str/join " ▶ " (:path node))
             :error (get-in node [:expected :error]))
      (dissoc :reimplements :comments :scenarios)))

(defn- add-remove-test-cases [generator-ns test-cases]
  (if-let [add-remove-test-cases-fn (ns-resolve generator-ns (symbol "add-remove-test-cases"))]
    (add-remove-test-cases-fn test-cases)
    test-cases))

(defn- update-test-cases [generator-ns test-cases]
  (if-let [update-test-case-fn (ns-resolve generator-ns (symbol "update-test-case"))]
    (mapv update-test-case-fn test-cases)
    test-cases))

(defn- transform [slug test-cases]
  (let [transform-file (paths/generator-clojure-file slug)]
    (if (.exists transform-file)
      (let [generator-ns (symbol (str slug "-generator"))]
        (load-file (str transform-file))
        (->> test-cases
             (add-remove-test-cases generator-ns)
             (update-test-cases generator-ns)))
      test-cases)))

(defn- test-cases->data [slug test-cases]
  (let [transformed (transform slug test-cases)
        grouped (group-by :property transformed)
        data (update-vals grouped #(map-indexed test-case->data %))]
    {:test_cases data}))

(defn template [slug]
  (->> slug
       (paths/generator-template-file)
       (slurp)
       (str/trim-newline)))

(defn generate-test-files [slug test-cases]
  (->> (test-cases->data slug test-cases)
       (render reg (template slug))
       (formatting/format-code)
       (spit (paths/tests-file slug))))
