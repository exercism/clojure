(ns yacht-test
  (:require [clojure.test :refer [deftest testing is]]
             yacht))

(deftest test-3060e4a5-4063-4deb-a380-a630b43a84b6
  (testing "Yacht"
    (is (= 50 (yacht/score [5 5 5 5 5] "yacht")))))

(deftest test-15026df2-f567-482f-b4d5-5297d57769d9
  (testing "Not Yacht"
    (is (= 0 (yacht/score [1 3 3 2 5] "yacht")))))

(deftest test-36b6af0c-ca06-4666-97de-5d31213957a4
  (testing "Ones"
    (is (= 3 (yacht/score [1 1 1 3 5] "ones")))))

(deftest test-023a07c8-6c6e-44d0-bc17-efc5e1b8205a
  (testing "Ones, out of order"
    (is (= 3 (yacht/score [3 1 1 5 1] "ones")))))

(deftest test-7189afac-cccd-4a74-8182-1cb1f374e496
  (testing "No ones"
    (is (= 0 (yacht/score [4 3 6 5 5] "ones")))))

(deftest test-793c4292-dd14-49c4-9707-6d9c56cee725
  (testing "Twos"
    (is (= 2 (yacht/score [2 3 4 5 6] "twos")))))

(deftest test-dc41bceb-d0c5-4634-a734-c01b4233a0c6
  (testing "Fours"
    (is (= 8 (yacht/score [1 4 1 4 1] "fours")))))

(deftest test-f6125417-5c8a-4bca-bc5b-b4b76d0d28c8
  (testing "Yacht counted as threes"
    (is (= 15 (yacht/score [3 3 3 3 3] "threes")))))

(deftest test-464fc809-96ed-46e4-acb8-d44e302e9726
  (testing "Yacht of 3s counted as fives"
    (is (= 0 (yacht/score [3 3 3 3 3] "fives")))))

(deftest test-d054227f-3a71-4565-a684-5c7e621ec1e9
  (testing "Fives"
    (is (= 10 (yacht/score [1 5 3 5 3] "fives")))))

(deftest test-e8a036e0-9d21-443a-8b5f-e15a9e19a761
  (testing "Sixes"
    (is (= 6 (yacht/score [2 3 4 5 6] "sixes")))))

(deftest test-51cb26db-6b24-49af-a9ff-12f53b252eea
  (testing "Full house two small, three big"
    (is (= 16 (yacht/score [2 2 4 4 4] "full house")))))

(deftest test-1822ca9d-f235-4447-b430-2e8cfc448f0c
  (testing "Full house three small, two big"
    (is (= 19 (yacht/score [5 3 3 5 3] "full house")))))

(deftest test-b208a3fc-db2e-4363-a936-9e9a71e69c07
  (testing "Two pair is not a full house"
    (is (= 0 (yacht/score [2 2 4 4 5] "full house")))))

(deftest test-b90209c3-5956-445b-8a0b-0ac8b906b1c2
  (testing "Four of a kind is not a full house"
    (is (= 0 (yacht/score [1 4 4 4 4] "full house")))))

(deftest test-32a3f4ee-9142-4edf-ba70-6c0f96eb4b0c
  (testing "Yacht is not a full house"
    (is (= 0 (yacht/score [2 2 2 2 2] "full house")))))

(deftest test-b286084d-0568-4460-844a-ba79d71d79c6
  (testing "Four of a Kind"
    (is (= 24 (yacht/score [6 6 4 6 6] "four of a kind")))))

(deftest test-f25c0c90-5397-4732-9779-b1e9b5f612ca
  (testing "Yacht can be scored as Four of a Kind"
    (is (= 12 (yacht/score [3 3 3 3 3] "four of a kind")))))

(deftest test-9f8ef4f0-72bb-401a-a871-cbad39c9cb08
  (testing "Full house is not Four of a Kind"
    (is (= 0 (yacht/score [3 3 3 5 5] "four of a kind")))))

(deftest test-b4743c82-1eb8-4a65-98f7-33ad126905cd
  (testing "Little Straight"
    (is (= 30 (yacht/score [3 5 4 1 2] "little straight")))))

(deftest test-7ac08422-41bf-459c-8187-a38a12d080bc
  (testing "Little Straight as Big Straight"
    (is (= 0 (yacht/score [1 2 3 4 5] "big straight")))))

(deftest test-97bde8f7-9058-43ea-9de7-0bc3ed6d3002
  (testing "Four in order but not a little straight"
    (is (= 0 (yacht/score [1 1 2 3 4] "little straight")))))

(deftest test-cef35ff9-9c5e-4fd2-ae95-6e4af5e95a99
  (testing "No pairs but not a little straight"
    (is (= 0 (yacht/score [1 2 3 4 6] "little straight")))))

(deftest test-fd785ad2-c060-4e45-81c6-ea2bbb781b9d
  (testing "Minimum is 1, maximum is 5, but not a little straight"
    (is (= 0 (yacht/score [1 1 3 4 5] "little straight")))))

(deftest test-35bd74a6-5cf6-431a-97a3-4f713663f467
  (testing "Big Straight"
    (is (= 30 (yacht/score [4 6 2 5 3] "big straight")))))

(deftest test-87c67e1e-3e87-4f3a-a9b1-62927822b250
  (testing "Big Straight as little straight"
    (is (= 0 (yacht/score [6 5 4 3 2] "little straight")))))

(deftest test-c1fa0a3a-40ba-4153-a42d-32bc34d2521e
  (testing "No pairs but not a big straight"
    (is (= 0 (yacht/score [6 5 4 3 1] "big straight")))))

(deftest test-207e7300-5d10-43e5-afdd-213e3ac8827d
  (testing "Choice"
    (is (= 23 (yacht/score [3 3 5 6 6] "choice")))))

(deftest test-b524c0cf-32d2-4b40-8fb3-be3500f3f135
  (testing "Yacht as choice"
    (is (= 10 (yacht/score [2 2 2 2 2] "choice")))))
