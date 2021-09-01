(ns meetup
  (:import (java.util Calendar)))

(def day-offsets
  {:sunday    1
   :monday    2
   :tuesday   3
   :wednesday 4
   :thursday  5
   :friday    6
   :saturday  7})

(def days-of-month
  {:first 1
   :second 8
   :third 15
   :fourth 22
   :teenth 13})

(defn- ^Calendar to-date
  [year month day]
  (let [cal (Calendar/getInstance)]
    (.set cal Calendar/YEAR year)
    (.set cal Calendar/MONTH (dec month))
    (.set cal Calendar/DATE day)
    (.set cal Calendar/HOUR_OF_DAY 0)
    (.set cal Calendar/MINUTE 0)
    (.set cal Calendar/SECOND 0)
    (.set cal Calendar/MILLISECOND 0)
    cal))

(defn- date-parts
  [date]
  [(.get date Calendar/YEAR)
   (inc (.get date Calendar/MONTH))
   (.get date Calendar/DATE)])

(defn- days-to-move
  [weekday offset-and-direction]
  (let [offset    (Math/abs offset-and-direction)
        direction (/ offset-and-direction offset)]
    (* (mod (* -1 direction (- weekday offset)) 7) direction)))

(defn- offset-date
  [year month day offset]
  (let [date    (to-date year month day)
        weekday (.get date Calendar/DAY_OF_WEEK)]
    (.roll date Calendar/DATE (days-to-move weekday offset))
    date))

(defn- last-day-of-month
  [year month]
  (let [date (to-date year month 1)]
    (.getActualMaximum date Calendar/DAY_OF_MONTH)))

(defn- offset-for
  [schedule day-of-week]
  (if (= :last schedule)
    (* -1 day-of-week)
    day-of-week))

(defn meetup
  [month year day-name schedule]
  (let [day-of-month (if (= :last schedule)
                       (last-day-of-month year month)
                       (get days-of-month schedule))
        day-of-week (get day-offsets day-name)
        offset (offset-for schedule day-of-week)]
    (date-parts (offset-date year month day-of-month offset))))
