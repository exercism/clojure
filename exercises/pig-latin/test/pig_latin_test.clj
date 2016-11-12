(ns pig-latin-test
  (:require [clojure.test :refer [deftest is]]
            pig-latin))

;; ay is added to words that start with vowels

(deftest word-beginning-with-a
  (is (= "appleay"
         (pig-latin/translate "apple"))))

(deftest word-beginning-with-e
  (is (= "earay"
         (pig-latin/translate "ear"))))

(deftest word-beginning-with-i
  (is (= "iglooay"
         (pig-latin/translate "igloo"))))

(deftest word-beginning-with-o
  (is (= "objectay"
         (pig-latin/translate "object"))))

(deftest word-beginning-with-u
  (is (= "underay"
         (pig-latin/translate "under"))))

(deftest word-beginning-with-a-vowel-and-followed-by-a-qu
  (is (= "equalay"
         (pig-latin/translate "equal"))))

;; first letter and ay are moved to the end of words that start with consonants

(deftest word-beginning-with-p
  (is (= "igpay"
       (pig-latin/translate "pig"))))

(deftest word-beginning-with-k
  (is (= "oalakay"
       (pig-latin/translate "koala"))))

(deftest word-beginning-with-y
  (is (= "ellowyay"
       (pig-latin/translate "yellow"))))

(deftest word-beginning-with-x
  (is (= "enonxay"
       (pig-latin/translate "xenon"))))

(deftest word-beginning-with-q-without-a-following-u
  (is (= "atqay"
         (pig-latin/translate "qat"))))

;; some letter clusters are treated like a single consonant

(deftest word-beginning-with-ch
  (is (= "airchay"
       (pig-latin/translate "chair"))))

(deftest word-beginning-with-qu
  (is (= "eenquay"
       (pig-latin/translate "queen"))))

(deftest word-beginning-with-qu-and-a-preceding-consonant
  (is (= "aresquay"
       (pig-latin/translate "square"))))

(deftest word-beginning-with-th
  (is (= "erapythay"
       (pig-latin/translate "therapy"))))

(deftest word-beginning-with-thr
  (is (= "ushthray"
       (pig-latin/translate "thrush"))))

(deftest word-beginning-with-sch
  (is (= "oolschay"
       (pig-latin/translate "school"))))

;;  some letter clusters are treated like a single vowel

(deftest word-beginning-with-yt
  (is (= "yttriaay"
       (pig-latin/translate "yttria"))))

(deftest word-beginning-with-xr
  (is (= "xrayay"
       (pig-latin/translate "xray"))))

;; phrases are translated
(deftest a-whole-phrase
  (is (= "ickquay astfay unray"
       (pig-latin/translate "quick fast run"))))
