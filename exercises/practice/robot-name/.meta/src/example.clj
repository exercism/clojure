(ns robot-name)

(defn letters [] 
  (let [letter #(rand-nth (map char (range 65 91)))]
    (apply str (repeatedly 2 letter))))

(defn numbers []
  (let [number #(rand-int 10)]
    (apply str (repeatedly 3 number))))

;; Maintain a set of robot names

(def robots (atom #{}))

;; Before returning robot, check if the set count has increased.

(defn robot []
  (let [active-names @robots
        robot-count (count active-names)
        new-name (str (letters) (numbers))]
    (if (< robot-count (count (conj active-names new-name)))
      (do (swap! robots conj new-name)
          (atom {:name new-name}))
      (recur))))

(comment
  (robot)
  @robots
  )

(defn robot-name [robot]
  (:name @robot))
 
(defn reset-name [robot]
  (swap! robot assoc :name (str (letters) (numbers))))

(comment
  (re-seq #"[A-Z]{2}\d{3}" (robot-name (robot)))
  )
