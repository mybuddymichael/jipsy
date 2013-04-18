(ns jipsy.core
  (:require [instaparse.core :as instaparse]
            [clojure.pprint :use [pprint]]))

(defmacro debug [x]
  `(let [x# ~x]
     (println "debug:" '~x "=" x#)
     x#))

(def grammar
  "program = form*
   form = <ws>? definition <ws>?
        | <ws>? expression <ws>?
   definition = <'(def'> <ws> identifier <ws> expression <')'>
   expression = number
              | object
              | identifier
              | <'('> (identifier|mathop) <ws> expression (<ws> expression)* <')'>
   object = <'{'> (<ws>* keyword <ws>+ expression <ws>*)* <'}'>
   number = #'[0-9]+([.][0-9]+)?'
   identifier = !reserved #'[A-Za-z][A-Za-z0-9_]*'
   mathop = '+' | '-' | '*' | '/' | '^' | '%'
   reserved = 'def' | 'fn'
   ws = #'[\\s,]+'")

(def parse (instaparse/parser grammar))
