



(ns go.core)

(defn play-stone [board [x y] colour]
  (assoc-in board [:stones [x y]] colour)
  )

(defn new-board [size] {:size size :stones {}})

(defn neighbours [[x y]]
  (set (map (fn [[dx dy]] [(+ x dx) (+ y dy)]) [[1 0] [-1 0] [0 1] [0 -1]])))

(defn hostile? [{:keys [stones size]} pos colour]
  (not= colour (stones pos)))

(defn group [board position]
  (loop [nbrs #{position}
         seen #{}]
        (println nbrs)
        (println seen)
        (println "----------")


    (if (empty? nbrs)
      seen
      (let [thingy (first nbrs)
            colour ((board :stones) position)]
        (recur
         (conj (next nbrs)
               (remove #(hostile? board % colour)
                       (neighbours thingy)))
         
         (conj seen thingy))))))


(defn valid-move? [{stones :stones size :size} [x y] colour]
  (and (not (contains? stones [x y]))
       (<= 0 x (dec size))
       (<= 0 y (dec size))
       ))

(defn -main
  "I don't do a whole lot."
  [& args]
  (println "Hello, World!"))
