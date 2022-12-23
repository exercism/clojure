## Clojure representations

The [Clojure representer][github-clojure-representer] applies the following normalizations:

- All comments are removed
- All whitespace is normalized
- Identifiers are normalized to a placeholder value
- All macros are fully expanded

### Before you submit

Please check the following things:

1. You don't duplicate analyzer feedback
2. You check the "examples" tab in the submit dialog and see if the feedback makes sense for _all_ tabs.
3. You check that you have not referred to whitespace or comments
4. You check that you have not given feedback specific to library functions implemented as macros (eg. `when`, `cond`, `lazy-seq`, `if-not`, or threading macros). For reference, you can check the [Clojure core library source][clojure-core-source] and search for `defmacro`.
6. You check that you don't refer to function names, or variable names as they appear in the solution, but rather use the mapping provided (or leave names out).
   Only _exported_ names (required by the tests) you can safely refer to because these are always the same for everyone.
   
[clojure-core-source]: https://github.com/clojure/clojure/blob/master/src/clj/clojure/core.clj
[github-clojure-representer]: https://github.com/exercism/clojure-representer
