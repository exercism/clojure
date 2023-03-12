(ns zipper-test
  (:require [clojure.test :refer [deftest testing is run-tests]]
             zipper))

(def t1 {:value 1, :left {:value 2, :left nil, :right {:value 3, :left nil, :right nil}}, :right {:value 4, :left nil, :right nil}})

(deftest expectedValue-test
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
      (is (= tree (-> tree zipper/fromTree zipper/toTree))))
    (testing "left, right and value"
      (is (= 3 (-> t1
                   zipper/fromTree
                   zipper/left
                   zipper/right
                   zipper/value
                   ))))
    (testing "dead end"
      (is (= nil (-> tree
                     zipper/fromTree
                     zipper/left
                     zipper/left))))
    (testing "tree from deep focus"
      (is (= tree (-> tree
                      zipper/fromTree
                      zipper/left
                      zipper/right
                      zipper/toTree))))
    (testing "traversing up from top"
      (is (= nil 
             (-> tree
                 zipper/fromTree
                 zipper/up))))
    (testing "left, right, and up"
      (is (= 3 
             (-> tree
                 zipper/fromTree
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
                 zipper/fromTree
                 zipper/left
                 zipper/right
                 zipper/up
                 zipper/up
                 zipper/value))))
    #_(testing "set_value"
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
                 zipper/fromTree
                 zipper/left
                 (zipper/setValue 5)
                 zipper/toTree))))
    #_(testing "set_value after traversing up"
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
                 zipper/to_zip
                 zipper/left
                 zipper/right
                 zipper/up
                 (zipper/set_value 5)
                 zipper/to_tree))))
    #_(testing "set_left with leaf"
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
                 zipper/to_zip
                 zipper/left
                 (zipper/set_left {:value 5
                                   :left  nil
                                   :right nil})
                 zipper/to_tree))))
    #_(testing "set_right with null"
      (is (= {:value 1
              :left  {:value 2
                      :left  nil
                      :right nil}
              :right {:value 4
                      :left  nil
                      :right nil}} 
             (-> tree
                 zipper/to_zip
                 zipper/left
                 (zipper/set_right nil)
                 zipper/to_tree))))
    #_(testing "set_right with subtree"
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
                 zipper/to_zip
                 (zipper/set_right {:value 6
                                    :left  {:value 7
                                            :left  nil
                                            :right nil}
                                    :right {:value 8
                                            :left  nil
                                            :right nil}})
                 zipper/to_tree))))
    #_(testing "set_value on deep focus"
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
                 zipper/to_zip
                 zipper/left
                 zipper/right
                 (zipper/set_value 5)
                 zipper/to_tree))))))

#_(deftest sameResultFromOperations-test
  (testing "different paths to same zipper"
     (is (= nil 
         (-> {:value 1
              :left  {:value 2
                      :left  nil
                      :right {:value 3
                              :left  nil
                              :right nil}}
              :right {:value 4
                      :left  nil
                      :right nil}}
             zipper/to_zip
             zipper/left
             zipper/up
             zipper/right)))))

 (run-tests)