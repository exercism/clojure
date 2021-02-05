A floating-point number is a number with zero or more digits behind the decimal separator. Examples are `-2.4`, `0.1`, `3.14`, `16.984025` and `1024.0`.

Different floating-point types can store different numbers of digits after the digit separator - this is referred to as its precision. This means that trying to store PI in a `single` will only store the first 6 to 9 digits (with the last digit being rounded).

Floating point numbers in Clojure are read as Doubles; with M suffix they are read as BigDecimals.

- `Double`: 8 bytes (~15-17 digits precision). This is the most common type. Written as `2.45`.
- `BigDecimal`: Arbitrary precision integer unscaled value and a 32-bit integer scale. Written as `2.45M`.
