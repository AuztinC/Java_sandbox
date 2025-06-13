(ns todo1.test1-spec
  (:require [speclj.core :refer :all]
            [todo1.test1 :refer :all]))

(describe "first "
  (it "1 + 1"
    (should= 2 (add 1))))