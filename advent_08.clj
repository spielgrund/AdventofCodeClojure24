(ns advent.advent-08)



(def karte (into [] (map #(into [] (seq %)) (clojure.string/split (slurp "input_08_full.txt") #"\r\n"))))

(map println karte)

(def unique-chars
  (map first
     (frequencies
      (mapcat #(apply str %)
              (for [x karte] (remove #(= \. %)
                                      x))))))

(println (sort unique-chars))

(defn get-vectors [c karte]
  (for [x (range (count (first karte)))
        y (range (count karte))
        :when (= c (get-in karte [x y]))]
    [x y]))

(defn +v [a b]
  [(+ (first a) (first b))
   (+ (second a) (second b))])

(defn -v [a b]
  [(- (first a) (first b))
   (- (second a) (second b))])

(defn in-karte? [a k]
  (and
   (and
    (<= 0 (first a))
    (<= 0 (second a)))
   (and
    (> (count k) (first a))
    (> (count k) (second a)))))

(defn setze-antenne [a b]
  (when (not (= a b))
    (let [distanz (-v b a)
          vorwaerts (+v b distanz)
          rueckwaerts (-v a distanz)]
      (filter #(in-karte? % karte)(list vorwaerts rueckwaerts)))))

(defn go [s] (for [x s y s](setze-antenne x y)))

(count
 (set (concat
 (apply concat (remove nil? (go (get-vectors \0 karte))))
(apply concat (remove nil? (go (get-vectors \A karte)))))))

(count (set (apply concat (for [x unique-chars] (apply concat (remove nil? (go (get-vectors x karte))))))))

(get-vectors \0 karte)

; ich brauche die distanz zwischen vector 1 und 2 (2-1)
; diese Distanz wird auf vector 2 aufaddiert und von vector 1 subtrahiert
; vector 1 und 2 dürfen nicht gleich sein

