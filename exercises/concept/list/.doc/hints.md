# Hints

### 4. Query an item from the list

At first sight, you might think of using `contains` as you do in other languages. 

However if you do that, you will get `IllegalArgumentException` errors in Clojure:

```
=> (contains? '(1 2 3) 1)   
;; IllegalArgumentException (Clojure >=1.5)
```

This is because, although lists in Clojure are sequences, they are not **keyed** sequences, while `[contains?](https://clojuredocs.org/clojure.core/contains_q) requires keyed sequences to work on.

> `contains?` Returns true if key is present in the given collection, otherwise returns false.`

Instead, you can use [some](https://clojuredocs.org/clojure.core/some)

```
> (some  #(=  5  %)  \[1  2  3  4  5\])  ;;=\> true
```