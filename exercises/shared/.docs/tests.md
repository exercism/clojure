# Tests

## Clojure CLI

The Clojure exercises on Exercism ship with a `deps.edn` file with a `:test` alias to invoke the [cognitect-labs test-runner](https://github.com/cognitect-labs/test-runner):

``` bash
$ clj -X:test
```

## Leiningen

Leiningen can also be used to run the exercise's test by running the following command from the exercise's directory:

```bash
lein test
```

## REPL

To use the REPL to run the exercise's test, run the following command from the exercise's directory:

```bash
$ clj
```

-or-

```bash
$ lein repl
```

Then `require` the exercise's test namespace and the Clojure test namespace):

```clojure
;; replace <exercise> with the exercise's name
=> (require '<exercise>-test)
```

Then call `run-tests` on `<exercise>-test`:

```clojure
;; replace <exercise> with the exercise's name
=> (clojure.test/run-tests '<exercise>-test)
```
