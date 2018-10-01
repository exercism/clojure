(ns go-counting-test
  (:require [clojure.test :refer [deftest is]]
            [go-counting :as g]))

(def example
  ["  B  "
   " B B "
   "B W B"
   " W W "
   "  W  "])

(deftest territory
  (is (= (g/territory example [0 1])
         {:stones #{[0 0] [0 1] [1 0]} :owner :black}))
  (is (= (g/territory example [2 3])
         {:stones #{[2 3]} :owner :white}))
  (is (= (g/territory example [1 4])
         {:stones #{[0 3] [0 4] [1 4]} :owner nil}))
  (is (= (g/territory example [1 1])
         {:stones #{} :owner nil}))
  (is (thrown? Throwable (g/territory example [-1 1])))
  (is (thrown? Throwable (g/territory example [5 1])))
  (is (thrown? Throwable (g/territory example [1 -1])))
  (is (thrown? Throwable (g/territory example [1 5]))))

(deftest territories
  (is (= (g/territories [" "])
         {:black-territory #{}
          :white-territory #{}
          :null-territory  #{[0 0]}}))
  (is (= (g/territories [" BW " " BW "])
         {:black-territory #{[0 0] [0 1]}
          :white-territory #{[3 0] [3 1]}
          :null-territory  #{}}))
  (is (= (g/territories [" B "])
         {:black-territory #{[0 0] [2 0]}
          :white-territory #{}
          :null-territory  #{}})))
