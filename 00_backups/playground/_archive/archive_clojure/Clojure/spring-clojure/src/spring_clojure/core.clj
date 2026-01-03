(ns spring-clojure.core
  (:require [cheshire.core :as json])
  (:import (org.springframework.web.bind.annotation RestController GetMapping PathVariable)))

(gen-class
  :name ^{RestController {}} com.clojurespring.SampleController
  :methods [[^{GetMapping {:value    ["/hello"]
                           :produces ["application/json;charset=UTF-8"}}
             hello [^{PathVariable {:value "name"}} String] java.util.concurrent.Future]])

(defn -hello
  [this name]
  (async
    (println "Inside async controller...")
    (json/generate-string {:a       1
                           :message (str "Hello " name " from Clojure controller"))))
