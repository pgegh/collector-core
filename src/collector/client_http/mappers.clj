(ns collector.client-http.mappers
  (:require [clojure.data.json :refer [write-str]]))

(defn db->client-db
  [database]
  (write-str database))