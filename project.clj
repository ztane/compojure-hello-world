(defproject hello-world "0.1.0-SNAPSHOT"
  :description "My compojure hello world project"
  :url "http://github.com/ztane/compojure-hello-world"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.3.1"]
                 [ring/ring-defaults "0.1.2"]
                 [enlive "1.1.1"]]
  :plugins [[lein-ring "0.8.13"]]
  :ring {:handler hello-world.core.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}})
