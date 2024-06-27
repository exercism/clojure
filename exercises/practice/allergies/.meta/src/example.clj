(ns allergies)

(def ^:private allergens
  [:eggs :peanuts :shellfish :strawberries :tomatoes :chocolate :pollen :cats])

(def ^:private allergen->power
  (zipmap allergens (range (count allergens))))

(defn allergic-to?
  [score allergen]
  (bit-test score (allergen->power allergen)))

(defn allergies
  [score]
  (keep-indexed #(if (bit-test score %1) %2) allergens))
