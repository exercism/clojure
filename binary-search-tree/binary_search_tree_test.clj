(ns binary-search-tree-test
  (:require [clojure.test :refer :all]))

(load-file "binary_search_tree.clj")

(deftest data-is-retained
  (is (= 4 (binary-search-tree/value (binary-search-tree/singleton 4)))))

(deftest inserting-less
  (let [t (binary-search-tree/insert 2 (binary-search-tree/singleton 4))]
    (is (= 4 (binary-search-tree/value t)))
    (is (= 2 (binary-search-tree/value (binary-search-tree/left t))))))

(deftest inserting-same
  (let [t (binary-search-tree/insert 4 (binary-search-tree/singleton 4))]
    (is (= 4 (binary-search-tree/value t)))
    (is (= 4 (binary-search-tree/value (binary-search-tree/left t))))))

(deftest inserting-right
  (let [t (binary-search-tree/insert 5 (binary-search-tree/singleton 4))]
    (is (= 4 (binary-search-tree/value t)))
    (is (= 5 (binary-search-tree/value (binary-search-tree/right t))))))

(deftest complex-tree
  (let [t (binary-search-tree/from-list [4 2 6 1 3 7 5])]
    (is (= 4 (binary-search-tree/value t)))
    (is (= 2 (binary-search-tree/value (binary-search-tree/left t))))
    (is (= 1 (binary-search-tree/value (binary-search-tree/left (binary-search-tree/left t)))))
    (is (= 3 (binary-search-tree/value (binary-search-tree/right (binary-search-tree/left t)))))
    (is (= 6 (binary-search-tree/value (binary-search-tree/right t))))
    (is (= 5 (binary-search-tree/value (binary-search-tree/left (binary-search-tree/right t)))))
    (is (= 7 (binary-search-tree/value (binary-search-tree/right (binary-search-tree/right t)))))))

(deftest iterating-one-element
  (is (= [4] (binary-search-tree/to-list (binary-search-tree/singleton 4)))))

(deftest iterating-over-smaller-element
  (is (= [2 4] (binary-search-tree/to-list (binary-search-tree/from-list [4 2])))))

(deftest iterating-over-larger-element
  (is (= [4 5] (binary-search-tree/to-list (binary-search-tree/from-list [4 5])))))

(deftest iterating-over-complex-tree
  (is (= (range 1 8) (binary-search-tree/to-list (binary-search-tree/from-list [4 2 1 3 6 7 5])))))

(run-tests)

