# Hints

## General

- Review regular expression patterns from the introduction. Remember, when creating the pattern from a string, you must escape some characters.
- Refer to the full [Java regex spec][java-util-regex-pattern].
- Check out this website about regular expressions: [Regular-Expressions.info][website-regex-info].
- Check out this website about regular expressions: [Rex Egg -The world's most tyrannosauical regex tutorial][website-rexegg].
- Check out this website about regular expressions: [RegexOne - Learn Regular Expressions with simple, interactive exercises.][website-regexone].
- Check out this website about regular expressions: [Regular Expressions 101 - an online regex sandbox][website-regex-101].
- Check out this website about regular expressions: [RegExr - an online regex sandbox][website-regexr].

## 1. Match the day, month, and year from a date

- Remember to return a string representing the regular expression pattern.
- Review how to create _character classes_ or use _shorthand character classes_.
- Review _quantifiers_.
- A day is one or two digits.
- A month is one or two digits.
- A year is four digits.
- Create a regex pattern with [`re-pattern`][re-pattern].
- Return a regex match with [`re-matches`][re-matches].

## 2. Match the day of the week and the month of the year

- Review how to write a pattern to match _string literals_.
- Review _alternations_.
- Wrap the whole expression in a _group_.

## 3. Capture the day, month, and year

- Review how to write patterns for captures and named captures.
- Reuse the `day`, `month`, `year`, `day-names`, and `month-names` functions that you already implemented.
- You can use [`re-matcher`][re-matcher] to return an instance of `java.util.regex.Matcher` to use with [`re-find`][re-find].

## 4. Combine the captures to capture the whole date

- Remember, string concatenation may be used to join strings.
- Reuse the `capture-day`, `capture-month`, `capture-year`, `capture-day-name`, and `capture-month-name` functions that you already implemented.

## 5. Narrow the capture to match only on the date

- Remember, _anchors_ help to match the pattern to the **whole line**.
- String concatenation may be used in a call to `re-pattern`.
- Reuse the `capture-numeric-date`, `capture-month-name-date`, and `capture-day-month-nam-date` functions that you already implemented.

[java-util-regex-pattern]: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/regex/Pattern.html
[re-find]: https://clojuredocs.org/clojure.core/re-find
[re-matcher]: https://clojuredocs.org/clojure.core/re-matcher
[re-matches]: https://clojuredocs.org/clojure.core/re-matches
[re-pattern]: https://clojuredocs.org/clojure.core/re-pattern
[website-regex-info]: https://www.regular-expressions.info
[website-rexegg]: https://www.rexegg.com/
[website-regexone]: https://regexone.com/
[website-regex-101]: https://regex101.com/
[website-regexr]: https://regexr.com/
[website-regex-crossword]: https://regexcrossword.com/
