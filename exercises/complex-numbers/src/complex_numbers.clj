(ns complex-numbers)

(defn real
  "Returns the real part of a complex number."
  [[real _]]
)

(defn imaginary
  "Returns the imaginary part of a complex number."
  [[_ imag]]
  )

(defn abs
  "Returns the absolute value of a complex number."
  [[real imag]]
)

(defn conjugate
  "Returns the conjugate of a complex number."
  [[real imag]]
)

(defn add
  "Returns the sum of 2 complex numbers."
  [[real imag] [real imag]]
)

(defn sub
  "Returns the difference of 2 complex numbers."
  [[real imag] [real imag]]
  )

(defn mul
  "Returns the result of multiplying 2 complex numbers."
  [[real imag] [real imag]]
  )

(defn div
  "Returns the result of dividing 2 complex numbers."
  [[real imag] [real imag]]
  )
