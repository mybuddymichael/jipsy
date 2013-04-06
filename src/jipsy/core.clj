(ns jipsy.core)

(defmacro debug [x]
  `(let [x# ~x]
     (println "debug:" '~x "=" x#)
     x#))

;; factor = "0" | "1" | "2" | "3" | "4" | "5" | "6" | "7" | "8" | "9" ;
;; mathop = "+" | "-" | "*" | "/" ;
;; expression = factor | "(" , mathop , expression , { expression } , ")" ;
