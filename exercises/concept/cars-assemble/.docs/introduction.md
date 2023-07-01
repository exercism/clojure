# Introduction

Numbers in Clojure include:

- Integers: numbers with no digits behind the decimal separator (whole numbers). Examples are `-6`, `0`, `1`, `25`, `976` and `500000`.
- Floating-point numbers: numbers with zero or more digits behind the decimal separator. Examples are `-2.4`, `0.1`, `3.14`, `16.984025` and `1024.0`.

Two common numeric types are `int` and `float`. An `int` is a 32-bit integer and a `float` is a 64-bit floating-point number.

Arithmetic is done using the standard arithmetic operators. Numbers can be compared using the standard numeric comparison operators (`>`, `<`, `<=`, `>=`), the equality operator (`=`) and the non-equality operator (`not=`).

In this exercise you must conditionally execute logic. A common way to do this in Clojure is by using `cond`:

```clojure
(cond (= x 5) "Expression to evaluate when x equals 5"
      (> x 7) "Expression to evaluate when x is greater than 7"
      :else   "Expression to evaluate in all other cases")
```

## Note
The `==` operator might be preferable to `=` in some cases where numbers need to be compared irrespective of the exact type. For instance,
```clojure
(== 5.0 5) ;; true as both numbers are equal when type is ignored
(= 5.0 5) ;; false as the types of numbers are also taken into account here i.e. float is different from int
```
The [Clojure guide on Equality][guide-equality], specifically the section on [Numbers][guide-numbers] goes into more details.

[guide-equality]: https://clojure.org/guides/equality
[guide-numbers]: https://clojure.org/guides/equality#numbers
