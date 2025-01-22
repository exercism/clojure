(ns formatting
  (:require [cljfmt.core :refer [reformat-string]]
            [clojure.string :as str])
  (:import [com.github.jknack.handlebars Formatter]))

(defn format-code [code]
  (reformat-string code))

(defn format-char [c _next]
  (str "\\" c))

(defn format-string [s _next]
  (str "\"" (str/escape s char-escape-string) "\""))

(defn format-collection [coll next open close]
  (let [formatted-elements (str/join " " (map #(. next format %) coll))]
    (str open formatted-elements close)))

(defn format-list [coll next]
  (format-collection coll next "'(" ")"))

(defn format-set [coll next]
  (format-collection coll next "#{" "}"))

(defn formatter [test conv]
  (proxy [Formatter] []
    (format [value next]
      (if (test value)
        (conv value next)
        (. next format value)))))
