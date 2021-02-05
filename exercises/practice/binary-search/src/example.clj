(ns binary-search)

(defn middle [alist]
  (-> alist (count) (quot 2)))

(defn search-for
  [elem alist]
  (let [middle (middle alist)
        cur-elem (nth alist middle)]
    (cond
      (= cur-elem elem) middle
      (or (= middle (count alist)) (zero? middle)) (throw (Exception. (format "%s not found in list" elem)))
      (< cur-elem elem) (+ middle (search-for elem (drop middle alist)))
      (> cur-elem elem) (search-for elem (take middle alist)))))
