(ns clock-test
  (:require [clock :refer :all]
            [clojure.test :refer [deftest testing is]]))

(deftest create-clock-test

  (testing "on the hour"
    (let [test-clock (clock->string (clock 8 0))]
      (is (= "08:00" test-clock))))
  (testing "past the hour"
    (let [test-clock (clock->string (clock 11 9))]
      (is (= "11:09" test-clock))))
  (testing "midnight is zero hours"
    (let [test-clock (clock->string (clock 24 0))]
      (is (= "00:00" test-clock))))
  (testing "hour rolls over"
    (let [test-clock (clock->string (clock 25 0))]
      (is (= "01:00" test-clock))))
  (testing "hour rolls over continuously"
    (let [test-clock (clock->string (clock 100 0))]
      (is (= "04:00" test-clock))))
  (testing "sixty minutes is next hour"
    (let [test-clock (clock->string (clock 1 60))]
      (is (= "02:00" test-clock))))
  (testing "minutes roll over"
    (let [test-clock (clock->string (clock 0 160))]
      (is (= "02:40" test-clock))))
  (testing "minutes roll over continuously"
    (let [test-clock (clock->string (clock 0 1723))]
      (is (= "04:43" test-clock))))
  (testing "hour and minutes roll over"
    (let [test-clock (clock->string (clock 25 160))]
      (is (= "03:40" test-clock))))
  (testing "hour and minutes roll over continuously"
    (let [test-clock (clock->string (clock 201 3001))]
      (is (= "11:01" test-clock))))
  (testing "hour and minutes roll over to exactly midnight"
    (let [test-clock (clock->string (clock 72 8640))]
      (is (= "00:00" test-clock))))
  (testing "negative hour"
    (let [test-clock (clock->string (clock -1 15))]
      (is (= "23:15" test-clock))))
  (testing "negative hour rolls over"
    (let [test-clock (clock->string (clock -25 0))]
      (is (= "23:00" test-clock))))
  (testing "negative hour rolls over continuously"
    (let [test-clock (clock->string (clock -91 0))]
      (is (= "05:00" test-clock))))
  (testing "negative minutes"
    (let [test-clock (clock->string (clock 1 -40))]
      (is (= "00:20" test-clock))))
  (testing "negative minutes roll over"
    (let [test-clock (clock->string (clock 1 -160))]
      (is (= "22:20" test-clock))))
  (testing "negative minutes roll over continuously"
    (let [test-clock (clock->string (clock 1 -4820))]
      (is (= "16:40" test-clock))))
  (testing "negative hour and minutes both roll over"
    (let [test-clock (clock->string (clock -25 -160))]
      (is (= "20:20" test-clock))))
  (testing "negative hour and minutes both roll over continuously"
    (let [test-clock (clock->string (clock -121 -5810))]
      (is (= "22:10" test-clock)))))

