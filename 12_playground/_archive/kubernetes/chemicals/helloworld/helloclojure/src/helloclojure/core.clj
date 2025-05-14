(ns helloclojure.core)

(defn doSomething
  "I don't do a whole lot."
  [x]
  (println "Hello," x "!"))

(defn -main [& args]
  (doSomething "Folks"))
