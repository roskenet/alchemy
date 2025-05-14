(ns the-joy-of-clojure.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(defn print-down-from [x]
  (when (pos? x)
    (println x)
    (recur (dec x))))

