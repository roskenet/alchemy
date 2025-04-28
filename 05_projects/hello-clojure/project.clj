(defproject hello-clojure "0.1.0-SNAPSHOT"
  :description "A simple REST webservice with a hello endpoint"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [ring/ring-core "1.9.5"]
                 [ring/ring-jetty-adapter "1.9.5"]
                 [compojure "1.7.0"]
                 [ring/ring-json "0.5.1"]
                 [ring/ring-mock "0.4.0"]
                 [org.clojure/data.json "2.4.0"]]
  :main hello-clojure.core
  :repl-options {:init-ns hello-clojure.core})
