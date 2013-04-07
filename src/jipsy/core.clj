(ns jipsy.core)

(defmacro debug [x]
  `(let [x# ~x]
     (println "debug:" '~x "=" x#)
     x#))

;; factor = "0" | "1" | "2" | "3" | "4" | "5" | "6" | "7" | "8" | "9" ;
;; mathop = "+" | "-" | "*" | "/" ;
;; space = " ";
;; expression = factor
;;            | "(" , mathop , space , expression , { space , expression } , ")" ;

(def factor-regex #"^[0-9]$")
(def mathop-regex #"^[\+\-\*\/]$")

(defn expected [expected actual]
  (throw (Exception. (str "Expected " expected ". Found \"" actual "\"."))))

(defn factor [s]
  (if (re-seq factor-regex s)
    s
    (expected "factor" s)))

(defn expression [s]
  (if (= 1 (count s))
    (factor s)))
