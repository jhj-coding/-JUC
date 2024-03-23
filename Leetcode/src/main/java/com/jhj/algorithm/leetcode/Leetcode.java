package com.jhj.algorithm.leetcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Leetcode {
    class Solution {
        ArrayList<String> res = new ArrayList<String>();

        public List<String> letterCombinations(String digits) {
            if (digits.length() == 0) {
                return res;
            }
            HashMap<Character, String> map = new HashMap<>();
            map.put('1', "");
            map.put('2', "abc");
            map.put('3', "def");
            map.put('4', "ghi");
            map.put('5', "jkl");
            map.put('6', "mno");
            map.put('7', "pqrs");
            map.put('8', "tuv");
            map.put('9', "wxyz");
            huisu(new StringBuilder(), digits, 0, map);
            return res;
        }

        public void huisu(StringBuilder path, String digits, int start, HashMap<Character, String> map) {

            if (path.length() == digits.length()) {
                res.add(new String(path.toString()));
                return;
            }
            String s = map.get(digits.charAt(start));
            for (int j = 0; j < s.length(); j++) {
                path.append(s.charAt(j));
                huisu(path, digits, start + 1, map);
                path.deleteCharAt(path.length() - 1);
            }
        }
    }
}
