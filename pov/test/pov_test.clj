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

(deftest test-pov
  (is (= singleton
         (pov/of :x singleton))
      "Can handle singletons")
  (is (= simple-pulled
         (pov/of :x simple-tree))
      "Can handle simple trees")
  (is (= nested-pulled
         (pov/of :x deeply-nested))
      "Can handle nested trees")
  (is (= flat-pulled
         (pov/of :x large-flat))
      "Can extract a node from a list of siblings")
  (is (= cousins-pulled
         (pov/of :x cousins))
      "Can handle moderate trees")
  (is (= with-kids-pulled
         (pov/of :x target-with-children))
      "Can handle complex trees"))

(deftest not-found
  (is (nil? (pov/of :not-found! target-with-children))
      "Returns nil if we cannot reparent")
  (is (nil? (pov/of :x []))
      "Return nil if the input is empty")
  (is (nil? (pov/of :x nil))
      "Returns nil if the input is nil"))

(deftest path-from-to
  (is (= [:x :parent]
         (pov/path-from-to :x :parent simple-tree))
      "Can trace a path from target to parent")
  (is (= [:x :parent :sib-c]
         (pov/path-from-to :x :sib-c large-flat))
      "Can trace a path from target to sibling")
  (is (= [:x :parent :grand-parent :aunt :cousin-1 :2nd-cousin-1]
         (pov/path-from-to :x :2nd-cousin-1 target-with-children))
      "Can trace a path from :x to :2nd-cousin-1")
  (is (nil? (pov/path-from-to :x :not-there! cousins))
      "Returns nil if there is no path"))
