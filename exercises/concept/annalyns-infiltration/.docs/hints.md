# Hints

## 1. Check if a fast attack can be made

We need to check if the knight is awake and _invert_ the boolean value representing their state. This can be done with the [`not`][not] function.

## 2. Check if the group can be spied upon

We want to return `true` if _any_ of the supplied predicates are `true`. This can be done with the [`or`][or] function.

## 3. Check if the prisoner can be signaled

We want to return `true` if and only if _all_ of the supplied predicates are `true`. This can be done with the [`and`][and] function.

## 4. Check if the prisoner can be freed

We need to combine the three basic logical operators, [`and`][and], [`or`][or], and [`not`][not].

[not]: https://clojuredocs.org/clojure.core/not
[or]: https://clojuredocs.org/clojure.core/or
[and]: https://clojuredocs.org/clojure.core/and
