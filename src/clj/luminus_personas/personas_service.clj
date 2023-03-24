(ns luminus-personas.personas-service)

(defmacro dbg [x] `(let [x# ~x] (println "dbg:" '~x "=" x#) x#))

(def personas (atom []))

(defn get-all []
  @personas)

(defn save [persona]
;;   (let [nueva-persona (assoc persona :id (str (count @personas)))]
    
;;   (swap! personas conj nueva-persona)
  {:id 1 :nombre "Ana"})