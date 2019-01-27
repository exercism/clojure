(ns proverb
  (:require [clojure.string :as str]))

(def last-line "And all for the want of a %s.")

(defn- line [[cause-subject effect-subject]]
  (format "For want of a %s the %s was lost." cause-subject effect-subject))

(defn recite [subjects]
  (if (empty? subjects) ""
    (->> subjects
    (partition 2 1)
    (map line)
    (#(conj (vec %) (format last-line (first subjects))))
    (str/join "\n"))))
