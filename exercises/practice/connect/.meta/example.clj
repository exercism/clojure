(ns connect)

(defn find-input-dimensions
  [input-board]
  (let [rows (count input-board)
        columns (/ (inc (.length (first input-board))) 2)]
    {:rows rows
     :columns columns
     :max-pos (* rows columns)}))

(defn parse-value
  [value]
  (if (= value ".")
    {:value :E}
    {:value (keyword value)}))

(defn create-values
  [input-board]
  (let [dimensions (find-input-dimensions input-board)]
    (->> input-board
         (apply str)
         (re-seq #"[XO.]")
         (map parse-value)
         (zipmap (range 1 (inc (:max-pos dimensions)))))))

(defn connect-positions
  [board pos1 pos2]
  (-> board
      (update-in [pos1 :neighbors] #(conj % pos2))
      (update-in [pos2 :neighbors] #(conj % pos1))))

(defn on-right-edge?
  [pos dimensions]
  (zero? (rem pos (:columns dimensions))))

(defn on-bottom-edge?
  [pos dimensions]
  (> pos (- (:max-pos dimensions) (:columns dimensions))))

(defn on-left-edge?
  [pos dimensions]
  (zero? (rem (dec pos) (:columns dimensions))))

(defn connect-right
  [board pos dimensions]
  (if (on-right-edge? pos dimensions)
    board
    (connect-positions board pos (inc pos))))

(defn connect-down-right
  [board pos dimensions]
  (if (on-bottom-edge? pos dimensions)
    board
    (connect-positions board pos (+ pos (:columns dimensions)))))

(defn connect-down-left
  [board pos dimensions]
  (if (or (on-left-edge? pos dimensions)
          (on-bottom-edge? pos dimensions))
    board
    (connect-positions board pos (+ pos (dec (:columns dimensions))))))

(defn create-position-connections
  [board pos dimensions]
  (reduce #(%2 %1 pos dimensions)
          board [connect-right connect-down-left connect-down-right]))

(defn create-connections
  [input-board]
  (let [dimensions (find-input-dimensions input-board)]
    (reduce #(create-position-connections %1 %2 dimensions)
            {} (range 1 (inc (:max-pos dimensions))))))

(defn create-board
  [input-board]
  (let [connections (create-connections input-board)
        values (create-values input-board)]
    (merge-with into values connections)))

(defn path?
  [board start-pos final-positions]
  (let [start-value (:value (get board start-pos))]
    (if (= start-value :E)
      false
      (loop [positions-to-visit [start-pos]
             visited #{}]
        (if (empty? positions-to-visit)
          false
          (let [current-position (peek positions-to-visit)
                remaining-positions (pop positions-to-visit)
                new-visited (conj visited current-position)
                neighbors (:neighbors (get board current-position))
                valid-neighbors (filter #(and (not (visited %))
                                              (= start-value (:value (get board %))))
                                        neighbors)]
            (cond
              (contains? final-positions current-position) true
              (visited current-position) (recur remaining-positions visited)
              :else (recur (into remaining-positions valid-neighbors) new-visited))))))))

(defn any-path?
  [board start-positions final-positions]
  (boolean (some #(path? board % final-positions) start-positions)))

(defn X-edge-positions
  [dimensions]
  (let [{:keys [columns max-pos]} dimensions]
    {:start-positions (range 1 (inc max-pos) columns)
     :end-positions (range columns (inc max-pos) columns)}))

(defn O-edge-positions
  [dimensions]
  (let [{:keys [columns max-pos]} dimensions]
    {:start-positions (range 1 (inc columns))
     :end-positions (range (inc (- max-pos columns)) (inc max-pos))}))

(def type->edge-positions-fn
  {:X X-edge-positions
   :O O-edge-positions})

(defn filter-positions-by-type
  [board positions type]
  (filter #(= type (:value (get board %))) positions))

(defn wins?
  [type board dimensions]
  (let [edge-positions-fn (type->edge-positions-fn type)
        {:keys [start-positions end-positions]} (edge-positions-fn dimensions)
        starting-type-positions (filter-positions-by-type board start-positions type)]
    (any-path? board starting-type-positions (set end-positions))))

(defn connect-winner
  [input-board]
  (let [board (create-board input-board)
        dimensions (find-input-dimensions input-board)]
    (cond
      (wins? :X board dimensions) :X
      (wins? :O board dimensions) :O
      :else :no-winner)))
