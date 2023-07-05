# Instructions append

## Project Structure

Clojure exercises in exercism support the two most common tools for dependency management and testing, [leiningen](http://leiningen.org/) and the [Clojure CLI](https://clojure.org/guides/deps_and_cli).

You will find a test file named `hello_world_test.clj` inside `test` directory.
Write your code in `src/hello_world.clj`. It should use the namespace `hello-world` so that tests can pick it up.

### Running tests using the Clojure CLI

```
$ clj -X:test
```

### Running tests using Leiningen

```
$ lein test

lein test hello-world-test

Ran 3 tests containing 3 assertions.
0 failures, 0 errors.
```

Then submit the exercise using:

```
$ exercism submit src/hello_world.clj
```

For more detailed instructions and learning resources refer [exercism's clojure language page](http://exercism.org/languages/clojure).
