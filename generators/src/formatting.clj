(ns formatting
  (:require [cljfmt.core :refer [reformat-string]]))

(defn format-code [code]
  (reformat-string code))
