(ns trips-by-bike)

(defn estimated-trip-duration 
  "Returns the time it takes to do the trip
  given the average-speed."
  [average-speed trip ]
  (reduce + (map (partial * (/ 1.0 average-speed))  (map :distance trip))))

(defn time-per-trip
  "Returns the time it takes to do each one
  of the trips in the input vector `trips`,
  given `average-speed`. The result is a vector
  of floats, one per trip in `trips`."
  [trips average-speed]
  (map #(reduce + (map (partial * (/ 1.0 average-speed))  (map :distance %)))  trips)
  )

(defn calculate-speed
  "Returns the speed with each the trip
  `trip-with-duration` was done"
  [trip-with-duration]
  (/ (reduce + (map :distance trip-with-duration))
               (reduce + (map :duration trip-with-duration))))

(defn calculate-average-speed
  "Returns the average speed given the input vector 
  `trips-with-duration`."
  [trips-with-duration]
  (/ (reduce + (map calculate-speed trips-with-duration)) (count trips-with-duration)))

(defn time-per-trip-with-updated-speed
  "Given a vector `last-trips` with the time it 
  took to do the last trips, it calculates the average 
  speed with which those trips were done, and uses this
  average speed to estimate the time it will
  take to do each one of the trips in `next-trips`. The
  result is a vector of floats, one per trip in `next-trips`"
  [last-trips next-trips]
    ((comp (partial time-per-trip next-trips) calculate-average-speed) last-trips))

(defn slow-calculate-speed
  "Calculates the speed with which `trip-with-duration` 
  was performed. It introduces a delay of 0.1 sec in the
  calculation."
  [trip-with-duration]
  (Thread/sleep 10)
  (/ (reduce + (map :distance trip-with-duration))
               (reduce + (map :duration trip-with-duration))))

(def memoized-calculate-speed (memoize slow-calculate-speed))

(defn time-per-couple
  "Returns the estimated time it will take to finish 
  the given trip for each value in `average-speeds. 
  The result is a vector of floats with the same length
  as `average-speeds`."
  [average-speeds trip]
  ((apply juxt (map #(partial estimated-trip-duration %) average-speeds)) trip))

