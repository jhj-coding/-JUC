package com.jhj.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class All {
    //1 两数之和
    class Solution1 {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<Integer, Integer>();
            for (int i = 0; i < nums.length; i++) {
                integerIntegerHashMap.put(nums[i], i);
            }
            int res1 = 0;
            int res2 = 0;
            for (int i = 0; i < nums.length; i++) {
                Integer integer = integerIntegerHashMap.get(target - nums[i]);
                if (integer != null && integer != i) {
                    res1 = i;
                    res2 = integer;
                    break;
                }
            }
            return new int[]{res1, res2};
        }
    }

    //2 两数相加
    class Solution2 {
        class ListNode {
            int val;
            ListNode next;

            ListNode() {
            }

            ListNode(int val) {
                this.val = val;
            }

            ListNode(int val, ListNode next) {
                this.val = val;
                this.next = next;
            }
        }

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode cur1 = l1;
            ListNode cur2 = l2;
            ListNode res = new ListNode();
            ListNode cur3 = res;
            int a = 0;
            while (cur1 != null || cur2 != null) {
                if (cur1 != null && cur2 != null) {
                    int temp = cur1.val + cur2.val + a;
                    ListNode listNode = new ListNode(temp % 10);
                    cur3.next = listNode;
                    a = temp / 10;
                    cur1 = cur1.next;
                    cur2 = cur2.next;
                    cur3 = cur3.next;
                    continue;
                }
                if (cur1 != null && cur2 == null) {
                    int temp = cur1.val + a;
                    ListNode listNode = new ListNode(temp % 10);
                    cur3.next = listNode;
                    a = temp / 10;
                    cur1 = cur1.next;
                    cur3 = cur3.next;
                    continue;
                }
                if (cur1 == null && cur2 != null) {
                    int temp = cur2.val + a;
                    ListNode listNode = new ListNode(temp % 10);
                    cur3.next = listNode;
                    a = temp / 10;
                    cur2 = cur2.next;
                    cur3 = cur3.next;
                    continue;
                }
            }
            if (a != 0) {
                cur3.next = new ListNode(a);
            }

            return res.next;
        }
    }

    //3 无重复字符的最长子串
    class Solution3 {
        public int lengthOfLongestSubstring(String s) {
            char[] chars = s.toCharArray();
            HashSet<Character> characters = new HashSet<Character>();
            if (s.length() > 0) {
                characters.add(chars[0]);
            }
            int res = 0;
            int i = 0, j = 1;
            while (j < chars.length) {
                if (characters.contains(chars[j])) {
                    res = Math.max(res, j - i);
                    characters.remove(chars[i]);
                    i++;
                } else {
                    characters.add(chars[j]);
                    j++;
                }
            }
            return Math.min(s.length(), Math.max(res, j - i));
        }
    }

    //4 寻找两个正序数组的中位数 todo 时间复杂度
    class Solution4 {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int i = 0;
            int j = 0;
            int[] nums3 = new int[nums1.length + nums2.length];
            for (int n = 0; n < nums3.length; n++) {
                if (i < nums1.length && j < nums2.length) {
                    if (nums1[i] <= nums3[j]) {
                        nums3[n] = nums1[i];
                        i++;
                    } else {
                        nums3[n] = nums2[j];
                        j++;
                    }
                } else if (i == nums1.length) {
                    nums3[n] = nums2[j];
                    j++;
                } else {
                    nums3[n] = nums1[i];
                    i++;
                }
            }
            int i1 = nums1.length + nums2.length;
            if (i1 % 2 == 1) {
                return nums3[i1 / 2];
            } else {
                return (nums3[i1 / 2] + nums3[i1 / 2 + 1]) / 2.0;
            }
        }
    }

    //5 最长回文字串
    class Solution5 {
        public String longestPalindrome(String s) {
            int length = s.length();
            String res = s.substring(0, 1);
            int[][] resp = new int[length][length];
            for (int i = 0; i < length; i++) {
                resp[i][i] = 1;
            }
            int i = 0;
            for (int j = 1; j < length; ) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 3) {
                        resp[i][j] = 1;
                        res = s.substring(i, j + 1).length() > res.length() ? s.substring(i, j + 1) : res;
                    } else {
                        resp[i][j] = resp[i + 1][j - 1];
                        if (resp[i][j] == 1) {
                            res = s.substring(i, j + 1).length() > res.length() ? s.substring(i, j + 1) : res;
                        }
                    }
                } else {
                    resp[i][j] = 0;
                }
                if (i < j) {
                    i++;
                } else {
                    i = 0;
                    j++;
                }
            }
            return res;
        }
    }

    //6 N 字形变换
    class Solution6 {
        public String convert(String s, int numRows) {
            if (numRows == 1) {
                return s;
            }
            ArrayList<StringBuilder> stringBuilders = new ArrayList<StringBuilder>();
            for (int i = 0; i < numRows; i++) {
                stringBuilders.add(new StringBuilder());
            }
            int j = 0;
            int flag = -1;
            for (int i = 0; i < s.length(); i++) {
                stringBuilders.get(j).append(s.charAt(i));
                if (j == 0 || j == numRows - 1) {
                    flag = -flag;
                }
                j += flag;
            }
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < numRows; i++) {
                res.append(stringBuilders.get(i));
            }
            return res.toString();
        }
    }

    //7 整数反转
    class Solution7 {
        public int reverse(int x) {
            int res = 0;
            while (x != 0) {
                if (res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10) {
                    return 0;
                }
                res *= 10;
                res += x % 10;
                x = x / 10;
            }
            return res;
        }
    }

    //8 字符串转换整数 (atoi)
    class Solution8 {
        public int myAtoi(String s) {
            if (s.length() == 0) {
                return 0;
            }
            int i = 0;
            while (s.charAt(i) == ' ') {
                i++;
                if (i == s.length()) {
                    break;
                }
            }
            if (i == s.length()) {
                return 0;
            }
            int flag = 1;
            int res = 0;
            char c = s.charAt(i);
            if (c == '-') {
                flag = -1;
                i++;
            } else if (c == '+') {
                flag = 1;
                i++;
            }
            if (i == s.length()) {
                return 0;
            }
            while (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                if (flag == 1) {
                    if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && s.charAt(i) - '0' >= 7)) {
                        res = Integer.MAX_VALUE;
                        return res;
                    }
                } else {
                    if (res * flag < Integer.MIN_VALUE / 10 || (res * flag == Integer.MIN_VALUE / 10 && s.charAt(i) - '0' >= 8)) {
                        res = Integer.MIN_VALUE;
                        return res;
                    }
                }
                res *= 10;
                res += s.charAt(i) - '0';
                i++;
                if (i == s.length()) {
                    break;
                }
            }
            return res * flag;
        }
    }

    //9 回文数
    class Solution9 {
        public boolean isPalindrome(int x) {
            int f = x;
            if (x < 0)
                return false;
            int res = 0;
            while (x != 0) {
                if (res > Integer.MAX_VALUE / 10) {
                    return false;
                }
                res *= 10;
                res += x % 10;
                x /= 10;
            }
            return res == f;
        }
    }

    //10 正则表达式匹配
    class Solution10 {
        public boolean isMatch(String s, String p) {
            int m = s.length() + 1, n = p.length() + 1;
            boolean[][] dp = new boolean[m][n];
            dp[0][0] = true;
            // 初始化首行 相当于把前面的给消掉
            for(int j = 2; j < n; j += 2)
                dp[0][j] = dp[0][j - 2] && p.charAt(j - 1) == '*';
            // 状态转移
            for(int i = 1; i < m; i++) {
                for(int j = 1; j < n; j++) {
                    if (p.charAt(j - 1) == '*') {
                        if (dp[i][j - 2]) dp[i][j] = true;                                            // 1.
                        else if (dp[i - 1][j] && s.charAt(i - 1) == p.charAt(j - 2)) dp[i][j] = true; // 2.
                        else if (dp[i - 1][j] && p.charAt(j - 2) == '.') dp[i][j] = true;             // 3.
                    } else {
                        if (dp[i - 1][j - 1] && s.charAt(i - 1) == p.charAt(j - 1)) dp[i][j] = true;  // 1.
                        else if (dp[i - 1][j - 1] && p.charAt(j - 1) == '.') dp[i][j] = true;         // 2.
                    }
                }
            }
            return dp[m - 1][n - 1];
        }
    }

    //11 盛最多水的容器
    class Solution11 {
        public int maxArea(int[] height) {
            int i=0;
            int j=height.length-1;
            int res=0;
            while(i<=j){
                res=Math.max(res,Math.min(height[j],height[i])*(j-i));
                if(height[j]<height[i]){
                    j--;
                }else{
                    i++;
                }
            }
            return res;
        }
    }

    //12 整数转罗马数字
    class Solution12 {
        public String intToRoman(int num) {
            StringBuilder res=new StringBuilder();
            while(num!=0) {
                if (num >= 1000) {
                    num-=1000;
                    res.append("M");
                } else if (num >= 500) {
                    if(num>=900){
                        num-=900;
                        res.append("CM");
                    }else{
                        num-=500;
                        res.append("D");
                    }
                } else if (num >= 100) {
                    if(num>=400){
                        num-=400;
                        res.append("CD");
                    }else{
                        num-=100;
                        res.append("C");
                    }
                } else if (num >= 50) {
                    if(num>=90){
                        num-=90;
                        res.append("XC");
                    }else{
                        num-=50;
                        res.append("L");
                    }
                } else if (num >= 10) {
                    if(num>=40){
                        num-=40;
                        res.append("XL");
                    }else{
                        num-=10;
                        res.append("X");
                    }
                } else if (num >= 5) {
                    if(num>=9){
                        num-=9;
                        res.append("IX");
                    }else{
                        num-=5;
                        res.append("V");
                    }
                }else if (num >= 1) {
                    if(num>=4){
                        num-=4;
                        res.append("IV");
                    }else{
                        num-=1;
                        res.append("I");
                    }
                }
            }
            return res.toString();
        }
    }

    //13 罗马数字转整数
    class Solution13 {
        public int romanToInt(String s) {
            HashMap<String, Integer> stringIntegerHashMap = new HashMap<String, Integer>();
            stringIntegerHashMap.put("I",1);
            stringIntegerHashMap.put("IV",4);
            stringIntegerHashMap.put("V",5);
            stringIntegerHashMap.put("IX",9);
            stringIntegerHashMap.put("X",10);
            stringIntegerHashMap.put("XL",40);
            stringIntegerHashMap.put("L",50);
            stringIntegerHashMap.put("XC",90);
            stringIntegerHashMap.put("C",100);
            stringIntegerHashMap.put("CD",400);
            stringIntegerHashMap.put("D",500);
            stringIntegerHashMap.put("CM",900);
            stringIntegerHashMap.put("M",1000);
            int res=0;
            for(int i=0;i<s.length();i++){
                Integer integer =null;
                if(i+2<=s.length()) {
                    integer = stringIntegerHashMap.get(s.substring(i, i + 2));
                }
                if(integer!=null){
                    res+=integer;
                    i++;
                }else{
                    res+=stringIntegerHashMap.get(s.substring(i, i + 1));
                }
            }
            return res;
        }
    }

    //14 最长公共前缀
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            int i=0;
            HashSet<Character> characters = new HashSet<Character>();
            int j=0;
            char size=' ';
            while(j<strs.length){
                if(i==strs[j].length()){
                    break;
                }
                if(j==0){
                    size=strs[j].charAt(i);
                }else{
                    if(size!=strs[j].charAt(i)){
                        break;
                    }
                }
                j++;
                if(j==strs.length){
                    j=0;
                    i++;
                }
            }
            return strs[0].substring(0,i);
        }
    }
}
