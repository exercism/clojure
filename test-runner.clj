#!/usr/bin/env bb

(require '[clojure.test :as t :refer [is deftest]]
         '[babashka.classpath :as cp]
         '[cheshire.core :as json]
         '[clojure.string :as str]
         '[rewrite-clj.zip :as z])

(comment
  (def slug "leap")
  (def in-dir "/home/porky/exercism/clojure-test-runner/tests/example-success/")
  )

;; Add solution source and tests to classpath
(def slug (first *command-line-args*))
(def in-dir (second *command-line-args*))
(def test-ns (symbol (str slug "-test")))
(cp/add-classpath (str in-dir "src:" in-dir "test"))
(require test-ns)

;; Parse test file into zipper using rewrite-clj
(def zloc (z/of-file (str in-dir "/test/" (str/replace slug "-" "_") "_test.clj")))

(defmethod t/report :fail [m])

(defn eval-is [assertion]
  (try (eval assertion)
       (catch Exception e
         (str e))))

(defn test-meta [loc]
  (-> loc
      (z/find-tag z/next :meta)
      first
      :children
      first
      :k))

(defn test-deftest 
  "Traverses a zipper from a 'deftest node. Recursively 
   evaluates all assertions and outputs a map of the results."
  [loc]
  (let [test loc]
    (loop [loc test prefix-string ""
           test-strings [] results [] assertions []]
      (cond
        (= (symbol 'deftest) (-> loc z/down z/sexpr))
        (recur (-> loc z/down z/right z/right)
               prefix-string test-strings results assertions)
        (and
         (= (symbol 'testing) (-> loc z/down z/sexpr))
         (= (symbol 'testing) (-> loc z/down z/right z/right z/down z/sexpr)))
        (recur (-> loc z/down z/right z/right)
               (-> loc z/down z/right z/sexpr)
               test-strings results assertions)
        (= (symbol 'testing) (-> loc z/down z/sexpr))
        (recur (-> loc z/down z/right z/right)
               prefix-string
               (conj test-strings
                     (str/trim (str prefix-string " "
                                    (-> loc z/down z/right z/sexpr))))
               (conj results [])
               assertions)
        (and 
         (= (symbol 'is) (-> loc z/down z/sexpr)) 
         (= (symbol 'is) (-> loc z/right z/down z/sexpr)))
        (recur (-> loc z/right)
               prefix-string
               test-strings
               (conj results [(eval-is (-> loc z/sexpr))])
               (conj assertions (z/sexpr loc)))
        (= (symbol 'is) (-> loc z/down z/sexpr))
        (recur (if (= (symbol 'testing) (-> loc z/up z/right z/sexpr))
                 (-> loc z/up z/right)
                 (-> loc z/right))
               prefix-string
               test-strings
               (conj (vec (butlast results))
                     (conj (vec (last results)) (eval-is (-> loc z/sexpr))))
               (conj assertions (z/sexpr loc)))
        :else
        {:test-name (-> test z/down z/right z/sexpr str)
         :results (vec (remove empty? results))
         :test-strings test-strings
         :assertions assertions
         :task_id (when (number? (test-meta test)) (Integer/parseInt (str/replace (str (test-meta test)) ":task" "")))}))))

(comment
  (test-deftest (z/of-string "(deftest year-not-divisible-by-4 (is (not (leap/leap-year? 2015))))")
)
  (test-deftest (-> zloc z/right))
  )

(defn test-file 
  "Takes a zipper representing a parsed test file.
   Finds each 'deftest form, tests it, and outputs
   an ordered sequence of result maps."
  [loc]
  (loop [loc loc
         tests []]
    (cond
      (nil? loc) tests
      (= (symbol 'deftest) (-> loc z/down z/sexpr)) 
      (recur (-> loc z/right) (conj tests (test-deftest loc)))
      :else 
      (recur (-> loc z/right) tests))))

(comment
  (test-file zloc))

(defn results 
  "Takes a zipper representing a parsed test file.
   Outputs the test results according to the spec."
  [loc]
  (flatten
   (for [test (test-file loc)]
     (if (empty? (:test-strings test))
       {:name (:test-name test)
        :status (if (every? true? (flatten (:results test)))
                  "pass" "fail")
        :test_code (str (first (:assertions test)))}
       (for [n (range (count (:test-strings test)))]
         {:name (get (:test-strings test) n)
          :status (cond 
                    (every? true? (get (:results test) n)) "pass" 
                    (some false? (get (:results test) n)) "fail"
                    :else "error")
          :test_code (str (get (:assertions test) n))
          :task_id (:task_id test)})))))

(comment
  (first (test-file zloc))
  (results zloc)
  (eval-is '(is (= true (annalyns-infiltration/can-fast-attack? false))))
  (eval-is '(is (= true (annas-infiltration/can-fast-attack? false))))
  (eval-is '(is (= false (annalyns-infiltration/can-fast-attack? e))))
  (results zloc)
  )

;; Produce JSON output

(println (json/generate-string
      {:version 3
       :status (cond 
                 (every? #(= "pass" (:status %)) (results zloc)) "pass" 
                 (some #(= "fail" (:status %)) (results zloc)) "fail"
                 :else "error")
       :message 
                  (first (remove #(or (= "pass" (:status %))
                                      (= "fail" (:status %)))
                                 (results zloc)))
       :tests
       (vec (results zloc))}
      {:pretty true}))

(System/exit 0)