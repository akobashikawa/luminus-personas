(ns luminus-personas.routes.home
  (:require [clojure.data.json :as json]
            [clojure.java.io :as io]
            [luminus-personas.layout :as layout]
            [luminus-personas.middleware :as middleware]
            [luminus-personas.personas-service :refer :all]
            [ring.util.response]))

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

(defn api-hola [request]
  ;; (let [nombre (get-in request [:params :nombre])]
  ;; (let [nombre (:nombre (:params request))]
  (let [nombre (-> request :params :nombre)]
    {:status 200
     :headers {"Content-Type" "application/json"}
     :body (json/write-str {:saludo (str "Hola, " nombre "!")})}))

(defn get-personas [request]
  (let [personas (get-all)]
    {:status 200
     :headers {"Content-Type" "application/json"}
     :body (json/write-str personas)}))

(defn add-persona [request]
  (let [
        persona {:id 1 :nombre "Ana"}]
    {:status 201
     :headers {"Content-Type" "application/json"}
     :body (json/write-str persona)}
)
  )

(defn home-routes []
  [ "" 
   {:middleware [
                ;;  middleware/wrap-csrf
                 middleware/wrap-formats]}
                 
   ["/" {:get home-page}]
   ["/about" {:get about-page}]
   ["/holamundo" {:get holamundo-page}]
   ["/hola" {:get hola-page :post hola-action}]
   ["/api/hola" {:post api-hola}]
   ["/api/personas" {:get get-personas :post add-persona}]
   ])

