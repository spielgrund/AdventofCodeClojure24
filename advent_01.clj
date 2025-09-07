(ns advent.advent-01)

(def locations
  [3   4
   4   3
   2   5
   1   3
   3   9
   3   3])



(defn go [s]
  (interleave (map sort (list (map first (partition 2 s))(map second (partition 2 s))))))



(defn gogo [s]
  (let [pairs (partition 2 s)
        l1 (sort (map first pairs))
        l2 (sort (map second pairs))
        inter (partition 2 (interleave l1 l2))]
    (reduce + (map #(- (second (sort %)) (first (sort %))) inter))))

(gogo locations)

(clojure.data/diff [1 2])