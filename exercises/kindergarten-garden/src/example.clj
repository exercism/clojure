(ns kindergarten-garden)

(def default-students ["Alice" "Bob" "Charlie" "David" "Eve" "Fred" "Ginny"
                       "Harriet" "Ileana" "Joseph" "Kincaid" "Larry"])

(def seeds {\G :grass \C :clover \R :radishes \V :violets})

(defn row-to-seeds [row-string]
  (map seeds row-string))

(defn garden-to-rows [garden]
  (clojure.string/split-lines garden))

(defn garden
  ([string]
   (garden string default-students))
  ([string students]
   (let [students     (map #(keyword (clojure.string/lower-case %1)) (sort students))
         [front back] (map #(partition 2 %1)
                           (map row-to-seeds (garden-to-rows string)))]
     (->> (interleave front back)
          (partition 2)
          (map flatten)
          (map vec)
          (zipmap students)))))
