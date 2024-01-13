# Data shapes

```clojure
(def leap-shapes
  #{{:by-4 true :by-100 true :by-400 true}
    {:by-4 true :by-100 false :by-400 false}})

(defn- to-shape [year]
  {:by-4 (zero? (mod year 4))
   :by-100 (zero? (mod year 100))
   :by-400 (zero? (mod year 400))})

(defn leap-year? [year]
  (->> year
       to-shape
       leap-shapes
       some?))
```

We can define a data structure that describes the properties of a number.
In this case, the number is a year, and the properties are whether it is divisible by 4, 100 and 400. Let's call any instance of such data structure the shape of a number.

While there are many numbers, there are fewer shapes, so we can define all shapes corresponding to all leap years. There are only two.

```clojure
(def leap-shapes
  #{{:by-4 true :by-100 true :by-400 true}
    {:by-4 true :by-100 false :by-400 false}})
```

We now need a function to convert any number to its shape.

```clojure
(defn- to-shape [year]
  {:by-4 (zero? (mod year 4))
   :by-100 (zero? (mod year 100))
   :by-400 (zero? (mod year 400))})
```

With the above, we can now take a year number and check if its shape is one of the leap shapes.

```clojure
(defn leap-year? [year]
  (->> year
       to-shape
       leap-shapes
       some?))
```

In Clojure, if a value is passed to a set, the set acts like a function checking if the value exists in that set. This is how `leap-shapes` acts as a predicate when combined with `some?`.