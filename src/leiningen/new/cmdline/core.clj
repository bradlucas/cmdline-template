(ns {{name}}.core
  (:gen-class)
  (:require [clojure.tools.cli :refer [cli]]))
  
(defn run-command
  [opts args banner]
  (println opts)
  (println args)
  (println banner))

(defn -main 
  [& args]
  (println args)
  (let [[opts args banner]
        (cli args
             ["-h" "--app-help" "Show help" :flag true :default false])]
    (if (:banner-help opts)
      (println banner)
      (println (run-command opts args banner)))))
