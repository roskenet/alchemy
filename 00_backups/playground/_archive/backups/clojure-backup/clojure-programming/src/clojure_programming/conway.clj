(ns clojure-programming.conway)

(defn empty-board
  "Creates a rectangular empty board of the specified width and height"
  [w h]
  (vec (repeat w (vec (repeat h nil)))))

(defn populate
  "Turns :on"
  [board living-cells]
  (reduce (fn [board coordinates]
            (assoc-in board coordinates :on))
          board
          living-cells))