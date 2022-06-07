You have been tasked to write a service which ingests events. Each event has a date associated with it, but you notice that 3 different formats are being submitted to your service's endpoint:

- `"01/01/1970"`
- `"January 1, 1970"`
- `"Thursday, January 1, 1970"`

You can see there are some similarities between each of them, and decide to write some composable regular expression patterns.

## 1. Match the day, month, and year from a date

Implement `day`, `month`, and `year` to return a string pattern which, when executed, would match the numeric components in `"01/01/1970"` (`dd/mm/yyyy`). The date and month may appear as `1` or `01` (left padded with zeroes).

Do not worry about error checking. You can assume you will always be passed a valid numeric component.

```clojure
(day "31")
;;=> "31"
(month "12")
;;=> "12"
(year "1970")
;;=> "1970"
```

## 2. Match the day of the week and the month of the year

Implement `day-name` and `month-name` to return a string pattern which, when executed, would match any named day of the week and the named month of the year respectively.

```clojure
(day-name "Tuesday")
;;=> "Tuesday"
(month-name "June")
;;=> "June"
```

## 3. Capture the day, month, and year

Implement `capture-day`, `capture-month`, `capture-year`, `capture-day-name`, and `capture-month-name` to return a map of the respective components to the names: `"day"`, `"month"`, `"year"`, `"day-name"`, and `"month-name"`.

```clojure
(capture-month-name "December")
;;=> {:month-name "December"}
```

## 4. Combine the captures to capture the whole date

Implement `capture-numeric-date`, `capture-month-name-date`, and `capture-day-month-name-date` to return a map of the components from part 3 using the respective date format.

```clojure
(capture-numeric-date "01/01/1970")
;;=> {:day "01", :month "01", :year "1970"}
```

## 5. Narrow the capture to match only on the date

Implement `match-numeric-date`, `match-month-name-date`, and `match-day-month-name-date` to return a `java.util.regex.Pattern` that only matches the date, and which can also capture the components.

```clojure
(re-matches date-parser/match-day-month-name-date "Thursday, January 1, 1970 was the day")
;; => nil
(re-matches date-parser/match-day-month-name-date "Thursday, January 1, 1970")
;; => ["Thursday, January 1, 1970" "Thursday" "January" "1" "1970"]
```