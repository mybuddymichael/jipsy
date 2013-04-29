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
        | <ws>? assignment <ws>?
        | <ws>? expression <ws>?

   definition = <'(defn'> <ws>+ identifier <ws>+ argslist <ws>+ expression <')'>
   argslist = <'['> <ws>* identifier* <ws>* <']'>

   assignment = <'(def'> <ws>+ identifier (<ws>+ expression)? <ws>* <')'>

   expression = number
              | string
              | object
              | array
              | identifier
              | call
              | comment

   call = <'('> <ws>* identifier (<ws>+ expression)* <ws>* <')'>
        | <'('> <ws>* (addop | mulop) <ws>+ expression (<ws>+ expression)* <ws>* <')'>
        | <'('> <ws>* (expop | modop) <ws>+ expression <ws>+ expression (<ws>+ expression)* <ws>* <')'>

   number = #'[0-9]+([.][0-9]+)?'
   string = #'\"[^\"]*\"'
   object = <'{'> (<ws>* keyword <ws>+ expression <ws>*)* <'}'>
   array = <'['> <ws>* expression* <ws>* (<ws>+ expression <ws>*)* <']'>

   keyword = <':'> identifier
   identifier = !reserved #'[A-Za-z][A-Za-z0-9_]*'
   addop = '+' | '-'
   mulop = '*' | '/'
   expop = '^'
   modop = '%'
   reserved = 'def' | 'fn'

   comment = <#';+'> <ws>* #'[^\\s].*$'
   ws = #'[\\s,]'")

(def parser (instaparse/parser grammar))
