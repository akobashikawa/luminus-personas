(ns luminus-personas.routes.home
  (:require
   [luminus-personas.layout :as layout]
   [clojure.java.io :as io]
   [luminus-personas.middleware :as middleware]
   [ring.util.response]
   [ring.util.http-response :as response]
   [ring.middleware.params :as params]))

(defmacro dbg [x] `(let [x# ~x] (println "dbg:" '~x "=" x#) x#))


(defn home-page [request]
  (layout/render request "home.html" {:docs (-> "docs/docs.md" io/resource slurp)}))

(defn about-page [request]
  (layout/render request "about.html"))

(defn holamundo-page [request]
  (layout/render request "holamundo.html"))

(defn hola-page [request]
  (layout/render request "hola.html" {:nombre "Mundo"}))

(defn hola-action [request]
  (let [nombre (-> request :params :nombre)]
    (layout/render request "hola.html" {:nombre nombre})))

(defn home-routes []
  [ "" 
   {:middleware [
                ;;  middleware/wrap-csrf
                 middleware/wrap-formats
                 ]}
   ["/" {:get home-page}]
   ["/about" {:get about-page}]
   ["/holamundo" {:get holamundo-page}]
   ["/hola" {:get hola-page :post hola-action}]])

