# Hints

## 1. Tracking Poker Rounds

- The [`list`][list] function returns a list consisting of the arguments it is passed.

## 2. Keeping all Rounds in the Same Place

- The [`concat`][concat] function can be used to concatenate two lists together.

## 3. Finding Prior Rounds

- The [`some`][some] function will return the first logically true value in a collection.
- [`boolean`][boolean] is useful in cases where a function returns a value but the tests are expecting a boolean.

## 4. Averaging Card Values

- Recall basic arithmetic operators such as [`/`][division] and [`+`][addition].
- A collection of numbers can be summed using either [`apply`][apply] or [`reduce`][reduce].
- The [`count`][count] function returns the number of items in a collection.
- The `/` function returns a ratio type when operating on integers. You can use [`double`][double] to convert a ratio to a decimal.

## 5. Alternate Averages

- There are sequence functions to return the [`first`][first] or [`last`] element of a sequential collection.
- To find the middle card you can divide the number of cards by 2, round to the lowest integer with [`int`][int], and retrieve the card at that index using [`nth`][nth].
- Use [`or`][or] to determine if either condition is true.

## 6. More Averaging Techniques

- One way of retrieving the cards at even/odd indices would be to [`map`][map] a function using [`nth`][nth] over a [`range`][range], which takes an optional `step` argument.

## 7. Bonus Round Rules

- Recall how to use [`if`][if] from the exercise on conditionals.
- You can return all items of a collection except for the last one using [`butlast`][butlast].

[addition]: https://clojuredocs.org/clojure.core/+
[apply]: https://clojuredocs.org/clojure.core/apply
[boolean]: https://clojuredocs.org/clojure.core/boolean
[butlast]: https://clojuredocs.org/clojure.core/butlast
[concat]: https://clojuredocs.org/clojure.core/concat
[count]: https://clojuredocs.org/clojure.core/count
[division]: https://clojuredocs.org/clojure.core/_fs
[double]: https://clojuredocs.org/clojure.core/double
[first]: https://clojuredocs.org/clojure.core/first
[if]: https://clojuredocs.org/clojure.core/if
[int]: https://clojuredocs.org/clojure.core/int
[last]: https://clojuredocs.org/clojure.core/last
[list]: https://clojuredocs.org/clojure.core/list
[map]: https://clojuredocs.org/clojure.core/map
[nth]: https://clojuredocs.org/clojure.core/nth
[or]: https://clojuredocs.org/clojure.core/or
[range]: https://clojuredocs.org/clojure.core/range
[reduce]: https://clojuredocs.org/clojure.core/reduce
[some]: https://clojuredocs.org/clojure.core/some