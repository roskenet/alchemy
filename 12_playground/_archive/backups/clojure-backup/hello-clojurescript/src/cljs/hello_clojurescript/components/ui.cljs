(ns hello-clojurescript.components.ui
  (:require [com.stuartsierra.component :as component]
            [hello-clojurescript.core :refer [render]]))

(defrecord UIComponent []
  component/Lifecycle
  (start [component]
    (render)
    component)
  (stop [component]
    component))

(defn new-ui-component []
  (map->UIComponent {}))
