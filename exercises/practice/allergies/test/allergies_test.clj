(ns allergies-test
  (:require [clojure.test :refer [deftest testing is]]
            allergies))

(deftest test-17fc7296-2440-4ac4-ad7b-d07c321bc5a0
  (testing "Testing for eggs allergy -> not allergic to anything"
    (is (false? (allergies/allergic-to? 0 :eggs)))))

(deftest test-07ced27b-1da5-4c2e-8ae2-cb2791437546
  (testing "Testing for eggs allergy -> allergic only to eggs"
    (is (true? (allergies/allergic-to? 1 :eggs)))))

(deftest test-5035b954-b6fa-4b9b-a487-dae69d8c5f96
  (testing "Testing for eggs allergy -> allergic to eggs and something else"
    (is (true? (allergies/allergic-to? 3 :eggs)))))

(deftest test-64a6a83a-5723-4b5b-a896-663307403310
  (testing "Testing for eggs allergy -> allergic to something, but not eggs"
    (is (false? (allergies/allergic-to? 2 :eggs)))))

(deftest test-90c8f484-456b-41c4-82ba-2d08d93231c6
  (testing "Testing for eggs allergy -> allergic to everything"
    (is (true? (allergies/allergic-to? 255 :eggs)))))

(deftest test-d266a59a-fccc-413b-ac53-d57cb1f0db9d
  (testing "Testing for peanuts allergy -> not allergic to anything"
    (is (false? (allergies/allergic-to? 0 :peanuts)))))

(deftest test-ea210a98-860d-46b2-a5bf-50d8995b3f2a
  (testing "Testing for peanuts allergy -> allergic only to peanuts"
    (is (true? (allergies/allergic-to? 2 :peanuts)))))

(deftest test-eac69ae9-8d14-4291-ac4b-7fd2c73d3a5b
  (testing "Testing for peanuts allergy -> allergic to peanuts and something else"
    (is (true? (allergies/allergic-to? 7 :peanuts)))))

(deftest test-9152058c-ce39-4b16-9b1d-283ec6d25085
  (testing "Testing for peanuts allergy -> allergic to something, but not peanuts"
    (is (false? (allergies/allergic-to? 5 :peanuts)))))

(deftest test-d2d71fd8-63d5-40f9-a627-fbdaf88caeab
  (testing "Testing for peanuts allergy -> allergic to everything"
    (is (true? (allergies/allergic-to? 255 :peanuts)))))

(deftest test-b948b0a1-cbf7-4b28-a244-73ff56687c80
  (testing "Testing for shellfish allergy -> not allergic to anything"
    (is (false? (allergies/allergic-to? 0 :shellfish)))))

(deftest test-9ce9a6f3-53e9-4923-85e0-73019047c567
  (testing "Testing for shellfish allergy -> allergic only to shellfish"
    (is (true? (allergies/allergic-to? 4 :shellfish)))))

(deftest test-b272fca5-57ba-4b00-bd0c-43a737ab2131
  (testing "Testing for shellfish allergy -> allergic to shellfish and something else"
    (is (true? (allergies/allergic-to? 14 :shellfish)))))

(deftest test-21ef8e17-c227-494e-8e78-470a1c59c3d8
  (testing "Testing for shellfish allergy -> allergic to something, but not shellfish"
    (is (false? (allergies/allergic-to? 10 :shellfish)))))

(deftest test-cc789c19-2b5e-4c67-b146-625dc8cfa34e
  (testing "Testing for shellfish allergy -> allergic to everything"
    (is (true? (allergies/allergic-to? 255 :shellfish)))))

(deftest test-651bde0a-2a74-46c4-ab55-02a0906ca2f5
  (testing "Testing for strawberries allergy -> not allergic to anything"
    (is (false? (allergies/allergic-to? 0 :strawberries)))))

(deftest test-b649a750-9703-4f5f-b7f7-91da2c160ece
  (testing "Testing for strawberries allergy -> allergic only to strawberries"
    (is (true? (allergies/allergic-to? 8 :strawberries)))))

(deftest test-50f5f8f3-3bac-47e6-8dba-2d94470a4bc6
  (testing "Testing for strawberries allergy -> allergic to strawberries and something else"
    (is (true? (allergies/allergic-to? 28 :strawberries)))))

(deftest test-23dd6952-88c9-48d7-a7d5-5d0343deb18d
  (testing "Testing for strawberries allergy -> allergic to something, but not strawberries"
    (is (false? (allergies/allergic-to? 20 :strawberries)))))

(deftest test-74afaae2-13b6-43a2-837a-286cd42e7d7e
  (testing "Testing for strawberries allergy -> allergic to everything"
    (is (true? (allergies/allergic-to? 255 :strawberries)))))

(deftest test-c49a91ef-6252-415e-907e-a9d26ef61723
  (testing "Testing for tomatoes allergy -> not allergic to anything"
    (is (false? (allergies/allergic-to? 0 :tomatoes)))))

(deftest test-b69c5131-b7d0-41ad-a32c-e1b2cc632df8
  (testing "Testing for tomatoes allergy -> allergic only to tomatoes"
    (is (true? (allergies/allergic-to? 16 :tomatoes)))))

(deftest test-1ca50eb1-f042-4ccf-9050-341521b929ec
  (testing "Testing for tomatoes allergy -> allergic to tomatoes and something else"
    (is (true? (allergies/allergic-to? 56 :tomatoes)))))

(deftest test-e9846baa-456b-4eff-8025-034b9f77bd8e
  (testing "Testing for tomatoes allergy -> allergic to something, but not tomatoes"
    (is (false? (allergies/allergic-to? 40 :tomatoes)))))

