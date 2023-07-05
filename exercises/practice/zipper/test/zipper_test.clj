(ns zipper-test
  (:require [clojure.test :refer [deftest testing is run-tests]]
             zipper))

(def t1 {:value 1, :left {:value 2, :left nil, :right {:value 3, :left nil, :right nil}}, :right {:value 4, :left nil, :right nil}})

(deftest expected-value-test
  (let [tree {:value 1
              :left  {:value 2
                      :left  nil
                      :right {:value 3
                              :left  nil
                              :right nil}}
              :right {:value 4
                      :left  nil
                      :right nil}}]
    (testing "data is retained"
      (is (= tree (-> tree zipper/from-tree zipper/to-tree))))
    (testing "left, right and value"
      (is (= 3 (-> t1
                   zipper/from-tree
                   zipper/left
                   zipper/right
                   zipper/value
                   ))))
    (testing "dead end"
      (is (nil? (-> tree
                     zipper/from-tree
                     zipper/left
                     zipper/left))))
    (testing "tree from deep focus"
      (is (= tree (-> tree
                      zipper/from-tree
                      zipper/left
                      zipper/right
                      zipper/to-tree))))
    (testing "traversing up from top"
      (is (= nil 
             (-> tree
                 zipper/from-tree
                 zipper/up))))
    (testing "left, right, and up"
      (is (= 3 
             (-> tree
                 zipper/from-tree
                 zipper/left
                 zipper/up
                 zipper/right
                 zipper/up
                 zipper/left
                 zipper/right
                 zipper/value))))
    (testing "test ability to descend multiple levels and return"
      (is (= 1 
             (-> tree
                 zipper/from-tree
                 zipper/left
                 zipper/right
                 zipper/up
                 zipper/up
                 zipper/value))))
    (testing "set_value"
      (is (= {:value 1
              :left  {:value 5
                      :left  nil
                      :right {:value 3
                              :left  nil
                              :right nil}}
              :right {:value 4
                      :left  nil
                      :right nil}} 
             (-> tree
                 zipper/from-tree
                 zipper/left
                 (zipper/set-value 5)
                 zipper/to-tree))))
    (testing "set_value after traversing up"
      (is (= {:value 1
              :left  {:value 5
                      :left  nil
                      :right {:value 3
                              :left  nil
                              :right nil}}
              :right {:value 4
                      :left  nil
                      :right nil}} 
             (-> tree
                 zipper/from-tree
                 zipper/left
                 zipper/right
                 zipper/up
                 (zipper/set-value 5)
                 zipper/to-tree))))
    (testing "set_left with leaf"
      (is (= {:value 1
              :left  {:value 2
                      :left  {:value 5
                              :left  nil
                              :right nil}
                      :right {:value 3
                              :left  nil
                              :right nil}}
              :right {:value 4
                      :left  nil
                      :right nil}} 
             (-> tree
                 zipper/from-tree
                 zipper/left
                 (zipper/set-left {:value 5
                                   :left  nil
                                   :right nil})
                 zipper/to-tree))))
    (testing "set_right with null"
      (is (= {:value 1
              :left  {:value 2
                      :left  nil
                      :right nil}
              :right {:value 4
                      :left  nil
                      :right nil}} 
             (-> tree
                 zipper/from-tree
                 zipper/left
                 (zipper/set-right nil)
                 zipper/to-tree))))
    (testing "set_right with subtree"
      (is (= {:value 1
              :left  {:value 2
                      :left  nil
                      :right {:value 3
                              :left  nil
                              :right nil}}
              :right {:value 6
                      :left  {:value 7
                              :left  nil
                              :right nil}
                      :right {:value 8
                              :left  nil
                              :right nil}}} 
             (-> tree
                 zipper/from-tree
                 (zipper/set-right {:value 6
                                    :left  {:value 7
                                            :left  nil
                                            :right nil}
                                    :right {:value 8
                                            :left  nil
                                            :right nil}})
                 zipper/to-tree))))
    (testing "set_value on deep focus"
      (is (= {:value 1
              :left  {:value 2
                      :left  nil
                      :right {:value 5
                              :left  nil
                              :right nil}}
              :right {:value 4
                      :left  nil
                      :right nil}} 
             (-> tree
                 zipper/from-tree
                 zipper/left
                 zipper/right
                 (zipper/set-value 5)
                 zipper/to-tree))))))

(deftest sameResultFromOperations-test
  (testing "different paths to same zipper"
     (is (= (-> {:value 1
                 :left  {:value 2
                         :left  nil
                         :right {:value 3
                                 :left  nil
                                 :right nil}}
                 :right {:value 4
                         :left  nil
                         :right nil}}
                zipper/from-tree
                zipper/right)
         (-> {:value 1
              :left  {:value 2
                      :left  nil
                      :right {:value 3
                              :left  nil
                              :right nil}}
              :right {:value 4
                      :left  nil
                      :right nil}}
             zipper/from-tree
             zipper/left
             zipper/up
             zipper/right)))))
