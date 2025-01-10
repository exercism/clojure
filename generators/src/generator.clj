(require
 '[clojure.data.json :as json]
 '[clojure.java.shell :refer [sh]]
 '[clojure.java.io :as io]
 '[selmer.parser :refer [render render-file]]
 '[toml-clj.core :as toml])

(defn error [message]
  (println message)
  (System/exit 1))

(def prob-specs-dir ".problem-specifications")

(defn sync-prob-specs []
  (if (.isDirectory (io/file prob-specs-dir))
    (sh "git" "pull" :dir prob-specs-dir)
    (sh "git" "clone" "https://github.com/exercism/problem-specifications.git" prob-specs-dir)))

(defn canonical-data [slug]
  (let [file (io/file prob-specs-dir "exercises" slug "canonical-data.json")]
    (if (.exists file)
      (json/read (io/reader file) :key-fn keyword)
      (error (str "No canonical data found for slug '" slug "'")))))

(defn filter-reimplemented [case-nodes]
  (let [reimplemented (set (remove nil? (map #(:reimplements %) case-nodes)))]
    (remove #(contains? reimplemented (:uuid %)) case-nodes)))

(defn node->case [node]
  (-> node
      (assoc :error (get-in node [:expected :error]))
      (dissoc :reimplements :comments :scenarios)))

(defn case-nodes
  ([node] (case-nodes node []))
  ([node path]
   (let [description (:description node)
         children (:cases node)
         updated-path (if description (conj path description) path)]
     (if children
       (mapcat #(case-nodes % updated-path) children)
       [(assoc node :path updated-path)]))))

(defn cases [node]
  (->> node
       (case-nodes)
       (filter-reimplemented)
       (map node->case)
       (into [])))

(sync-prob-specs)
(cases (canonical-data "isogram"))

(def data {:slug "isogram"
           :cases (cases (canonical-data "isogram"))})

(def template "/Users/erik/Code/exercism/tracks/clojure/exercises/practice/collatz-conjecture/.meta/tests.template")
(def tests "/Users/erik/Code/exercism/tracks/clojure/exercises/practice/collatz-conjecture/.meta/tests.clj")

(spit tests (render (slurp template) data))
 