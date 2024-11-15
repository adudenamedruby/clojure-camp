(ns clojure-camp-exercises.core
  (:gen-class)
  (:require [clojure.string :as str]))

;; write your own flatten
(defn my-flatten
  [x]
  (let [head (first x)
        tail (rest x)
        result '()]
  (if (nil? head)
    result
    (if (sequential? head)
      (concat result (my-flatten head) (my-flatten tail))
      (concat result (list head) (my-flatten tail))))))

(defn my-flatten2
  [x]
  (if (sequential? x)
    (mapcat my-flatten2 x)
    (list x)))

(my-flatten [1 2 [3]])
(my-flatten2 [[[[[[5 4]]]]] 1 2 [3]])

;; get the caps
(defn my-caps
  [x]
  (->> x
       (str/join "")
       (re-seq #"[a-zA-Z]")
       (seq)
       (filter #(= (str %) (str/upper-case (str %))))
       (apply str)))

(my-caps "HeLlO, WoRlD!")

(defn my-dedupe
  [coll]
  (loop [input coll
         result []]
    (if (empty? input)
      result
      (if (= (first input) (second input))
        (recur (rest input) result)
        (recur (rest input) (conj result (first input)))))))

(my-dedupe [1 1 2 3 3 2 2 3])
















