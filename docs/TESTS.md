#+TITLE: Tests

A Clojure REPL allows you to easily run code and get immediate feedback and can
also be used to run tests.

* Leiningen
To open a REPL using Leiningen change to the directory containing the
exercise and run:
#+BEGIN_SRC bash
$ lein repl
#+END_SRC

Once you are ready to work on an exercise and have created a file to hold your
solution (such as =bob.clj=) you can run the tests using
~#'clojure.test/run-tests~ [[http://clojure.github.io/clojure/clojure.test-api.html#clojure.test/run-tests][as described here]].

First, =require= the test namespace:
#+BEGIN_SRC clojure
=> (require 'bob-test)
nil
#+END_SRC

Then call =run-tests= on =bob-test=:
#+BEGIN_SRC clojure
=> (clojure.test/run-tests 'bob-test)

Testing bob-test

Ran 14 tests containing 14 assertions.
0 failures, 0 errors.
{:test 14, :pass 14, :fail 0, :error 0, :type :summary}
#+END_SRC

To run a exercise's tests with Leiningen, simply call:
#+BEGIN_SRC bash
$ lein test
#+END_SRC
#+BEGIN_EXAMPLE
lein test bob-test

Ran 14 tests containing 14 assertions.
0 failures, 0 errors.
#+END_EXAMPLE

* Standalone JAR
To open a REPL using the standalone JAR file (assuming Clojure 1.8.0) run:
#+BEGIN_SRC bash
$ java -cp clojure-1.8.0.jar clojure.main
#+END_SRC

To execute a file use:
#+BEGIN_SRC bash
$ java -cp clojure-1.8.0.jar clojure.main bob_test.clj
#+END_SRC
