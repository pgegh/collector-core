(ns collector-core.all
  (:require [clojure.test :refer :all]
            [collector-core.core]
            [collector-core.constructors]))

(deftest a-test
  "Bootstrapping with the required namespaces, finds all the firestone.* namespaces (except this one),
         requires them, and runs all their tests."
  (let [namespaces (->> (all-ns)
                        (map str)
                        (filter (fn [x] (re-matches #"collector-core\..*" x)))
                        (remove (fn [x] (= "collector-core.all" x)))
                        (map symbol))]
    (is (successful? (time (apply run-tests namespaces))))))
