# Instructions append

## Appendix

~~~~exercism/note
The instructions above are synchronized with a shared repository to ensure consistency across all language tracks.
This appendix provides additional clarification or modifies the instructions as needed to better align with the goals of the Clojure track.
~~~~

For this exercise in the Clojure track, **assume both the input and output are vectors**, as indicated by the tests.
As a stretch goal, consider how to implement an approach that does not use lists for intermediate steps.

It is important not to reuse existing Clojure built-in functions with similar functionality, as doing so would diminish the intended learning value of the exercise.
Key functions from the `clojure.core` namespace to avoid include `into`, `concat`, `cat`, `lazy-cat`, `mapcat`, `flatten`, `filter`, `filterv`, `remove`, `count`, `map`, `mapv`, `reduce`, `transduce`, `reverse`, and `rseq`.

### Optional goals

The optional goal is for those who want an extra challenge and is designed with the expectation that you've already completed the main goal.

Try to pass the tests by devising an approach that assumes:

* Both the input and output are lists instead of vectors.
  Note that, as usual, the tests do not need to be modified.
* Vectors cannot be used for intermediate steps.

If you decide to publish this, be sure to include a comment indicating that it addresses the optional goal of using lists.
Don't forget to update the docstrings!
