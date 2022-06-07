(ns date-parser-test
  (:require [clojure.test :refer [deftest testing is]]
            date-parser))

(deftest day-test
  (testing "numeric pattern for day matches"
    (testing "un-padded 1"
      (is (= "1" (re-matches (re-pattern date-parser/day) "1"))))
    (testing "un-padded 2"
      (is (= "2" (re-matches (re-pattern date-parser/day) "2"))))
    (testing "un-padded 3"
      (is (= "3" (re-matches (re-pattern date-parser/day) "3"))))
    (testing "un-padded 4"
      (is (= "4" (re-matches (re-pattern date-parser/day) "4"))))
    (testing "un-padded 5"
      (is (= "5" (re-matches (re-pattern date-parser/day) "5"))))
    (testing "un-padded 6"
      (is (= "6" (re-matches (re-pattern date-parser/day) "6"))))
    (testing "un-padded 7"
      (is (= "7" (re-matches (re-pattern date-parser/day) "7"))))
    (testing "un-padded 8"
      (is (= "8" (re-matches (re-pattern date-parser/day) "8"))))
    (testing "un-padded 9"
      (is (= "9" (re-matches (re-pattern date-parser/day) "9"))))
    (testing "un-padded 10"
      (is (= "10" (re-matches (re-pattern date-parser/day) "10"))))
    (testing "un-padded 11"
      (is (= "11" (re-matches (re-pattern date-parser/day) "11"))))
    (testing "un-padded 12"
      (is (= "12" (re-matches (re-pattern date-parser/day) "12"))))
    (testing "un-padded 13"
      (is (= "13" (re-matches (re-pattern date-parser/day) "13"))))
    (testing "un-padded 14"
      (is (= "14" (re-matches (re-pattern date-parser/day) "14"))))
    (testing "un-padded 15"
      (is (= "15" (re-matches (re-pattern date-parser/day) "15"))))
    (testing "un-padded 16"
      (is (= "16" (re-matches (re-pattern date-parser/day) "16"))))
    (testing "un-padded 17"
      (is (= "17" (re-matches (re-pattern date-parser/day) "17"))))
    (testing "un-padded 18"
      (is (= "18" (re-matches (re-pattern date-parser/day) "18"))))
    (testing "un-padded 19"
      (is (= "19" (re-matches (re-pattern date-parser/day) "19"))))
    (testing "un-padded 20"
      (is (= "20" (re-matches (re-pattern date-parser/day) "20"))))
    (testing "un-padded 21"
      (is (= "21" (re-matches (re-pattern date-parser/day) "21"))))
    (testing "un-padded 22"
      (is (= "22" (re-matches (re-pattern date-parser/day) "22"))))
    (testing "un-padded 23"
      (is (= "23" (re-matches (re-pattern date-parser/day) "23"))))
    (testing "un-padded 24"
      (is (= "24" (re-matches (re-pattern date-parser/day) "24"))))
    (testing "un-padded 25"
      (is (= "25" (re-matches (re-pattern date-parser/day) "25"))))
    (testing "un-padded 26"
      (is (= "26" (re-matches (re-pattern date-parser/day) "26"))))
    (testing "un-padded 27"
      (is (= "27" (re-matches (re-pattern date-parser/day) "27"))))
    (testing "un-padded 28"
      (is (= "28" (re-matches (re-pattern date-parser/day) "28"))))
    (testing "un-padded 29"
      (is (= "29" (re-matches (re-pattern date-parser/day) "29"))))
    (testing "un-padded 30"
      (is (= "30" (re-matches (re-pattern date-parser/day) "30"))))
    (testing "un-padded 31"
      (is (= "31" (re-matches (re-pattern date-parser/day) "31"))))
    (testing "un-padded 1"
      (is (= "1" (re-matches (re-pattern date-parser/day) "1"))))
    (testing "padded 02"
      (is (= "02" (re-matches (re-pattern date-parser/day) "02"))))
    (testing "padded 03"
      (is (= "03" (re-matches (re-pattern date-parser/day) "03"))))
    (testing "padded 04"
      (is (= "04" (re-matches (re-pattern date-parser/day) "04"))))
    (testing "padded 05"
      (is (= "05" (re-matches (re-pattern date-parser/day) "05"))))
    (testing "padded 06"
      (is (= "06" (re-matches (re-pattern date-parser/day) "06"))))
    (testing "padded 07"
      (is (= "07" (re-matches (re-pattern date-parser/day) "07"))))
    (testing "padded 08"
      (is (= "08" (re-matches (re-pattern date-parser/day) "08"))))
    (testing "padded 09"
      (is (= "09" (re-matches (re-pattern date-parser/day) "09")))))
  (testing "numeric pattern for a day that doesn't match"
    (testing "too few digits"
      (is (nil? (re-matches (re-pattern date-parser/day) ""))))
    (testing "too many digits"
      (is (nil? (re-matches (re-pattern date-parser/day) "111"))))
    (testing "one letter"
      (is (nil? (re-matches (re-pattern date-parser/day) "a"))))
    (testing "two letters"
      (is (nil? (re-matches (re-pattern date-parser/day) "bb"))))))

