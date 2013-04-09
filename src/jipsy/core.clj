(ns jipsy.core
  (:require [instaparse.core :as instaparse]))

(defmacro debug [x]
  `(let [x# ~x]
     (println "debug:" '~x "=" x#)
     x#))

(def parser
  (instaparse/parser
    "expression = factor+
                | <'('> mathop space expression { space expression } <')'>
     factor = '0' | '1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9'
     mathop = '+' | '-' | '*' | '/'
     space = ' '"))
