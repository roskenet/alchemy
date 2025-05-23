(ns fizzbuzz.core-test
  (:require [clojure.test :refer :all]
            [fizzbuzz.core :refer :all]))

(deftest fizzbuzz-test
  (testing "FizzBuzz function doesn't throw exceptions"
    (is (nil? (fizzbuzz 15)))))

(deftest main-test
  (testing "-main function doesn't throw exceptions"
    (is (nil? (-main "15")))))