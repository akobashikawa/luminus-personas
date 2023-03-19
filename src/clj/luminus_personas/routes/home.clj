(ns luminus-personas.routes.home
  (:require
   [luminus-personas.layout :as layout]
   [clojure.java.io :as io]
   [luminus-personas.middleware :as middleware]
   [ring.util.response]
   [ring.util.http-response :as response]))



(defn home-page [request]
  (layout/render request "home.html" {:docs (-> "docs/docs.md" io/resource slurp)}))

(defn about-page [request]
  (layout/render request "about.html"))

(defn holamundo-page [request]
  (layout/render request "holamundo.html"))

(defn home-routes []
  [ "" 
   {:middleware [middleware/wrap-csrf
                 middleware/wrap-formats
                 ]}
   ["/" {:get home-page}]
   ["/about" {:get about-page}]
   ["/holamundo" {:get holamundo-page}]])

