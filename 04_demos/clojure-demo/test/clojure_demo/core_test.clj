(ns clojure-demo.core-test
  (:require [clojure.test :refer :all]
            [clojure-demo.core :refer :all]))

(deftest handle-hello-test
  (testing "When name is Elvis"
    (let [response (handle-hello "Elvis")]
      (is (= 200 (:status response)))
      (is (= {:name "Elvis A. Presley" :birthday "January 8, 1935"} (:body response)))))

  (testing "When name is not Elvis"
    (let [response (handle-hello "John")]
      (is (= 200 (:status response)))
      (is (= {:name "UNKNOWN" :birthday ""} (:body response))))))
