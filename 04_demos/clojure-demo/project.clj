(defproject clojure-demo "0.1.0-SNAPSHOT"
  :description "A simple REST API demo"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [ring/ring-core "1.9.5"]
                 [ring/ring-jetty-adapter "1.9.5"]
                 [ring/ring-json "0.5.1"]
                 [compojure "1.7.0"]]
  :main clojure-demo.core
  :repl-options {:init-ns clojure-demo.core})
