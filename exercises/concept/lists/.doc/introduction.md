In Clojure, Lists are [collections][type-collection], just as like [lists in other languages][type-list]. Similar to other languages in the Lisp family, Clojure uses parentheses to express lists.

Clojure lists can be created in one of two ways. The `list` function can create a list, or you can `quote` a literal list.

```clojure
(list 1 3 5 8)
;; => (1 3 5 8)

'(1 3 5 8)
;; => (1 3 5 8)
```

Lists are special beacuse Clojure will treat them as _calls_. It expects the call to start with an _operator_, which is usually a function. The remaining items of the list are considered _operands_, meaning they become the function's arguments.

Most of your Clojure code will be in the form of lists.

```clojure
(+ 1 2)
;; => 3

(+ 2 (* 5 6))
;; => 32
```

Clojure's special treatment of lists is why we cannot create a list literal directly. In the example below, we get an error saying that `1` cannot be used as a function. Quoting a list using `quote` or its shorthand `'` incidates that the list should not be evaluated.

```clojure
(1 3 5 8)
;; => Execution error (ClassCastException) at user/eval2009 (REPL:1).java.lang.Long cannot be cast to clojure.lang.IFn

(quote (1 3 5 8))
;; => (1 3 5 8)
```

Unlike some modern languages, Clojure lists are _heterogenous_, meaning they can contain mutliple types of item internally. E.g. `'(2 "a" "b" 3)`
Unlike other other Lisps, an empty list in Clojure in truthy and is not equivalent to `nil` or `false`.

[type-list]: ../../../../../../reference/types/list.md
[type-collection]: ../../../../../../reference/types/collection.md
