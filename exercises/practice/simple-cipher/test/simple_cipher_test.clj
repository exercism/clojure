(ns simple-cipher-test
  (:require [clojure.test :refer [deftest testing is]]
            simple-cipher))

(deftest rand-key_test_1
  (testing "Random key cipher ▶ Key is made only of lowercase letters"
    (is (true? (boolean (re-matches #"^[a-z]+$" (simple-cipher/rand-key)))))))

(deftest encode_test_1
  (testing "Random key cipher ▶ Can encode"
    (let [key (simple-cipher/rand-key)]
      (is (= (subs key 0 (count "aaaaaaaaaa")) (simple-cipher/encode key "aaaaaaaaaa"))))))

(deftest encode_test_2
  (testing "Substitution cipher ▶ Can encode"
    (is (= "abcdefghij" (simple-cipher/encode "abcdefghij" "aaaaaaaaaa")))))

(deftest encode_test_3
  (testing "Substitution cipher ▶ Can double shift encode"
    (is (= "qayaeaagaciai" (simple-cipher/encode "iamapandabear" "iamapandabear")))))

(deftest encode_test_4
  (testing "Substitution cipher ▶ Can wrap on encode"
    (is (= "zabcdefghi" (simple-cipher/encode "abcdefghij" "zzzzzzzzzz")))))

(deftest encode_test_5
  (testing "Substitution cipher ▶ Can encode messages longer than the key"
    (is (= "iboaqcnecbfcr" (simple-cipher/encode "abc" "iamapandabear")))))

(deftest decode_test_1
  (testing "Random key cipher ▶ Can decode"
    (let [key (simple-cipher/rand-key)]
      (is (= "aaaaaaaaaa" (simple-cipher/decode key (subs key 0 (count "aaaaaaaaaa")))))))

  (deftest decode_test_2
    (testing "Random key cipher ▶ Is reversible. I.e., if you apply decode in a encoded result, you must see the same plaintext encode parameter as a result of the decode method"
      (let [key (simple-cipher/rand-key)]
        (is (= "abcdefghij" (simple-cipher/decode key (simple-cipher/encode key "abcdefghij")))))

      (deftest decode_test_3
        (testing "Substitution cipher ▶ Can decode"
          (is (= "aaaaaaaaaa" (simple-cipher/decode "abcdefghij" "abcdefghij"))))))

    (deftest decode_test_4
      (testing "Substitution cipher ▶ Is reversible. I.e., if you apply decode in a encoded result, you must see the same plaintext encode parameter as a result of the decode method"
        (is (= "abcdefghij" (simple-cipher/decode "abcdefghij" (simple-cipher/encode "abcdefghij" "abcdefghij"))))))

    (deftest decode_test_5
      (testing "Substitution cipher ▶ Can wrap on decode"
        (is (= "zzzzzzzzzz" (simple-cipher/decode "abcdefghij" "zabcdefghi"))))))

  (deftest decode_test_6
    (testing "Substitution cipher ▶ Can decode messages longer than the key"
      (is (= "iamapandabear" (simple-cipher/decode "abc" "iboaqcnecbfcr"))))))
