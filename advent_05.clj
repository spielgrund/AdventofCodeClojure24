(ns advent.advent-05)


(def split1 (map #(clojure.string/split % #"\|") (clojure.string/split (slurp "input_05_01.txt") #"\r\n")))
(def rulepairs (for [x split1] (map #(Integer/parseInt %) x)))

(def split2 (map #(clojure.string/split % #",") (clojure.string/split (slurp "input_05_02.txt") #"\r\n")))

(def updates (map (partial map #(Integer/parseInt %)) split2))

(defn get-pairs [x] (remove nil? (map #(if (= x (first %)) (second %)) rulepairs)))

(defn prelists [s] (remove empty? (map (fn [x] (take (.indexOf s x) s)) s)))

(defn prelist [s coll] (take (.indexOf  coll s) coll))

(defn check-prelists [s] (for [x s]
                           (map #(contains?
                                  (set (get-pairs x)) %) 
                                (prelist x s))))

(defn valid? [s] (not
                  (some true?
                        (map #(some true? %) (check-prelists s)))))

(defn middle-index [s] (int (/ s 2)))

(reduce +
        (remove nil?
                (for [x updates]
                  (if (valid? x)
                    (nth x (middle-index (count x)))))))

