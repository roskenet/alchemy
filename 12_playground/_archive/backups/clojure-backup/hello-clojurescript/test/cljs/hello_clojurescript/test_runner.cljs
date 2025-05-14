(ns hello-clojurescript.test-runner
  (:require
   [doo.runner :refer-macros [doo-tests]]
   [hello-clojurescript.core-test]
   [hello-clojurescript.common-test]))

(enable-console-print!)

(doo-tests 'hello-clojurescript.core-test
           'hello-clojurescript.common-test)
