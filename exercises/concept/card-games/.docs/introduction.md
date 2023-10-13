# Introduction

In Clojure, Lists are [collections][type-collection], just as like [lists in other languages][type-list]. Similar to other languages in the Lisp family, Clojure uses parentheses to express lists.

Clojure lists can be created in one of two ways. The `list` function can create a list, or you can `quote` a literal list.

Lists are special because Clojure will treat them as _calls_. It expects the call to start with an _operator_, which is usually a function. The remaining items of the list are considered _operands_, meaning they become the function's arguments.

Clojure's special treatment of lists is why we cannot create a list literal directly. Quoting a list using `quote` or its shorthand `'` indicates that the list should not be evaluated.

Unlike some modern languages, Clojure lists are _heterogeneous_, meaning they can contain multiple types of items internally e.g., `'(2 "a" "b" 3)`.
Unlike other Lisps, an empty list in Clojure is truthy and is not equivalent to `nil` or `false`.

[type-list]: https://github.com/exercism/v3/blob/main/reference/types/list.md
[type-collection]: https://github.com/exercism/v3/blob/main/reference/types/collection.md
