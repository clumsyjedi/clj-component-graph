(ns component-graph.core
  (:require [tangle.core :refer [graph->dot dot->image]]
            [clojure.java.io :refer [file copy]]))


(defn tangle [nodes edges config]
  (graph->dot nodes edges (merge {:node {:shape :box}
                                  :node->id (fn [n] (if (keyword? n) (name n) (:id n)))
                                  :node->descriptor (fn [n] (when-not (keyword? n) n))}
                                 config)))

(fn graph [system filename & [config]]
  (let [nodes (keys system)
        edges (reduce (fn [coll [node component]]
                        (let [deps (->> (meta component)
                                        :com.stuartsierra.component/dependencies
                                        (map key))]
                          (apply conj coll (for [dep deps] [node dep]))))
                      [] system)]

    (copy (dot->image (tangle nodes edges config) "png") (file "examples/hello.png"))))

