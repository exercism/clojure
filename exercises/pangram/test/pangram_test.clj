(ns pangram-test
  (:require [clojure.test :refer [is deftest]]
            [pangram :refer [pangram?]]))

(deftest empty-sentence
  (is (false? (pangram? ""))))

(deftest lowercase-pangram
  (is (pangram? "the quick brown fox jumps over the lazy dog")))

(deftest missing-character-x
  (is
   (false?
    (pangram? "a quick movement of the enemy will jeopardize five gunboats"))))

(deftest another-missing-character-x
  (is
   (false?
    (pangram? "the quick brown fish jumps over the lazy dog"))))

(deftest with-underscores
  (is (pangram? "the_quick_brown_fox_jumps_over_the_lazy_dog")))

(deftest with-numbers
  (is (pangram? "the 1 quick brown fox jumps over the 2 lazy dogs")))

(deftest missing-letters-replaced-by-numbers
  (is
   (false?
    (pangram? "7h3 qu1ck brown fox jumps ov3r 7h3 lazy dog"))))

(deftest mixed-case-and-punctuation
  (is (pangram? "\"Five quacking Zephyrs jolt my wax bed.\"")))

(deftest non-ascii-characters
  (is (pangram?
       "Victor jagt zwölf Boxkämpfer quer über den großen Sylter Deich.")))
