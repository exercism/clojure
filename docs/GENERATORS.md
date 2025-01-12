# Generators

The Clojure track uses a [test generator](https://exercism.org/docs/building/tooling/test-generators) to auto-generate (some) of the practice exercise's tests.
It uses the fact that most exercises defined in the [problem-specifications repo](https://github.com/exercism/problem-specifications/) also have a `canonical-data.json` file, which contains standardized test inputs and outputs that can be used to implement the exercise.

## Steps

To generate a practice exercise's tests, the test generator:

1. Reads the exercise's test cases from its [`canonical-data.json` file]
2. Uses `tests.toml` file to omit and excluded test cases
3. Transforms the test cases (optional)
4. Renders the test cases using the exercise's generator template
5. Writes the rendered template to the exercise's test file

### Step 1: read `canonical-data.json` file

The test generator parses the test cases from the exercise's `canonical-data.json` using the [clojure/data.json library](https://github.com/clojure/data.json).

Since some canonical data uses nesting, the parsed test case includes an additional `path` field that contains the `description` properties of any parent elements, as well as the test case's own `description` property.

Note: keys are parsed as keywords.

### Step 2: omit excluded tests from `tests.toml` file

Each exercise has a `tests.toml` file, in which individual tests can be excluded/disabled.
The test generator will remove any test cases that are marked as excluded (`include = false`).

### Step 3: transform the test cases (optional)

Some exercises might need some tweaks before rendering the data.
For example, you might want to make the description less verbose.

To tweak the test cases, define a `.meta/generator.clj` file with a `<slug>-generator` namespace .
You then defined a function called `transform` that takes (and returns) a single value: the parsed test cases.

Example:

```clojure
(ns difference-of-squares-generator)

(defn- update-path [path]
  (take-last 1 path))

(defn transform [test-cases]
  (map #(update % :path update-path) test-cases))
```

This step is entirely optional.

### Step 4: render the test cases

The (potentially transformed) test cases are then passed to the `.meta/generator.tpl` file, which defines how the tests should be rendered based on the test cases.

### Step 5: write the rendered template to the exercise's test file

Finally, the rendered template's output is written to the exercise's test file.

## Templates

The templates are rendered using the [hbs library](https://github.com/sunng87/hbs), which supports handlebars syntax (using [handlebars.java](https://github.com/jknack/handlebars.java/)).

## Command-line interface

There are two ways in which the test generator can be run:

1. `bin/generate-tests`: generate the tests for all exercises with a test generator
2. `bin/generate-tests <slug>`: generate the tests for the specified exercise
