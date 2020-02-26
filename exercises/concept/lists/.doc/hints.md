### 1. Create an empty list

Creating an empty list is just like creating a list with items. It can be done using `list` or using `quote` on an empty list.

### 2. Add a new lanuguage to the list

Check out [`cons`](https://clojuredocs.org/clojure.core/cons).

### 3. Check the lanugage last added

Check out [`first`](https://clojuredocs.org/clojure.core/first).

### 4. Remove the first language from the list

Check out [`rest`](https://clojuredocs.org/clojure.core/rest).

### 5. Count the languages in the list

Check out [`count`](https://clojuredocs.org/clojure.core/count).

### 6. Put it all together

Remember that function calls can be nested.

```clojure
(add-language "Clojure" (new-list))
```
