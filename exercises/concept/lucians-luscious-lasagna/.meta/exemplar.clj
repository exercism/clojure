(ns basics)

(def expected-time 40)

(defn remaining-time [actual-time]
  (- expected-time actual-time))

(defn prep-time [num-layers]
  (* num-layers 2))

(defn total-time [num-layers actual-time]
  (+ (prep-time num-layers) actual-time))
