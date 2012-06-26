(ns go.core)

(defn play-stone [board [x y] colour]
  (assoc-in board [:stones [x y]] colour)
  )

(defn new-board [size] {:size size :stones {}})

(defn valid-move? [{stones :stones size :size} [x y] colour]
  (and (not (contains? stones [x y])) (>= x 0)))

(defn -main
  "I don't do a whole lot."
  [& args]
  (println "Hello, World!"))
