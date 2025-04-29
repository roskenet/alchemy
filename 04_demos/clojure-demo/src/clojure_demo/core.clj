(ns clojure-demo.core
  (:require [compojure.core :refer [defroutes GET]]
            [compojure.route :as route]
            [ring.adapter.jetty :as jetty]
            [ring.middleware.json :refer [wrap-json-response]]
            [ring.util.response :refer [response]])
  (:gen-class))

(defn handle-hello
  "Handle the /hello/{name} endpoint"
  [name]
  (if (= name "Elvis")
    (response {:name "Elvis A. Presley" :birthday "January 8, 1935"})
    (response {:name "UNKNOWN" :birthday ""})))

(defroutes app-routes
  (GET "/hello/:name" [name] (handle-hello name))
  (route/not-found (response {:error "Not Found"})))

(def app
  (-> app-routes
      wrap-json-response))

(defn -main
  "Start the web server"
  [& args]
  (println "Starting server on port 3000...")
  (jetty/run-jetty app {:port 3000 :join? false}))
