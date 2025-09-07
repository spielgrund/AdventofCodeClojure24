(ns advent.advent-04)


(def stringput
  (map str input))
(count (first stringput))

;TODO vorwärts, rückwärts, vertikal, vertikalrück, diagonal runter links, diagonal runter rechts, diagonal rauf links, diagonal rauf rechts

(def forward
  (remove nil? (map #(re-seq #"XMAS" %) stringput)))

(def backward
  (remove nil? (map #(re-seq #"SAMX" %) stringput)))

(def vertical 
  (map clojure.string/join 
       (partition (count stringput) 
                  (for [x (range (count stringput)) 
                        y (range (count (first stringput)))]
                    (nth (nth stringput y) x)))))


(def diagonal-positive
  (map clojure.string/join
       (partition 4 (for [z (range (count stringput))
                          x (range (count stringput))
                          y (range (count "XMAS"))
                          :while (and (< x (- (count stringput) 3))
                                      (< y (- (count stringput) 3))
                                      (< (+ x y) (count stringput))
                                      (< (+ y z) (count stringput)))]
                      (nth (nth stringput (+ y z)) (+ x y))))))

(count diagonal-positive)

(def diagonal-negative
 (map clojure.string/join
     (partition 4
           (for [y (range 3 (count stringput))
      x (range (count stringput))
      z (range (count "XMAS"))
      :while (and (< x (- (count stringput) 3))
              (< (+ x z) (count stringput))
                   )]
  (nth (nth stringput (- y z)) (+ x z))))))

(count diagonal-negative)
forward
backward
vertical
diagonal-positive

(reduce +
        (list
         (count (remove nil? (map #(re-seq #"XMAS" %) stringput)))
         (count (remove nil? (map #(re-seq #"SAMX" %) stringput)))
         (count (remove nil? (map #(re-seq #"XMAS" %) vertical)))
         (count (remove nil? (map #(re-seq #"SAMX" %) vertical)))
         (count (filter #{"XMAS"} diagonal-positive))
         (count (filter #{"SAMX"} diagonal-positive))
         (count (filter #{"XMAS"} diagonal-negative))
         (count (filter #{"SAMX"} diagonal-negative))))



