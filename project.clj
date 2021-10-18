(defproject org.clojars.clumsyjedi/clj-component-graph "0.1.1"
  :description "renders directed graphs from a stuartsierra style component system"
  :url "https://github.com/clumsyjedi/clj-component-graph"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [macroz/tangle "0.2.2"]]
  :repl-options {:init-ns component-graph.core}
  :deploy-repositories [["releases" :clojars]
                        ["snapshots" :clojars]])
