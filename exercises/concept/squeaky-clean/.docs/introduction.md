# Introduction

## Character operations

Clojure characters are `java.lang.Character` primitives, and we can manipulate them via [interop][clojure-java-interop] using the methods in the [Character class][java-character-class]:

```clojure
(Character/isDigit \2)
;;=> true
```

## String utilities

Clojure ships with a powerful string processing library, [clojure.string][clojure-str]. This is often more idiomatic than interop.

[clojure-str]: https://clojuredocs.org/clojure.string
[clojure-java-interop]: https://clojure.org/reference/java_interop
[java-character-class]: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Character.html