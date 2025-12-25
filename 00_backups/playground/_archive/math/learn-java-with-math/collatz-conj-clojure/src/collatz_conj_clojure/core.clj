(ns collatz-conj-clojure.core)

(defn collatz
  [x calls]
  (if (= (% x 2) 0)
    collatz((/ x 2) (+ calls 1))
    collatz((+ (* x 3) 1) (+ calls 1))
  ))
