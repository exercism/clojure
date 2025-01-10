(ns log)

(defn error [message]
  (println message)
  (System/exit 1))
