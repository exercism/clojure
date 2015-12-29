(ns hello-world-test
  (:require [clojure.test :refer [deftest is]]
            hello-world))

(deftest hello-world-test
  (is (= "Hello, World!" (hello-world/hello))))

(deftest hello-alice-test
  (is (= "Hello, Alice!" (hello-world/hello "Alice"))))

(deftest hello-bob-test
  (is (= "Hello, Bob!" (hello-world/hello "Bob"))))
