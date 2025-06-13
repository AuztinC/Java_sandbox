(ns game-of-life.game-logic-spec
  (:require [speclj.core :refer :all]
            [game-of-life.game-logic :as sut]))

(def state [[0 0 0]
            [0 1 0]
            [1 1 0]])

(describe "The game of life Kata"
  (context "given a position, counts neighbors with value 1"
    (it "count alive neighbors"
      (should= 1 (sut/count-ones state [0 0])))
    )
  (context "update cell states"
    (it "dead cell stays dead"
      (should= 0 (sut/->cell-state 1 0)))
    (it "dead cell becomes alive"
      (should= 1 (sut/->cell-state 3 0)))
    (it "alive cell dies"
      (should= 0 (sut/->cell-state 1 1)))
    (it "alive cell survives"
      (should= 1 (sut/->cell-state 2 1)))
    )
  (context "updates state"
    (it "creates coordinates from state"
      (let [state [[0 0]
                   [0 0]]]
       (should= [[0 0] [0 1] [1 0] [1 1]] (sut/state->yx state))))
    (it "computes next state for single cell"
      (let [state [[0 1]
                   [1 1]]
            new-state [[0 0]
                       [0 0]]]
        (should= [[1 0]
                  [0 0]] (sut/->new-state state new-state [0 0]))))
    (it "update and return full state"
      (should= [[0 0 0]
                [1 1 0]
                [1 1 0]] (sut/update-state state)))
    )
  )
