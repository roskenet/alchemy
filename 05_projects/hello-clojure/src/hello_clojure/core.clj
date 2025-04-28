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
  (let [port (if (and (seq args) (re-matches #"\d+" (first args)))
               (Integer/parseInt (first args))
               3000)]
    (println (str "Starting server on port " port "..."))
    (run-jetty app {:port port :join? false})
    (println (str "Server started on port " port))))
