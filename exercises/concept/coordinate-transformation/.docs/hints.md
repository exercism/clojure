# Hints

## General

- For each task, each function should return a function closure, using the supplied arguments. See the section of the Clojure docs on [function closures][closures] for reference.

## 1. Translate the coordinates

- The supplied arguments provide the amount to translate the coordinate pair along the _x_ and _y_ axis.

## 2. Scale the coordinates

- The supplied arguments provide the amount to scale the coordinate pair for the _x_ and _y_ axis.

## 3. Compose transformation functions

- The result of the first transformation is a vector, but the transformation functions take two number arguments. You will have to get the values from the vector.
- Remember that the order in which the functions are performed matters.

## 4. Save the results of functions

- For this function, you are only to memoize the result of the last transformation.
- In order to send back the result of the last transformation, you will have to check if the input arguments are the same.
- To save the value of the arguments and the last result, you can use an [atom][atoms].

[atoms]: https://clojure.org/reference/atoms
[closures]: https://clojure.org/guides/higher_order_functions#_functions_returning_functions_and_closures