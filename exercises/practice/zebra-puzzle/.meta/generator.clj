(ns zebra-puzzle-generator
  (:require [hbs.helper :refer [safe-str]]
            [clojure.string :as str]))

(defn update-test-case [test-case]
  (update test-case :expected #(safe-str (str/lower-case (keyword %)))))
