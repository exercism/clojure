(ns isogram-test
  (:require [clojure.test :refer [deftest is]]
            isogram))

(deftest test-isograms
  (is (isogram/isogram? "duplicates"))
  (is (isogram/isogram? "subdermatoglyphic"))
  (is (isogram/isogram? "thumbscrew-japingly"))
  (is (isogram/isogram? "Hjelmqvist-Gryb-Zock-Pfund-Wax"))
  (is (isogram/isogram? "Heizölrückstoßabdämpfung"))
  (is (isogram/isogram? "Emily Jung Schwartzkopf")))

(deftest test-non-isograms
  (is (not (isogram/isogram? "eleven")))
  (is (not (isogram/isogram? "Alphabet")))
  (is (not (isogram/isogram? "the quick brown fox")))
  (is (not (isogram/isogram? "éléphant"))))
