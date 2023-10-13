# Instructions

Your design company has primarily been working with CSS transformations to build web pages. After some discussion, a decision is made
to start using Clojure to perform some calculations dynamically. Some of your teammates are less experienced with Clojure,
so you decide to use a function closure to create reusable transformations for `{x, y}` coordinate pairs.

## 1. Translate the coordinates

Implement the `translate2d` function that returns a function making use of a closure to perform a repeatable 2d translation of a coordinate pair.

```clojure
(def move-coordinates-right-2px (translate2d 2 0))
(def result (move-coordinates-right-2px 4 8))
;; result => [6 8]
```

## 2. Scale the coordinates

Implement the `scale2d` function that returns a function making use of a closure to perform a repeatable 2d scale of a coordinate pair.

> For this exercise, assume only positive scaling values.

```clojure
(def double-scale (scale2d 2 2))
(def result (double-scale 6 -3))
;; result => [12 -6]
```

## 3. Compose transformation functions

Combine two transformation functions to perform a repeatable transformation. This is often called _function composition_, where the result of the first function _'f(x)'_ is used as the input to the second function _'g(x)'_.

```clojure
(def move-coordinates-right-2px (translate2d 2 0))
(def double-coordinates (scale2d 2 2))
(def composed-transformations 
  (compose-transform move-coordinates-right-2px 
                     double-coordinates))
(def result (composed-transformations 0 1))
;; result => [4 2]
```

## 4. Save the results of functions

Implement the `memoize-transform` function. It takes a function to _memoize_, then returns a new function that remembers the inputs to the supplied function so that the last return value can be "remembered" and only calculated once if it is called again with the same arguments.

> Memoizing is sometimes called _dynamic programming_, it allows for expensive operations to be done only once since their result is remembered.

```clojure
(def triple-scale (scale2d 3 3))
(def memoized-scale (memoize-transform triplescale))

(memoized-scale 4 3)
;; => [12, 9], this is computed since it hasn't been computed before for the arguments

(memoized-scale 4 3)
;; => [12, 9], this is remembered, since it was computed already

(def triple-scale (scale2d 3 3))
(def memoized-scale (memoize-transform triple-scale))

(memoizedScale 4 3)
;; => [12, 9], this is computed since it hasn't been computed before for the arguments

(memoizedScale 4 3)
;; => [12, 9], this is remembered, since it was computed already
```