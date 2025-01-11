(ns secret-handshake)

(defn- int->reversed-binary [int]
  (-> int
      (Integer/toBinaryString)
      (reverse)))

(defn- convert [integer]
  (remove nil?
          (map (fn [command binary]
                 (when (= \1 binary) command))
               ["wink" "double blink" "close your eyes" "jump"]
               (int->reversed-binary integer))))

(defn commands [integer]
  (let [cmds (convert integer)]
    (if (= \1 (nth (int->reversed-binary integer) 4 \0))
      (reverse cmds)
      cmds)))
