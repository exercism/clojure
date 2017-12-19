(ns reverse-string)

(require '[clojure.string :as s])

(defn reverse-string 
  ([word] (str (s/reverse word))))
