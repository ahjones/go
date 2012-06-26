



(ns go.core)

(defn play-stone [board [x y] colour]
  (assoc-in board [:stones [x y]] colour)
  )

(defn new-board [size] {:size size :stones {}})

(defn neighbours [[x y]]
  (set (map (fn [[dx dy]] [(+ x dx) (+ y dy)]) [[1 0] [-1 0] [0 1] [0 -1]])))

(defn valid-move? [{stones :stones size :size} [x y] colour]
  (and (not (contains? stones [x y]))
       (<= 0 x (dec size))
       (<= 0 y (dec size))
       ))

(defn hostile? [{:keys [stones size]} pos colour]
  (not= colour (stones pos)))

(defn -main
  "I don't do a whole lot."
  [& args]
  (println "Hello, World!"))
