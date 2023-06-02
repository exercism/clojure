(ns robot-name
  (:require [clojure.set :as set]))

;; h/t next-mad-hatter: https://exercism.org/tracks/clojure/exercises/robot-name/solutions/next-mad-hatter
;;
;; First, note how allowed robot names can be viewed as
;; mixed-base numbers (two digits in base 26, three in base 10)
;; between 0 and what is called max-robot-code below.
;;
;; We'll call these numbers robot codes to differentiate them from
;; their string representations (or "names").
;;
(def ^:private max-robot-code (+ (* 27 25 1000) 999))
;;
;; Above interpretation results in a mapping like this:
;;
;; (map code->name [0 1000 25999 26001 max-robot-code])
;; => ("AA000" "AB000" "AZ999" "BA001" "ZZ999")
;;
(defn- code->name [n]
  (let [part3   (mod n 1000)
        part2   (mod (int (/ n 1000)) 26)
        part1   (int (/ n 26000))
        letter2 (char (+ (int \A) part2))
        letter1 (char (+ (int \A) part1))]
    (str letter1 letter2 (format "%03d" part3))))
;;
;; Our world contains last code taken along with the set of all currently taken
;; codes.  Each robot will additionally hold all its previously assigned codes.
;;
(def ^:private world (atom [nil #{}]))
(def ^:private all-codes (set (range (inc max-robot-code))))
(defn- get-new-code [previous old-code [_ taken]]
  (let [available (set/difference all-codes taken previous)
        new-code  (-> available shuffle first)
        taken'    (-> taken (conj new-code) (disj old-code))]
    [new-code taken']))
(defn robot-name [robot]
  (-> robot :code deref code->name))
(defn reset-name [robot]
  (let [old-code     (-> robot :code deref)
        [new-code _] (swap! world (partial get-new-code (-> robot :previous deref) (-> robot :code deref)))]
    (assert (some? new-code))
    (when old-code (swap! (:previous robot) #(conj % old-code)))
    (reset! (:code robot) new-code)
    robot))
(defn robot []
  (-> {:previous (atom #{}) :code (atom nil)}
      reset-name))
(defn previous-names [robot]
  (->> robot :previous deref (map code->name)))
(defn current-names []
  (->> @world second (map code->name)))
