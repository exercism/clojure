# Hints

## 1. Get the first card

- [This guide][destructuring_resource] has a good overview of sequential destructuring. You can find an example of binding names to values.

## 2. Get the second card

- You can use placeholders to ignore one or more values in the binding.

## 3. Swap the first two cards

- It's possible to use `&` to combine the tail elements into a sequence.

## 4. Discard the top card

- You can use `:as all` to bind the entire vector to the symbol `all`.

## 5. Insert face cards

- You can find more info on where to destructure [here][where-to-destructure].

[destructuring_resource]: https://clojure.org/guides/destructuring#_sequential_destructuring
[where-to-destructure]: https://clojure.org/guides/destructuring#_where_to_destructure
