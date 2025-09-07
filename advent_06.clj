(ns advent.advent-06)


(defn index-of [x coll]
  (let [idx? (fn [i a] (when (= x a) i))]
    (first (keep-indexed idx? coll))))

(def split1 (into [] (map #(into [] (seq %)) (clojure.string/split (slurp "input_06.txt") #"\r\n"))))
(def tut (into [] (map #(into [] (seq %)) (clojure.string/split (slurp "input_06_01.txt") #"\r\n"))))


(def fieldm split1)
split1
tut


(into [] (seq "123"))

(clojure.pprint/pprint  split1)
(println split1)

(def field-size [(count (first fieldm)) (count fieldm)])

(def startposition (let [y (index-of \^ (map #(some #{\^} %) fieldm))
                         x (index-of \^ (nth fieldm y))]
                     [x y]))

startposition
field-size

(defn in-field? [v]
  (and
   (and (<= 0 (first v)) (< (first v) (first field-size)))
   (and (<= 0 (second v)) (< (second v) (second field-size)))))

(defn turn-right [x]
  (if (= x 3)
    0
    (inc x)))

(defn get-f-m [x]
  (if (in-field? x) 
  (nth (nth fieldm (second x)) (first x))))

  (get-f-m [10 10])

(defn add [x y]
  [(+ (first x) (first y)) (+ (second x) (second y))])

(defn direction-vector [direction]
  (case direction
    0 [0 -1]
    1 [1 0]
    2 [0 1]
    3 [-1 0]))

(defn next-position [direction pos]
  (let [dv (direction-vector direction)]
    (do
      ;(println (add pos dv))
      (add pos dv))))

(defn move [direction pos]
  (if (= \# (get-f-m (next-position direction pos)))
    [(turn-right direction) pos]
    [direction (next-position direction pos)]))

(move 1 [4 1])
(get-f-m (next-position 0 [4 1]))


(turn-right 3)

;todo -> startposition x ->  check in field? x -> check field -> move -> finish


(defn go [direction position f]
  (loop [dir direction pos position field f]
    (let [x (move dir pos)
          marker [(second pos) (first pos)]]
      (if (in-field? (second x))
        (do
          ;(println pos)
          (recur (first x) (second x) (assoc-in field marker \X)))
        field))))



(time
 (+ 1
   (reduce +
           (remove nil?
                   (map #(% \X) (map frequencies (go 0 startposition fieldm)))))))

({\. 4, \X 5, \# 1} \X)

(some? nil)