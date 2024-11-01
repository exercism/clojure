(ns matching-brackets-test
  (:require [clojure.test :refer [deftest testing is]]
            matching-brackets))

(deftest test-81ec11da-38dd-442a-bcf9-3de7754609a5
  (testing "Paired square brackets"
    (is (true? (matching-brackets/valid? "[]")))))

(deftest test-287f0167-ac60-4b64-8452-a0aa8f4e5238
  (testing "Empty string"
    (is (true? (matching-brackets/valid? "")))))

(deftest test-6c3615a3-df01-4130-a731-8ef5f5d78dac
  (testing "Unpaired brackets"
    (is (false? (matching-brackets/valid? "[[")))))

(deftest test-9d414171-9b98-4cac-a4e5-941039a97a77
  (testing "Wrong ordered brackets"
    (is (false? (matching-brackets/valid? "}{")))))

(deftest test-f0f97c94-a149-4736-bc61-f2c5148ffb85
  (testing "Wrong closing bracket"
    (is (false? (matching-brackets/valid? "{]")))))

(deftest test-754468e0-4696-4582-a30e-534d47d69756
  (testing "Paired with whitespace"
    (is (true? (matching-brackets/valid? "{ }")))))

(deftest test-ba84f6ee-8164-434a-9c3e-b02c7f8e8545
  (testing "Partially paired brackets"
    (is (false? (matching-brackets/valid? "{[])")))))

(deftest test-3c86c897-5ff3-4a2b-ad9b-47ac3a30651d
  (testing "Simple nested brackets"
    (is (true? (matching-brackets/valid? "{[]}")))))

(deftest test-2d137f2c-a19e-4993-9830-83967a2d4726
  (testing "Several paired brackets"
    (is (true? (matching-brackets/valid? "{}[]")))))

(deftest test-2e1f7b56-c137-4c92-9781-958638885a44
  (testing "Paired and nested brackets"
    (is (true? (matching-brackets/valid? "([{}({}[])])")))))

(deftest test-84f6233b-e0f7-4077-8966-8085d295c19b
  (testing "Unopened closing brackets"
    (is (false? (matching-brackets/valid? "{[)][]}")))))
 
(deftest test-9b18c67d-7595-4982-b2c5-4cb949745d49
  (testing "Unpaired and nested brackets"
    (is (false? (matching-brackets/valid? "([{])")))))

(deftest test-a0205e34-c2ac-49e6-a88a-899508d7d68e
  (testing "Paired and wrong nested brackets"
    (is (false? (matching-brackets/valid? "[({]})")))))

(deftest test-1d5c093f-fc84-41fb-8c2a-e052f9581602
  (testing "Paired and wrong nested brackets but innermost are correct"
    (is (false? (matching-brackets/valid? "[({}])")))))

(deftest test-ef47c21b-bcfd-4998-844c-7ad5daad90a8
  (testing "Paired and incomplete brackets"
    (is (false? (matching-brackets/valid? "{}[")))))

(deftest test-a4675a40-a8be-4fc2-bc47-2a282ce6edbe
  (testing "Too many closing brackets"
    (is (false? (matching-brackets/valid? "[]]")))))

(deftest test-a345a753-d889-4b7e-99ae-34ac85910d1a
  (testing "Early unexpected brackets"
    (is (false? (matching-brackets/valid? ")()")))))

(deftest test-21f81d61-1608-465a-b850-baa44c5def83
  (testing "Early mismatched brackets"
    (is (false? (matching-brackets/valid? "{)()")))))

(deftest test-99255f93-261b-4435-a352-02bdecc9bdf2
  (testing "Math expression"
    (is (true? (matching-brackets/valid? "(((185 + 223.85) * 15) - 543)/2")))))

(deftest test-8e357d79-f302-469a-8515-2561877256a1
  (testing "Complex latex expression"
    (is (true? (matching-brackets/valid? "\\\\left(\\\\begin{array}{cc} \\\\frac{1}{3} & x\\\\\\\\ \\\\mathrm{e}^{x} &... x^2 \\\\end{array}\\\\right)")))))
