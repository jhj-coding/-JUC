package com.jhj.algorithm.leetcode;


import java.util.HashMap;

public class Leetcode {

    class FrequencyTracker {
        HashMap<Integer, Integer> map; // 数字
        HashMap<Integer, Integer> map1; // 次数

        public FrequencyTracker() {
            this.map = new HashMap<Integer, Integer>();
            this.map1 = new HashMap<Integer, Integer>();
        }

        public void add(int number) {
            if(map.getOrDefault(number, 0)>0)
                map1.put(map.get(number), map1.get(map.get(number)) - 1);
            map.put(number, map.getOrDefault(number, 0) + 1);
            map1.put(map.get(number), map1.getOrDefault(map.get(number),0) + 1);
        }

        public void deleteOne(int number) {
            if (map.getOrDefault(number, 0) > 0) {
                map1.put(map.get(number), map1.get(map.get(number)) - 1);
                map.put(number, map.get(number) - 1);
                map1.put(map.get(number), map1.getOrDefault(map.getOrDefault(number, 0), 0) + 1);
            }
        }

        public boolean hasFrequency(int frequency) {
            return map1.getOrDefault(frequency, 0) > 0;
        }
    }
}
