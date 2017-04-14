(ns clojurescript-tdd-application.core-test
  (:require [cljs.test :refer-macros [deftest is testing run-tests]]
            [clojurescript-tdd-application.core :as sut]))

(deftest test-numbers
  (is (= 1 0)))

