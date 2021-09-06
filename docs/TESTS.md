# Tests

## Clojure CLI

The Clojure exercises on Exercism come with a `deps.edn` file with a `:test` alias to invoke the [cognitect-labs test-runner](cognitect-labs test-runner):

``` bash
$ clj -X:test
```

## Leiningen

To run an exercise's tests with Leiningen, simply call:
``` bash
$ lein test

lein test bob-test

Ran 14 tests containing 14 assertions.
0 failures, 0 errors.
```
