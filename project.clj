(defproject clojure "0.1.0"
  :description  "Exercism Exercises in Clojure"
  :url          "https://github.com/exercism/clojure"
  :test-paths   ["_test"]
  :source-paths ["_src"]
  :aliases {"generate" ["run" "-m" "generator"]}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [cheshire            "5.5.0"]
                 [stencil             "0.5.0"]])
