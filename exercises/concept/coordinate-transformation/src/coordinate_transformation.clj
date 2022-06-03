(ns coordinate-transformation
  (:require [hyperfiddle.rcf :refer [tests]]
            [clojure.test :refer [function?]]))

(hyperfiddle.rcf/enable!)

(defn translate2d 
  "Returns a function making use of a closure to
   perform a repeatable 2d translation of a coordinate pair."
  [dx dy]
  (fn [x y] [(+ dx x) (+ dy y)]))

(defn scale2d 
  "Returns a function making use of a closure to
   perform a repeatable 2d scale of a coordinate pair."
  [sx sy]
  (fn [x y] [(* sx x) (* sy y)]))

(defn compose-transform
  "Create a composition function that returns a function that 
   combines two functions to perform a repeatable transformation."
  [f g]
  (fn [x y]
    (let [f-result (f x y)]
      (g (first f-result) (last f-result)))))

(def fake-first (atom true))

(defn fake-transform [x y]
  (if @fake-first
    (do (reset! fake-first false)
        [1 1])
    false))

(defn memoize-transform
  [f]
  (let [mem (atom {})]
    (fn [& args]
      (if-let [e (find @mem args)]
        (val e)
        (let [ret (apply f args)]
          (swap! mem assoc args ret)
          ret)))))

(tests
 (let [memoized-transform (memoize-transform fake-transform)]
   (memoized-transform 5 5)
   (memoized-transform 5 5)) := [1 1]
 (function? (memoize-transform (translate2d 2 2))) := true
 ((memoize-transform (translate2d 2 2)) 2 2) := [4 4]
 ((memoize-transform (translate2d 2 2)) 2 2) := [4 4]
 ((memoize-transform (translate2d 1 2)) 2 2) := [3 4]
 ((memoize-transform (translate2d 1 2)) 6 6) := [7 8]
 (function? translate2d) := true
 ((translate2d 3 -5) 0 0) := [3 -5]
 ((translate2d 3 -5) 4 5) := [7 0]
 (function? scale2d) := true
 ((scale2d 4 2) 1 1) := [4 2]
 ((scale2d 4 2) -2 5) := [-8 10]
 (function? (compose-transform (translate2d -6 10) (scale2d 3 2))) := true
 ((compose-transform (translate2d -6 10) (translate2d -6 10)) 0 0) := [-12 20]
 ((compose-transform (scale2d 3 2) (scale2d 3 2)) 1 1) := [9 4]
 ((compose-transform (scale2d 3 2) (translate2d -6 10)) 0 0) := [-6 10]
 ((compose-transform (translate2d -6 10) (scale2d 3 2)) 0 0) := [-18 20]
 )