(deftest month-test
  (testing "numeric pattern for month matches"
    (testing "un-padded 1"
      (is (= "1" (re-matches (re-pattern date-parser/month) "1"))))
    (testing "un-padded 2"
      (is (= "2" (re-matches (re-pattern date-parser/month) "2"))))
    (testing "un-padded 3"
      (is (= "3" (re-matches (re-pattern date-parser/month) "3"))))
    (testing "un-padded 4"
      (is (= "4" (re-matches (re-pattern date-parser/month) "4"))))
    (testing "un-padded 5"
      (is (= "5" (re-matches (re-pattern date-parser/month) "5"))))
    (testing "un-padded 6"
      (is (= "6" (re-matches (re-pattern date-parser/month) "6"))))
    (testing "un-padded 7"
      (is (= "7" (re-matches (re-pattern date-parser/month) "7"))))
    (testing "un-padded 8"
      (is (= "8" (re-matches (re-pattern date-parser/month) "8"))))
    (testing "un-padded 9"
      (is (= "9" (re-matches (re-pattern date-parser/month) "9"))))
    (testing "un-padded 10"
      (is (= "10" (re-matches (re-pattern date-parser/month) "10"))))
    (testing "un-padded 11"
      (is (= "11" (re-matches (re-pattern date-parser/month) "11"))))
    (testing "un-padded 12"
      (is (= "12" (re-matches (re-pattern date-parser/month) "12"))))
    (testing "padded 01"
      (is (= "01" (re-matches (re-pattern date-parser/month) "01"))))
    (testing "padded 02"
      (is (= "02" (re-matches (re-pattern date-parser/month) "02"))))
    (testing "padded 03"
      (is (= "03" (re-matches (re-pattern date-parser/month) "03"))))
    (testing "padded 04"
      (is (= "04" (re-matches (re-pattern date-parser/month) "04"))))
    (testing "padded 05"
      (is (= "05" (re-matches (re-pattern date-parser/month) "05"))))
    (testing "padded 06"
      (is (= "06" (re-matches (re-pattern date-parser/month) "06"))))
    (testing "padded 07"
      (is (= "07" (re-matches (re-pattern date-parser/month) "07"))))
    (testing "padded 08"
      (is (= "08" (re-matches (re-pattern date-parser/month) "08"))))
    (testing "padded 09"
      (is (= "09" (re-matches (re-pattern date-parser/month) "09")))))
  (testing "numeric pattern for month that doesn't match"
    (testing "too few digits"
      (is (nil? (re-matches (re-pattern date-parser/month) ""))))
    (testing "too many digits"
      (is (nil? (re-matches (re-pattern date-parser/month) "111"))))
    (testing "one letter"
      (is (nil? (re-matches (re-pattern date-parser/month) "a"))))
    (testing "two letters"
      (is (nil? (re-matches (re-pattern date-parser/month) "bb"))))
    (testing "short month name"
      (is (nil? (re-matches (re-pattern date-parser/month) "Jan"))))
    (testing "long month name"
      (is (nil? (re-matches (re-pattern date-parser/month) "January"))))))

(deftest year-test
  (testing "numeric pattern for year"
    (testing "matches 4 digits"
      (is (= "1970" (re-matches (re-pattern date-parser/year) "1970"))))
    (testing "doesn't match short year"
      (is (nil? (re-matches (re-pattern date-parser/year) "84"))))
    (testing "doesn't match letters"
      (is (nil? (re-matches (re-pattern date-parser/year) "198A"))))
    (testing "doesn't match too few"
      (is (nil? (re-matches (re-pattern date-parser/year) "198"))))
    (testing "doesn't match too many"
      (is (nil? (re-matches (re-pattern date-parser/year) "19701"))))))

(deftest day-names-test
  (testing "day names match"
    (is (= "Sunday" (date-parser/day-names "Sunday")))
    (is (= "Monday" (date-parser/day-names "Monday")))
    (is (= "Tuesday" (date-parser/day-names "Tuesday")))
    (is (= "Wednesday" (date-parser/day-names "Wednesday")))
    (is (= "Thursday" (date-parser/day-names "Thursday")))
    (is (= "Friday" (date-parser/day-names "Friday")))
    (is (= "Saturday" (date-parser/day-names "Saturday"))))
  (testing "day names don't match"
    (testing "combined"
      (is (nil? (date-parser/day-names "SundayMonday"))))
    (testing "short name"
      (is (nil? (date-parser/day-names "Sun"))))
    (testing "numeric day of the week (0-indexed)"
      (is (nil? (date-parser/day-names "0"))))
    (testing "numeric day of the week (1-indexed)"
      (is (nil? (date-parser/day-names "1")))))
  (testing "day names don't match with trailing or leading whitespace"
    (is (nil? (date-parser/day-names " Sunday ")))))

