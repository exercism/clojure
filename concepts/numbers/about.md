Numbers in Clojure include:

- Integers: numbers with no digits behind the decimal separator (whole numbers). Examples are `-6`, `0`, `1`, `25`, `976` and `500000`.
- Floating-point numbers: numbers with zero or more digits behind the decimal separator. Examples are `-2.4`, `0.1`, `3.14`, `16.984025` and `1024.0`.

Two common numeric types are `int` and `float`. An `int` is a 32-bit integer and a `float` is a 64-bit floating-point number.

Arithmetic is done using the standard arithmetic operators. Numbers can be compared using the standard numeric comparison operators and the equality (`=`) and inequality (`<>`) operators.

In this exercise you must conditionally execute logic. A common way to do this in Clojure is by using `cond`:

```clojure
(cond (= x 5) "Expression to evaluate when x equals 5"
      (> x 7) "Expression to evaluate when x is greater than 7"
      :else   "Expression to evaluate in all other cases")
```
