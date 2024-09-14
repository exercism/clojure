# Instructions

In this exercise you will implement a partial set of utility routines 
to help a developer clean up identifier names.

In the 5 tasks you will gradually build up the routine `clean`. 
A valid identifier comprises zero or more letters and underscores.

In all cases the input string is guaranteed to be non-nil. 
If an empty string is passed to the `clean` function, 
an empty string should be returned.

Note that the caller should avoid calling the routine `clean` 
with an empty identifier since such identifiers are ineffectual.

## 1. Replace any spaces encountered with underscores

Implement the `clean` function to replace any spaces with underscores. 
This also applies to leading and trailing spaces.

```clojure
(clean "my   Id")
;;=> "my___Id"
```

## 2. Replace control characters with the upper case string "CTRL"

Modify the `clean` function to replace control characters with 
the upper case string `"CTRL"`. 
A character is considered to be an ISO control character if 
its code is in the range '\u0000' through '\u001F' 
or in the range '\u007F' through '\u009F'.

```clojure
(clean "my\u007FId")
;;=> "myCTRLId"
```

## 3. Convert kebab-case to camelCase

Modify the `clean` function to convert kebab-case to camelCase.

```clojure
(clean "à-ḃç")
;;=> "àḂç"
```

## 4. Omit characters that are not letters

Modify the `clean` function to omit any characters that are not letters.
Note: The underscores must be preserved from the previous step.

```clojure
(clean "1😀2😀3😀")
;; => ""
```

## 5. Omit Greek lower case letters

Modify the `clean` function to omit any Greek letters in the range 'α' to 'ω'.

```clojure
(clean "MyΟβιεγτFinder")
;;=> "MyΟFinder"
```
