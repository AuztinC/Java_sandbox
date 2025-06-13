(defproject game-of-life "0.1.0-SNAPSHOT"
  :description "Game of Life Kata by Austin Cripe"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [quil "4.3.1323"]
                 [speclj "3.9.0"]]
  :profiles {:dev {:dependencies [[speclj "3.9.0"]]}}
  :plugins [[speclj "3.9.0"]]
  :test-paths ["spec"])
