(ns pig-latin-test
  (:require [clojure.test :refer [deftest testing is]]
            pig-latin))

(deftest translate_test_1
  (testing "ay is added to words that start with vowels ▶ word beginning with a"
    (is (= "appleay" (pig-latin/translate "apple")))))

(deftest translate_test_2
  (testing "ay is added to words that start with vowels ▶ word beginning with e"
    (is (= "earay" (pig-latin/translate "ear")))))

(deftest translate_test_3
  (testing "ay is added to words that start with vowels ▶ word beginning with i"
    (is (= "iglooay" (pig-latin/translate "igloo")))))

(deftest translate_test_4
  (testing "ay is added to words that start with vowels ▶ word beginning with o"
    (is (= "objectay" (pig-latin/translate "object")))))

(deftest translate_test_5
  (testing "ay is added to words that start with vowels ▶ word beginning with u"
    (is (= "underay" (pig-latin/translate "under")))))

(deftest translate_test_6
  (testing "ay is added to words that start with vowels ▶ word beginning with a vowel and followed by a qu"
    (is (= "equalay" (pig-latin/translate "equal")))))

(deftest translate_test_7
  (testing "first letter and ay are moved to the end of words that start with consonants ▶ word beginning with p"
    (is (= "igpay" (pig-latin/translate "pig")))))

(deftest translate_test_8
  (testing "first letter and ay are moved to the end of words that start with consonants ▶ word beginning with k"
    (is (= "oalakay" (pig-latin/translate "koala")))))

(deftest translate_test_9
  (testing "first letter and ay are moved to the end of words that start with consonants ▶ word beginning with x"
    (is (= "enonxay" (pig-latin/translate "xenon")))))

(deftest translate_test_10
  (testing "first letter and ay are moved to the end of words that start with consonants ▶ word beginning with q without a following u"
    (is (= "atqay" (pig-latin/translate "qat")))))

(deftest translate_test_11
  (testing "first letter and ay are moved to the end of words that start with consonants ▶ word beginning with consonant and vowel containing qu"
    (is (= "iquidlay" (pig-latin/translate "liquid")))))

(deftest translate_test_12
  (testing "some letter clusters are treated like a single consonant ▶ word beginning with ch"
    (is (= "airchay" (pig-latin/translate "chair")))))

(deftest translate_test_13
  (testing "some letter clusters are treated like a single consonant ▶ word beginning with qu"
    (is (= "eenquay" (pig-latin/translate "queen")))))

(deftest translate_test_14
  (testing "some letter clusters are treated like a single consonant ▶ word beginning with qu and a preceding consonant"
    (is (= "aresquay" (pig-latin/translate "square")))))

(deftest translate_test_15
  (testing "some letter clusters are treated like a single consonant ▶ word beginning with th"
    (is (= "erapythay" (pig-latin/translate "therapy")))))

(deftest translate_test_16
  (testing "some letter clusters are treated like a single consonant ▶ word beginning with thr"
    (is (= "ushthray" (pig-latin/translate "thrush")))))

(deftest translate_test_17
  (testing "some letter clusters are treated like a single consonant ▶ word beginning with sch"
    (is (= "oolschay" (pig-latin/translate "school")))))

(deftest translate_test_18
  (testing "some letter clusters are treated like a single vowel ▶ word beginning with yt"
    (is (= "yttriaay" (pig-latin/translate "yttria")))))

(deftest translate_test_19
  (testing "some letter clusters are treated like a single vowel ▶ word beginning with xr"
    (is (= "xrayay" (pig-latin/translate "xray")))))

(deftest translate_test_20
  (testing "position of y in a word determines if it is a consonant or a vowel ▶ y is treated like a consonant at the beginning of a word"
    (is (= "ellowyay" (pig-latin/translate "yellow")))))

(deftest translate_test_21
  (testing "position of y in a word determines if it is a consonant or a vowel ▶ y is treated like a vowel at the end of a consonant cluster"
    (is (= "ythmrhay" (pig-latin/translate "rhythm")))))

(deftest translate_test_22
  (testing "position of y in a word determines if it is a consonant or a vowel ▶ y as second letter in two letter word"
    (is (= "ymay" (pig-latin/translate "my")))))

(deftest translate_test_23
  (testing "phrases are translated ▶ a whole phrase"
    (is (= "ickquay astfay unray" (pig-latin/translate "quick fast run")))))
