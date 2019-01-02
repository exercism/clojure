(ns rotational-cipher-test
  (:require  [clojure.test :refer [deftest is testing]]
             rotational-cipher))

(deftest rotational-cipher-test
  (testing "rotate a by 1"
    (is (= (rotational-cipher/rotate "a" 1) "b")))

  (testing "rotate a by 26, same output as input"
    (is (= (rotational-cipher/rotate "a" 26) "a")))

  (testing "rotate a by 0, same output as input"
    (is (= (rotational-cipher/rotate "a" 0) "a")))

  (testing "rotate m by 13"
    (is (= (rotational-cipher/rotate "m" 13) "z")))

  (testing "rotate n by 13 with wrap around alphabet"
    (is (= (rotational-cipher/rotate "n" 13) "a")))

  (testing "rotate capital letters"
    (is (= (rotational-cipher/rotate "OMG" 5) "TRL")))

  (testing "rotate spaces"
    (is (= (rotational-cipher/rotate "O M G" 5) "T R L")))

  (testing "rotate numbers"
    (is (= (rotational-cipher/rotate "Testing 1 2 3 testing" 4) "Xiwxmrk 1 2 3 xiwxmrk")))

  (testing "rotate punctuation"
    (is (= (rotational-cipher/rotate "Let's eat, Grandma!" 21) "Gzo'n zvo, Bmviyhv!")))

  (testing "rotate in the opposite direction"
    (is (= (rotational-cipher/rotate "b" -1) "a")))

  (testing "rotate in the opposite direction past first letter"
    (is (= (rotational-cipher/rotate "B" -2) "Z")))

  (testing "rotate in the opposite direction past letter count"
    (is (= (rotational-cipher/rotate "B" -28) "Z")))

  (testing "rotate forward then backwards the same number of steps"
    (is (=  (rotational-cipher/rotate
             (rotational-cipher/rotate "B" 28) -28) "B")))

  (testing "rotate all letters"
    (is (= (rotational-cipher/rotate "The quick brown fox jumps over the lazy dog." 13) "Gur dhvpx oebja sbk whzcf bire gur ynml qbt."))))