(deftest add-time-test

  (testing "add minutes"
    (let [test-clock (clock->string (add-time (clock 10 0) 3))]
      (is (= "10:03" test-clock))))
  (testing "add no minutes"
    (let [test-clock (clock->string (add-time (clock 6 41) 0))]
      (is (= "06:41" test-clock))))
  (testing "add to next hour"
    (let [test-clock (clock->string (add-time (clock 0 45) 40))]
      (is (= "01:25" test-clock))))
  (testing "add more than one hour"
    (let [test-clock (clock->string (add-time (clock 10 0) 61))]
      (is (= "11:01" test-clock))))
  (testing "add more than two hours with carry"
    (let [test-clock (clock->string (add-time (clock 0 45) 160))]
      (is (= "03:25" test-clock))))
  (testing "add across midnight"
    (let [test-clock (clock->string (add-time (clock 23 59) 2))]
      (is (= "00:01" test-clock))))
  (testing "add more than one day (1500 min = 25 hrs)"
    (let [test-clock (clock->string (add-time (clock 5 32) 1500))]
      (is (= "06:32" test-clock))))
  (testing "add more than two days"
    (let [test-clock (clock->string (add-time (clock 1 1) 3500))]
      (is (= "11:21" test-clock))))
  (testing "subtract minutes"
    (let [test-clock (clock->string (add-time (clock 10 3) -3))]
      (is (= "10:00" test-clock))))
  (testing "subtract to previous hour"
    (let [test-clock (clock->string (add-time (clock 10 3) -30))]
      (is (= "09:33" test-clock))))
  (testing "subtract more than an hour"
    (let [test-clock (clock->string (add-time (clock 10 3) -70))]
      (is (= "08:53" test-clock))))
  (testing "subtract across midnight"
    (let [test-clock (clock->string (add-time (clock 0 3) -4))]
      (is (= "23:59" test-clock))))
  (testing "subtract more than two hours"
    (let [test-clock (clock->string (add-time (clock 0 0) -160))]
      (is (= "21:20" test-clock))))
  (testing "subtract more than two hours with borrow"
    (let [test-clock (clock->string (add-time (clock 6 15) -160))]
      (is (= "03:35" test-clock))))
  (testing "subtract more than one day (1500 min = 25 hrs)"
    (let [test-clock (clock->string (add-time (clock 5 32) -1500))]
      (is (= "04:32" test-clock))))
  (testing "subtract more than two days"
    (let [test-clock (clock->string (add-time (clock 2 20) -3000))]
      (is (= "00:20" test-clock)))))

(deftest equal-clock-test
  (testing "clocks with same time"
    (let [clock1 (clock 15 37)
          clock2 (clock 15 37)]
      (is (= clock1 clock2))))
  (testing "clocks a minute apart"
    (let [clock1 (clock 15 36)
          clock2 (clock 15 37)]
      (is (not= clock1 clock2))))
  (testing "clocks an hour apart"
    (let [clock1 (clock 14 37)
          clock2 (clock 15 37)]
      (is (not= clock1 clock2))))
  (testing "clocks with hour overflow"
    (let [clock1 (clock 10 37)
          clock2 (clock 34 37)]
      (is (= clock1 clock2))))
  (testing "clocks with hour overflow by several days"
    (let [clock1 (clock 3 11)
          clock2 (clock 99 11)]
      (is (= clock1 clock2))))
  (testing "clocks with negative hour"
    (let [clock1 (clock 22 40)
          clock2 (clock -2 40)]
      (is (= clock1 clock2))))
  (testing "clocks with negative hour that wraps"
    (let [clock1 (clock 17 3)
          clock2 (clock -31 3)]
      (is (= clock1 clock2))))
  (testing "clocks with negative hour that wraps multiple times"
    (let [clock1 (clock 13 49)
          clock2 (clock -83 49)]
      (is (= clock1 clock2))))
  (testing "clocks with minute overflow"
    (let [clock1 (clock 0 1)
          clock2 (clock 0 1441)]
      (is (= clock1 clock2))))
  (testing "clocks with minute overflow by several days"
    (let [clock1 (clock 2 2)
          clock2 (clock 2 4322)]
      (is (= clock1 clock2))))
  (testing "clocks with negative minute"
    (let [clock1 (clock 2 40)
          clock2 (clock 3 -20)]
      (is (= clock1 clock2))))
  (testing "clocks with negative minute that wraps"
    (let [clock1 (clock 4 10)
          clock2 (clock 5 -1490)]
      (is (= clock1 clock2))))
  (testing "clocks with negative minute that wraps multiple times"
    (let [clock1 (clock 6 15)
          clock2 (clock 6 -4305)]
      (is (= clock1 clock2))))
  (testing "clocks with negative hours and minutes"
    (let [clock1 (clock 7 32)
          clock2 (clock -12 -268)]
      (is (= clock1 clock2))))
  (testing "clocks with negative hours and minutes that wrap"
    (let [clock1 (clock 18 7)
          clock2 (clock -54 -11513)]
      (is (= clock1 clock2)))))
