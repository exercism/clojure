(require
 '[clojure.java.io :as io]
 '[selmer.parser :refer [render render-file]])

(def data {:slug "isogram"
           :cases (cases (canonical-data "isogram"))})

(def template "/Users/erik/Code/exercism/tracks/clojure/exercises/practice/collatz-conjecture/.meta/tests.template")
(def tests "/Users/erik/Code/exercism/tracks/clojure/exercises/practice/collatz-conjecture/.meta/tests.clj")

(def toml-file "/home/erik/exercism/tracks/clojure/exercises/practice/collatz-conjecture/.meta/tests.toml")

(spit tests (render (slurp template) data))
(def t (toml/read (io/reader toml-file)))
(set (map first (filter #(not= false (get (last %) "include")) t)))

(.getAbsolutePath (io/file *file* ".." ".."))
(.getCanonicalPath (io/file *file* ".." ".." ".."))