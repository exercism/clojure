# Introduction

Since all of Clojure's standard data types are immutable, it offers *reference types* which offer controlled mutation. The simplest and most commonly used of these are called Atoms.

Atoms are created with the `atom` function, which take an initial value:

```clojure
(def players (atom ()))
```

The current value of the atom is dereferenced with either `deref` or the `@` shorthand:

```clojure
@players
;;=> ()
```

The current value of the `players` atom can be modified using `swap!`, which updates the value by applying a function:

```clojure
(swap! players conj :player1)
;;=> (:player1)
```

The `reset!` function replaces the value of an atom without regard for its current value:

```clojure
(reset! players ())
```
