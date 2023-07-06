#!/usr/bin/env bb

(require '[clojure.test :as t]
         '[babashka.classpath :as cp]
         '[cheshire.core :as json]
         '[clojure.string :as str]
         '[rewrite-clj.zip :as z])

(cp/add-classpath "libs.jar")

(require '[clojure.spec.alpha :as s]
         '[clojure.spec.gen.alpha :as gen])

;; Add solution source and tests to classpath
(def slug (first *command-line-args*))
(def in-dir (second *command-line-args*))
(def test-ns (symbol (str slug "-test")))
(cp/add-classpath (str in-dir "src:" in-dir "test"))
(require test-ns)

;; clojure.test runs the tests in random order,
;; but the spec requires that we report them in order.

;; Parse test file into zipper using rewrite-clj
(def zloc
  (z/of-file (str in-dir "/test/" (str/replace slug "-" "_") "_test.clj")))

(defn test?
  "Returns true if the given node is a `deftest`."
  [loc]
  (= (symbol 'deftest) (-> loc z/down z/sexpr)))

(defn assertion?
  "Returns true if the given node is an `is`."
  [loc]
  (= (symbol 'is) (-> loc z/down z/sexpr)))

(defn test-name
  "Returns the name of the test at a given node."
  [loc]
  (-> loc z/down z/right z/sexpr))

(defn test-code
  "Returns all of the test code for a given test"
  [loc]
  (->> (z/child-sexprs loc)
       (drop 2)
       (str/join "\n")))

(defn find-assertions
  "Returns a vector of the code for individual assertions in a given test."
  [loc]
  (->> (z/subzip loc) ;; isolate subtree to prevent find from leaving
       (iterate #(z/find-next-depth-first % assertion?))
       rest
       (take-while some?)
       (map #(->> (iterate z/up %)
                  (take-while (complement test?))
                  last))
       (map z/sexpr)
       (mapv str)))

(defn for-each-test
  "Traverses the zipper representing the parsed test file.
   Returns the result of calling f on each test."
  [f]
  (->> (iterate z/right zloc)
       (take-while some?)
       (filter test?)
       (map f)))

(def tests
  "A vector of the test names in the order defined."
  (for-each-test test-name))

(def test-codes
  "A vector of the test codes in the order defined."
  (for-each-test test-code))

(def test-assertions
  "A vector of vectors of test assertions in the order defined."
  (for-each-test find-assertions))

(def test-code-map (zipmap tests test-codes))
(def test-assertions-map (zipmap tests test-assertions))

;; State to hold test results
(def passes (atom []))
(def fails+errors (atom []))
(def assertion-counts (atom {})) ;; tracks which assertion is being reported on

;; logic for creating test results

(defn error-message [err]
  (or (:message (ex-data err)) (str err)))

(defn get-message [{:keys [type] :as m}]
  (case type
    :fail (str "Expected " (:expected m) " but got " (:actual m))
    :error (str "An unexpected error occurred:\n" (error-message (:actual m)))
    :pass nil))

(defn get-test-code [test-name status]
  (let [a-count ((swap! assertion-counts update test-name (fnil inc 0)) test-name)]
    (if (= :pass status)
      ;; for passing tests show the whole test
      (test-code-map test-name)
      ;; for fails just the one that failed/default to the whole test if index is out of bounds
      (get (test-assertions-map test-name) (dec a-count) (test-code-map test-name)))))

(defn report [{:keys [type] :as m}]
  (let [{:keys [name task]} (meta (first t/*testing-vars*))]
    {:name name
     :status type
     :task_id task
     :test_code (get-test-code name type)
     :message (get-message m)}))

;; Override clojure.test reporting methods to capture their results

(defmethod t/report :begin-test-ns [_])

(defmethod t/report :pass [m]
  (swap! passes conj (report m)))

(defmethod t/report :fail [m]
  (swap! fails+errors conj (report m)))

(defmethod t/report :error [m]
  (swap! fails+errors conj (report m)))

(defmethod t/report :summary [_])

(t/run-tests test-ns)

;; Produce JSON output

(defn remove-nil-vals [m]
  (into {} (remove #(nil? (second %)) m)))

(defn default-report
  "A test that has no assertions and throws no errors passes by default"
  [test-name]
  {:name test-name :status :pass :test_code (test-code-map test-name)})

(println (json/generate-string
          {:version 3
           :status (if (empty? @fails+errors) :pass :fail)
           :tests (for [test tests]
                    (->> (concat @fails+errors @passes [(default-report test)])
                         (filter #(= test (:name %)))
                         first
                         remove-nil-vals))}))

(System/exit 0)
