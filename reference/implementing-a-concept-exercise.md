# How to implement a Clojure concept exercise

This document describes how to implement a concept exercise for the Clojure track.

**Please please please read the docs before starting.** Posting PRs without reading these docs will be a lot more frustrating for you during the review cycle, and exhaust Exercism's maintainers' time. So, before diving into the implementation, please read the following documents:

- [The features of v3][docs-features-of-v3].
- [Rationale for v3][docs-rationale-for-v3].
- [What are concept exercise and how they are structured?][docs-concept-exercises]

Please also watch the following video:

- [The Anatomy of a Concept Exercise][anatomy-of-a-concept-exercise].

As this document is generic, the following placeholders are used:

- `<SLUG>`: the name of the exercise in kebab-case (e.g. `anonymous-methods`).
- `<NAME>`: the name of the exercise in PascalCase (e.g. `AnonymousMethods`).

Before implementing the exercise, please make sure you have a good understanding of what the exercise should be teaching (and what not). This information can be found in the exercise's GitHub issue. Having done this, please read the [Clojure concept exercises introduction]//TODO.

To implement a concept exercise, the following files must be added:

<pre>
languages
└── clojure
    └── exercises
        └── concept
            └── &lt;SLUG&gt;
                ├── .docs
                |   ├── instructions.md
                |   ├── introduction.md
                |   ├── hints.md
                |   ├── source.md (required if there are third-party sources)
                |   └── after.md
                ├── .meta
                |   |── config.json
                |   |── design.md
                |   └── Example.clj
                ├── &lt;NAME&gt;.clj
                └── &lt;NAME&gt;_test.clj
</pre>

## Step 1: Add code files

The code files are track-specific and should be designed to help the student learn the exercise's concepts. The following Clojure code files must be added (not necessarily in this order):

- `<NAME>.clj`: the Clojure file.
- `<NAME>_test.clj`: the test suite.
- `.meta/Example.clj`: the example implementation file.

## Step 2: Add documentation files

How to create the files common to all tracks is described in the [how to implement a concept exercise document][how-to-implement-a-concept-exercise].

## Step 3: Add analyzer (optional)

//TODO

## Step 4: Add representation (optional)

//TODO

## Inspiration

//TODO

## Help

If you have any questions regarding implementing the exercise, please post them as comments in the exercise's GitHub issue.

//To-Add-More

[how-to-implement-a-concept-exercise]: ../../../docs/maintainers/generic-how-to-implement-a-concept-exercise.md
[docs-concept-exercises]: ../../../docs/concept-exercises.md
[docs-rationale-for-v3]: ../../../docs/rationale-for-v3.md
[docs-features-of-v3]: ../../../docs/features-of-v3.md
[anatomy-of-a-concept-exercise]: https://www.youtube.com/watch?v=gkbBqd7hPrA
