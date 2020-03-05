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

;; Learners are not expected to use threading macros.
(defn learning-list []
  (count-languages
   (add-language "JavaScript"
                 (add-language "Java"
                               (remove-language
                                (add-language "Lisp"
                                              (add-language "Clojure"
                                                            (new-list))))))))
