(ns gigasecond)

;; Given a moment, compute the moment that would be after an arbitrary number
;; of seconds has passed (one Gigasecond for this example).
;;
;; This function works is extreme cases like:
;; * Periods of any size (any positive number of seconds)
;; * Periods that include years like 1900 inside (oddly not leap year)
;; * Periods that start (or end), before (or after), the end of February in
;;   years that are (or not) leap years
;; * Periods that start (or end), before (or after), the start (or end) of any
;;   year
;;
;; Note: The number of seconds is embedded as `total-seconds` binding
(defn from [y m d]
  ;; Steps:
  ;; 1) Convert time period to days
  ;; 2) Compute result thru 3 sections of the period (Start, Middle, End)
  ;;  2a) Start: Remaining days in first month of the period
  ;;  2b) Middle: Find last month of the period (loop through months/years)
  ;;  2c) End: Days in the last month of the period
  (letfn [;; Helper to compute boolean whether a year is leap or not
          (leap-year? [year]
            (cond
              (zero? (mod year 400)) true
              (zero? (mod year 100)) false
              :else (zero? (mod year 4))))

          ;; Helper to compute total number of days in a year's month
          (days-in-month [year month]
            (cond
              (= month 2) (if (leap-year? year) 29 28) ; February
              (some #(= month %) [4 6 9 11]) 30 ; Abril, June, ...
              :else 31)) ; January, March, ...

          ;; Helper to compute the number of remaining days of a date's month
          ;; Ex.: [2000 2 27] results in 3 days because 2000 is a leap year
          ;;      so day 27, day 28 and day 29 are 3 days in total.
          ;; (To obtain the total days of a particular month, set day to 1)
          (days-to-next-month [year month day]
            (+ (days-in-month year month) (- day) 1))]

    (let [total-seconds 1e9 ;; Gigasecond (works with any positive number)
          seconds-per-day 86400 ;; 24 x 60 x 60
          ;; Convert seconds to days
          total-days (int (/ total-seconds seconds-per-day))]

      ;; Loop thru months decrementing the the total days remaining in period
      (loop [;; Initialize date and total days in period
             year y
             month m
             day d
             remaining total-days]
        (let [;; Compute amount to jump according to distance to next month
              ;; First loop cycle computes from date's day (step 2a)
              ;; Following cycles compute from 1st of current month (step 2b)
              jump (days-to-next-month year month day)]
          ;; Out of the loop when no more room for another month
          (if-not (>= remaining jump)
            ;; Result (step 2c)
            [year month (+ day remaining)]
            ;; Update to next month and increment year when necesary
            (recur ;; Increment year when December jumps to January
             (if (zero? (mod month 12)) (inc year) year)
                   ;; Circular month increment (December jumps to January)
             (inc (mod month 12))
             1 ;; 1st of month
                   ;; Decrement the the total days remaining in period
             (- remaining jump))))))))