(ns jipsy.core
  (:require [instaparse.core :as instaparse]))

(defmacro debug [x]
  `(let [x# ~x]
     (println "debug:" '~x "=" x#)
     x#))

(def grammar
  "program = { <whitespace> } expression { <whitespace> } { expression }
   expression = number
              | name
              | <'('> mathop <whitespace> expression { <whitespace> expression } <')'>
   number = #'[0-9]+([.][0-9]+)?'
   mathop = '+' | '-' | '*' | '/'
   name = #'[A-Za-z][A-Za-z0-9_]*'
   whitespace = #'[\\s,]+'")

(def parse (instaparse/parser grammar))