(deftest test-b2414f01-f3ad-4965-8391-e65f54dad35f
  (testing "Testing for tomatoes allergy -> allergic to everything"
    (is (true? (allergies/allergic-to? 255 :tomatoes)))))

(deftest test-978467ab-bda4-49f7-b004-1d011ead947c
  (testing "Testing for chocolate allergy -> not allergic to anything"
    (is (false? (allergies/allergic-to? 0 :chocolate)))))

(deftest test-59cf4e49-06ea-4139-a2c1-d7aad28f8cbc
  (testing "Testing for chocolate allergy -> allergic only to chocolate"
    (is (true? (allergies/allergic-to? 32 :chocolate)))))

(deftest test-b0a7c07b-2db7-4f73-a180-565e07040ef1
  (testing "Testing for chocolate allergy -> allergic to chocolate and something else"
    (is (true? (allergies/allergic-to? 112 :chocolate)))))

(deftest test-f5506893-f1ae-482a-b516-7532ba5ca9d2
  (testing "Testing for chocolate allergy -> allergic to something, but not chocolate"
    (is (false? (allergies/allergic-to? 80 :chocolate)))))

(deftest test-02debb3d-d7e2-4376-a26b-3c974b6595c6
  (testing "Testing for chocolate allergy -> allergic to everything"
    (is (true? (allergies/allergic-to? 255 :chocolate)))))

(deftest test-17f4a42b-c91e-41b8-8a76-4797886c2d96
  (testing "Testing for pollen allergy -> not allergic to anything"
    (is (false? (allergies/allergic-to? 0 :pollen)))))

(deftest test-7696eba7-1837-4488-882a-14b7b4e3e399
  (testing "Testing for pollen allergy -> allergic only to pollen"
    (is (true? (allergies/allergic-to? 64 :pollen)))))

(deftest test-9a49aec5-fa1f-405d-889e-4dfc420db2b6
  (testing "Testing for pollen allergy -> allergic to pollen and something else"
    (is (true? (allergies/allergic-to? 224 :pollen)))))

(deftest test-3cb8e79f-d108-4712-b620-aa146b1954a9
  (testing "Testing for pollen allergy -> allergic to something, but not pollen"
    (is (false? (allergies/allergic-to? 160 :pollen)))))

(deftest test-1dc3fe57-7c68-4043-9d51-5457128744b2
  (testing "Testing for pollen allergy -> allergic to everything"
    (is (true? (allergies/allergic-to? 255 :pollen)))))

(deftest test-d3f523d6-3d50-419b-a222-d4dfd62ce314
  (testing "Testing for cats allergy -> not allergic to anything"
    (is (false? (allergies/allergic-to? 0 :cats)))))

(deftest test-eba541c3-c886-42d3-baef-c048cb7fcd8f
  (testing "Testing for cats allergy -> allergic only to cats"
    (is (true? (allergies/allergic-to? 128 :cats)))))

(deftest test-ba718376-26e0-40b7-bbbe-060287637ea5
  (testing "Testing for cats allergy -> allergic to cats and something else"
    (is (true? (allergies/allergic-to? 192 :cats)))))

(deftest test-3c6dbf4a-5277-436f-8b88-15a206f2d6c4
  (testing "Testing for cats allergy -> allergic to something, but not cats"
    (is (false? (allergies/allergic-to? 64 :cats)))))

(deftest test-1faabb05-2b98-4995-9046-d83e4a48a7c1
  (testing "Testing for cats allergy -> allergic to everything"
    (is (true? (allergies/allergic-to? 255 :cats)))))

(deftest test-f9c1b8e7-7dc5-4887-aa93-cebdcc29dd8f
  (testing "List when: -> no allergies"
    (is (= []
           (allergies/allergies 0)))))

(deftest test-9e1a4364-09a6-4d94-990f-541a94a4c1e8
  (testing "List when: -> just eggs"
    (is (= [:eggs]
           (allergies/allergies 1)))))

(deftest test-8851c973-805e-4283-9e01-d0c0da0e4695
  (testing "List when: -> just peanuts"
    (is (= [:peanuts]
           (allergies/allergies 2)))))

(deftest test-2c8943cb-005e-435f-ae11-3e8fb558ea98
  (testing "List when: -> just strawberries"
    (is (= [:strawberries]
           (allergies/allergies 8)))))

(deftest test-6fa95d26-044c-48a9-8a7b-9ee46ec32c5c
  (testing "List when: -> eggs and peanuts"
    (is (= [:eggs :peanuts]
           (allergies/allergies 3)))))

(deftest test-19890e22-f63f-4c5c-a9fb-fb6eacddfe8e
  (testing "List when: -> more than eggs but not peanuts"
    (is (= [:eggs :shellfish]
           (allergies/allergies 5)))))

(deftest test-4b68f470-067c-44e4-889f-c9fe28917d2f
  (testing "List when: -> lots of stuff"
    (is (= [:strawberries :tomatoes :chocolate :pollen :cats]
           (allergies/allergies 248)))))

(deftest test-0881b7c5-9efa-4530-91bd-68370d054bc7
  (testing "List when: -> everything"
    (is (= [:eggs :peanuts :shellfish :strawberries :tomatoes :chocolate :pollen :cats]
           (allergies/allergies 255)))))

(deftest test-12ce86de-b347-42a0-ab7c-2e0570f0c65b
  (testing "List when: -> no allergen score parts"
    (is (= [:eggs :shellfish :strawberries :tomatoes :chocolate :pollen :cats]
           (allergies/allergies 509)))))

(deftest test-93c2df3e-4f55-4fed-8116-7513092819cd
  (testing "List when: -> no allergen score parts without highest valid score"
    (is (= [:eggs]
           (allergies/allergies 257)))))
