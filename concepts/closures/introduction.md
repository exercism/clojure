# Introduction

**Closures** are a programming pattern [in Clojure][clojure-guide-closures] which allows variables from an outer [lexical scope][wiki-lexical-scope] to be used inside of a function. Clojure supports closures transparently, and they are often used without knowing what they are.

```clojure
;; Top-level definitions are global-scope
(def dozen 12)

;; Functions create a new scope.
;; Referencing the outer variable here is a closure.
(fn [n] (* dozen n))
```

## Closures to save state and pass along values

Using an atom allows for some state to be preserved:

```clojure
;; This function closure increments the counter's state
;; in the outer lexical context.
;; This way the counter can be shared between many calling contexts.

(def increment
  (let [counter (atom 0)]
    (fn [] (swap! counter inc))))
```

Each successive call to `increment` increments its counter:

``` clojure
(increment)
;;=> 1
(increment)
;;=> 2
```

[wiki-lexical-scope]: https://en.wikipedia.org/wiki/Scope_(computer_science)#Lexical_scoping
[clojure-guide-closures]: https://clojure.org/guides/higher_order_functions#_functions_returning_functions_and_closures