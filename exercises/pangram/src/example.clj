(ns pangram)

(def ^:private in-range? ((fn [] (let [start (int \a)
                                       end (inc (int \z))]
                                   #(<= start (int %) end)))))

(defn pangram? [input]
  (->> input
       (into [] (comp (map #(Character/toLowerCase %))
                      (filter in-range?)
                      (distinct)))
       count
       (= 26)))
