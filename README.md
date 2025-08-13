# Exercism Clojure Track

[![Configlet CI](https://github.com/exercism/clojure/actions/workflows/configlet.yml/badge.svg)](https://github.com/exercism/clojure/actions/workflows/configlet.yml)
[![test](https://github.com/exercism/clojure/workflows/test/badge.svg)](https://github.com/exercism/clojure/actions?query=workflow%3Atest)

**Exercism exercises in [Clojure](https://clojure.org/)**

This is the Clojure track, one of the many tracks on [Exercism][web-exercism].
It holds all the _exercises_ that are currently implemented and available for students to complete.
The track consists of various **concept** exercises which teach the [Clojure syllabus][web-syllabus], and various practice exercises, which are unlocked by progressing in the syllabus and can be used to practice concepts learned.
You can find this in the [`config.json`][file-config].

## Running the test suite

The Clojure track is using [babashka][babashka] as its test runner.

Each exercise contains an example solution named `example.clj`.
This file is run against the tests when verifying the exercise.

After installing babashka, you can verify all exercises with:

```bash
$ bin/verify-exercises

{:tested 114, :fails ()}
```

Verify a single exercise with:

```bash
bin/verify-exercises {slug}
```

For example:

```bash
$ bin/verify-exercises bob

{:tested 1, :fails ()}
```

## Clojure Track Tooling

Next to the exercises, the Clojure track also consists of the following tooling:

- [exercism/clojure-test-runner] - The Exercism [test runner][docs-test-runners] for the Clojure track that automatically verifies if a submitted solution passes all of the exercise's tests.
- [exercism/clojure-representer] - The Exercism [representer][docs-representers] for the Clojure track that creates normalized representations of submitted solutions.
- [exercism/clojure-analyzer] - The Exercism [analyzer][docs-analyzers] for the Clojure track that automatically provides comments on submitted solutions.

## Contributing Guide

If you have any suggestions or comments, it is recommended to start a topic on the [Exercism forum][forum-clojure] first.

For general information about how to contribute to Exercism, please refer to the [contributing guide][contributing].

[babashka]: https://babashka.org
[web-exercism]: https://exercism.org
[web-syllabus]: https://exercism.org/tracks/clojure/concepts
[file-config]: https://github.com/exercism/clojure/blob/main/config.json
[forum-clojure]: https://forum.exercism.org/c/programming/clojure/73
[docs-analyzers]: https://exercism.org/docs/building/tooling/analyzers
[docs-representers]: https://exercism.org/docs/building/tooling/representers
[docs-test-runners]: https://exercism.org/docs/building/tooling/test-runners
[exercism/clojure-analyzer]: https://github.com/exercism/clojure-analyzer
[exercism/clojure-representer]: https://github.com/exercism/clojure-representer
[exercism/clojure-test-runner]: https://github.com/exercism/clojure-test-runner
[contributing]: https://exercism.org/docs/building
