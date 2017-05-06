#+TITLE: Installation

* Installing Leiningen
The simplest approach to setting up a Clojure environment is to install the
build tool [[https://github.com/technomancy/leiningen][Leiningen]] which will provide access to a REPL (Read Eval Print Loop)
for interactive development and allow you to run Clojure code.

** Linux and Windows
For installation instructions on most platforms see:
[[https://github.com/technomancy/leiningen#installation][Leiningen installation]].

** Homebrew for Mac OS X
Update your Homebrew:
#+BEGIN_SRC bash
$ brew update
#+END_SRC

Install Leiningen:
#+BEGIN_SRC bash
$ brew install leiningen
#+END_SRC

** Installing the standalone JAR
Alternatively you can download the latest stable release jar file from
[[http://clojure.org/community/downloads][clojure.org/downloads]] which contains everything required to run Clojure code and
provides a basic REPL.
