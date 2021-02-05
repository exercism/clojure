You're an avid bird watcher that keeps track of how many birds have visited your garden in the last seven days.

You have six tasks, all dealing with the numbers of birds that visited your garden.

## 1. Check what the counts were last week

For comparison purposes, you always keep a copy of last week's counts nearby, which were: 0, 2, 5, 3, 7, 8 and 4. Create a vector containing last week's counts:

```clojure
last-week
;;=> [0 2 5 3 7 8 4]
```

## 2. Check how many birds visited today

Implement the `today` function to return how many birds visited your garden today. The bird counts are ordered by day, with the first element being the count of the oldest day, and the last element being today's count.

```clojure
(def birds-per-day [2 5 0 7 4 1])
(today birds-per-day)
;;=> 1
```

## 3. Increment today's count

Implement the `inc-bird` function to increment today's count:

```clojure
(inc-bird birds-per-day)
;;=> [2 5 0 7 4 2]
```

## 4. Check if there was a day with no visiting birds

Implement the `day-without-birds?` predicate function that returns `true` if there was a day at which zero birds visited the garden; otherwise, return `false`:

```clojure
(day-without-birds? birds-per-day)
;;=> true
```

## 5. Calculate the number of visiting birds for the first number of days

Implement the `n-days-count` function that returns the number of birds that have visited your garden from the start of the week, but limit the count to the specified number of days from the start of the week.

```clojure
(n-days-count birds-per-day 4)
;;=> 14
```

## 6. Calculate the number of busy days

Some days are busier than others. A busy day is one where five or more birds have visited your garden.
Implement the `busy-days` function to return the number of busy days:

```clojure
(busy-days birds-per-day)
;;=> 2
```

## 7. Check for odd week

Over the last year, you've found that some weeks for the same, odd pattern, where the counts alternate between one and zero birds visiting. Implement the `odd-week?` function that returns `true` if the bird count pattern of this week matches the odd pattern:

```clojure
(odd-week? [1 0 1 0 1 0 1])
;;=> true
```
