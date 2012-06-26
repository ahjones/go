(ns go.core)

(defn play-stone [board [x y] colour]
  (assoc-in board [:stones [x y]] colour)
  )

(defn -main
  "I don't do a whole lot."
  [& args]
  (println "Hello, World!"))
