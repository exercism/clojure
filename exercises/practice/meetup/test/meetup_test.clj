(ns meetup-test
  (:require [clojure.test :refer [deftest is]]
            meetup))

(deftest monteenth-of-may-2013
  (is (= [2013 5 13] (meetup/meetup 5 2013 :monday :teenth))))

(deftest monteenth-of-august-2013
  (is (= [2013 8 19] (meetup/meetup 8 2013 :monday :teenth))))

(deftest monteenth-of-september-2013
  (is (= [2013 9 16] (meetup/meetup 9 2013 :monday :teenth))))

(deftest tuesteenth-of-march-2013
  (is (= [2013 3 19] (meetup/meetup 3 2013 :tuesday :teenth))))

(deftest tuesteenth-of-april-2013
  (is (= [2013 4 16] (meetup/meetup 4 2013 :tuesday :teenth))))

(deftest tuesteenth-of-august-2013
  (is (= [2013 8 13] (meetup/meetup 8 2013 :tuesday :teenth))))

(deftest wednesteenth-of-january-2013
  (is (= [2013 1 16] (meetup/meetup 1 2013 :wednesday :teenth))))

(deftest wednesteenth-of-february-2013
  (is (= [2013 2 13] (meetup/meetup 2 2013 :wednesday :teenth))))

(deftest wednesteenth-of-june-2013
  (is (= [2013 6 19] (meetup/meetup 6 2013 :wednesday :teenth))))

(deftest thursteenth-of-may-2013
  (is (= [2013 5 16] (meetup/meetup 5 2013 :thursday :teenth))))

(deftest thursteenth-of-june-2013
  (is (= [2013 6 13] (meetup/meetup 6 2013 :thursday :teenth))))

(deftest thursteenth-of-september-2013
  (is (= [2013 9 19] (meetup/meetup 9 2013 :thursday :teenth))))

(deftest friteenth-of-april-2013
  (is (= [2013 4 19] (meetup/meetup 4 2013 :friday :teenth))))

(deftest friteenth-of-august-2013
  (is (= [2013 8 16] (meetup/meetup 8 2013 :friday :teenth))))

(deftest friteenth-of-september-2013
  (is (= [2013 9 13] (meetup/meetup 9 2013 :friday :teenth))))

(deftest saturteenth-of-february-2013
  (is (= [2013 2 16] (meetup/meetup 2 2013 :saturday :teenth))))

(deftest saturteenth-of-april-2013
  (is (= [2013 4 13] (meetup/meetup 4 2013 :saturday :teenth))))

(deftest saturteenth-of-october-2013
  (is (= [2013 10 19] (meetup/meetup 10 2013 :saturday :teenth))))

(deftest sunteenth-of-may-2013
  (is (= [2013 5 19] (meetup/meetup 5 2013 :sunday :teenth))))

(deftest sunteenth-of-june-2013
  (is (= [2013 6 16] (meetup/meetup 6 2013 :sunday :teenth))))

(deftest sunteenth-of-october-2013
  (is (= [2013 10 13] (meetup/meetup 10 2013 :sunday :teenth))))

(deftest first-monday-of-march-2013
  (is (= [2013 3 4] (meetup/meetup 3 2013 :monday :first))))

(deftest first-monday-of-april-2013
  (is (= [2013 4 1] (meetup/meetup 4 2013 :monday :first))))

(deftest first-tuesday-of-may-2013
  (is (= [2013 5 7] (meetup/meetup 5 2013 :tuesday :first))))

(deftest first-tuesday-of-june-2013
  (is (= [2013 6 4] (meetup/meetup 6 2013 :tuesday :first))))

(deftest first-wednesday-of-july-2013
  (is (= [2013 7 3] (meetup/meetup 7 2013 :wednesday :first))))

(deftest first-wednesday-of-august-2013
  (is (= [2013 8 7] (meetup/meetup 8 2013 :wednesday :first))))

(deftest first-thursday-of-september-2013
  (is (= [2013 9 5] (meetup/meetup 9 2013 :thursday :first))))

(deftest first-thursday-of-october-2013
  (is (= [2013 10 3] (meetup/meetup 10 2013 :thursday :first))))

