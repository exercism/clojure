# Introduction

In Clojure, binding a value to a name is referred to as a _var_. Top-level (global) vars are similar to constants in other languages.

Top-level vars are defined using `def`:

```clojure
(def fingers 10)

fingers
;;=> 10
```

You can use `defn` to define a function taking zero or more arguments. This is a function that would add 2 numbers together:

```clojure
(defn add [x y]
  (+ x y))
```

This function takes 2 arguments which are placed in the vector `[x y]`, followed by the *body* of the function which can contain any number of expressions. The return value is always the result of evaluating the last expression in the body, `(+ x y)`. This expression is a list representing a function call. The first items of the list is the `+` function which is evaluated using the following items `x` and `y` as arguments.

The `add` function defined above is called the same way:

```clojure
(add 2 3)
;;=> 5
```

Functions and values in Clojure can only be used _after_ they have been defined, i.e. forms are always evaluated in the order they appear.

In Clojure, whitespace has no significance other than formatting.

Clojure functions and vars are organized in namespaces. A namespace groups related functionality and is defined using the `ns` macro:

```clojure
(ns calculator)

(def pi 3.14)

(defn add [x y]
  (+ x y))
```

Clojure supports two types of comments. Single line comments are preceded by `;` and the `comment` form is used to prevent evaluation of everything between `(comment` and `)`.
