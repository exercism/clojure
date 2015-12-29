(import java.io.File)

(require '[cheshire.core      :as    json]
         '[clojure.java.io    :as    io]
         '[clojure.java.shell :refer [sh with-sh-dir]]
         '[clojure.string     :as    string])

(doseq [problem ((json/parse-string (slurp "config.json")) "problems")]
  (with-sh-dir problem
    (sh "mkdir" "-p" "src" "test")
    (sh "sh" "-c" "mv *_test.clj test")
    (sh "sh" "-c" "mv example.clj src"))
  (sh "sh" "-c" "gsed -i '/\\(source\\|test\\)-paths/d' */project.clj"))
