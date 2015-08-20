(defproject xclojure "0.1.0"
  :description  "Exercism Exercises in Clojure"
  :url          "https://github.com/exercism/xclojure"
  :test-paths   ["_test"]
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [cheshire            "5.5.0"]]
  :plugins      [[lein-exec           "0.3.5"]]
  :aliases      {"test" ["exec" "_test/check_exercises.clj"]})
