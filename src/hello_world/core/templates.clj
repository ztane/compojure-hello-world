(ns hello-world.core.templates
  (:require [net.cgrand.enlive-html :refer [deftemplate content]])
  (:require [hello-world.core.template-utils :refer [maybe-content]]))

(deftemplate tpl-helloworld "templates/helloworld.html"
  [{:keys [value]}]
  [:#message] (maybe-content value))
