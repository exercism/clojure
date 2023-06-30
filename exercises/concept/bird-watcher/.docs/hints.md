# Hints

## 1. Check what the counts were last week

- [Vectors][vectors] are represented in Clojure using square brackets (`[ ]`)

## 2. Check how many birds visited today

- The [`last`][last] function can be used to return the last item in a sequential collection.

## 3. Increment today's count

- The [`update`][update] function can be used to return a new vector with a different element at a given index.

- The [`count`][count] function can be used to find the length of the vector.

- The [`inc`][inc] and [`dec`][dec] functions can be used to increment and decrement integer values.

## 4. Check if there was a day with no visiting birds

- The [`every?`][every?] function can be used to check if all items in a collection satisfy a given predicate.

- The [`pos?`][pos?] predicate returns true if a number is greater than zero.

- The [`not`][not] function returns true if an expression evaluates to logical false.

## 5. Calculate the number of visiting birds for the first number of days

- The [`take`][take] function can be used return a sequence of the first n items in a collection.

- The [`reduce`][reduce] function can be used to add a collection of values together.

## 6. Calculate the number of busy days

- The [`filter`][filter] higher-order function can be used to return a sequence of items in a collection which satisfy a given predicate.

## 7.  Check for odd week

- The [`=`][equality] function can be used to test equality.

[count]: https://clojuredocs.org/clojure.core/count
[dec]: https://clojuredocs.org/clojure.core/dec
[equality]: https://clojuredocs.org/clojure.core/=
[every?]: https://clojuredocs.org/clojure.core/every_q
[filter]: https://clojuredocs.org/clojure.core/filter
[inc]: https://clojuredocs.org/clojure.core/inc
[last]: https://clojuredocs.org/clojure.core/last
[not]: https://clojuredocs.org/clojure.core/not
[pos?]: https://clojuredocs.org/clojure.core/pos_q
[reduce]: https://clojuredocs.org/clojure.core/reduce
[take]: https://clojuredocs.org/clojure.core/take
[update]: https://clojuredocs.org/clojure.core/update
[vectors]: https://clojure.org/guides/learn/sequential_colls#_vectors
