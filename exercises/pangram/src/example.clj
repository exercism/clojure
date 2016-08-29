(ns pangram)

(defn- char<= [ch1 ch2] (<= (compare ch1 ch2) 0))

(defn pangram? [input]
  (->> input
       (into [] (comp (map #(Character/toLowerCase %))
                      (filter #(and (char<= \a %) (char<= % \z)))
                      (distinct)))
       count
       (= 26)))
