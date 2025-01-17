(ns twelve-days-test
  (:require [clojure.test :refer [deftest testing is]]
            twelve-days))

(deftest recite_test_1
  (testing "verse - first day a partridge in a pear tree"
    (is (= (twelve-days/recite 1 1)
           [
             "On the first day of Christmas my true love gave to me: a Partridge in a Pear Tree."
           ]))))

(deftest recite_test_2
  (testing "verse - second day two turtle doves"
    (is (= (twelve-days/recite 2 2)
           [
             "On the second day of Christmas my true love gave to me: two Turtle Doves, and a Partridge in a Pear Tree."
           ]))))

(deftest recite_test_3
  (testing "verse - third day three french hens"
    (is (= (twelve-days/recite 3 3)
           [
             "On the third day of Christmas my true love gave to me: three French Hens, two Turtle Doves, and a Partridge in a Pear Tree."
           ]))))

(deftest recite_test_4
  (testing "verse - fourth day four calling birds"
    (is (= (twelve-days/recite 4 4)
           [
             "On the fourth day of Christmas my true love gave to me: four Calling Birds, three French Hens, two Turtle Doves, and a Partridge in a Pear Tree."
           ]))))

(deftest recite_test_5
  (testing "verse - fifth day five gold rings"
    (is (= (twelve-days/recite 5 5)
           [
             "On the fifth day of Christmas my true love gave to me: five Gold Rings, four Calling Birds, three French Hens, two Turtle Doves, and a Partridge in a Pear Tree."
           ]))))

(deftest recite_test_6
  (testing "verse - sixth day six geese-a-laying"
    (is (= (twelve-days/recite 6 6)
           [
             "On the sixth day of Christmas my true love gave to me: six Geese-a-Laying, five Gold Rings, four Calling Birds, three French Hens, two Turtle Doves, and a Partridge in a Pear Tree."
           ]))))

(deftest recite_test_7
  (testing "verse - seventh day seven swans-a-swimming"
    (is (= (twelve-days/recite 7 7)
           [
             "On the seventh day of Christmas my true love gave to me: seven Swans-a-Swimming, six Geese-a-Laying, five Gold Rings, four Calling Birds, three French Hens, two Turtle Doves, and a Partridge in a Pear Tree."
           ]))))

(deftest recite_test_8
  (testing "verse - eighth day eight maids-a-milking"
    (is (= (twelve-days/recite 8 8)
           [
             "On the eighth day of Christmas my true love gave to me: eight Maids-a-Milking, seven Swans-a-Swimming, six Geese-a-Laying, five Gold Rings, four Calling Birds, three French Hens, two Turtle Doves, and a Partridge in a Pear Tree."
           ]))))

(deftest recite_test_9
  (testing "verse - ninth day nine ladies dancing"
    (is (= (twelve-days/recite 9 9)
           [
             "On the ninth day of Christmas my true love gave to me: nine Ladies Dancing, eight Maids-a-Milking, seven Swans-a-Swimming, six Geese-a-Laying, five Gold Rings, four Calling Birds, three French Hens, two Turtle Doves, and a Partridge in a Pear Tree."
           ]))))

(deftest recite_test_10
  (testing "verse - tenth day ten lords-a-leaping"
    (is (= (twelve-days/recite 10 10)
           [
             "On the tenth day of Christmas my true love gave to me: ten Lords-a-Leaping, nine Ladies Dancing, eight Maids-a-Milking, seven Swans-a-Swimming, six Geese-a-Laying, five Gold Rings, four Calling Birds, three French Hens, two Turtle Doves, and a Partridge in a Pear Tree."
           ]))))

(deftest recite_test_11
  (testing "verse - eleventh day eleven pipers piping"
    (is (= (twelve-days/recite 11 11)
           [
             "On the eleventh day of Christmas my true love gave to me: eleven Pipers Piping, ten Lords-a-Leaping, nine Ladies Dancing, eight Maids-a-Milking, seven Swans-a-Swimming, six Geese-a-Laying, five Gold Rings, four Calling Birds, three French Hens, two Turtle Doves, and a Partridge in a Pear Tree."
           ]))))

