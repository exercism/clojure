# Introduction

## Regular Expressions

Regular expressions (regex) are a powerful tool for working with strings in Clojure. Regular expressions in Clojure follow the Java specification. String patterns representing the regular expression's meaning are first compiled then used for matching all or part of a string.

In Clojure, the most concise way to create regular expressions is using the #"pattern" syntax. This provides _syntactic sugar_ as a convenience. To match a _string literal_, we can use this.

```clojure
#"test"
```

If you want to construct a regex pattern dynamically at run time, then you need to use `re-pattern` to convert a string to a pattern that can be used for matching. When doing so, you need to escape every `\` character with another `\`. But if your pattern is one you write into the source code, it is more convenient to use the #"pattern" syntax.

### Character classes

Matching a range of characters using square brackets `[]` defines a _character class_. This will match any one character to the characters in the class. You can also specify a range of characters like `a-z`, as long as the start and end represent a contiguous range of code points.

```clojure
(def regex #"[a-z][ADKZ][0-9][!?]")
(re-matches regex "jZ5!")
;; => "jZ5!"
(re-matches regex "jB5?")
;; => nil
```

_Shorthand character classes_ make the pattern more concise. For example:

- `\d` short for `[0-9]` (any digit)
- `\w` short for `[A-Za-z0-9_]` (any 'word' character)
- `\s` short for `[ \t\n\x0B\f\r]` (any whitespace character)

When a _shorthand character class_ is used outside of the #"pattern" syntax, it must be escaped: `"\\d"`

### Alternations

_Alternations_ use `|` as a special character to denote matching one _or_ another

```clojure
(def regex #"cat|bat")
(re-matches regex "bat")
;; => "bat"
(re-matches regex "bat")
;; => "cat"
```

### Quantifiers

_Quantifiers_ allow for a repeating pattern in the regex. They affect the group preceding the quantifier.

- `{N, M}` where `N` is the minimum number of repetitions, and `M` is the maximum
- `{N,}` match `N` or more repetitions
- `{0,}` may also be written as `*`: match zero-or-more repetitions
- `{1,}` may also be written as `+`: match one-or-more repetitions

### Groups

Round brackets `()` are used to denote _groups_ and _captures_. The group may also be _captured_ in some instances to be returned for use. In Clojure, these may be named or un-named. Captures are named by appending `?<name>` after the opening parenthesis. Groups function as a single unit, like when followed by _quantifiers_.

```clojure
(re-find #"(?<letterb>b)" "blueberry")
;; => ["b" "b"]
```

### Anchors

_Anchors_ are used to tie the regular expression to the beginning or end of the string to be matched:

- `^` anchors to the beginning of the string
- `$` anchors to the end of the string

### Concatenation

Because the `#"pattern"` syntax is a shortcut for `re-pattern`, you may also use string concatenation to dynamically build a regular expression pattern:

```clojure
(def anchor "$")
(def regex (str "end of the line" anchor))
(re-matches regex "end of the line?")
;; => nil
(re-matches regex "end of the line")
"end of the line" =~ regex
;; => "end of the line"
```