(ns pythagorean-triplet)

(defn find-pythagorean-triplets
  [N]
  (for [a (range N)
        :let [b (/ (* N (- N (* 2 a))) (* 2 (- N a)))
              c (- N a b)]
        :when (and (pos-int? b)
                   (< a b c)
                   (= (* c c) (+ (* a a) (* b b))))]
    [a b c]))
