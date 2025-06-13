(ns hello-quil.core
  (:require [quil.core :as q]
            [quil.middleware :as m])
  (:require [hello-quil.test-01 :as test-01]))

(def size 20)
#_(def state (into [] (for [x (range size)
                           y (range size)]
                       {:height 30 :width 30 :x (* 30 x) :y (* 30 y) :on 0})))

(def state2 (take (* size size) (repeatedly #(rand-int 2))))

(def state (vec (map vec (partition size
                  (take (* size size) (repeatedly #(rand-int 2)))))))

(defn setup []
  (q/frame-rate 10)
  state)

(defn update-state [state]
  #_(test-01/update-state state)
  state
  )

(defn draw-state [state]
  (q/background 240)
  (if (q/mouse-pressed?) (println [(q/mouse-x) (q/mouse-y)]))
  (let [cell-size (quot (q/width) size)]
    (doseq [y (range (count state))
            x (range (count (get state y)))]
      (let [val (get-in state [y x])]
        (q/fill (if (= 1 val) 0 255))
        (q/rect (* x cell-size) (* y cell-size) cell-size cell-size)))))

(q/defsketch hello-quil
  :title "Thats a lot of squares!"
  :size [200 200]
  :setup setup
  :update update-state
  :draw draw-state
  :features [:keep-on-top]
  :middleware [m/fun-mode])






