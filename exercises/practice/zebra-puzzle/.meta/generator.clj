(ns zebra-puzzle-generator
  (:require [hbs.helper :refer [safe-str]]
            [clojure.string :as str]))

(defn transform-test-case [test-case]
  (update test-case :expected #(safe-str (str/lower-case (str ":" %)))))
