# Introduction

There are a few basic [flow control](https://clojure.org/guides/learn/flow) constructs in Clojure. `if` is the most important conditional expression - it consists of a condition, a "then", and an optional "else". `if` will only evaluate the branch selected by the conditional.

```clojure
(if (even? 2) "even" "odd")
```

`cond` is a series of tests and expressions. Each test is evaluated in order and the expression is evaluated and returned for the first true test.

```clojure
(cond (= x 5) "Expression to evaluate when x equals 5"
      (> x 7) "Expression to evaluate when x is greater than 7"
      :else   "Expression to evaluate in all other cases")
```
