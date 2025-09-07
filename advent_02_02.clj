(ns advent.advent-02-02)


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



(defn safe-diff?[x]
 (let [sorted (sort [(first x) (second x)])
       diff (- (second sorted)(first sorted))]
   (and (< 0 diff) (< diff 4))))

   (map safe-diff? data)


(def tst (partition 2 1 '(73 74 78 79 76)))

(defn check-safe-diff? [s]
(let 
 [a (filter safe-diff? s)
  b (concat (map first a) (list (last (last a))))]
  b))



(defn safe-diff-plus? [s]
  (let [a (check-safe-diff? (p2 (check-safe-diff? s)))]
    (if (>= 0 (- (count s)(count a)))
      true
false)
    ))

      


(defn des? [x]
  (> (first x) (second x)))

(defn asc? [x]
  (< (first x) (second x)))



(defn check-asc? [s]
(let 
 [a (filter asc? s)
  b (concat (map first a) (list (last (last a))))]
  b))

(defn check-des? [s]
(let 
 [a (filter des? s)
  b (concat (map first a) (list (last (last a))))]
  b))


 (defn slope-check-asc [s]
 (let [a (check-asc? (p2 (check-asc? s)))]
 (if (>= 0 (- (count s) (count a)))
true
false)))



  (defn slope-check-dsc [s]
 (let [a (check-des? (p2 (check-des? s)))]
 (if (>= 0 (- (count s) (count a)))
 true
 false)))

  
(def target '(22 21 23 26 27 30 31 35))
 
 (defn complete-check [s]
  (let [a (p2 s)]
    (and
     (safe-diff-plus? a)
     (or (slope-check-asc a) (slope-check-dsc a)))))
  
  (complete-check target)
   
   (defn complete-check2 [s]
    (let [a (p2 s)
          b  (filter safe-diff-plus? a)
           c  (filter slope-check-asc a)
           d  (filter slope-check-dsc a)]
      (println b)
      (println c)
      (println d)))

 (complete-check target)

 (defn complete-checkt [s]
(let [a (p2 s)]
  (println s (safe-diff-plus? a)(slope-check-asc a) (slope-check-dsc a))
)
)

(time (frequencies (map complete-checkt data2)))
   
 (filter complete-check data2)
   
   (filter safe-diff? (p2 target))
  
 
  (filter safe-diff? (filter safe-diff? (p2 target)))
 
(filter asc? (filter asc? (filter safe-diff? (filter safe-diff? (p2 target)))))
 
 (filter des? (filter des? (p2 target)))

  (defn remap [s]
   (concat (map first s) (list (last (last s)))))
 
(defn doppelcheck [s]
  (let [a (filter safe-diff? (p2 (remap (filter safe-diff? (p2 s)))))
        b (filter asc? (p2 (remap (filter asc? a))))
        c (filter des? (p2 (remap (filter des? a))))] 
    (if (>= (count b) (count c))
      (if (>= 2 (- (count s) (count b))) true false)
      (if (>= 2 (- (count s) (count c))) true false))))
   
   (defn doppelcheck1 [s]
     (let [a (filter safe-diff? (p2 (remap (filter safe-diff? (p2 s)))))
           b (filter safe-diff? (p2 (remap (filter safe-diff? a))))
           c (filter safe-diff? (p2 (remap (filter safe-diff? a))))
           ]
       (println s)
       (println a)
       (println b)
       (println c)))
 
(filter safe-diff? s)

(frequencies (map doppelcheck data2))

(map doppelcheck data)
   
   (filter safe-diff? (p2 (remap (filter safe-diff? (p2 [8 6 4 4 1])))))

   (filter safe-diff? (p2 '(89 91 92 95 93 94)))

   (filter safe-diff? (p2 [1 2 7 8 9]))

   (p2 [1 2 7 8 9])
   
  
  (interleave data2 (map doppelcheck data2))

 (println (p2 target))

(count '())

((fn [s](for [x s](remove #{x} s)))[1 2 3 5 6])

(defn go [s]
  (let [a (for [x s] (remove #{x} s))]
    (map complete-checkt a)))
   
   (go [1 2 3 4 5])

(map go data)
 (println target)

(println data2)

(slope-check-dsc (p2 '(38 40 43 44 44)))

(for [x (range 100)]
(println x))

(println 100)
 (println data2)

  
  ;(hint alle varianten -1 ausprobieren)