In this exercise you're going to write some code to help you cook a brilliant lasagna from your favorite cooking book.

You have four tasks, all related to the time spent cooking the lasagna.

## 1. Define the expected oven time in minutes

Define the `expected-time` var to check how many minutes the lasagna should be in the oven. According to the cooking book, the expected oven time in minutes is 40:

```clojure
expected-time
;;=> 40
```

## 2. Calculate the remaining oven time in minutes

Define the `remaining-time` function that takes the actual minutes the lasagna has been in the oven as an argument and returns how many minutes the lasagna still has to remain in the oven, based on the expected time oven time in minutes from the previous task.

```clojure
(remaining-time 30)
;;=> 10
```

## 3. Calculate the preparation time in minutes

Define the `prep-time` function that takes the number of layers you added to the lasagna as an argument and returns how many minutes you spent preparing the lasagna, assuming each layer takes you 2 minutes to prepare.

```clojure
(prep-time 2)
;;=> 4
```

## 4. Calculate the total working time in minutes

Define the `total-time` function that takes two arguments: the first argument is the number of layers you added to the lasagna, and the second argument is the number of minutes the lasagna has been in the oven. The function should return how many minutes in total you've worked on cooking the lasagna, which is the sum of the preparation time in minutes, and the time in minutes the lasagna has spent in the oven at the moment.

```clojure
(total-time 3 20)
;;=> 26
```
