(ns hello-world.core.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [hello-world.core.templates :as templates]
            [ring.middleware.reload :refer [wrap-reload]]
            [ring.middleware.stacktrace :refer [wrap-stacktrace]]
            [hello-world.core.middleware :as mw]))

(defroutes app-routes
  (GET "/" [value] (templates/tpl-helloworld {:value value}))
  (route/resources "/")
  (route/not-found "Not Found"))

(def production?
  (= "production" (get (System/getenv) "APP_ENV")))

(def development?
  (not production?))

(def app
  (->
    (wrap-defaults app-routes site-defaults)
    (mw/wrap-request-logging)
    (mw/wrap-if development? wrap-reload '[hello-world.core])
    (mw/wrap-if production?  mw/wrap-failsafe)
    (mw/wrap-if development? wrap-stacktrace)))

