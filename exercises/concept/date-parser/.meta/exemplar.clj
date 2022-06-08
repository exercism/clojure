(ns date-parser)

(def day "\\d{1,2}")
(def month "\\d{1,2}")
(def year "\\d{4}")

(def days "Sunday|Monday|Tuesday|Wednesday|Thursday|Friday|Saturday")

(defn day-names [s]
  (re-matches (re-pattern days) s))

(def months "January|February|March|April|May|June|July|August|September|October|November|December")

(defn month-names [s]
  (re-matches (re-pattern months) s))

(defn capture-month [s]
  (let [matcher (re-matcher (re-pattern (str "(?<month>" month ")")) s)]
    (when (.matches matcher)
      {:month (.group matcher "month")})))

(defn capture-day [s]
  (let [matcher (re-matcher (re-pattern (str "(?<day>" day ")")) s)]
    (when (.matches matcher)
      {:day (.group matcher "day")})))

(defn capture-year [s]
  (let [matcher (re-matcher (re-pattern (str "(?<year>" year ")")) s)]
    (when (.matches matcher)
      {:year (.group matcher "year")})))

(defn capture-month-name [s]
  {:month-name   (first (re-find (re-pattern (str "(?<month>" months ")")) s))})

(defn capture-day-name [s]
  {:day-name (first (re-find (re-pattern (str "(?<day>" days ")")) s))})

(defn capture-numeric-date [s]
  (let [matcher (re-matcher (re-pattern (str "(?<day>" day ")/(?<month>" month ")/(?<year>" year ")")) s)]
    (when (.matches matcher)
      {:day (.group matcher "day")
       :month (.group matcher "month")
       :year (.group matcher "year")})))

(defn capture-month-name-date [s]
  (let [matcher (re-matcher (re-pattern (str "(?<month>" months ") (?<day>" day "), (?<year>" year ")")) s)]
    (when (.matches matcher)
      {:month-name (.group matcher "month")
       :day (.group matcher "day")
       :year (.group matcher "year")})))

(defn capture-day-month-name-date [s]
  (let [matcher (re-matcher (re-pattern (str "(?<dayname>" days "), (?<month>" months ") (?<day>" day "), (?<year>" year ")")) s)]
    (when (.matches matcher)
      {:day-name (.group matcher "dayname")
       :month-name (.group matcher "month")
       :day (.group matcher "day")
       :year (.group matcher "year")})))

(def match-numeric-date 
  (re-pattern (str "(?<day>" day ")/(?<month>" month ")/(?<year>" year ")")))

(def match-month-name-date
  (re-pattern (str "(?<month>" months ") (?<day>" day "), (?<year>" year ")")))

(def match-day-month-name-date
  (re-pattern (str "(?<dayname>" days "), (?<month>" months ") (?<day>" day "), (?<year>" year ")")))
