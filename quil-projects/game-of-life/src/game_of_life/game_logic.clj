(ns game-of-life.game-logic)

(defn ->cell-state [ones cell-value]
  (cond
    (and (= 0 cell-value) (= 3 ones)) 1
    (and (= 1 cell-value) (or (= 3 ones) (= 2 ones))) 1
    :else 0))

(defn count-ones [state [y x]]
  (let [offsets [[-1 -1] [-1 0] [-1 1]
                 [0 -1] [0 1]
                 [1 -1] [1 0] [1 1]]]
    (get (frequencies (for [[dy dx] offsets]
                        (get-in state [(+ y dy) (+ x dx)]))) 1 0)))

(defn state->yx [state]
  (for [y (range (count state))
        x (range (count (get state y)))]
    [y x]))

(defn ->new-state [state new-state [y x]]
  (let [val (get-in state [y x])
        neighbor-ones (count-ones state [y x])
        updated-cell (->cell-state neighbor-ones val)]
    (assoc-in new-state [y x] updated-cell)))

(defn update-state [state]
  (reduce (partial ->new-state state)
    state
    (state->yx state)))