# Introduction

In Clojure, binding a value to a name is referred to as a _var_. Top-level (global) vars are similar to constants in other languages, but are commonly redefined to facilitate dynamic development.

Top-level vars are defined using `def`:

```clojure
(def fingers 10)
```

The `defn` macro can be used to define a function taking zero or more arguments. A function always returns the result of the last expression in its body.

```clojure
(defn add [x y]
  (+ x y))
```

Invoking a function is done by specifying its name and passing arguments for each of the function's parameters.

```clojure
(def five (add 2 3))
```

Functions and values in Clojure can only be used _after_ they have been defined. Using it before it has been defined results in a compile error.

```clojure
;; Compile error as `add` has not yet been defined
(def seven (add 3 4))

(defn add [x y]
  (+ x y))
```

In Clojure, whitespace has no significance other than formatting.

Clojure functions and vars are organized in namespaces. A namespace groups related functionality and is defined using the `ns` macro:

```clojure
(ns calculator)

(def pi 3.14)

(defn add [x y]
  (+ x y))
```

Clojure supports two types of comments. Single-line comments are preceded by `;` and the `comment` form is used to prevent evaluation of everything between `(comment` and `)`.
