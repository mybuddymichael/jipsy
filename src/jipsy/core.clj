(ns jipsy.core
  (:require [instaparse.core :as instaparse]))

(defmacro debug [x]
  `(let [x# ~x]
     (println "debug:" '~x "=" x#)
     x#))

(def parse
  (instaparse/parser
    "expression = factor
                | <'('> mathop <whitespace> expression { <whitespace> expression } <')'>
     factor = digit+
     <digit> = '0' | '1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9'
     mathop = '+' | '-' | '*' | '/'
     whitespace = #'[\\s,]+'"))
