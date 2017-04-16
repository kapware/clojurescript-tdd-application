(ns clojurescript-tdd-application.core-test
  (:require [cljs.test :refer-macros [is testing async]]
            [devcards.core :as dc :refer-macros [deftest defcard]]
            [clojurescript-tdd-application.views :as v]
            [reagent.core :as r]))

(deftest a-test
  (testing "FIXME, I fail."
    (async done
           (js/setTimeout
            (fn []
              (is (= 1 1))
              (done))
            100))))

(defcard reagent-support
  (dc/reagent v/i-am-reagent)
  (r/atom "aaaBB")
  {:inspect-data true :history true})
