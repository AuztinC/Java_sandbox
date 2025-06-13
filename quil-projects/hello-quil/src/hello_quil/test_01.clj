(ns hello-quil.test-01)

; Game of life kata.
; ALONE - if cell is alone with no niegbors it dies
; OVER POP - if cell has 4 or more neighbors it dies
; SURVIVE - if EMPTY cell has 2 or 3 neighbors lives
; For a space that is empty or unpopulated:
; Each cell with three neighbors becomes populated.
;
; TODO
; check if neighbors are populated
; count frequencies
; act
; create new state vector
; send back state

(def size 20)
(def state (vec (map vec (partition size
                           (take (* size size) (repeatedly #(rand-int 2)))))))

(defn check-neighbors [y x]
  (let [val (get-in state [y x])
        up (get-in state [(dec y) x])
        up-right (get-in state [(dec y) (inc x)])
        up-left (get-in state [(dec y) (dec x)])
        right (get-in state [y (inc x)])
        left (get-in state [y (dec x)])
        down (get-in state [(inc y) x])
        down-right (get-in state [(inc y) (inc x)])
        down-left (get-in state [(inc y) (dec x)])
        freq (frequencies [up-left up up-right left right down-left down down-right])]
    (for [cell freq]
      cell)))

(defn check-faces []
  (for [y (range (count state))
        x (range (count (get state y)))]
    (check-neighbors y x)))

(defn update-state []
  (println (check-faces)))

(defn -main []
  (update-state) )

(defn test-drive []
  [1 2 3 4 5 6 7 8])