(ns hello-clojure.core
  (:gen-class))

(defn foo
  "I don't do a whole lot."
  [name]
  (println "Hello," name))

(defn -main [& args]
  (foo (first args)))