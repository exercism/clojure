(ns food-chain-test
  (:require [clojure.test :refer [deftest testing is]]
            [clojure.string :as str]
            food-chain))

(deftest recite_test_1
  (testing "fly"
    (is (= (str/join "\n" ["I know an old lady who swallowed a fly."
                           "I don't know why she swallowed the fly. Perhaps she'll die."])
           (food-chain/recite 1 1)))))

(deftest recite_test_2
  (testing "spider"
    (is (= (str/join "\n" ["I know an old lady who swallowed a spider."
                           "It wriggled and jiggled and tickled inside her."
                           "She swallowed the spider to catch the fly."
                           "I don't know why she swallowed the fly. Perhaps she'll die."])
           (food-chain/recite 2 2)))))

(deftest recite_test_3
  (testing "bird"
    (is (= (str/join "\n" ["I know an old lady who swallowed a bird."
                           "How absurd to swallow a bird!"
                           "She swallowed the bird to catch the spider that wriggled and jiggled and tickled inside her."
                           "She swallowed the spider to catch the fly."
                           "I don't know why she swallowed the fly. Perhaps she'll die."])
           (food-chain/recite 3 3)))))

(deftest recite_test_4
  (testing "cat"
    (is (= (str/join "\n" ["I know an old lady who swallowed a cat."
                           "Imagine that, to swallow a cat!"
                           "She swallowed the cat to catch the bird."
                           "She swallowed the bird to catch the spider that wriggled and jiggled and tickled inside her."
                           "She swallowed the spider to catch the fly."
                           "I don't know why she swallowed the fly. Perhaps she'll die."])
           (food-chain/recite 4 4)))))

(deftest recite_test_5
  (testing "dog"
    (is (= (str/join "\n" ["I know an old lady who swallowed a dog."
                           "What a hog, to swallow a dog!"
                           "She swallowed the dog to catch the cat."
                           "She swallowed the cat to catch the bird."
                           "She swallowed the bird to catch the spider that wriggled and jiggled and tickled inside her."
                           "She swallowed the spider to catch the fly."
                           "I don't know why she swallowed the fly. Perhaps she'll die."])
           (food-chain/recite 5 5)))))

(deftest recite_test_6
  (testing "goat"
    (is (= (str/join "\n" ["I know an old lady who swallowed a goat."
                           "Just opened her throat and swallowed a goat!"
                           "She swallowed the goat to catch the dog."
                           "She swallowed the dog to catch the cat."
                           "She swallowed the cat to catch the bird."
                           "She swallowed the bird to catch the spider that wriggled and jiggled and tickled inside her."
                           "She swallowed the spider to catch the fly."
                           "I don't know why she swallowed the fly. Perhaps she'll die."])
           (food-chain/recite 6 6)))))

(deftest recite_test_7
  (testing "cow"
    (is (= (str/join "\n" ["I know an old lady who swallowed a cow."
                           "I don't know how she swallowed a cow!"
                           "She swallowed the cow to catch the goat."
                           "She swallowed the goat to catch the dog."
                           "She swallowed the dog to catch the cat."
                           "She swallowed the cat to catch the bird."
                           "She swallowed the bird to catch the spider that wriggled and jiggled and tickled inside her."
                           "She swallowed the spider to catch the fly."
                           "I don't know why she swallowed the fly. Perhaps she'll die."])
           (food-chain/recite 7 7)))))

(deftest recite_test_8
  (testing "horse"
    (is (= (str/join "\n" ["I know an old lady who swallowed a horse."
                           "She's dead, of course!"])
           (food-chain/recite 8 8)))))

(deftest recite_test_9
  (testing "multiple verses"
    (is (= (str/join "\n" ["I know an old lady who swallowed a fly."
                           "I don't know why she swallowed the fly. Perhaps she'll die."
                           ""
                           "I know an old lady who swallowed a spider."
                           "It wriggled and jiggled and tickled inside her."
                           "She swallowed the spider to catch the fly."
                           "I don't know why she swallowed the fly. Perhaps she'll die."
                           ""
                           "I know an old lady who swallowed a bird."
                           "How absurd to swallow a bird!"
                           "She swallowed the bird to catch the spider that wriggled and jiggled and tickled inside her."
                           "She swallowed the spider to catch the fly."
                           "I don't know why she swallowed the fly. Perhaps she'll die."])
           (food-chain/recite 1 3)))))

(deftest recite_test_10
  (testing "full song"
    (is (= (str/join "\n" ["I know an old lady who swallowed a fly."
                           "I don't know why she swallowed the fly. Perhaps she'll die."
                           ""
                           "I know an old lady who swallowed a spider."
                           "It wriggled and jiggled and tickled inside her."
                           "She swallowed the spider to catch the fly."
                           "I don't know why she swallowed the fly. Perhaps she'll die."
                           ""
                           "I know an old lady who swallowed a bird."
                           "How absurd to swallow a bird!"
                           "She swallowed the bird to catch the spider that wriggled and jiggled and tickled inside her."
                           "She swallowed the spider to catch the fly."
                           "I don't know why she swallowed the fly. Perhaps she'll die."
                           ""
                           "I know an old lady who swallowed a cat."
                           "Imagine that, to swallow a cat!"
                           "She swallowed the cat to catch the bird."
                           "She swallowed the bird to catch the spider that wriggled and jiggled and tickled inside her."
                           "She swallowed the spider to catch the fly."
                           "I don't know why she swallowed the fly. Perhaps she'll die."
                           ""
                           "I know an old lady who swallowed a dog."
                           "What a hog, to swallow a dog!"
                           "She swallowed the dog to catch the cat."
                           "She swallowed the cat to catch the bird."
                           "She swallowed the bird to catch the spider that wriggled and jiggled and tickled inside her."
                           "She swallowed the spider to catch the fly."
                           "I don't know why she swallowed the fly. Perhaps she'll die."
                           ""
                           "I know an old lady who swallowed a goat."
                           "Just opened her throat and swallowed a goat!"
                           "She swallowed the goat to catch the dog."
                           "She swallowed the dog to catch the cat."
                           "She swallowed the cat to catch the bird."
                           "She swallowed the bird to catch the spider that wriggled and jiggled and tickled inside her."
                           "She swallowed the spider to catch the fly."
                           "I don't know why she swallowed the fly. Perhaps she'll die."
                           ""
                           "I know an old lady who swallowed a cow."
                           "I don't know how she swallowed a cow!"
                           "She swallowed the cow to catch the goat."
                           "She swallowed the goat to catch the dog."
                           "She swallowed the dog to catch the cat."
                           "She swallowed the cat to catch the bird."
                           "She swallowed the bird to catch the spider that wriggled and jiggled and tickled inside her."
                           "She swallowed the spider to catch the fly."
                           "I don't know why she swallowed the fly. Perhaps she'll die."
                           ""
                           "I know an old lady who swallowed a horse."
                           "She's dead, of course!"])
           (food-chain/recite 1 8)))))
