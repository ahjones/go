(ns go.core-test
  (:use clojure.test
        go.core))
;                    x y
; {:size 19 :stones {[1 2] :black}}

(deftest a-test
  (testing "I have a board"
    (def board {:size 3 :stones {}})
    (is (= {:size 3 :stones {[0 0] :black}}
           (play-stone board [0 0] :black)))))