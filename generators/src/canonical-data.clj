(ns canonical-data
  (:require [clojure.data.json :as json]
            [clojure.java.io :as io]
            [toml-clj.core :as toml]
            [clj-jgit.porcelain :refer [git-clone git-pull load-repo]]
            [log]
            [paths]))

(def git-url "https://github.com/exercism/problem-specifications.git")

(defn- pull-repo []
  (-> paths/prob-specs-dir
      (load-repo)
      (git-pull)))

(defn- clone-repo [] (git-clone git-url :branch "main" :dir paths/prob-specs-dir))

(defn- sync-repo []
  (try
    (pull-repo)
    (catch java.io.FileNotFoundException  _ (clone-repo))))

(defn- canonical-data [slug]
  (let [file (paths/canonical-data-file slug)]
    (if (.exists file)
      (json/read (io/reader file) :key-fn keyword)
      (log/error (str "No canonical-data.json found for exercise '" slug "'")))))

(defn- excluded-uuids [slug]
  (let [file (paths/tests-toml-file slug)]
    (if (.exists file)
      (->> file
           (io/reader)
           (toml/read)
           (filter #(= false (get (last %) "include")))
           (map first)
           (set))
      (log/error (str "No tests.toml data found for exercise '" slug "'")))))

(defn- excluded? [slug]
  (let [excluded (excluded-uuids slug)]
    (fn [node] (contains? excluded (:uuid node)))))

(defn- node->test-case [node path]
  (-> node
      (assoc :path path :error (get-in node [:expected :error]))
      (dissoc :reimplements :comments :scenarios)))

(defn- test-case-nodes
  ([node] (test-case-nodes node []))
  ([node path]
   (let [description (:description node)
         children (:cases node)
         updated-path (if description (conj path description) path)]
     (if children
       (mapcat #(test-case-nodes % updated-path) children)
       [(node->test-case node updated-path)]))))

(defn test-cases [slug]
  (->> slug
       (canonical-data)
       (test-case-nodes)
       (remove (excluded? slug))
       (into [])))

(sync-repo)
