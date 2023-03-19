(ns luminus-personas.env
  (:require
    [selmer.parser :as parser]
    [clojure.tools.logging :as log]
    [luminus-personas.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[luminus-personas started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[luminus-personas has shut down successfully]=-"))
   :middleware wrap-dev})
