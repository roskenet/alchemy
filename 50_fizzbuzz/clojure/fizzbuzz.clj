(defn fizzbuzz [n]
  (doseq [i (range 1 (inc n))]
    (cond
      (and (zero? (mod i 3)) (zero? (mod i 5))) (println "FizzBuzz")
      (zero? (mod i 3)) (println "Fizz")
      (zero? (mod i 5)) (println "Buzz")
      :else (println i))))

;; Example usage
;; (fizzbuzz 15)

;; More functional using map println

(defn fizzbuzz [n]
  (map println
       (for [i (range 1 (inc n))]
         (cond
           (and (zero? (mod i 3)) (zero? (mod i 5))) "FizzBuzz"
           (zero? (mod i 3)) "Fizz"
           (zero? (mod i 5)) "Buzz"
           :else i))))

