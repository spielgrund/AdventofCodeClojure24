(ns advent.advent-02)


(def split (map #(clojure.string/split % #" ") (clojure.string/split (slurp "data_02.txt") #"\r\n")))
(def data2 (for [x split] (map #(Integer/parseInt %) x)))

(count data2)

(println data2)



(def data
  [7 6 4 2 1
   1 2 7 8 9
   9 7 6 2 1
   1 3 2 4 5
   8 6 4 4 1
   1 3 6 7 9])

(defn safe-diff?[x]
 (let [sorted (sort [(first x) (second x)])
       diff (- (second sorted)(first sorted))]
   (and (< 0 diff) (< diff 4))))

(defn decending? [x]
  (> (first x) (second x)))

(defn safty-check [s]
  (let [diff (map #(partition 2 1 %) s)]
    (for [x diff](list (set (map #(safe-diff? %) x))(set (map #(decending? %)x))))))


;(for [x diff] (do (map #(safe-diff? %) x) (map #(decending? %) x)))

(defn count-checks [s] (map #(reduce + %)(for [x s] (map #(count %) x))))

(sort-by first (frequencies (count-checks (safty-check data2))))




