# Hints

## General

- The `clojure.string` namespace has many useful [string manipulation functions][string-ns].

## 1. Get message from a log line

- The [`split`][split] function can be used to split a string on a regular expression.
- The [`trim`][trim] function can be used to remove whitespace from the ends of a string.

## 2. Get log level from a log line

- A `string` can be converted to lowercase using [`lowercase`][lowercase].

## 3. Reformat a log line

- The [`str`][str] function can be used to concatenate strings.

[lowercase]: https://clojuredocs.org/clojure.string/lower-case
[split]: https://clojuredocs.org/clojure.string/split
[str]: https://clojuredocs.org/clojure.core/str
[string-ns]: https://clojuredocs.org/clojure.string
[trim]: https://clojuredocs.org/clojure.string/trim
