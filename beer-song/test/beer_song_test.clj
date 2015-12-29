(ns beer-song-test
  (:require [clojure.test :refer [deftest is]]
            beer-song))

(def verse-8
  (str "8 bottles of beer on the wall, 8 bottles of beer.\n"
       "Take one down and pass it around, 7 bottles of beer on the wall.\n"))

(def verse-2
  (str "2 bottles of beer on the wall, 2 bottles of beer.\n"
       "Take one down and pass it around, 1 bottle of beer on the wall.\n"))

(def verse-1
  (str "1 bottle of beer on the wall, 1 bottle of beer.\n"
       "Take it down and pass it around, no more bottles of beer on the wall.\n"))

(def verse-0
  (str "No more bottles of beer on the wall, no more bottles of beer.\n"
       "Go to the store and buy some more, 99 bottles of beer on the wall.\n"))

(def song-8-6
  (str "8 bottles of beer on the wall, 8 bottles of beer.\n"
       "Take one down and pass it around, 7 bottles of beer on the wall.\n\n"
       "7 bottles of beer on the wall, 7 bottles of beer.\n"
       "Take one down and pass it around, 6 bottles of beer on the wall.\n\n"
       "6 bottles of beer on the wall, 6 bottles of beer.\n"
       "Take one down and pass it around, 5 bottles of beer on the wall.\n"))

(def song-3-0
  (str "3 bottles of beer on the wall, 3 bottles of beer.\n"
       "Take one down and pass it around, 2 bottles of beer on the wall.\n\n"
       "2 bottles of beer on the wall, 2 bottles of beer.\n"
       "Take one down and pass it around, 1 bottle of beer on the wall.\n\n"
       "1 bottle of beer on the wall, 1 bottle of beer.\n"
       "Take it down and pass it around, no more bottles of beer on the wall.\n\n"
       "No more bottles of beer on the wall, no more bottles of beer.\n"
       "Go to the store and buy some more, 99 bottles of beer on the wall.\n"))

(deftest test-verse
  (is (= verse-8 (beer-song/verse 8)))
  (is (= verse-2 (beer-song/verse 2)))
  (is (= verse-1 (beer-song/verse 1)))
  (is (= verse-0 (beer-song/verse 0))))

(deftest test-song
  (is (= song-8-6 (beer-song/sing 8 6)))
  (is (= song-3-0 (beer-song/sing 3))))