(deftest first-friday-of-november-2013
  (is (= [2013 11 1] (meetup/meetup 11 2013 :friday :first))))

(deftest first-friday-of-december-2013
  (is (= [2013 12 6] (meetup/meetup 12 2013 :friday :first))))

(deftest first-saturday-of-january-2013
  (is (= [2013 1 5] (meetup/meetup 1 2013 :saturday :first))))

(deftest first-saturday-of-february-2013
  (is (= [2013 2 2] (meetup/meetup 2 2013 :saturday :first))))

(deftest first-sunday-of-march-2013
  (is (= [2013 3 3] (meetup/meetup 3 2013 :sunday :first))))

(deftest first-sunday-of-april-2013
  (is (= [2013 4 7] (meetup/meetup 4 2013 :sunday :first))))

(deftest second-monday-of-march-2013
  (is (= [2013 3 11] (meetup/meetup 3 2013 :monday :second))))

(deftest second-monday-of-april-2013
  (is (= [2013 4 8] (meetup/meetup 4 2013 :monday :second))))

(deftest second-tuesday-of-may-2013
  (is (= [2013 5 14] (meetup/meetup 5 2013 :tuesday :second))))

(deftest second-tuesday-of-june-2013
  (is (= [2013 6 11] (meetup/meetup 6 2013 :tuesday :second))))

(deftest second-wednesday-of-july-2013
  (is (= [2013 7 10] (meetup/meetup 7 2013 :wednesday :second))))

(deftest second-wednesday-of-august-2013
  (is (= [2013 8 14] (meetup/meetup 8 2013 :wednesday :second))))

(deftest second-thursday-of-september-2013
  (is (= [2013 9 12] (meetup/meetup 9 2013 :thursday :second))))

(deftest second-thursday-of-october-2013
  (is (= [2013 10 10] (meetup/meetup 10 2013 :thursday :second))))

(deftest second-friday-of-november-2013
  (is (= [2013 11 8] (meetup/meetup 11 2013 :friday :second))))

(deftest second-friday-of-december-2013
  (is (= [2013 12 13] (meetup/meetup 12 2013 :friday :second))))

(deftest second-saturday-of-january-2013
  (is (= [2013 1 12] (meetup/meetup 1 2013 :saturday :second))))

(deftest second-saturday-of-february-2013
  (is (= [2013 2 9] (meetup/meetup 2 2013 :saturday :second))))

(deftest second-sunday-of-march-2013
  (is (= [2013 3 10] (meetup/meetup 3 2013 :sunday :second))))

(deftest second-sunday-of-april-2013
  (is (= [2013 4 14] (meetup/meetup 4 2013 :sunday :second))))

(deftest third-monday-of-march-2013
  (is (= [2013 3 18] (meetup/meetup 3 2013 :monday :third))))

(deftest third-monday-of-april-2013
  (is (= [2013 4 15] (meetup/meetup 4 2013 :monday :third))))

(deftest third-tuesday-of-may-2013
  (is (= [2013 5 21] (meetup/meetup 5 2013 :tuesday :third))))

(deftest third-tuesday-of-june-2013
  (is (= [2013 6 18] (meetup/meetup 6 2013 :tuesday :third))))

(deftest third-wednesday-of-july-2013
  (is (= [2013 7 17] (meetup/meetup 7 2013 :wednesday :third))))

(deftest third-wednesday-of-august-2013
  (is (= [2013 8 21] (meetup/meetup 8 2013 :wednesday :third))))

(deftest third-thursday-of-september-2013
  (is (= [2013 9 19] (meetup/meetup 9 2013 :thursday :third))))

(deftest third-thursday-of-october-2013
  (is (= [2013 10 17] (meetup/meetup 10 2013 :thursday :third))))

(deftest third-friday-of-november-2013
  (is (= [2013 11 15] (meetup/meetup 11 2013 :friday :third))))

(deftest third-friday-of-december-2013
  (is (= [2013 12 20] (meetup/meetup 12 2013 :friday :third))))

(deftest third-saturday-of-january-2013
  (is (= [2013 1 19] (meetup/meetup 1 2013 :saturday :third))))

(deftest third-saturday-of-february-2013
  (is (= [2013 2 16] (meetup/meetup 2 2013 :saturday :third))))

