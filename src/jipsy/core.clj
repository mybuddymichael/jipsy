(ns jipsy.core
  (:require [instaparse.core :as instaparse]))

(defmacro debug [x]
  `(let [x# ~x]
     (println "debug:" '~x "=" x#)
     x#))

(def grammar
  "expression = factor
              | name
              | <'('> mathop <whitespace> expression { <whitespace> expression } <')'>
   factor = digit+
   <digit> = '0' | '1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9'
   mathop = '+' | '-' | '*' | '/'
   name = #'[A-Za-z][A-Za-z0-9_]*'
   whitespace = #'[\\s,]+'")

(def parse (instaparse/parser grammar))
