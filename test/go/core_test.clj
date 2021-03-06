(ns go.core-test
  (:use clojure.test
        go.core))
;                    x y
; {:size 19 :stones {[1 2] :black}}

(deftest a-test
  (testing "I have a board"
    (let [board (new-board 3)]
      (is (= {:size 3 :stones {[0 0] :black}}
             (play-stone board [0 0] :black)))))
  (testing "I can't play the same place twice"
    (let [board (new-board 3)]
      (is (= {:size 3 :stones {[0 0] :black}}
             (play-stone (play-stone board [0 0] :black) [0 0] :black)))))
  (testing "I'm allowed to make a valid move"
    (let [board (new-board 3)]
      (is (= true
             (valid-move? board [0 0] :black)))))
  (testing "Playing to an occupied location is invalid"
    (is (= (valid-move? (play-stone (new-board 3) [0 0] :black)
                      [0 0]
                      :black)
           false)))
  (testing "Playing outside the bounds is invalid"
    (is (= (valid-move? (new-board 3) [-1 0] :black) false))
    (is (= (valid-move? (new-board 3) [17 0] :black) false))
    (is (= (valid-move? (new-board 3) [3 0] :black) false))
    (is (= (valid-move? (new-board 3) [0 -1] :black) false))
    (is (= (valid-move? (new-board 3) [0 4] :black) false)))
  
  (testing "Hostile location is reported as hostile"
    (is (= (hostile? (play-stone (new-board 3) [0 0] :white)
                     [0 0]
                     :black)
           true))
    (is (= (hostile? (play-stone (new-board 3) [0 0] :black)
                     [0 0]
                     :black)
           false))
    (is (= (hostile? (new-board 3)
                     [0 -1]
                     :black)
           true)))

  (testing "neighbours produces a seq of the adjacent squares"
    (is (= #{[0 1] [1 0] [2 1] [1 2]}
           (neighbours [1 1]))))

  (testing "Groups are adjacent stones of the same colour"
    (= #{[5 5] [5 6]}
       (group
        (-> (new-board 10)
            (play-stone [5 5] :black)
            (play-stone [5 6] :black)
            (play-stone [9 9] :black))
        [5 5]))))
