(ns templates
  (:require [hbs.core :refer [*hbs* render]]
            [hbs.helper :refer [defhelper register-helper! block-body else-body]]
            [hbs.ext :refer :all :exclude [hash]]
            [clojure.string :as str]
            [log]
            [paths]
            [formatting])
  (:import [com.github.jknack.handlebars EscapingStrategy]))

(def reg
  (-> *hbs*
      (. with (formatting/formatter set? formatting/format-set))
      (. with (formatting/formatter list? formatting/format-list))
      (. with (formatting/formatter string? formatting/format-string))
      (. with (formatting/formatter char? formatting/format-char))
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

(defn- load-generator-ns [slug]
  (let [transform-file (paths/generator-clojure-file slug)]
    (when (.exists transform-file)
      (let [generator-ns (symbol (str slug "-generator"))]
        (load-file (str transform-file))
        generator-ns))))

(defn- transform [generator-ns test-cases]
  (if generator-ns
    (->> test-cases
         (add-remove-test-cases generator-ns)
         (update-test-cases generator-ns))
    test-cases))

(defn- test-cases->data [generator-ns test-cases]
  (let [transformed (transform generator-ns test-cases)
        grouped (group-by :property transformed)
        data (update-vals grouped #(map-indexed test-case->data %))]
    {:test_cases data}))

(defn template [slug]
  (->> slug
       (paths/generator-template-file)
       (slurp)
       (str/trim-newline)))

(defn format-code [generator-ns code]
  (if-let [skip-formatting-var (ns-resolve generator-ns (symbol "skip-formatting"))]
    (if (true? (deref skip-formatting-var))
      code
      (formatting/format-code code))
    (formatting/format-code code)))

(defn generate-test-files [slug test-cases]
  (let [generator-ns (load-generator-ns slug)]
    (->> test-cases
         (test-cases->data generator-ns)
         (render reg (template slug))
         (format-code generator-ns)
         (spit (paths/tests-file slug)))))
