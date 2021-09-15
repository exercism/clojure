(ns meetup)

(def day-structure
  {1 :sunday 2 :monday 3 :tuesday 4 :wednesday
   5 :thursday 6 :friday 7 :saturday})

(defn leap-year? [year]
  (cond (zero? (mod year 400)) true
        (zero? (mod year 100)) false
        :else  (zero? (mod year 4))))

(defn zellers-congruence [input_year input_month input_day]
  (let [month (+ (mod (+ input_month 9) 12) 3)
        year (- input_year (quot (- month input_month) 12))
        century (quot year 100)
        century-year (mod year 100)]
    (mod (+ input_day
            (quot (* 26 (inc month)) 10)
            century-year
            (quot century-year 4)
            (quot century 4)
            (* 5 century)) 7)))

(defn get-day-counts [year]
  {1 31, 2 (if (leap-year? year) 29 28), 3 31, 4 30
   5 31, 6 30, 7 31, 8 31, 9 30, 10 31, 11 30, 12 31})

(defn get-days
  ([year month]
   (get-days year month
             (zellers-congruence year month 1)
             (get-in (get-day-counts year) [month])))
  ([year month start-day limit]
   (loop [count 2
          day (inc start-day)
          day-arrangement {1 (get-in day-structure [start-day])}]
     (if (not= count (inc limit))
       (recur  (inc count)
               (if (= (inc day) 8) 1 (inc day))
               (assoc day-arrangement count
                      (get-in day-structure [day])))
       day-arrangement))))

(defn filter-by-day [year month day]
  (let [days (get-days year month)]
    (apply hash-map (flatten (filter #(-> % val (= day)) days)))))

(defn filter-keys [year month day style]
  (let [days (filter-by-day year month day)
        dates (sort (keys days))]
    (cond
      (= style :first)
      (nth dates 0)
      (= style :second)
      (nth dates 1)
      (= style :third)
      (nth dates 2)
      (= style :fourth)
      (nth dates 3)
      (= style :last)
      (nth dates (dec (count dates)))
      (= style :teenth)
      (first (filter #(and (> % 12) (< % 20)) (vec dates))))))

(defn meetup [month year day style]
  [year month (filter-keys year month day style)])