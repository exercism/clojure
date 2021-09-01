# Instructions append

## Project Structure

Clojure exercises in exercism use [leiningen](http://leiningen.org/) to configure and run your code
and use [leiningen standard directory structure](https://github.com/technomancy/leiningen/blob/master/doc/TUTORIAL.md#directory-layout).

You will find a test file named `hello_world_test.clj` inside `test` directory.
Write your code in `src/hello_world.clj`. It should use the namespace `hello-world` so that tests can pick it up.

## Running tests

Run the tests using `lein test` command and make them pass:

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

For more detailed instructions and learning resources refer [exercism's clojure language page](http://exercism.io/languages/clojure).
