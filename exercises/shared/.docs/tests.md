# Tests

## Clojure CLI

The Clojure exercises on Exercism ship with a `deps.edn` file with a `:test` alias to invoke the [cognitect-labs test-runner](https://github.com/cognitect-labs/test-runner):

``` bash
clj -X:test
```

## Leiningen

Leiningen can also be used to run the exercise's test by running the following command from the exercise's directory:

```bash
lein test
```
