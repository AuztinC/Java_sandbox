(ns hello-quil.core_spec
  (:require [speclj.core :refer :all]
            [hello-quil.test-01 :as test]))

(describe "game of life"
  (it "getting all neighbors"
    (should-have-count 8 (test/test-drive)))
  (it "find "
    (should-have-count 8 (test/test-drive)))
  )