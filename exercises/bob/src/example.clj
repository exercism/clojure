(ns bob
  (:require [clojure.string :as str]))

(defn- silence?    [msg] (str/blank? msg))

(defn- question?   [msg] (= \? (last msg)))

(defn- has-letter? [msg] (some #(Character/isLetter (int %)) msg))

(defn- shouting?   [msg] (and (= msg (str/upper-case msg))
                              (has-letter? msg)))

(defn- forceful-question? [msg]
  (and (shouting? msg) (question? msg)))

(defn response-for [input]
  (cond
    (forceful-question? input) "Calm down, I know what I'm doing!"
    (silence?  input) "Fine. Be that way!"
    (shouting? input) "Whoa, chill out!"
    (question? input) "Sure."
    :else             "Whatever."))
