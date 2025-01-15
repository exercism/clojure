(ns simple-cipher)

(defn rand-key []
  (apply str (map char (repeatedly 100 #(+ 97 (rand-int 26))))))

(defn letter->idx [letter]
  (- (int letter) 97))

(defn shift-letter [op key letter]
  (char (+ 97 (mod (op (letter->idx letter) (letter->idx key)) 26))))

(defn shift [op key text]
  (apply str (map (partial shift-letter op) (cycle key) text)))

(defn encode [key plaintext]
  (shift + key plaintext))

(defn decode [key ciphertext]
  (shift - key ciphertext))
