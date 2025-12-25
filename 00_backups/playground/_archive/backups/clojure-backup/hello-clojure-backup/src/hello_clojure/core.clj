(ns hello-clojure.core)

(defn foo
      "I don't do a whole lot."
      [x]
      (println x "Hello, World!"))

; Scalar Literals
(class \c)

(class nil)
;This is domet

(class "My String!")

; Dies ist nun ein Kommentar 
(class true)
; Another one
(class :mykey)

; Does this work now?
[(class 42)]

; Der reader

'(+ 1 2)