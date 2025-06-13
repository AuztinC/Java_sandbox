(ns bowling.core-spec
  (:require [speclj.core :refer :all]
            [bowling.core :refer :all]))

(defn roll-many [rolls]
  (flatten (for [roll rolls]
    (repeat (first roll) (second roll)))))

(describe "Bowling Kata"
  (it "gutter game"
    (should= 0 (score-game (roll-many [[20 0]]))))
  (it "all 1s"
    (should= 20 (score-game (roll-many [[20 1]]))))
  (it "mix game 1s 2s"
    (should= 25 (score-game (roll-many [[5 2]
                                        [15 1]]))))
  (it "one spare"
    (should= 16 (score-game (roll-many [[2 5]
                                        [1 3]
                                        [17 0]]))))
  (it "one strike"
    (should= 24 (score-game (roll-many [[1 10]
                                        [1 3]
                                        [1 4]
                                        [17 0]]))))
  (it "perfect game"
    (should= 300 (score-game (roll-many [[12 10]]))))
  )
