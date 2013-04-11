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
              | name
              | <'('> name <whitespace> expression { <whitespace> expression } <')'>
   number = #'[0-9]+([.][0-9]+)?'
   name = #'[A-Za-z][A-Za-z0-9_]*' | mathop
   mathop = '+' | '-' | '*' | '/' | '^' | '%'
   ws = #'[\\s,]+'")

(def parse (instaparse/parser grammar))
