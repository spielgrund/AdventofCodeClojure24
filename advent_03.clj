(ns advent.advent-03)
(def input 
"insert input data")

(def numbers (map #(re-seq #"\d+" %) (re-seq #"mul\(\d+,\d+\)" input)))



(def pairs( for [x numbers] (map #(Integer/parseInt %) x)))

(reduce + (map #(* (first %) (second %)) pairs))

(println numbers)