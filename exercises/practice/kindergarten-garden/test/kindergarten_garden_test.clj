(ns kindergarten-garden-test
  (:require [clojure.test :refer [deftest testing is]]
            kindergarten-garden))

(deftest test-1fc316ed-17ab-4fba-88ef-3ae78296b692
  (testing "Partial garden -> Garden with single student"
    (is (= [:radishes :clover :grass :grass]
           (:alice (kindergarten-garden/garden "RC\nGG"))))))

(deftest test-acd19dc1-2200-4317-bc2a-08f021276b40
  (testing "Partial garden -> Different garden with single student"
    (is (= [:violets :clover :radishes :clover]
           (:alice (kindergarten-garden/garden "VC\nRC"))))))

(deftest test-c376fcc8-349c-446c-94b0-903947315757
  (testing "Partial garden -> Garden with two students"
    (is (= [:clover :grass :radishes :clover]
           (:bob (kindergarten-garden/garden "VVCG\nVVRC"))))))

(deftest test-2d620f45-9617-4924-9d27-751c80d17db9
  (testing "Partial garden -> Multiple students for the same garden with three students -> Second student's garden"
    (is (= [:clover :clover :clover :clover]
           (:bob (kindergarten-garden/garden "VVCCGG\nVVCCGG"))))))

(deftest test-57712331-4896-4364-89f8-576421d69c44
  (testing "Partial garden -> Multiple students for the same garden with three students -> Third student's garden"
    (is (= [:grass :grass :grass :grass]
           (:charlie (kindergarten-garden/garden "VVCCGG\nVVCCGG"))))))

(deftest test-149b4290-58e1-40f2-8ae4-8b87c46e765b
  (testing "Full garden -> For Alice first student's garden"
    (is (= [:violets :radishes :violets :radishes]
           (:alice (kindergarten-garden/garden "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV"))))))

(deftest test-ba25dbbc-10bd-4a37-b18e-f89ecd098a5e
  (testing "Full garden -> For Bob second student's garden"
    (is (= [:clover :grass :clover :clover]
           (:bob (kindergarten-garden/garden "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV"))))))

(deftest test-566b621b-f18e-4c5f-873e-be30544b838c
  (testing "Full garden -> For Charlie"
    (is (= [:violets :violets :clover :grass]
           (:charlie (kindergarten-garden/garden "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV"))))))

(deftest test-3ad3df57-dd98-46fc-9269-1877abf612aa
  (testing "Full garden -> For David"
    (is (= [:radishes :violets :clover :radishes]
           (:david (kindergarten-garden/garden "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV"))))))

(deftest test-0f0a55d1-9710-46ed-a0eb-399ba8c72db2
  (testing "Full garden -> For Eve"
    (is (= [:clover :grass :radishes :grass]
           (:eve (kindergarten-garden/garden "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV"))))))

(deftest test-a7e80c90-b140-4ea1-aee3-f4625365c9a4
  (testing "Full garden -> For Fred"
    (is (= [:grass :clover :violets :clover]
           (:fred (kindergarten-garden/garden "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV"))))))

(deftest test-9d94b273-2933-471b-86e8-dba68694c615
  (testing "Full garden -> For Ginny"
    (is (= [:clover :grass :grass :clover]
           (:ginny (kindergarten-garden/garden "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV"))))))

(deftest test-f55bc6c2-ade8-4844-87c4-87196f1b7258
  (testing "Full garden -> For Harriet"
    (is (= [:violets :radishes :radishes :violets]
           (:harriet (kindergarten-garden/garden "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV"))))))

(deftest test-759070a3-1bb1-4dd4-be2c-7cce1d7679ae
  (testing "Full garden -> For Ileana"
    (is (= [:grass :clover :violets :clover]
           (:ileana (kindergarten-garden/garden "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV"))))))

(deftest test-78578123-2755-4d4a-9c7d-e985b8dda1c6
  (testing "Full garden -> For Joseph"
    (is (= [:violets :clover :violets :grass]
           (:joseph (kindergarten-garden/garden "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV"))))))

(deftest test-6bb66df7-f433-41ab-aec2-3ead6e99f65b
  (testing "Full garden -> For Kincaid second to last student's garden"
    (is (= [:grass :clover :clover :grass]
           (:kincaid (kindergarten-garden/garden "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV"))))))

(deftest test-d7edec11-6488-418a-94e6-ed509e0fa7eb
  (testing "Full garden -> For Larry last student's garden"
    (is (= [:grass :violets :clover :violets]
           (:larry (kindergarten-garden/garden "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV"))))))
