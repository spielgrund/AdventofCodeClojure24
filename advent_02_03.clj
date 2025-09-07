(ns advent.advent-02-03)


(def split (map #(clojure.string/split % #" ") (clojure.string/split (slurp "input.txt") #"\n")))
(def data2 (for [x split] (map #(Integer/parseInt %) x)))

(slurp "input.txt")

(def data
  [[7 6 4 2 1]
   [1 2 7 8 9]
   [9 7 6 2 1]
   [1 3 2 4 5]
   [8 6 4 4 1]
   [1 3 6 7 9]])


  (defn p2 [x]
(partition 2 1 x))

(defn dsc? [x]
  (> (first x) (second x)))

(defn asc? [x]
  (< (first x) (second x)))

(defn diff? [x]
  (let [sorted (sort [(first x) (second x)])
        diff (- (second sorted) (first sorted))]
    (and (< 0 diff) (< diff 4))))

  (defn slope? [s]
  (or 
   (not (some false? (map dsc? (p2 s))))
   (not (some false? (map asc? (p2 s))))))
  
  (defn remove-idx [s i]
    (concat (subvec (vec s) 0 i)
            (subvec (vec s) (inc i))))

  (defn minus-one-variation [s]
    (for [i (range (count s))]
      (remove-idx s i)))

(defn diff-row? [s]
  (not (some false? (map diff? (p2 s)))))

(defn slope-row? [s]
  (and (slope? s)(diff-row? s)))
  
  
(defn go [s](for [x (map  #(map slope-row? (minus-one-variation %)) s)]
  (some true? x)))

(frequencies (go data2))