(deftest recite_test_12
  (testing "verse - twelfth day twelve drummers drumming"
    (is (= (twelve-days/recite 12 12)
           [
             "On the twelfth day of Christmas my true love gave to me: twelve Drummers Drumming, eleven Pipers Piping, ten Lords-a-Leaping, nine Ladies Dancing, eight Maids-a-Milking, seven Swans-a-Swimming, six Geese-a-Laying, five Gold Rings, four Calling Birds, three French Hens, two Turtle Doves, and a Partridge in a Pear Tree."
           ]))))

(deftest recite_test_13
  (testing "lyrics - recites first three verses of the song"
    (is (= (twelve-days/recite 1 3)
           [
             "On the first day of Christmas my true love gave to me: a Partridge in a Pear Tree."
             "On the second day of Christmas my true love gave to me: two Turtle Doves, and a Partridge in a Pear Tree."
             "On the third day of Christmas my true love gave to me: three French Hens, two Turtle Doves, and a Partridge in a Pear Tree."
           ]))))

(deftest recite_test_14
  (testing "lyrics - recites three verses from the middle of the song"
    (is (= (twelve-days/recite 4 6)
           [
             "On the fourth day of Christmas my true love gave to me: four Calling Birds, three French Hens, two Turtle Doves, and a Partridge in a Pear Tree."
             "On the fifth day of Christmas my true love gave to me: five Gold Rings, four Calling Birds, three French Hens, two Turtle Doves, and a Partridge in a Pear Tree."
             "On the sixth day of Christmas my true love gave to me: six Geese-a-Laying, five Gold Rings, four Calling Birds, three French Hens, two Turtle Doves, and a Partridge in a Pear Tree."
           ]))))

(deftest recite_test_15
  (testing "lyrics - recites the whole song"
    (is (= (twelve-days/recite 1 12)
           [
             "On the first day of Christmas my true love gave to me: a Partridge in a Pear Tree."
             "On the second day of Christmas my true love gave to me: two Turtle Doves, and a Partridge in a Pear Tree."
             "On the third day of Christmas my true love gave to me: three French Hens, two Turtle Doves, and a Partridge in a Pear Tree."
             "On the fourth day of Christmas my true love gave to me: four Calling Birds, three French Hens, two Turtle Doves, and a Partridge in a Pear Tree."
             "On the fifth day of Christmas my true love gave to me: five Gold Rings, four Calling Birds, three French Hens, two Turtle Doves, and a Partridge in a Pear Tree."
             "On the sixth day of Christmas my true love gave to me: six Geese-a-Laying, five Gold Rings, four Calling Birds, three French Hens, two Turtle Doves, and a Partridge in a Pear Tree."
             "On the seventh day of Christmas my true love gave to me: seven Swans-a-Swimming, six Geese-a-Laying, five Gold Rings, four Calling Birds, three French Hens, two Turtle Doves, and a Partridge in a Pear Tree."
             "On the eighth day of Christmas my true love gave to me: eight Maids-a-Milking, seven Swans-a-Swimming, six Geese-a-Laying, five Gold Rings, four Calling Birds, three French Hens, two Turtle Doves, and a Partridge in a Pear Tree."
             "On the ninth day of Christmas my true love gave to me: nine Ladies Dancing, eight Maids-a-Milking, seven Swans-a-Swimming, six Geese-a-Laying, five Gold Rings, four Calling Birds, three French Hens, two Turtle Doves, and a Partridge in a Pear Tree."
             "On the tenth day of Christmas my true love gave to me: ten Lords-a-Leaping, nine Ladies Dancing, eight Maids-a-Milking, seven Swans-a-Swimming, six Geese-a-Laying, five Gold Rings, four Calling Birds, three French Hens, two Turtle Doves, and a Partridge in a Pear Tree."
             "On the eleventh day of Christmas my true love gave to me: eleven Pipers Piping, ten Lords-a-Leaping, nine Ladies Dancing, eight Maids-a-Milking, seven Swans-a-Swimming, six Geese-a-Laying, five Gold Rings, four Calling Birds, three French Hens, two Turtle Doves, and a Partridge in a Pear Tree."
             "On the twelfth day of Christmas my true love gave to me: twelve Drummers Drumming, eleven Pipers Piping, ten Lords-a-Leaping, nine Ladies Dancing, eight Maids-a-Milking, seven Swans-a-Swimming, six Geese-a-Laying, five Gold Rings, four Calling Birds, three French Hens, two Turtle Doves, and a Partridge in a Pear Tree."
           ]))))
