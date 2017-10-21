(ns proverb
  (:require [clojure.string :as str]))

(def subjects ["nail" "shoe" "horse" "rider" "message" "battle" "kingdom"])

(def last-line "And all for the want of a horseshoe nail.")

(defn- line [[cause-subject effect-subject]]
  (format "For want of a %s the %s was lost." cause-subject effect-subject))

(def proverb (->> subjects
                  (partition 2 1)
                  (map line)
                  (#(conj (vec %) last-line))
                  (str/join "\n")))
