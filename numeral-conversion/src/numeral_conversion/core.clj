(ns numeral-conversion.core)

(def values {\I 1 \V 5 \X 10 \L 50 \C 100 \D 500 \M 1000})

(defn roman->arabic [s]
  (loop [s s total 0]
    (if (zero? (count s))
      total
      (let [curr (get values (first s))
            next (if (next s)
                   (get values (first (next s)))
                   0)
            new-total ((if (< curr next) - +) total curr)]
        (recur (rest s) new-total)))))
