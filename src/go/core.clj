(ns go.core)

(defn play-stone [board [x y] colour]
  (assoc-in board [:stones [x y]] colour)
  )

(defn new-board [size] {:size size :stones {}})

(defn valid-move? [{stones :stones size :size} pos colour]
  (not (contains? stones pos)))

(defn -main
  "I don't do a whole lot."
  [& args]
  (println "Hello, World!"))
