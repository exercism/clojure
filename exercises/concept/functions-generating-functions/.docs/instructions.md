# Instructions

Mary and John like to do frequent trips by bike. Based on their previous trips, they have estimated that their average speed is `20 km/h`.

```clojure
(def john-mary-average-speed 20)
```

Based on their average speed, they want to estimate how long it will take to perform their next planned trips.

# 1. Estimate total duration of a given trip

Each trip is defined as a list of maps, for example:

```clojure
(def trip 
  [{:origin "Paris"
    :destination "Lyon"
    :distance 800}
  
   {:origin "Lyon"
    :destination "Milan"
    :distance 500}
  
   {:origin "Milan"
    :destination "Rome"
    :distance 300}])

```

Using `map`, `reduce`, and `partial`, implement a function that takes as input the average speed and a given trip, and returns the estimated time that takes to do such trip:

```clojure
(defn estimated-trip-duration 
  "Returns the time it takes to do the trip
  given the average-speed."
  [average-speed trip]
  ;(reduce + (map my-partial-fn (:distance trip))))
```

in our case, if we run:

```clojure
(estimated-trip-duration john-mary-average-speed trip) ; => 80.0
```

we get 80.0

In mathematical notation we have:
 
```
my-full-fn (speed, distance) => time it takes to travel given distance at given speed
my-partial-fn = my-full-fn (speed=average-speed, distance) => new function where the parameter `speed` is set to value `average-speed`. The returned function accepts only one parameter:
my-partial-fn (distance) => time it takes to travel given distance if speed is fixed to be `average-speed`
```
where `average-speed` is the value introduced as parameter to `estimated-trip-duration`. 

Note that, instead of using `partial`, we could simply use an anonymous function, i.e., `#(...)`. Using `partial` will become handy in the next task where we need to nest several such functions. This is due to the fact that clojure doesn't allow to nest multiple anonymous functions, as explained [here][anonymous-functions-official-docs]. Again, we could use `fn` instead of `partial`, since we can nest multiple functions defined with `fn`. However, `partial` offers a slightly more compact syntax for achieving the same. 

## 2. Estimate duration of multiple trips

John and Mary are still a bit undecisive about what their next trip will be. They have several potential trips in mind, but this time they have a very limited number of remaining annual leave days. They decide to estimate the total duration per trip and select the trip that takes the least amount of time.

Implement a function that, given a list of trips, returns a list of durations:

```clojure
(defn time-per-trip
  "Returns the time it takes to do each one
  of the trips in the input vector `trips`,
  given `average-speed`. The result is a vector
  of floats, one per trip in `trips`."
  [trips average-speed]
  ; (...)
  )
```

For example:
```clojure
(def trip1
  [{:origin "Paris"
    :destination "Lyon"
    :distance 800}

   {:origin "Lyon"
    :destination "Milan"
    :distance 500}

   {:origin "Milan"
    :destination "Rome"
    :distance 300}])

(def trip2
  [{:origin "Madrid"
    :destination "Barcelona"
    :distance 700}

   {:origin "Barcelona"
    :destination "San Sebastian"
    :distance 500}

   {:origin "San Sebastian"
    :destination "Santiago de Compostela"
    :distance 450}])

(time-per-trip [trip1 trip2] john-mary-average-speed) ; => (80.0 82.5)
```

While `time-per-trip` could simply call `estimated-trip-duration`. For doing this exercise, however, we recommend to avoid using `estimated-trip-duration`, so that we can see the use of partial in a nested expression. 

Hint: we can use here an outer anonymous function with the syntax `#(reduce + ...)`` and use `partial` in the inner part of this expression.

### 3. Update the estimated average speed 

As John and Mary get more and more practice in doing this type of trips by bike, they observe that their average speed is increasing over time. They would like to use the most up-to-date estimate of their average speed to calculate the duration of the next trips.

Use `comp` to implement a function that, given the last trips, and the next potential trips:

- calculates a new average-speed based on the last trips
- uses the new average-speed to calculate the time it takes to do each one of the next potential trips

In order to implement this function:

1. implement `calculate-speed`:

```clojure
(defn calculate-speed 
  "Returns the speed with each the trip
  `trip-with-duration` was done"
  [trip-with-duration]
  (...))
