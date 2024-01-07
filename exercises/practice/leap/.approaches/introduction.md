# Introduction

Every fourth year is a leap year (with some exceptions), but let's focus initially on the primary condition.

In the Leap problem, we need to determine if a year is evenly divisible by a number,
which means checking if the remainder of an integer division is zero.
This operation in computing is known as [modulo][modulo].


Clojure has two functions we can use: `mod` and `rem`. 
The two functions differ in how they work with negative numbers, but since, in this exercise,
all the numbers are non-negative, both will work.

## General Solution

To check if a year is divisible by `n` in Clojure, we can do `(zero? (mod year n))`. To make the intent clearer, let's define a private function. 

```clojure
(defn- divides? [number divisor]
  (zero? (mod number divisor)))
```

Any approach to the problem will perform this check three times to see if a year is equally divisible by 4, 100 and 400.
What will differ between approaches is which Clojure features we will use to combine the checks. 

## Approach: Boolean Operations

The full rules are as follows:
A year is a leap year if 
* it is divisible by 4 
* but not divisible by 100
* unless it is divisible by 400


We can use `and`, `or` and `not` functions to combine the checks, for example, like so: 

```clojure
(or (divides? year 400)
    (and (not (divides? year 100)) 
        (divides? year 4))))
```

Explore the details in the [boolean operations approach][boolean-approach].

## Approach: Conditional Branching

Instead of combining the logical expressions, we can use conditional branching with functions like `if` or `cond` to perform the necessary checks and return true or false. 

```clojure
(if (divides? year 100) 
    (divides? year 400) 
    (divides? year 4)))
```

In the [conditional branching approach][conditional-approach], we discuss the options comparing `if` and `cond` functions.

[modulo]: https://en.wikipedia.org/wiki/Modulo
[boolean-approach]: https://exercism.org/tracks/clojure/exercises/leap/approaches/boolean
[conditional-approach]: https://exercism.org/tracks/clojure/exercises/leap/approaches/conditional