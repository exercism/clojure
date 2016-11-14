(ns clock)

(defn clock
  "Return a 24 hour clock representation of the given hours and minutes."
  [in-hour in-minute]
  (let [total-minutes (mod (+ (* in-hour 60) in-minute) (* 60 24))
        hours (mod (quot total-minutes 60) 24)
        minutes (mod total-minutes 60)]
    {:hour hours :minute minutes}))

(defn clock->string
  "Print the HH:MM representation of a clock."
  [in-clock]
  (format "%02d:%02d" (:hour in-clock) (:minute in-clock)))

(defn add-time
  "Add minutes to the given clock."
  [in-clock minutes-to-add]
  (clock (:hour in-clock) (+ (:minute in-clock) minutes-to-add)))
