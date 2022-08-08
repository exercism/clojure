(ns elyses-destructured-enchantments)

(defn first-card
  "Returns the first card from deck."
  [[card]]
  card)

(defn second-card
  "Returns the second card from deck."
  [[_ card]]
  card)

(defn swap-top-two-cards
  "Returns the deck with first two items reversed."
  [[a b & more]]
  (list* b a more))

(defn discard-top-card
  "Returns a sequence containing the first card and
   a sequence of the remaining cards in the deck."
  [[card & more]]
  [card more])

(def face-cards
  ["jack" "queen" "king"])

(defn insert-face-cards
  "Returns the deck with face cards between its head and tail."
  [[head & tail]]
    (vec (remove nil? (flatten [head face-cards tail]))))

(comment
  (insert-face-cards [3 10 7])
  (insert-face-cards [9])
  (insert-face-cards []))
