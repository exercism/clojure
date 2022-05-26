(ns tracks-on-tracks-on-tracks)

(defn new-list []
  '())

(defn add-language
  [lang-list lang]
  (conj lang-list lang))

(defn first-language
  [lang-list]
  (first lang-list))

(defn remove-language
  [lang-list]
  (rest lang-list))

(defn count-languages
  [lang-list]
  (count lang-list))

(defn learning-list []
  (-> (new-list)
      (add-language "Clojure")
      (add-language "Lisp")
      remove-language
      (add-language "Java")
      (add-language "JavaScript")
      count-languages))
