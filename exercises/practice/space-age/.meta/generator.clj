(ns space-age-generator
  (:require [hbs.helper :refer [safe-str]]
            [clojure.string :as str]))

(defn update-test-case [test-case]
  (update-in test-case [:input :planet] #(safe-str (str/lower-case %))))
