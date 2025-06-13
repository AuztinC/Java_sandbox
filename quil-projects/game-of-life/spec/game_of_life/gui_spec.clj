(ns game-of-life.gui-spec
  (:require [speclj.core :refer :all]
            [game-of-life.gui :as sut]
            [quil.core :as q]))

(def mock-state [[0 0 0]
                 [0 1 0]
                 [1 1 0]])

(describe "game-of-life gui"
  (with-stubs)

  (it "calls quil functions on draw-state"
    (with-redefs [q/fill (stub :fill)
                  q/stroke (stub :stroke)
                  q/background (stub :bg)
                  q/width (stub :width {:return 500})
                  q/rect (stub :rect)]
      (sut/draw-state mock-state)
      (should-have-invoked :fill)
      (should-have-invoked :stroke)
      (should-have-invoked :bg)
      (should-have-invoked :width)
      (should-have-invoked :rect)))

  (it "gives RGB random color between 100-255"
    (with-redefs [rand-int (fn [&_] 150)]
      (should= [250 250 250] (sut/->color))))

  #_(it "update and returns state"
      (should= [[0 0 0]
                [1 1 0]
                [1 1 0]] (sut/update-state mock-state)))
  )