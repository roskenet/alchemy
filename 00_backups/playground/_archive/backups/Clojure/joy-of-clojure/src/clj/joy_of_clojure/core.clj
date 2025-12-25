(ns joy-of-clojure.core
  (:gen-class))

(defn foo
  "I don't do a whole lot."
  [x]
  (println "Hello," x)
  true)

(def population {:zombies 2700, :humans 9})
(get population :zombies)
;=> 2700
(println (/ (:zombies population)
            (get population :humans))
         "zombies per capita")
; 300 zombies per capita

(defn -main [& args]
  (prn (format "args=%s" args)))
