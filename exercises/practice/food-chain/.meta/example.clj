(ns food-chain
  (:require [clojure.string :as str]))

(def animals ["fly" "spider" "bird" "cat" "dog" "goat" "cow" "horse"])

(def phrases [nil
              "It wriggled and jiggled and tickled inside her."
              "How absurd to swallow a bird!"
              "Imagine that, to swallow a cat!"
              "What a hog, to swallow a dog!"
              "Just opened her throat and swallowed a goat!"
              "I don't know how she swallowed a cow!"
              nil])

(defn verse-begin [n]
  (let [first (str "I know an old lady who swallowed a " (get animals n) ".")
        second (get phrases n)]
    (remove nil? [first second])))

(defn verse-caught [caught]
  (if (= "spider" caught)
    (str caught " that wriggled and jiggled and tickled inside her")
    caught))

(defn verse-swallow [[swallowed caught]]
  (str "She swallowed the " swallowed " to catch the " (verse-caught caught) "."))

(defn verse-swallows [n]
  (mapv verse-swallow (partition 2 1 (reverse (take (inc n) animals)))))

(defn verse-middle [n]
  (if (< 0 n 7)
    (verse-swallows n)
    []))

(defn verse-end [n]
  (if (< n 7)
    "I don't know why she swallowed the fly. Perhaps she'll die."
    "She's dead, of course!"))

(defn verse [n]
  (->> (cons (verse-begin n) (conj (verse-middle n) (verse-end n)))
       (flatten)
       (str/join "\n")))

(defn recite [start-verse end-verse]
  (->> (range (dec start-verse) end-verse)
       (map verse)
       (interpose "")
       (str/join "\n")))
