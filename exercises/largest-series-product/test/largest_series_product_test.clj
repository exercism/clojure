(ns largest-series-product-test
  (:require [clojure.test :refer [deftest is]]
            [largest-series-product :as lsp]))

(deftest largest-series-tests
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
  ;; edge cases involving 0 or empty strings
  (is (= 1 (lsp/largest-product 0 "")))
  (is (= 1 (lsp/largest-product 0 "123")))
  (is (thrown? Throwable (lsp/largest-product 1 "")))
  (is (thrown? Throwable (lsp/largest-product 4 "123")))
  ;; if all spans contain zero, result is zero.
  (is (= 0 (lsp/largest-product 3 "99099")))
  (is (= 0 (lsp/largest-product 2 "00"))))
