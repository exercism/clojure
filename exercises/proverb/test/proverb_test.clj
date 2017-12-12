(ns proverb-test
  (:require [clojure.test :refer [deftest is]]
            [proverb :refer [proverb]]
            [clojure.string :as str]))

(deftest full-text-is-correct
  (is (= proverb
         (str/join "\n" ["For want of a nail the shoe was lost."
                         "For want of a shoe the horse was lost."
                         "For want of a horse the rider was lost."
                         "For want of a rider the message was lost."
                         "For want of a message the battle was lost."
                         "For want of a battle the kingdom was lost."
                         "And all for the want of a horseshoe nail."]))))
