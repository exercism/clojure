(ns robot-name)

(def ^:private random (java.util.Random.))
(def ^:private letters (map char (range 65 91)))
(defn- generate-name []
  (str (apply str (take 2 (shuffle letters)))
       (+ 100 (.nextInt random 899))))

(defn robot []
  (atom {:name (generate-name)}))

(defn robot-name [robot]
  (:name @robot))

(defn reset-name [robot]
  (swap! robot assoc :name (generate-name)))
