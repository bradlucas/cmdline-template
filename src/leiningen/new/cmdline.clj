(ns leiningen.new.cmdline
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "cmdline"))

(defn cmdline
  "Generate a cmdline (command line) application"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new cmdline' project, " name)
    (main/info data)
    (->files data
             [".gitignore" (render "gitignore")]
             ["LICENSE" (render "LICENSE")]
             ["README.md" (render "README.md" data)]
             ["project.clj" (render "project.clj" data)]
             ["doc/intro.md" (render "intro.md" data)]
             ;; TODO resources directory
             ;; ["resource"]
             ["src/{{sanitized}}/core.clj" (render "core.clj" data)]
             ["test/{{sanitized}}/core_test.clj" (render "core_test.clj" data)])))