(deftest third-sunday-of-march-2013
  (is (= [2013 3 17] (meetup/meetup 3 2013 :sunday :third))))

(deftest third-sunday-of-april-2013
  (is (= [2013 4 21] (meetup/meetup 4 2013 :sunday :third))))

(deftest fourth-monday-of-march-2013
  (is (= [2013 3 25] (meetup/meetup 3 2013 :monday :fourth))))

(deftest fourth-monday-of-april-2013
  (is (= [2013 4 22] (meetup/meetup 4 2013 :monday :fourth))))

(deftest fourth-tuesday-of-may-2013
  (is (= [2013 5 28] (meetup/meetup 5 2013 :tuesday :fourth))))

(deftest fourth-tuesday-of-june-2013
  (is (= [2013 6 25] (meetup/meetup 6 2013 :tuesday :fourth))))

(deftest fourth-wednesday-of-july-2013
  (is (= [2013 7 24] (meetup/meetup 7 2013 :wednesday :fourth))))

(deftest fourth-wednesday-of-august-2013
  (is (= [2013 8 28] (meetup/meetup 8 2013 :wednesday :fourth))))

(deftest fourth-thursday-of-september-2013
  (is (= [2013 9 26] (meetup/meetup 9 2013 :thursday :fourth))))

(deftest fourth-thursday-of-october-2013
  (is (= [2013 10 24] (meetup/meetup 10 2013 :thursday :fourth))))

(deftest fourth-friday-of-november-2013
  (is (= [2013 11 22] (meetup/meetup 11 2013 :friday :fourth))))

(deftest fourth-friday-of-december-2013
  (is (= [2013 12 27] (meetup/meetup 12 2013 :friday :fourth))))

(deftest fourth-saturday-of-january-2013
  (is (= [2013 1 26] (meetup/meetup 1 2013 :saturday :fourth))))

(deftest fourth-saturday-of-february-2013
  (is (= [2013 2 23] (meetup/meetup 2 2013 :saturday :fourth))))

(deftest fourth-sunday-of-march-2013
  (is (= [2013 3 24] (meetup/meetup 3 2013 :sunday :fourth))))

(deftest fourth-sunday-of-april-2013
  (is (= [2013 4 28] (meetup/meetup 4 2013 :sunday :fourth))))

(deftest last-monday-of-march-2013
  (is (= [2013 3 25] (meetup/meetup 3 2013 :monday :last))))

(deftest last-monday-of-april-2013
  (is (= [2013 4 29] (meetup/meetup 4 2013 :monday :last))))

(deftest last-tuesday-of-may-2013
  (is (= [2013 5 28] (meetup/meetup 5 2013 :tuesday :last))))

(deftest last-tuesday-of-june-2013
  (is (= [2013 6 25] (meetup/meetup 6 2013 :tuesday :last))))

(deftest last-wednesday-of-july-2013
  (is (= [2013 7 31] (meetup/meetup 7 2013 :wednesday :last))))

(deftest last-wednesday-of-august-2013
  (is (= [2013 8 28] (meetup/meetup 8 2013 :wednesday :last))))

(deftest last-thursday-of-september-2013
  (is (= [2013 9 26] (meetup/meetup 9 2013 :thursday :last))))

(deftest last-thursday-of-october-2013
  (is (= [2013 10 31] (meetup/meetup 10 2013 :thursday :last))))

(deftest last-friday-of-november-2013
  (is (= [2013 11 29] (meetup/meetup 11 2013 :friday :last))))

(deftest last-friday-of-december-2013
  (is (= [2013 12 27] (meetup/meetup 12 2013 :friday :last))))

(deftest last-saturday-of-january-2013
  (is (= [2013 1 26] (meetup/meetup 1 2013 :saturday :last))))

(deftest last-saturday-of-february-2013
  (is (= [2013 2 23] (meetup/meetup 2 2013 :saturday :last))))

(deftest last-sunday-of-march-2013
  (is (= [2013 3 31] (meetup/meetup 3 2013 :sunday :last))))

(deftest last-sunday-of-april-2013
  (is (= [2013 4 28] (meetup/meetup 4 2013 :sunday :last))))
