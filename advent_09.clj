(ns advent.advent-09)

(def string "")

(slurp "input_09.txt")

(partition-all 2 (seq (str 2333133121414131402)))

(seq (str 23))

(take-nth 2 (map #(Character/digit % 10) (seq (str 123456))))

((fn [s] (let [cs (seq (str s))
               e (take-nth 2 (map #(Character/digit % 10) cs))
               o (take-nth 2 (rest (map #(Character/digit % 10) cs)))
               n (map #(apply str (repeat (last %) (first %))) (map-indexed vector e))
               d (map #(apply str (repeat % ".")) o)]
           (if (even? (count cs))
             (interleave n d)
             (apply str (conj (vec (interleave n d)) (last n)))))) (str 2333133121414131402))

((fn [s] (let [cs (seq (str s))
               evn (take-nth 2 (map #(Character/digit % 10) cs))
               oddd (take-nth 2 (rest (map #(Character/digit % 10) cs)))
               nmbr (reverse (flatten (map #(repeat (last %) (first %)) (map-indexed vector evn))))
               dts (map #(apply str (repeat % ".")) oddd)]
           (list nmbr dts))) (slurp "input_09.txt"))

(defn go [s] (let [cs (seq s)
                   gerade (take-nth 2 (map #(Character/digit % 10) cs))
                   ungerade (take-nth 2 (rest (map #(Character/digit % 10) cs)))
                   nummer (map #(repeat (last %) (first %)) (map-indexed vector gerade))
                   nummer-reverse-flat (reverse (flatten (map #(repeat (last %) (first %)) (map-indexed vector gerade))))
                   dts (map #(apply str (repeat % ".")) ungerade)
                   between (loop [x nummer-reverse-flat
                                  y ungerade
                                  z '()]
                             (if (empty? y)
                               (reverse z)
                               (recur (nthrest x (first y)) (next y) (conj z (take (first y) x)))))]
               (take (count (flatten nummer)) (flatten (concat (interleave nummer between) (nthrest nummer (count dts)))))))



;TODO liste ist zu lang?

"00...111...2...333.44.5555.6666.777.888899"
"009981118882777333644655556666667775888899"
"0099811188827773336446555566.............."
(go (str 2333133121414131402))


(reduce + (map #(* (first %) (second %))(map-indexed vector (go (slurp "input_09.txt")))))

(reduce + (map #(* (first %) (second %))(map-indexed vector (go (str 2333133121414131402)))))
(go (str 2333133121414131402))

(count (slurp "input_09.txt"))

(count (str 2333133121414131402))


(count (go (slurp "input_09.txt")))
(go (slurp "input_09.txt"))
