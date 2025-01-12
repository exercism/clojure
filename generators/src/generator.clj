(ns generator
  (:require [clojure.string :as str]
            [canonical-data]
            [templates]
            [log]))

(defn- slugs-to-generate [slug]
  (let [slugs templates/exercises-with-template]
    (if (str/blank? slug)
      slugs
      (if (contains? slugs slug)
        [slug]
        (log/error (str "No template found for exercise '" slug "'"))))))

(defn- run [{:keys [exercise]}]
  (canonical-data/sync-repo)
  (doseq [slug (slugs-to-generate (str exercise))]
    (log/normal (str "Generating tests for exercise '" slug "'"))
    (templates/generate-test-files slug (canonical-data/test-cases slug))))  
