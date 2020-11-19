(ns exercism.dialing-codes)

(def countries
  {1 "United States of America", 55 "Brazil", 91 "India"})

(defn add-country [m code name]
  (assoc m code name))

(defn country-name [m code]
  (get m code))

(defn code-exists? [m code]
  (if (get m code) true false))

(defn update-country [m code name]
  (if (code-exists? m code)
    (assoc m code name)
    m))

(defn remove-country [m code]
  (dissoc m code))

(defn longest-name [m]
  (last (first (sort-by count m))))

(comment
  (get countries 1)
  (add-country {} 44 "United Kingdom")
  (code-exists? countries 999)
  (last (first (sort-by count countries)))
  (longest-name {})
  )