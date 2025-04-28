(ns hello-clojure.core
  (:require [compojure.core :refer [defroutes GET]]
            [compojure.route :as route]
            [ring.middleware.json :refer [wrap-json-response]]
            [ring.util.response :refer [response]]
            [ring.adapter.jetty :refer [run-jetty]])
  (:gen-class))

(defn hello-handler [name]
  (if (= name "Elvis")
    (response {:name "Elvis A. Presley" :birthday "January 8, 1935"})
    (response {:name "Unknown" :birthday ""})))

(defroutes app-routes
  (GET "/hello/:name" [name] (hello-handler name))
  (route/not-found (response {:error "Not Found"})))

(def app
  (-> app-routes
      wrap-json-response))

(defn -main [& args]
  (println "Starting server on port 3000...")
  (run-jetty app {:port 3000 :join? false})
  (println "Server started on port 3000"))
