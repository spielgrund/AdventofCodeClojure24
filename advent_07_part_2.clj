(ns advent.advent-07-part-2)
(require '[clojure.math.combinatorics :as combo])

(def numbers
  (let [a (clojure.string/replace (slurp "input_07_full.txt") ":" "")
        b (clojure.string/split a #"\r\n")
        c (map #(clojure.string/split % #" ") b)
        d (for [x c]
            (map #(bigint %) x))]
    d))

(clojure.pprint/pprint numbers)

(defn rechne [op a b]
  (case op
  "+" (+ a b)
  "*" (* a b)
  "||" (bigint (apply str (list a b)))))

(defn rechne-rekursiv [op lst ergebnis]
  (if (= 0 (count lst))
    ergebnis
    (if (nil? ergebnis)
      (rechne-rekursiv (rest op) (nthrest lst 2) (rechne (first op) (first lst) (second lst)))
      (rechne-rekursiv (rest op) (rest lst) (rechne (first op) ergebnis (first lst))))))


(defn go [s]
  (let [op (clojure.math.combinatorics/selections ["+" "*" "||"] (- (count s) 2))
        lst (rest s)
        ergebnis (first s)]
    (for [x op
    :let [y (rechne-rekursiv x lst nil)]
    :when (= y ergebnis)]
    ergebnis)))


(time (reduce + (map first (remove empty? (map go numbers)))))





(bigint "4185056939")

