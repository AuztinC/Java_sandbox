(ns numeral-conversion.core-spec
  (:require [speclj.core :refer :all]
            [numeral-conversion.core :refer :all]))

(describe "Converting Roman to Arabic"
  (it "single digit"
    (should= 1 (roman->arabic "I"))
    (should= 5 (roman->arabic "V"))
    (should= 10 (roman->arabic "X"))
    (should= 50 (roman->arabic "L"))
    (should= 100 (roman->arabic "C"))
    (should= 500 (roman->arabic "D"))
    (should= 1000 (roman->arabic "M"))
    )
  (it "additives"
    (should= 2 (roman->arabic "II"))
    (should= 6 (roman->arabic "VI"))
    (should= 2100 (roman->arabic "MMC"))
    )
  (it "subtractions"
    (should= 4 (roman->arabic "IV"))
    (should= 900 (roman->arabic "CM"))
    )
  (it "add and subtractions"
    (should= 19 (roman->arabic "XIX"))
    (should= 2450 (roman->arabic "MMCDL"))
    )
  )
