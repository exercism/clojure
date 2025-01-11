(ns kindergarten-garden-test
  (:require [clojure.test :refer [deftest testing is]]
            kindergarten-garden))

(deftest garden_test_1
  (testing "partial garden -> garden with single student"
    (is (= [:radishes :clover :grass :grass]
           (:alice (kindergarten-garden/garden "RC\nGG"))))))

(deftest garden_test_2
  (testing "partial garden -> different garden with single student"
    (is (= [:violets :clover :radishes :clover]
           (:alice (kindergarten-garden/garden "VC\nRC"))))))

(deftest garden_test_3
  (testing "partial garden -> garden with two students"
    (is (= [:clover :grass :radishes :clover]
           (:bob (kindergarten-garden/garden "VVCG\nVVRC"))))))

(deftest garden_test_4
  (testing "partial garden -> multiple students for the same garden with three students -> second student's garden"
    (is (= [:clover :clover :clover :clover]
           (:bob (kindergarten-garden/garden "VVCCGG\nVVCCGG"))))))

(deftest garden_test_5
  (testing "partial garden -> multiple students for the same garden with three students -> third student's garden"
    (is (= [:grass :grass :grass :grass]
           (:charlie (kindergarten-garden/garden "VVCCGG\nVVCCGG"))))))

(deftest garden_test_6
  (testing "full garden -> for Alice first student's garden"
    (is (= [:violets :radishes :violets :radishes]
           (:alice (kindergarten-garden/garden "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV"))))))

(deftest garden_test_7
  (testing "full garden -> for Bob second student's garden"
    (is (= [:clover :grass :clover :clover]
           (:bob (kindergarten-garden/garden "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV"))))))

(deftest garden_test_8
  (testing "full garden -> for Charlie"
    (is (= [:violets :violets :clover :grass]
           (:charlie (kindergarten-garden/garden "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV"))))))

(deftest garden_test_9
  (testing "full garden -> for David"
    (is (= [:radishes :violets :clover :radishes]
           (:david (kindergarten-garden/garden "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV"))))))

(deftest garden_test_10
  (testing "full garden -> for Eve"
    (is (= [:clover :grass :radishes :grass]
           (:eve (kindergarten-garden/garden "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV"))))))

(deftest garden_test_11
  (testing "full garden -> for Fred"
    (is (= [:grass :clover :violets :clover]
           (:fred (kindergarten-garden/garden "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV"))))))

(deftest garden_test_12
  (testing "full garden -> for Ginny"
    (is (= [:clover :grass :grass :clover]
           (:ginny (kindergarten-garden/garden "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV"))))))

(deftest garden_test_13
  (testing "full garden -> for Harriet"
    (is (= [:violets :radishes :radishes :violets]
           (:harriet (kindergarten-garden/garden "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV"))))))

(deftest garden_test_14
  (testing "full garden -> for Ileana"
    (is (= [:grass :clover :violets :clover]
           (:ileana (kindergarten-garden/garden "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV"))))))

(deftest garden_test_15
  (testing "full garden -> for Joseph"
    (is (= [:violets :clover :violets :grass]
           (:joseph (kindergarten-garden/garden "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV"))))))

(deftest garden_test_16
  (testing "full garden -> for Kincaid second to last student's garden"
    (is (= [:grass :clover :clover :grass]
           (:kincaid (kindergarten-garden/garden "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV"))))))

(deftest garden_test_17
  (testing "full garden -> for Larry last student's garden"
    (is (= [:grass :violets :clover :violets]
           (:larry (kindergarten-garden/garden "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV"))))))
