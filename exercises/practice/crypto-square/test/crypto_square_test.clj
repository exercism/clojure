(ns crypto-square-test
  (:require [clojure.test :refer [deftest is]]
            crypto-square))

(deftest normalize-splunk
  (is (= "splunk" (crypto-square/normalize-plaintext "s#!@$%plunk"))))
(deftest normalize-with-punctuation
  (is (= "123go" (crypto-square/normalize-plaintext "1, 2, 3 GO!"))))

(deftest square-2
  (is (= 2 (crypto-square/square-size "1234"))))
(deftest square-3
  (is (= 3 (crypto-square/square-size "123456789"))))
(deftest square-4
  (is (= 4 (crypto-square/square-size "123456789abc"))))

(deftest segments
  (is (= ["neverv", "exthin", "eheart", "withid", "lewoes"]
         (crypto-square/plaintext-segments "Never vex thine heart with idle woes."))))
(deftest segments-2
  (is (= ["zomg", "zomb", "ies"]
         (crypto-square/plaintext-segments "ZOMG! ZOMBIES!!!"))))

(deftest cipher-1
  (is (= "tasneyinicdsmiohooelntuillibsuuml"
         (crypto-square/ciphertext "Time is an illusion. Lunchtime doubly so."))))
(deftest cipher-2
  (is (= "wneiaweoreneawssciliprerlneoidktcms"
         (crypto-square/ciphertext "We all know interspecies romance is weird."))))
(deftest cipher-3
  (is (= "msemo aanin dnin ndla etlt shui"
         (crypto-square/normalize-ciphertext "Madness, and then illumination."))))
(deftest cipher-4
  (is (= "vrel aepe mset paoo irpo"
         (crypto-square/normalize-ciphertext "Vampires are people too!"))))
(deftest cipher-5
  (is (= (str "ageihdsednsh lsagtoonaepe lannswnccair hrditeaetnrh "
              "ueethdnatoio mbqyewdnotto aouayicdwhod nranatosaef "
              "bnldrhnhrrb efirersodir irnieecusno nedgnailoat")
         (let [plaintext (str "All human beings are born free "
                              "and equal in dignity and rights. "
                              "They are endowed with reason and conscience "
                              "and should act towards one another "
                              "in a spirit of brotherhood.")]
           (crypto-square/normalize-ciphertext plaintext)))))
