(ns pov-test
  (:require [clojure.test :refer [deftest is]]
            pov))

;;; Inputs.

(def singleton [:x])

(def simple-tree [:parent [:sibling] [:x]])

(def large-flat
  [:parent [:sib-a]
   [:sib-b]
   [:x]
   [:sib-c]
   [:sib-d]])

(def deeply-nested
  [:level-0
   [:level-1
    [:level-2
     [:level-3
      [:level-4
       [:x]]]]]])

(def cousins
  [:grand-parent
   [:parent
    [:sib-1]
    [:x]
    [:sib-2]]
   [:uncle
    [:cousin-1]
    [:cousin-2]]])

(def target-with-children
  [:grand-parent
   [:parent
    [:x
     [:child-1]
     [:child-2]]
    [:sibling
     [:nephew]
     [:niece]]]
   [:aunt
    [:cousin-1
     [:2nd-cousin-1]
     [:2nd-cousin-2]]
    [:cousin-2
     [:2nd-cousin-3]
     [:2nd-cousin-4]]]])

;;; Expected results.

(def simple-pulled [:x [:parent [:sibling]]])

(def flat-pulled
  [:x [:parent
       [:sib-a]
       [:sib-b]
       [:sib-c]
       [:sib-d]]])

(def nested-pulled
  [:x
   [:level-4
    [:level-3
     [:level-2
      [:level-1
       [:level-0]]]]]])

(def cousins-pulled
  [:x
   [:parent
    [:sib-1]
    [:sib-2]
    [:grand-parent
     [:uncle
      [:cousin-1]
      [:cousin-2]]]]])

(def with-kids-pulled
  [:x
   [:child-1]
   [:child-2]
   [:parent
    [:sibling
     [:nephew]
     [:niece]]
    [:grand-parent
     [:aunt
      [:cousin-1
       [:2nd-cousin-1]
       [:2nd-cousin-2]]
      [:cousin-2
       [:2nd-cousin-3]
       [:2nd-cousin-4]]]]]])

(deftest singletons
  (is (= singleton
         (pov/of :x singleton))))

(deftest simple-trees
  (is (= simple-pulled
         (pov/of :x simple-tree))))

(deftest nested-trees
  (is (= nested-pulled
         (pov/of :x deeply-nested))))

(deftest extract-node-from-siblings
  (is (= flat-pulled
         (pov/of :x large-flat))))

(deftest moderate-trees
  (is (= cousins-pulled
         (pov/of :x cousins))))

(deftest complex-trees
  (is (= with-kids-pulled
         (pov/of :x target-with-children))))

(deftest not-found-cannot-reparent
  (is (nil? (pov/of :not-found! target-with-children))))

(deftest not-found-input-empty
  (is (nil? (pov/of :x []))))

(deftest not-found-input-nil
  (is (nil? (pov/of :x nil))))

(deftest path-from-target-to-parent
  (is (= [:x :parent]
         (pov/path-from-to :x :parent simple-tree))))

(deftest path-from-target-to-sibling
  (is (= [:x :parent :sib-c]
         (pov/path-from-to :x :sib-c large-flat))))

(deftest path-from-x-to-2nd-cousin-1
  (is (= [:x :parent :grand-parent :aunt :cousin-1 :2nd-cousin-1]
         (pov/path-from-to :x :2nd-cousin-1 target-with-children))))

(deftest no-path
  (is (nil? (pov/path-from-to :x :not-there! cousins))))
