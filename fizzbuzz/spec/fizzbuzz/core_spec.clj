(ns fizzbuzz.core-spec
  (:require [speclj.core :refer :all]
            [fizzbuzz.core :refer :all]))

(describe "fizzbuzz"
  (context "one number at a time"
    (it "1 gives 1"
      (should= 1 (fizzbuzz 1)))
    (it "2 gives 2"
      (should= 2 (fizzbuzz 2)))
    (it "3 gives fizz"
      (should= "fizz" (fizzbuzz 3)))
    (it "6 gives fizz"
      (should= "fizz" (fizzbuzz 6)))
    (it "5 gives buzz"
      (should= "buzz" (fizzbuzz 5)))
    (it "10 gives buzz"
      (should= "buzz" (fizzbuzz 10)))
    (it "15 gives fizzbuzz"
      (should= "fizzbuzz" (fizzbuzz 15)))
    )
  (context "range of numbers"
    (it "1 gives '(1)"
      (should= '(1) (fizzbuzz-range 1)))
    (it "3 gives '(1 2 fizz)"
      (should= '(1 2 "fizz") (fizzbuzz-range 3)))
    )
  (context "print"
    (it "1 gives '1\n'"
      (should= "1\n" (with-out-str (print-fizzbuzz-range 1))))
    (it "3"
      (should= "1\n2\nfizz\n" (with-out-str (print-fizzbuzz-range 3))))
    )
  )
