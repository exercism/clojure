# Tests

Leiningen can be used to run the exercise's test by running the following command from the exercise's directory:

```bash
lein test
```

## REPL

To use the REPL to run the exercise's test, run the following command from the exercise's directory:

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
