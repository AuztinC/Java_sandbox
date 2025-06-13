(ns fizzbuzz.core)

(defn fizzbuzz [n]
  (cond
    (and (zero? (mod n 5)) (zero? (mod n 3))) "fizzbuzz"
    (zero? (mod n 5)) "buzz"
    (zero? (mod n 3)) "fizz"
    :else n))

(defn fizzbuzz-range [n]
  (map fizzbuzz (map inc (range n))))

(defn print-fizzbuzz-range [n]
  (run! println (fizzbuzz-range n)))

(defn -main
  [& args]
  (print-fizzbuzz-range 45))


Thank you for watching! :)