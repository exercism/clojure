(ns log)

(defn normal [message]
  (println message))

(defn error [message]
  (println message)
  (System/exit 1))
