# Hints

## 1. Replace any spaces encountered with underscores

The built-in `clojure.string` library contains a [`replace`][str-replace] function.

## 2. Replace control characters with the upper case string "CTRL"

Here we need to use the [`isISOControl`][java-ctrl] method from Java's `Character` class.

[str-replace]: https://clojuredocs.org/clojure.string/replace
[java-ctrl]: https://docs.oracle.com/javase/8/docs/api/java/lang/Character.html#isISOControl-char-