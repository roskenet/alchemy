(ns cljs.user
  (:require [hello-clojurescript.core]
            [hello-clojurescript.system :as system]))

(def go system/go)
(def reset system/reset)
(def stop system/stop)
(def start system/start)
