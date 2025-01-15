(ns zebra-puzzle)

(def colors        #{:red :green :ivory :yellow :blue})
(def nationalities #{:englishman :spaniard :ukrainian :japanese :norwegian})
(def pets          #{:dog :snails :fox :horse :zebra})
(def drinks        #{:coffee :tea :milk :orange-juice :water})
(def hobbies       #{:dancing :painting :reading :football :chess})

(defn- permutations [s]
  (lazy-seq
   (if (next s)
     (for [head s
           tail (permutations (disj s head))]
       (cons head tail))
     [s])))

(defn index-of [coll e]
  (first (keep-indexed #(when (= e %2) %1) coll)))

(def solution
  (first
   (for [colors' (permutations colors)
         :when (= (dec (index-of colors' :green)) (index-of colors' :ivory))

         nationalities' (permutations nationalities)
         :when (= :norwegian (first nationalities'))
         :when (= (index-of nationalities' :englishman) (index-of colors' :red))
         :when (= 1 (abs (- (index-of nationalities' :norwegian) (index-of colors' :blue))))

         pets' (permutations pets)
         :when (= (index-of nationalities' :spaniard) (index-of pets' :dog))

         drinks' (permutations drinks)
         :when (= :milk (nth drinks' 2))
         :when (= (index-of drinks' :coffee) (index-of colors' :green))
         :when (= (index-of nationalities' :ukrainian) (index-of drinks' :tea))

         hobbies' (permutations hobbies)
         :when (= (index-of pets' :snails) (index-of hobbies' :dancing))
         :when (= (index-of colors' :yellow) (index-of hobbies' :painting))
         :when (= (index-of nationalities' :japanese) (index-of hobbies' :chess))
         :when (= (index-of drinks' :orange-juice) (index-of hobbies' :football))
         :when (= 1 (abs (- (index-of pets' :fox) (index-of hobbies' :reading))))
         :when (= 1 (abs (- (index-of pets' :horse) (index-of hobbies' :painting))))]
     {:colors colors'
      :nationalities nationalities'
      :pets pets'
      :drinks drinks'
      :hobbies hobbies'})))

(defn nationality-of [category value]
  (nth (:nationalities solution) (index-of (category solution) value)))

(defn drinks-water [] (nationality-of :drinks :water))

(defn owns-zebra [] (nationality-of :pets :zebra))
