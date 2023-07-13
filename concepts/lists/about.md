# About

## Key Learnings

- Lists are collections.
- Lists can be created using `list` or by using a single quote.
- Clojure will try to evaluate lists, treating the first item as a function.
- Core functions:
  - `cons` returns a list with the new item added to beginning.
  - `first` returns the first item from a list.
  - `rest` returns the list without the first item.
  - `count` returns the number of items in the list.
  - `conj` returns a list with items added at beginning in list. The difference between conj and cons is conj works with other data types unlike cons.The conj function returns a clojure.lang.PersistentList, while the cons function returns a clojure.lang.Cons.
## Additional Resources

- [list - clojure.core | ClojureDocs](https://clojuredocs.org/clojure.core/list)
- [Data Structures](https://clojure.org/reference/data_structures)
- [Lists in Clojurescript](https://cljs.github.io/api/syntax/list)
