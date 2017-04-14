(ns secret-handshake)

(defn- to-binary-seq [integer]
  (reverse (seq (Integer/toString integer 2))))

(defn- convert [integer]
  (filter some?
          (map (fn [command binary]
                 (if (= \1 binary) command))
               ["wink" "double blink" "close your eyes" "jump"]
               (to-binary-seq integer))))

(defn commands [integer]
  (let [cmds (convert integer)]
    (if (= \1 (nth (to-binary-seq integer) 4 \0))
      (reverse cmds)
      cmds)))
