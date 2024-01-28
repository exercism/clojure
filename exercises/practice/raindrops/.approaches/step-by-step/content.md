# Step by step

```clojure
(defn convert [num]
  (let [pling (if (zero? (rem num 3)) "Pling" "")
        plang (if (zero? (rem num 5)) "Plang" "")
        plong (if (zero? (rem num 7)) "Plong" "")
        sound (str pling plang plong)]
      (if (empty? sound) (str num) sound)))
```

In the above example, the individual sounds of rain are calculated separately and then added to make up the overall sound.
Then we can use the bindings created by `let` to check if the `sound` is empty and return either the sound or the number.

A variant of this approach can use the thread first macro `->` and private functions.

```clojure
(defn- pling [[s n]] [(if (zero? (rem n 3)) (str s "Pling") s) n])
(defn- plang [[s n]] [(if (zero? (rem n 5)) (str s "Plang") s) n])
(defn- plong [[s n]] [(if (zero? (rem n 7)) (str s "Plong") s) n])
(defn- sound [[s n]] (if (empty? s) (str n) s))

(defn convert [number]
  (-> ["", number]
      pling
      plang
      plong
      sound))
```

Using the thread first macro makes the `convert` function simple, if not clearer, but it comes at the cost of extra complexity in the `pling`, `plang`, `plong` and `sound` functions.