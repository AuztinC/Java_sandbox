(ns game-of-life.gui
  (:require [quil.core :as q]
            [quil.middleware :as m]
            [game-of-life.game-logic :as logic]))

(def size 50)
(def state (vec (map vec (partition size
                           (take (* size size) (repeatedly #(rand-int 2)))))))

(defn ->color []
  (vec (take 3 (repeatedly #(+ 100 (rand-int 156))))))

(defn draw-cell [state cell-size x y]
  (let [val (get-in state [y x])
        random-color (->color)]
    (q/fill (if (= 1 val) random-color 0))
    (q/rect (* x cell-size) (* y cell-size) cell-size cell-size)))

(defn ->draw [state]
  (let [cell-size (/ (q/width) size)]
    (doseq [y (range (count state))
            x (range (count (get state y)))]
      (draw-cell state cell-size x y))))

(defn setup []
  (q/frame-rate 10)
  state)

(defn update-state [state]
  (logic/update-state state))

(defn draw-state [state];
  (q/background 240)
  (q/stroke [100 100 100 100])
  (->draw state))

(q/defsketch game-of-life
  :title "The Game of Life"
  :size [500 500]
  :setup setup
  :update update-state
  :draw draw-state
  :features [:keep-on-top]
  :middleware [m/fun-mode])
