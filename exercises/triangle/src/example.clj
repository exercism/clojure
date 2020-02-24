(ns triangle)

(defn is-valid? [s1 s2 s3]
  (and
   (> s1 0) (> s2 0) (> s3 0)
   (>= (+ s1 s2) s3)
   (>= (+ s1 s3) s2)
   (>= (+ s2 s3) s1)))

(defn equilateral? [s1 s2 s3]
  (and (is-valid? s1 s2 s3) (= s1 s2 s3)))

(defn isosceles? [s1 s2 s3]
  (and (is-valid? s1 s2 s3) (or (= s1 s2) (= s1 s3) (= s2 s3))))

(defn scalene? [s1 s2 s3]
  (and (not (isosceles? s1 s2 s3)) (is-valid? s1 s2 s3)))