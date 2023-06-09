# Hints

## 1. Replace any spaces encountered with underscores

The built-in `clojure.string` library contains a [`replace`][str-replace] function.

## 2. Replace control characters with the upper case string "CTRL"

Here we need to use the [`isISOControl`][java-ctrl] method from Java's `Character` class.

## 3. Convert kebab-case to camelCase

Try separating the string on the hyphens with [`string/split`][str-split].
If there are no hyphens, we need to pass the original string. You can check using [string/includes?][str-includes]. Use [string/upper-case][str-upper-case] to make the "humps" of the camel. Finally, concatenate them with [string/join][str-join].

[str-join]: https://clojuredocs.org/clojure.string/join
[str-upper-case]: https://clojuredocs.org/clojure.string/upper-case
[str-includes]: https://clojuredocs.org/clojure.string/includes_q
[str-split]: https://clojuredocs.org/clojure.string/split
[str-replace]: https://clojuredocs.org/clojure.string/replace
[java-ctrl]: https://docs.oracle.com/javase/8/docs/api/java/lang/Character.html#isISOControl-char-