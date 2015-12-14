(ns check-exercises
  (:require [cheshire.core :as json]
            [clojure.string :as string]
            [clojure.test :refer :all]))

(deftest check-exercises
  (doseq [problem (-> (slurp "config.json") (json/parse-string true) :problems)
          :let [str-problem #(apply str problem %&)]]
    (load-file (str-problem "/example.clj"))
    (load-file (str-problem "/" (string/replace problem \- \_) "_test.clj"))
    (is (successful? (run-tests (symbol (str-problem "-test")))))))
