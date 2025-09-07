(ns advent.advent-01-02)


(def locations
  [3   4
   4   3
   2   5
   1   3
   3   9
   3   3])

(defn f [s db] (reduce list (filter #(= s (first %)) db)))

(defn gogo [s]
  (let [pairs (partition 2 s)
        l (sort (map first pairs))
        r (sort (map second pairs)) 
        rfreq (frequencies r)
        linr (remove nil? (map #(some #{%} r) l))]
    (map #(f % rfreq) linr)))


(reduce + (map #(reduce * %) (gogo locations)))
