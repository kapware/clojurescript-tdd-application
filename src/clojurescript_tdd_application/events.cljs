(ns clojurescript-tdd-application.events
    (:require [re-frame.core :as re-frame]
              [clojurescript-tdd-application.db :as db]))

(re-frame/reg-event-db
 :initialize-db
 (fn  [_ _]
   db/default-db))
