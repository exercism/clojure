(ns anagram-test
  (:require [clojure.test :refer [deftest testing is]]
            anagram))

(deftest no-matches
  (testing "No matches"
    (is (= []
           (anagram/anagrams-for "diaper" ["hello" "world" "zombies" "pants"])))))

(deftest detects-two-anagrams
  (testing "Detects two anagrams"
    (is (= ["lemons", "melons"]
           (anagram/anagrams-for "solemn" ["lemons", "cherry", "melons"])))))

(deftest does-not-detect-anagram-subsets
  (testing "Does not detect anagram subsets"
    (is (= []
           (anagram/anagrams-for "good" ["dog", "goody"])))))

(deftest detects-anagram
  (testing "Detects anagram"
    (is (= ["inlets"]
           (anagram/anagrams-for "listen" ["enlists", "google", "inlets", "banana"])))))

(deftest detects-three-anagrams
  (testing "Detects three anagrams"
    (is (= ["gallery", "regally", "largely"]
           (anagram/anagrams-for "allergy" ["gallery", "ballerina", "regally", "clergy", "largely", "leading"])))))

(deftest detects-multiple-anagrams-with-different-case
  (testing "Detects multiple anagrams with different case"
    (is (= ["Eons", "ONES"]
           (anagram/anagrams-for "nose" ["Eons", "ONES"])))))

(deftest does-not-detect-non-anagrams-with-identical-checksum
  (testing "Does not detect non-anagrams with identical checksum"
    (is (= []
           (anagram/anagrams-for "mass" ["last"])))))

(deftest detects-anagrams-case-insensitively
  (testing "Detects anagrams case-insensitively"
    (is (= ["Carthorse"]
           (anagram/anagrams-for "Orchestra" ["cashregister", "Carthorse", "radishes"])))))

(deftest detects-anagrams-using-case-insensitive-subject
  (testing "Detects anagrams using case-insensitive subject"
    (is (= ["carthorse"]
           (anagram/anagrams-for "Orchestra" ["cashregister", "carthorse", "radishes"])))))

(deftest detects-anagrams-using-case-insensitive-possible-matches
  (testing "Detects anagrams using case-insensitive possible matches"
    (is (= ["Carthorse"]
           (anagram/anagrams-for "orchestra" ["cashregister", "Carthorse", "radishes"])))))

(deftest does-not-detect-anagram-if-original-word-is-repeated
  (testing "Does not detect an anagram if the original word is repeated"
    (is (= []
           (anagram/anagrams-for "go" ["goGoGO"])))))

(deftest anagrams-must-use-all-letters-exactly-once
  (testing "Anagrams must use all letters exactly once"
    (is (= []
           (anagram/anagrams-for "tapper" ["patter"])))))

(deftest words-are-not-anagrams-of-themselves
  (testing "Words are not anagrams of themselves"
    (is (= []
           (anagram/anagrams-for "BANANA" ["BANANA"])))))

(deftest words-are-not-anagrams-of-themselves-even-if-letter-case-is-partially-different
  (testing "Words are not anagrams of themselves even if letter case is partially different"
    (is (= []
           (anagram/anagrams-for "BANANA" ["Banana"])))))

(deftest words-are-not-anagrams-of-themselves-even-if-letter-case-is-completely-different
  (testing "Words are not anagrams of themselves even if letter case is completely different"
    (is (= []
           (anagram/anagrams-for "BANANA" ["banana"])))))

(deftest words-other-than-themselves-can-be-anagrams
  (testing "Words other than themselves can be anagrams"
    (is (= ["Silent"]
           (anagram/anagrams-for "LISTEN" ["LISTEN", "Silent"])))))

(deftest handles-greek-letters
  (testing "Handles case of greek letters"
    (is (= ["ΒΓΑ", "γβα"]
           (anagram/anagrams-for "ΑΒΓ" ["ΒΓΑ", "ΒΓΔ", "γβα", "αβγ"])))))

(deftest different-characters-may-have-same-bytes
  (testing "Different characters may have the same bytes"
    (is (= []
           (anagram/anagrams-for "a⬂" ["€a"])))))
