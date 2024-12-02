# Instructions append

## Appendix

~~~~exercism/note
The instructions above are synchronized with a shared repository to ensure consistency across all language tracks.
This appendix provides additional clarification or modifies the instructions as needed to better align with the goals of the Clojure track.
~~~~

For this exercise in the Clojure track, **assume both the input and output are vectors**.
As a stretch goal, consider how you could implement the solution without using lists anywhere in your code.
Also, think about the efficiency of your program.

It is important not to reuse existing Clojure built-in functions with similar functionality, as doing so would diminish the intended learning value of the exercise.
Key functions from the `clojure.core` namespace to avoid include `into`, `concat`, `cat`, `lazy-cat`, `mapcat`, `flatten`, `filter`, `filterv`, `remove`, `count`, `map`, `mapv`, `reduce`, `transduce`, `reverse`, and `rseq`.

### Optional goals

Try to pass the tests by devising a solution that assumes:

- both the input and output are lists instead of vectors
- the test suite isn't modified

These assumptions directly influence the types of the functions that can be used.

As a stretch goal, consider how you could implement the solution without using vectors anywhere in your code.

If you decide to publish this solution, be sure to include a comment indicating that it addresses the optional goal of using lists.
Don't forget to update the docstrings!
