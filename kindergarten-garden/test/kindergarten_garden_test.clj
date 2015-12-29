(ns kindergarten-garden-test
  (:require [clojure.test :refer [deftest is]]
            kindergarten-garden))

(deftest garden-test
  (is (= [:radishes :clover :grass :grass]
         (:alice (kindergarten-garden/garden "RC\nGG"))))
  (is (= [:violets :clover :radishes :clover]
         (:alice (kindergarten-garden/garden "VC\nRC")))))

(deftest small-garden-test
  (let [small-garden (kindergarten-garden/garden "VVCG\nVVRC")]
    (is (= [:clover :grass :radishes :clover] (:bob small-garden)))))

(deftest medium-garden-test
  (let [medium-garden (kindergarten-garden/garden "VVCCGG\nVVCCGG")]
    (is (= [:clover :clover :clover :clover] (:bob medium-garden)))
    (is (= [:grass :grass :grass :grass] (:charlie medium-garden)))))

(deftest full-garden-test
  (let [string "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV"
        full-garden (kindergarten-garden/garden string)]
    (is (= [:violets  :radishes :violets  :radishes] (:alice   full-garden)))
    (is (= [:clover   :grass    :clover   :clover]   (:bob     full-garden)))
    (is (= [:violets  :violets  :clover   :grass]    (:charlie full-garden)))
    (is (= [:radishes :violets  :clover   :radishes] (:david   full-garden)))
    (is (= [:clover   :grass    :radishes :grass]    (:eve     full-garden)))
    (is (= [:grass    :clover   :violets  :clover]   (:fred    full-garden)))
    (is (= [:clover   :grass    :grass    :clover]   (:ginny   full-garden)))
    (is (= [:violets  :radishes :radishes :violets]  (:harriet full-garden)))
    (is (= [:grass    :clover   :violets  :clover]   (:ileana  full-garden)))
    (is (= [:violets  :clover   :violets  :grass]    (:joseph  full-garden)))
    (is (= [:grass    :clover   :clover   :grass]    (:kincaid full-garden)))
    (is (= [:grass    :violets  :clover   :violets]  (:larry   full-garden)))))

(deftest surprise-garden-test
  (let [string   "VCRRGVRG\nRVGCCGCV"
        students ["Samantha" "Patricia" "Xander" "Roger"]
        surprise-garden (kindergarten-garden/garden string students)]
    (is (= [:violets  :clover   :radishes :violets]
           (:patricia surprise-garden)))
    (is (= [:radishes :radishes :grass    :clover]
           (:roger    surprise-garden)))
    (is (= [:grass    :violets  :clover   :grass]
           (:samantha surprise-garden)))
    (is (= [:radishes :grass    :clover   :violets]
           (:xander   surprise-garden)))))
