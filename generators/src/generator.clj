(ns generator
  (:require [canonical-data]
            [templates]
            [log]))

(defn- slugs-to-generate [args]
  (let [slugs templates/exercises-with-template]
    (if-let [slug (first args)]
      (if (contains? slugs slug)
        [slug]
        (log/error (str "No template found for exercise '" slug "'")))
      slugs)))

(defn- run [args]
  (canonical-data/sync-repo)
  (doseq [slug (slugs-to-generate args)]
    (log/normal (str "Generating tests for exercise '" slug "'"))
    (templates/generate-tests-file slug (canonical-data/test-cases slug))))  