```

where `trip-with-duration` is a map similar to `trip` but including duration:

```clojure
(def trip-with-duration-1
  [{:origin "Paris"
    :destination "Lyon"
    :distance 800
    :duration 50.0}

   {:origin "Lyon"
    :destination "Milan"
    :distance 500
    :duration 35.0}

   {:origin "Milan"
    :destination "Rome"
    :distance 300
    :duration 20.0}
   ])
```

```clojure
(calculate-average-speed trip-with-duration-1) ; => 15.238095238095237
```

2. Implement `calculate-average-speed`

```clojure
(defn calculate-average-speed 
  "Returns the average speed given the input vector 
  `trips-with-duration`."
  [trips-with-duration]
  ;(...)
)
```

where `trips-with-duration` is a vector of `trip-with-duration` maps 

```clojure
(def trip-with-duration-2
  [{:origin "Madrid"
    :destination "Barcelona"
    :distance 700
    :duration 45.0}

   {:origin "Barcelona"
    :destination "San Sebastian"
    :distance 500
    :duration 35.0}

   {:origin "San Sebastian"
    :destination "Santiago de Compostela"
    :distance 450
    :duration 33.5}])

(def trips-with-duration [trip-with-duration-1 trip-with-duration-2])
```

```clojure
(calculate-average-speed trips-with-duration) ; => 14.887770086007972
```

3. Implement `time-per-trip-with-updated-speed`

```clojure
(defn time-per-trip-with-updated-speed
  "Given a vector `last-trips` with the time it 
  took to do the last trips, it calculates the average 
  speed with which those trips were done, and uses this
  average speed to estimate the time it will
  take to do each one of the trips in `next-trips`. The
  result is a vector of floats, one per trip in `next-trips`"
  [last-trips next-trips]
  ; ...
  )
```

```clojure
(def next-trip-1
  [{:origin "Amsterdam"
    :destination "Copenhaguen"
    :distance 800}

   {:origin "Copenhaguen"
    :destination "Berlin"
    :distance 500}

   {:origin "Berlin"
    :destination "Frankfurt"
    :distance 300}])

(def next-trip-2
  [{:origin "Helsinki"
    :destination "Saint PetersBurg"
    :distance 400}

   {:origin "Saint PetersBurg"
    :destination "Moscow"
    :distance 900}

   {:origin "Moscow"
    :destination "Minsk"
    :distance 750}])

(def next-trips [next-trip-1 next-trip-2])

(time-per-trip-with-updated-speed trips-with-duration next-trips) ; => (107.47076229392701 137.69691418909397)
```

in order to implement `time-per-trip-with-updated-speed`, make use of `comp`, `partial`, and the previous functions: `calculate-average-speed` and `time-per-trip`

### 4. Save time by using memoize

The function `calculate-average-speed` takes a list of previous trips, calculates the speed per trip using `calculate-speed`, and then calculates the average. When we add a new trip to the list, the calculation of speed per trip needs to be repeated for all the previous trips that were already in the list. Since this is not really an expensive computation, let us implement a new function `slow-calculate-speed` where we add an artificial delay of 0.1 seconds, and wrap that function with `memoize`.

```clojure
(defn slow-calculate-speed
  "Calculates the speed with which `trip-with-duration` 
  was performed. It introduces a delay of 0.1 sec in the
  calculation."
  [trip-with-duration]
; ...
)

(def memoized-calculate-speed (memoize slow-calculate-speed))
```

### 5. Calculate the trip duration for multiple couples

John and Mary have joined an organized group of bike travellers who travel in couples. Each couple has estimated their average speed. Given a new trip, they want to estimate the time it takes to do such trip for each one of the couples:

```clojure
(defn time-per-couple
  "Returns the estimated time it will take to finish 
  the given trip for each value in `average-speeds`. 
  The result is a vector of floats with the same length
  as `average-speeds`."
  [average-speeds trip]
  ; (...)
)
```

```clojure
(def average-speeds [20.0 25.0 15.0 30.0])
(time-per-couple average-speeds trip1) ; => [80.0 64.0 106.66666666666667 53.333333333333336]
```

In order to implement `time-per-couple` we can use `juxt`. The individual functions used by `juxt` can be obtained with `partial` applied to each individual average-speed.


[anonymous-functions-official-docs]: https://clojure.org/guides/learn/functions#_anonymous_function_syntax