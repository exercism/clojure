(ns largest-series-product-test
  (:require [clojure.test :refer [deftest is testing]]
            [largest-series-product :as lsp]))

(deftest largest-series-tests
  (testing "can find the largest product of 2 with numbers in order"
    (is (= 72 (lsp/largest-product 2 "0123456789"))))
  (testing "can find the largest product of 2"
    (is (= 48 (lsp/largest-product 2 "576802143"))))
  (testing "finds the largest product if span equals length"
    (is (= 18 (lsp/largest-product 2 "29"))))
  (testing "can find the largest product of 3 with numbers in order"
    (is (= 504 (lsp/largest-product 3 "0123456789"))))
  (testing "can find the largest product of 3"
    (is (= 270 (lsp/largest-product 3 "1027839564"))))
  (testing "can find the largest product of 5 with numbers in order"
    (is (= 15120 (lsp/largest-product 5 "0123456789"))))
  (testing "can get the largest product of a big number"
    (is (= 23520
           (let [ds "73167176531330624919225119674426574742355349194934"]
             (lsp/largest-product 6 ds)))))
  (testing "can get the largest product of a big number II"
    (is (= 28350
           (let [ds "52677741234314237566414902593461595376319419139427"]
             (lsp/largest-product 6 ds)))))
  (testing "can get the largest product of a big number (Project Euler)"
    (is (= 23514624000
           (let [ds "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450"]
             (lsp/largest-product 13 ds)))))
  (testing "reports zero if the only digits are zero"
    (is (= 0 (lsp/largest-product 2 "0000"))))
  (testing "reports zero if all spans include zero"
    (is (= 0 (lsp/largest-product 3 "99099"))))
  (testing "rejects span longer than string length"
    (is (thrown? Throwable (lsp/largest-product 4 "123"))))
  (testing "reports 1 for empty string and empty product (0 span)"
    (is (= 1 (lsp/largest-product 0 ""))))
  (testing "reports 1 for nonempty string and empty product (0 span)"
    (is (= 1 (lsp/largest-product 0 "123"))))
  (testing "rejects empty string and nonzero span"
    (is (thrown? Throwable (lsp/largest-product 1 ""))))
  (testing "rejects invalid character in digits"
    (is (thrown? Throwable (lsp/largest-product 2 "1234a5"))))
  (testing "rejects negative span"
    (is (thrown? Throwable (lsp/largest-product -1 "12345")))))
