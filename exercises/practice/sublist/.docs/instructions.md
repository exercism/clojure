# Instructions

Given two lists determine whether :
- the first list is contained within the second 
- the second list is contained within the first list
- both lists are equal
- none of the above, lists are unequal

Specifically, a list A is a sublist of list B if by dropping 0 or more elements
from the front of B and 0 or more elements from the back of B you get a list
that's completely equal to A.

### Rules

Determine the relation between list1 and list2 and return the relation as a Clojure keyword.
The function `classify` should either return `:sublist`, `:superlist`, `:equal` or`:unequal`.


### Examples:

 * A = [1, 2, 3], B = [1, 2, 3, 4, 5], A is a sublist of B
 * A = [3, 4, 5], B = [1, 2, 3, 4, 5], A is a sublist of B
 * A = [3, 4], B = [1, 2, 3, 4, 5], A is a sublist of B
 * A = [1, 2, 3], B = [1, 2, 3], A is equal to B
 * A = [1, 2, 3, 4, 5], B = [2, 3, 4], A is a superlist of B
 * A = [1, 2, 4], B = [1, 2, 3, 4, 5], A is neither a superlist, sublist nor equal to B : they are unequal
