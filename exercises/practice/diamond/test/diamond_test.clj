(ns diamond-test
  (:require [clojure.test :refer [deftest testing is]]
            [clojure.string :as str]
            diamond))

(deftest diamond_test_1
  (testing "Degenerate case with a single 'A' row"
    (is (= (str/join "\n" ["A"])
           (diamond/diamond \A)))))

(deftest diamond_test_2
  (testing "Degenerate case with no row containing 3 distinct groups of spaces"
    (is (= (str/join "\n" [" A "
                           "B B"
                           " A "])
           (diamond/diamond \B)))))

(deftest diamond_test_3
  (testing "Smallest non-degenerate case with odd diamond side length"
    (is (= (str/join "\n" ["  A  "
                           " B B "
                           "C   C"
                           " B B "
                           "  A  "])
           (diamond/diamond \C)))))

(deftest diamond_test_4
  (testing "Smallest non-degenerate case with even diamond side length"
    (is (= (str/join "\n" ["   A   "
                           "  B B  "
                           " C   C "
                           "D     D"
                           " C   C "
                           "  B B  "
                           "   A   "])
           (diamond/diamond \D)))))

(deftest diamond_test_5
  (testing "Largest possible diamond"
    (is (= (str/join "\n" ["                         A                         "
                           "                        B B                        "
                           "                       C   C                       "
                           "                      D     D                      "
                           "                     E       E                     "
                           "                    F         F                    "
                           "                   G           G                   "
                           "                  H             H                  "
                           "                 I               I                 "
                           "                J                 J                "
                           "               K                   K               "
                           "              L                     L              "
                           "             M                       M             "
                           "            N                         N            "
                           "           O                           O           "
                           "          P                             P          "
                           "         Q                               Q         "
                           "        R                                 R        "
                           "       S                                   S       "
                           "      T                                     T      "
                           "     U                                       U     "
                           "    V                                         V    "
                           "   W                                           W   "
                           "  X                                             X  "
                           " Y                                               Y "
                           "Z                                                 Z"
                           " Y                                               Y "
                           "  X                                             X  "
                           "   W                                           W   "
                           "    V                                         V    "
                           "     U                                       U     "
                           "      T                                     T      "
                           "       S                                   S       "
                           "        R                                 R        "
                           "         Q                               Q         "
                           "          P                             P          "
                           "           O                           O           "
                           "            N                         N            "
                           "             M                       M             "
                           "              L                     L              "
                           "               K                   K               "
                           "                J                 J                "
                           "                 I               I                 "
                           "                  H             H                  "
                           "                   G           G                   "
                           "                    F         F                    "
                           "                     E       E                     "
                           "                      D     D                      "
                           "                       C   C                       "
                           "                        B B                        "
                           "                         A                         "])
           (diamond/diamond \Z)))))
