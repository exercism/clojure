(ns rotational-cipher-test
  (:require  [clojure.test :refer [deftest is testing]]
             rotational-cipher))

(deftest rotate-a-by-1
  (is (= (rotational-cipher/rotate "a" 1) "b")))

(deftest rotate-a-by-26-same-output
  (is (= (rotational-cipher/rotate "a" 26) "a")))

(deftest rotate-a-by-0-same-output
  (is (= (rotational-cipher/rotate "a" 0) "a")))

(deftest rotate-m-by-13
  (is (= (rotational-cipher/rotate "m" 13) "z")))

(deftest rotate-n-by-13-with-wrap
  (is (= (rotational-cipher/rotate "n" 13) "a")))

(deftest rotate-capital-letters
  (is (= (rotational-cipher/rotate "OMG" 5) "TRL")))

(deftest rotate-spaces
  (is (= (rotational-cipher/rotate "O M G" 5) "T R L")))

(deftest rotate-numbers
  (is (= (rotational-cipher/rotate "Testing 1 2 3 testing" 4) "Xiwxmrk 1 2 3 xiwxmrk")))

(deftest rotate-punctuation
  (is (= (rotational-cipher/rotate "Let's eat, Grandma!" 21) "Gzo'n zvo, Bmviyhv!")))

(deftest rotate-opposite-direction
  (is (= (rotational-cipher/rotate "b" -1) "a")))

(deftest rotate-opposite-past-first-letter
  (is (= (rotational-cipher/rotate "B" -2) "Z")))

(deftest rotate-opposite-past-letter-count
  (is (= (rotational-cipher/rotate "B" -28) "Z")))

(deftest rotate-forward-then-backwards-same-number-of-steps
  (is (=  (rotational-cipher/rotate
           (rotational-cipher/rotate "B" 28) -28) "B")))

(deftest rotate-all-letters
  (is (= (rotational-cipher/rotate "The quick brown fox jumps over the lazy dog." 13) "Gur dhvpx oebja sbk whzcf bire gur ynml qbt.")))
