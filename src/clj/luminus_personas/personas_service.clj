(ns luminus-personas.personas-service)

(defmacro dbg [x] `(let [x# ~x] (println "dbg:" '~x "=" x#) x#))

(def personas (atom []))

(defn get-all []
  @personas)

(defn save [persona]
  (let [nueva-persona (assoc persona :id (str (+ 1 (count @personas))))]
  (swap! personas conj nueva-persona)
    ;; (dbg persona)
    ;; (dbg nueva-persona)
  nueva-persona))