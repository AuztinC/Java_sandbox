(ns bowling.core)

(defn spare? [rolls]
  (= 10 (+ (first rolls) (second rolls))))

(defn strike? [rolls]
  (= 10 (first rolls)))

(defn score-strike [rolls]
  (if (nil? (nth rolls 2 nil))
    0
    (+ 10 (second rolls) (nth rolls 2))))

(defn score-spare [rolls]
  (if (spare? rolls)
    (+ 10 (nth rolls 2))
    (+ (first rolls) (second rolls))))

(defn score-frame [rolls]
  (cond
    (strike? rolls) (score-strike rolls))
  (if (strike? rolls)
    (score-strike rolls)
    (score-spare rolls)))

(defn next-frame [rolls]
  (if (strike? rolls)
    (next rolls)
    (next (next rolls))))

(defn score-game [rolls]
  (loop [rolls rolls score 0]
    (if (> 2 (count rolls))
      score
      (recur (next-frame rolls) (+ score (score-frame rolls))))))
