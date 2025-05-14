(ns playground.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (println "Hello this is", x))

;Alt+Shift+L loads this file into the REPL
;Alt+Shift+P sends this to the REPL
(foo "Somebody else")

(foo "Felix")

(defn average
  "I am a documentatio string here!"
  [numbers]
  (/ (apply + numbers) (count numbers)))


