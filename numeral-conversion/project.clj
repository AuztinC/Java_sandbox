(defproject numeral-conversion "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :main numeral-conversion.core
  :dependencies [[org.clojure/clojure "1.12.0"]]
  :profiles {:dev {:dependencies [[speclj "3.9.0"]]}}
  :plugins [[speclj "3.9.0"]]
  :test-paths ["spec", "src"])
