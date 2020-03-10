(ns allergies)

(def ^:private allergens
  [:eggs :peanuts :shellfish :strawberries :tomatoes :chocolate :pollen :cats])

(defn- flagged?
  [flags index]
  (-> (bit-shift-right flags index)
      (bit-and 1)
      (pos?)))

(defn allergies
  "Given an 8-bit bitmap of flags, returns the list of matching allergens."
  [flags]
  (keep-indexed (fn [index allergen]
                  (when (flagged? flags index)
                    allergen))
                allergens))

(defn allergic-to?
  "Given an 8-bit bitmap of flags and an allergen, returns a boolean
  indicating whether or not the patient is allergic to the given allergen."
  [flags allergen]
  (some #{allergen} (allergies flags)))