(deftest month-names-test
  (testing "month names match"
    (is (= "January" (date-parser/month-names "January")))
    (is (= "February" (date-parser/month-names "February")))
    (is (= "March" (date-parser/month-names "March")))
    (is (= "April" (date-parser/month-names "April")))
    (is (= "May" (date-parser/month-names "May")))
    (is (= "June" (date-parser/month-names "June")))
    (is (= "July" (date-parser/month-names "July")))
    (is (= "August" (date-parser/month-names "August")))
    (is (= "September" (date-parser/month-names "September")))
    (is (= "October" (date-parser/month-names "October")))
    (is (= "November" (date-parser/month-names "November")))
    (is (= "December" (date-parser/month-names "December"))))
  (testing "month names don't match"
    (testing "combined"
      (is (nil? (date-parser/month-names "JanuaryFebruary"))))
    (testing "short name"
      (is (nil? (date-parser/month-names "Jan"))))
    (testing "numeric month of the year (0-indexed)"
      (is (nil? (date-parser/month-names "0"))))
    (testing "numeric month of the year (1-indexed)"
      (is (nil? (date-parser/month-names "1")))))
  (testing "month names don't match with trailing or leading whitespace"
    (is (nil? (date-parser/day-names " January ")))))

(deftest capture-test
  (testing "capture numeric month"
    (is (= {:month "01"} (date-parser/capture-month "01"))))
  (testing "capture numeric day"
    (is (= {:day "01"} (date-parser/capture-day "01"))))
  (testing "capture numeric year"
    (is (= {:year "1970"} (date-parser/capture-year "1970"))))
  (testing "capture day name"
    (is (= {:day-name "Monday"} (date-parser/capture-day-name "Monday"))))
  (testing "capture month name"
    (is (= {:month-name "February"} (date-parser/capture-month-name "February"))))
  (testing "numeric date"
    (is (= {:year "1970", :month "02", :day "01"} (date-parser/capture-numeric-date "01/02/1970"))))
  (testing "month named date"
    (is (= {:year "1970", :month-name "January", :day "1"} (date-parser/capture-month-name-date "January 1, 1970"))))
  (testing "day and month named date"
    (is (= {:year "1970", :month-name "January", :day "1", :day-name "Thursday"}
           (date-parser/capture-day-month-name-date "Thursday, January 1, 1970")))))

(deftest match-numeric-date-test
  (testing "pattern to match numeric date is a regex"
    (is (= java.util.regex.Pattern (type date-parser/match-numeric-date))))
  (testing "numeric date matches"
    (is (= "01/02/1970"
           (first (re-matches date-parser/match-numeric-date "01/02/1970")))))
  (testing "numeric date has named captures"
    (is (= ["01/02/1970" "01" "02" "1970"]
           (re-matches date-parser/match-numeric-date "01/02/1970"))))
  (testing "numeric date with a prefix doesn't match"
    (is (nil? (re-matches date-parser/match-numeric-date "The day was 01/02/1970"))))
  (testing "numeric date with a suffix doesn't match"
    (is (nil? (re-matches date-parser/match-numeric-date "01/02/1970 was the day"))))
  (testing "pattern to match month name date is a regex"
    (is (= java.util.regex.Pattern (type date-parser/match-month-name-date))))
  (testing "month named date matches"
    (is (= "January 1, 1970"
           (first (re-matches date-parser/match-month-name-date "January 1, 1970")))))
  (testing "month named date has named captures"
    (is (= ["January 1, 1970" "January" "1" "1970"]
           (re-matches date-parser/match-month-name-date "January 1, 1970"))))
  (testing "month named date with a prefix doesn't match"
    (is (nil? (re-matches date-parser/match-month-name-date "The day was January 1, 1970"))))
  (testing "month named date with a suffix doesn't match"
    (is (nil? (re-matches date-parser/match-month-name-date "January 1, 1970 was the day"))))
  (testing "day and month names date matches"
    (is (= "Thursday, January 1, 1970"
           (first (re-matches date-parser/match-day-month-name-date "Thursday, January 1, 1970")))))
  (testing "month named date has named captures"
    (is (= ["Thursday, January 1, 1970" "Thursday" "January" "1" "1970"]
           (re-matches date-parser/match-day-month-name-date "Thursday, January 1, 1970"))))
  (testing "day and month names date with a prefix doesn't match"
    (is (nil? (re-matches date-parser/match-day-month-name-date "The day way Thursday, January 1, 1970"))))
  (testing "day and month names date with a suffix doesn't match"
    (is (nil? (re-matches date-parser/match-day-month-name-date "Thursday, January 1, 1970 was the day")))))


(clojure.test/run-tests)