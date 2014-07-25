(ns bst.test (:require [clojure.test :refer :all]))
(load-file "bst.clj")

(deftest data-is-retained
  (is (= 4 (binary_search_tree/value (binary_search_tree/singleton 4)))))

(deftest inserting-less 
  (let [t (binary_search_tree/insert 2 (binary_search_tree/singleton 4))]
    (is (= 4 (binary_search_tree/value t)))
    (is (= 2 (binary_search_tree/value (binary_search_tree/left t))))))

(deftest inserting-same
  (let [t (binary_search_tree/insert 4 (binary_search_tree/singleton 4))]
    (is (= 4 (binary_search_tree/value t)))
    (is (= 4 (binary_search_tree/value (binary_search_tree/left t))))))

(deftest inserting-right
  (let [t (binary_search_tree/insert 5 (binary_search_tree/singleton 4))]
    (is (= 4 (binary_search_tree/value t)))
    (is (= 5 (binary_search_tree/value (binary_search_tree/right t))))))

(deftest complex-tree
  (let [t (binary_search_tree/from-list [4 2 6 1 3 7 5])]
    (is (= 4 (binary_search_tree/value t)))
    (is (= 2 (binary_search_tree/value (binary_search_tree/left t))))
    (is (= 1 (binary_search_tree/value (binary_search_tree/left (binary_search_tree/left t)))))
    (is (= 3 (binary_search_tree/value (binary_search_tree/right (binary_search_tree/left t)))))
    (is (= 6 (binary_search_tree/value (binary_search_tree/right t))))
    (is (= 5 (binary_search_tree/value (binary_search_tree/left (binary_search_tree/right t)))))
    (is (= 7 (binary_search_tree/value (binary_search_tree/right (binary_search_tree/right t)))))))

(deftest iterating-one-element
  (is (= [4] (binary_search_tree/to-list (binary_search_tree/singleton 4)))))

(deftest iterating-over-smaller-element
  (is (= [2 4] (binary_search_tree/to-list (binary_search_tree/from-list [4 2])))))

(deftest iterating-over-larger-element
  (is (= [4 5] (binary_search_tree/to-list (binary_search_tree/from-list [4 5])))))

(deftest iterating-over-complex-tree 
  (is (= (range 1 8) (binary_search_tree/to-list (binary_search_tree/from-list [4 2 1 3 6 7 5])))))

(run-tests)

