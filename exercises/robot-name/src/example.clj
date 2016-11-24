(ns robot-name)

(def ^:private letters (map char (range 65 91)))
(defn- generate-name []
  (format "%s%03d" (apply str (repeatedly 2 #(rand-nth letters)))
          (rand-int 1000)))

(defn robot []
  (atom {:name (generate-name)}))

(defn robot-name [robot]
  (:name @robot))

(defn reset-name [robot]
  (swap! robot assoc :name (generate-name)))
