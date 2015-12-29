(ns hexadecimal-test
  (:require [clojure.test :refer [deftest is]]
            hexadecimal))

(deftest hex-to-int-test
  (is (= 1 (hexadecimal/hex-to-int "1")))
  (is (= 12 (hexadecimal/hex-to-int "c")))
  (is (= 16 (hexadecimal/hex-to-int "10")))
  (is (= 175 (hexadecimal/hex-to-int "af")))
  (is (= 256 (hexadecimal/hex-to-int "100")))
  (is (= 105166 (hexadecimal/hex-to-int "19ace")))
  (is (= 0 (hexadecimal/hex-to-int "carrot")))
  (is (= 0 (hexadecimal/hex-to-int "000000")))
  (is (= 16777215 (hexadecimal/hex-to-int "ffffff")))
  (is (= 16776960 (hexadecimal/hex-to-int "ffff00"))))
