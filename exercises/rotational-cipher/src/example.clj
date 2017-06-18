(ns rotational-cipher)

(def ^:private string (partial apply str))

(def ^:private lower-case "abcdefghijklmnopqrstuvwxyz")

(def ^:private upper-case (->> lower-case (map clojure.string/upper-case) string))

(def ^:private letters (into #{} (concat lower-case upper-case)))

(defn- rotater [shift]
  (let [encoding (->> (cycle letters)
                      (drop (* shift 2))
                      (take 52)
                      (zipmap letters))]
    (fn [char] (get encoding char char))))

(defn rotate [message shift]
  (->> message
       (map (rotater shift))
       string))
