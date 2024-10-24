# Hints

## 1. Replace any spaces encountered with underscores

The built-in `clojure.string` library contains a [`replace`][str-replace] function.

## 2. Replace control characters with the upper case string "CTRL"

You can use the [`isISOControl`][java-ctrl] method from Java's `Character` class.

## 3. Convert kebab-case to camelCase

Try separating the string on the hyphens with [`split`][str-split].
If it contains no hyphens, you should return it as it is. You can check this using [`includes?`][str-includes]. Use [`upper-case`][str-upper-case] to make the "humps" of the camel. Finally, concatenate them with [`join`][str-join].

## 4. Omit characters that are not letters

You can filter characters using [`Character/isLetter`][java-isletter] as a predicate.

## 5. Omit Greek lowercase letters

The Greek lowercase letters are Unicode points `\u03B1` to `\u03C9`, or integer values 945 through 969.

[str-join]: https://clojuredocs.org/clojure.string/join
[str-upper-case]: https://clojuredocs.org/clojure.string/upper-case
[str-includes]: https://clojuredocs.org/clojure.string/includes_q
[str-split]: https://clojuredocs.org/clojure.string/split
[str-replace]: https://clojuredocs.org/clojure.string/replace
[java-ctrl]: https://docs.oracle.com/javase/8/docs/api/java/lang/Character.html#isISOControl-char-
[java-isletter]: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Character.html#isLetter(char)