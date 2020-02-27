(ns lists)

(defn new-list []
  '())

(defn add-language
  [lang lang-list]
  (cons lang lang-list))

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
  (->> (empty-list)
       (add-language "Clojure")
       (add-language "Lisp")
       remove-language
       (add-language "Java")
       (add-language "Javascript")
       count-languages))
