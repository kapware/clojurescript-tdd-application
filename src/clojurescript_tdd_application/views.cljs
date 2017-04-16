(ns clojurescript-tdd-application.views
    (:require [re-frame.core :as re-frame]))

(defn i-am-reagent [foo]
  [:div "I am reagent." (str @foo)])

(defn main-panel []
  (let [name (re-frame/subscribe [:name])]
    (fn []
      [:div "Hello from " @name
       [i-am-reagent name]])))
