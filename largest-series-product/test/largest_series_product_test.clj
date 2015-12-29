(ns largest-series-product-test
  (:require [clojure.test :refer [deftest is]]
            [largest-series-product :as lsp]))

(deftest largest-series-tests
  (is (= (range 0 10) (lsp/digits "0123456789")))
  (is (= (range 9 -1 -1) (lsp/digits "9876543210")))
  (is (= (range 8 3 -1) (lsp/digits "87654")))
  (is (= [9 3 6 9 2 3 4 6 8] (lsp/digits "936923468")))
  (is (= [[9 8] [8 2] [2 7] [7 3] [3 4] [4 6] [6 3]]
         (lsp/slices 2 "98273463")))
  (is (= [[9 8 2] [8 2 3] [2 3 4] [3 4 7]]
         (lsp/slices 3 "982347")))
  (is (= 72 (lsp/largest-product 2 "0123456789")))
  (is (= 2 (lsp/largest-product 2 "12")))
  (is (= 9 (lsp/largest-product 2 "19")))
  (is (= 48 (lsp/largest-product 2 "576802143")))
  (is (= 504 (lsp/largest-product 3 "0123456789")))
  (is (= 270 (lsp/largest-product 3 "1027839564")))
  (is (= 15120 (lsp/largest-product 5 "0123456789")))
  (is (= 23520
         (let [ds "73167176531330624919225119674426574742355349194934"]
           (lsp/largest-product 6 ds))))
  (is (= 28350
         (let [ds "52677741234314237566414902593461595376319419139427"]
           (lsp/largest-product 6 ds))))
  (is (thrown-with-msg? Throwable #"empty"
        (lsp/largest-product 0 "")))
  ;; unlike the Ruby implementation no error is expected for too small input
  (is (= 1 (lsp/largest-product 4 "123")))
  ;; edge case :)
  (is (= 0 (lsp/largest-product 2 "00"))))
