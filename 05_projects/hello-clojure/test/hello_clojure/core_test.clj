(ns hello-clojure.core-test
  (:require [clojure.test :refer :all]
            [hello-clojure.core :refer :all]
            [ring.mock.request :as mock]
            [clojure.data.json :as json]))

(deftest hello-handler-test
  (testing "hello-handler returns correct response for Elvis"
    (let [response (hello-handler "Elvis")
          body (:body response)]
      (is (= 200 (:status response)))
      (is (= "Elvis A. Presley" (:name body)))
      (is (= "January 8, 1935" (:birthday body)))))

  (testing "hello-handler returns Unknown for non-Elvis names"
    (let [response (hello-handler "John")
          body (:body response)]
      (is (= 200 (:status response)))
      (is (= "Unknown" (:name body)))
      (is (= "" (:birthday body))))))
