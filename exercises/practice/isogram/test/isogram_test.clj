(ns isogram-test
  (:require [clojure.test :refer [deftest testing is]]
            isogram))

(deftest test-a0e97d2d-669e-47c7-8134-518a1e2c4555
  (testing "empty string"
    (is (true? (isogram/isogram? "")))))

(deftest test-9a001b50-f194-4143-bc29-2af5ec1ef652
  (testing "isogram with only lower case characters"
    (is (true? (isogram/isogram? "isogram")))))

(deftest test-8ddb0ca3-276e-4f8b-89da-d95d5bae78a4
  (testing "word with one duplicated character"
    (is (false? (isogram/isogram? "eleven")))))

(deftest test-6450b333-cbc2-4b24-a723-0b459b34fe18
  (testing "word with one duplicated character from the end of the alphabet"
    (is (false? (isogram/isogram? "zzyzx")))))

(deftest test-a15ff557-dd04-4764-99e7-02cc1a385863
  (testing "longest reported english isogram"
    (is (true? (isogram/isogram? "subdermatoglyphic")))))

(deftest test-f1a7f6c7-a42f-4915-91d7-35b2ea11c92e
  (testing "word with duplicated character in mixed case"
    (is (false? (isogram/isogram? "Alphabet")))))

(deftest test-14a4f3c1-3b47-4695-b645-53d328298942
  (testing "word with duplicated character in mixed case, lowercase first"
    (is (false? (isogram/isogram? "alphAbet")))))

(deftest test-423b850c-7090-4a8a-b057-97f1cadd7c42
  (testing "hypothetical isogrammic word with hyphen"
    (is (true? (isogram/isogram? "thumbscrew-japingly")))))

(deftest test-93dbeaa0-3c5a-45c2-8b25-428b8eacd4f2
  (testing "hypothetical word with duplicated character following hyphen"
    (is (false? (isogram/isogram? "thumbscrew-jappingly")))))

(deftest test-36b30e5c-173f-49c6-a515-93a3e825553f
  (testing "isogram with duplicated hyphen"
    (is (true? (isogram/isogram? "six-year-old")))))

(deftest test-cdabafa0-c9f4-4c1f-b142-689c6ee17d93
  (testing "made-up name that is an isogram"
    (is (true? (isogram/isogram? "Emily Jung Schwartzkopf")))))

(deftest test-5fc61048-d74e-48fd-bc34-abfc21552d4d
  (testing "duplicated character in the middle"
    (is (false? (isogram/isogram? "accentor")))))

(deftest test-310ac53d-8932-47bc-bbb4-b2b94f25a83e
  (testing "same first and last characters"
    (is (false? (isogram/isogram? "angola")))))

(deftest test-0d0b8644-0a1e-4a31-a432-2b3ee270d847
  (testing "word with duplicated character and with two hyphens"
    (is (false? (isogram/isogram? "up-to-date")))))
