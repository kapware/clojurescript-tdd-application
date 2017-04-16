(defproject clojurescript-tdd-application "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[lein-doo "0.1.7"]
                 [devcards "0.2.3"]
                 [org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.521"]
                 [reagent "0.6.0"]
                 [re-frame "0.9.2"]]
  :plugins [[lein-cljsbuild "1.1.5" :exclusions [[org.clojure/clojure]]]]
  :min-lein-version "2.5.3"
  :clean-targets ^{:protect false} [:target-path "out" "resources/public/cljs"]
  :figwheel {:css-dirs ["resources/public/css"]}
  :profiles {:dev {:dependencies [[binaryage/devtools "0.8.2"]] 
                   :plugins      [[lein-figwheel "0.5.10"]
                                  [lein-doo "0.1.7"]]}}
  :cljsbuild {
              :builds [{:id "dev"
                        :source-paths ["src"]
                        :figwheel     {:on-jsload "clojurescript_tdd_application.core/mount-root"}
                        :compiler {:main clojurescript_tdd_application.core
                                   :asset-path "cljs/out"
                                   :output-to "resources/public/cljs/main.js"
                                   :output-dir "resources/public/cljs/out"
                                   :source-map-timestamp true
                                   :preloads             [devtools.preload]
                                   :external-config      {:devtools/config {:features-to-install :all}}}}
                       {:id "min"
                        :source-paths ["src"]
                        :compiler     {:main            clojurescript_tdd_application.core
                                       :output-to "resources/public/cljs/main.js"
                                       :optimizations   :advanced
                                       :closure-defines {goog.DEBUG false}
                                       :pretty-print    false}}
                       {:id "test"
                        :source-paths ["src" "test"]
                        :compiler {:main runners.doo
                                   :optimizations :none
                                   :output-to "resources/public/cljs/tests/all-tests.js"
                                   :output-dir "resources/public/cljs/tests/test-out"}}
                       {:id "devcards-test"
                        :source-paths ["src" "test"]
                        :figwheel {:devcards true}
                        :compiler {:main runners.browser
                                   :optimizations :none
                                   :asset-path "cljs/tests/out"
                                   :output-dir "resources/public/cljs/tests/out"
                                   :output-to "resources/public/cljs/tests/all-tests.js"
                                   :source-map-timestamp true}}]
              :test-commands {"test" ["lein" "doo" "phantom" "test" "once"]}})
