Clojure's sequential destructuring syntax is a concise way to extract values from a vector and assign them to distinct variables.

In this example, each value in the `number-of-moons` vector is assigned to its corresponding planet:

```clojure
(def number-of-moons [0 2 14])

(let [[venus mars neptune] number-of-moons]
  neptune)

;=> 14
```
