In this exercise you'll be writing code to process a list of programming languages you are planning to practice from Exercism platform.

You have six tasks.

## 1. Create a new list

Before you can add languages, you'll need to start by creating an new list. Define a function that returns an empty list.

```clojure
(new-list)
;; => ()
```

## 2. Add a new language to the list

As you explore Exercism and find languages you want to learn, you'll need to be able to add them to your list. Define a function to add a new language the the beginning of your list.

```clojure
(add-language "JavaScript" '("Clojurescript"))
;; => '("JavaScript" "Clojurescript")
```

## 3. Check the language last added

You'll want to quickly check which language you just added. Define a function that returns the first language from your list.

```clojure
(first-language '("Haskell" "Python"))
;; => "Haskell"
```

## 4. Remove the first language from the list

Sometimes you'll change your mind about a language you just added. Define a function to remove the first language from your list.

```clojure
(remove-language '("Common Lisp" "Racket" "Scheme"))
;; => '("Racket" "Scheme")
```

## 5. Count the languages in the list

Counting the languages one-by-one is inconvenient. Define function to count the number of languages on your list.

```clojure
(count-languages '("C#" "Racket" "Rust" "Ruby"))
;; => 4
```

## 6. Put it all together

Define a `learning-list` function, within which you will use the some of the functions you've defined above.

- Create an empty list
- Add 2 new programming languages to the list.

  - "Clojure"
  - "Lisp"

- Remove "Lisp" from the list, as you might not have enough time for the year, and it's quite similar to Clojure.
- Add 2 more programming languages to the list.

  - "Java"
  - "JavaScript"

- Return the total number of languages. Hint: it should be 3.

```clojure
(learning-list)
;; => 3
```
