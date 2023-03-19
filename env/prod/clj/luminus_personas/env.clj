(ns luminus-personas.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[luminus-personas started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[luminus-personas has shut down successfully]=-"))
   :middleware identity})
