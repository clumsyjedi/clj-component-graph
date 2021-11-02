(ns component-graph.core
  (:require [tangle.core :refer [graph->dot dot->image]]
            [clojure.java.io :refer [file copy]]))


(defn tangle [nodes edges config]
  (graph->dot nodes edges (merge {:node {:shape :box}
                                  :node->id (fn [n] (if (keyword? n) (name n) (:id n)))
                                  :node->descriptor (fn [n] (when-not (keyword? n) n))}
                                 config)))

(defn graph
  ([system filename] (graph system filename {}))
  ([system filename {tangle-conf :tangle
                     :keys [blacklist filetype]
                     :or {filetype "png"}}]
   (let [blacklisted? (set blacklist)
         nodes (remove blacklisted? (keys system))
         edges (reduce (fn [coll node]
                         (let [component (node system)
                               deps (->> (meta component)
                                         :com.stuartsierra.component/dependencies
                                         (map key)
                                         (remove blacklisted?))]
                           (apply conj coll (for [dep deps] [node dep]))))
                       [] nodes)]
     (copy (dot->image (tangle nodes edges tangle-conf) filetype) (file filename)))))

