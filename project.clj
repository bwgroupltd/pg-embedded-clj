(defproject audiogum/pg-embedded-clj "1.0.3-SNAPSHOT"
  :description "Embedded postgres for clojure"
  :url "https://github.com/bwgroupltd/audiogum/pg-embedded-clj"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.12.0"]
                 [integrant "0.13.1"]
                 [io.zonky.test/embedded-postgres "2.0.7"]
                 [org.clojure/tools.logging "1.3.0"]
                 [org.clojure/tools.namespace "1.5.0"]]


  :profiles {:dev {:dependencies [[org.clojure/java.jdbc "0.7.12"]]}}

  :release-tasks  [["vcs" "assert-committed"]
                   ["change" "version" "leiningen.release/bump-version" "release"]
                   ["vcs" "commit"]
                   ["vcs" "tag" "--no-sign"]
                   ["deploy" "releases"]
                   ["change" "version" "leiningen.release/bump-version" "patch"]
                   ["vcs" "commit"]
                   ["vcs" "push" "origin" "master"]]

  :plugins [[s3-wagon-private "1.3.4"]]

  :repositories {"releases" {:url           "s3p://repo.bowerswilkins.net/releases/"
                             :no-auth       true
                             :sign-releases false}})


