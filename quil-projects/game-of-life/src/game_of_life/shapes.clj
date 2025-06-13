(ns game-of-life.shapes)

(def state_blinker [[0 1 0]
                    [0 1 0]
                    [0 1 0]])

(def state_frog [[0 0 0 0 0 0]
                 [0 0 1 1 1 0]
                 [0 1 1 1 0 0]
                 [0 0 0 0 0 0]])

(def state_battle
  (vec (map vec
         (partition 20
           (flatten
             (for [y (range 20)]
               (for [x (range 20)]
                 (if (or (and (= y 2) (= x 3))
                       (and (= y 3) (= x 4))
                       (and (= y 4) (#{2 3 4} x)))
                   1
                   (if (or (and (= y 16) (#{11 12 13 14} x))
                         (and (= y 17) (#{10 14} x))
                         (and (= y 18) (= x 14))
                         (and (= y 19) (#{10 13} x)))
                     1
                     (if (or (and (= y 14) (#{6 7 8} x))
                           (and (= y 15) (#{5 6 7} x)))
                       1
                       0))))))))))