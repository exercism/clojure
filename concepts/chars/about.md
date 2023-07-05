# About

Clojure uses the underlying `java.lang.Character` type, which is a 16 bit quantity to represent the smallest addressable components of text.
Multiple `char`s can comprise a string such as `"word"` or `char`s can be
processed independently. Their literals are written like `\a \b \c`.

Clojure's `char`s support UTF-16 Unicode encoding so in addition to the latin character set
pretty much all the writing systems in use world can be represented,
e.g. the Greek letter `'β'`.

There are many library methods to inspect and manipulate `char`s. These
can be accessed by interop as the methods of the `Character` class. Clojure also includes a built-in string utility library, `clojure.string`, which offers many powerful functions for operating on characters.
