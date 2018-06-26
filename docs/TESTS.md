# Tests

A Clojure REPL allows you to easily run code and get immediate feedback and can also be used to run tests.

## Leiningen
To open a REPL using Leiningen change to the directory containing the exercise and run:
``` bash
$ lein repl
```

Once you are ready to work on an exercise and have created a file to hold your solution (such as `bob.clj`) you can run the tests using `clojure.test/run-tests` [as described here](http://clojure.github.io/clojure/clojure.test-api.html#clojure.test/run-tests).

First, `require` the test namespace:
``` clojure
=> (require 'bob-test)
nil
```

Then call `run-tests` on `bob-test`:
``` clojure
=> (clojure.test/run-tests 'bob-test)

Testing bob-test

Ran 14 tests containing 14 assertions.
0 failures, 0 errors.
{:test 14, :pass 14, :fail 0, :error 0, :type :summary}
```

To run an exercise's tests with Leiningen, simply call:
``` bash
$ lein test

lein test bob-test

Ran 14 tests containing 14 assertions.
0 failures, 0 errors.
```

## Standalone JAR
To open a REPL using the standalone JAR file (assuming Clojure 1.8.0) run:
``` bash
$ java -cp clojure-1.8.0.jar clojure.main
```

To execute a file use:
``` bash
$ java -cp clojure-1.8.0.jar clojure.main bob_test.clj
```
