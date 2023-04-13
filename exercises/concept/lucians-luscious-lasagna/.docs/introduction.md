# Introduction

In Clojure, binding a value to a name is referred to as a _var_. Top-level (global) vars are similar to constants in other languages.

Top-level vars are defined using `def`:

```clojure
(def fingers 10)

fingers
;;=> 10
```

The `defn` macro can be used to define a function taking zero or more arguments. A function always returns the result of the last expression in its body.

```clojure
(defn add [x y]
  (+ x y))
```

`[x y]` is the function's arglist, with the parameters placed inside of a vector. More about vectors later, but they are similar to arrays in other languages. One of the biggest syntactical differences between Clojure and other Lisps is the addition of built-in data structure literals besides lists. 

A nice benefit of this is consistency - we always know that unquoted lists represent function calls, making it easier to visually distinguish *code* from *data*, the vector of arguments being the latter.

Invoking a function is done by specifying its name and passing arguments for each of the function's parameters.

```clojure
(add 2 3)
;;=> 5
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

Clojure supports two types of comments. Single line comments are preceded by `;` and the `comment` form is used to prevent evaluation of everything between `(comment` and `)`.
