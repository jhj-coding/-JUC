package com.jhj.algorithm.leetcode;

import java.util.*;

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
        public boolean isMatch1(String s, String p) {
            int m = s.length() + 1, n = p.length() + 1;
            boolean[][] dp = new boolean[m][n];
            dp[0][0] = true;
            // 初始化首行 相当于把前面的给消掉
            for (int j = 2; j < n; j += 2)
                dp[0][j] = dp[0][j - 2] && p.charAt(j - 1) == '*';
            // 状态转移
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
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
        public boolean isMatch2(String s, String p) {
            int slen = s.length() + 1;
            int plen=p.length()+1;
            boolean[][] f = new boolean[slen][plen];
            f[0][0]=true;
            s=" "+s;
            p=" "+p;
            char[] schars = s.toCharArray();
            char[] pchars = p.toCharArray();
            for(int i=0;i<slen;i++){
                for(int j=1;j<plen;j++){
                    if(j+1<plen&&p.charAt(j+1)=='*'&&p.charAt(j)!='*'){
                        continue;
                    }
                    if(pchars[j]!='*'){
                        f[i][j]= (p.charAt(j)==s.charAt(i)||p.charAt(j)=='.')&&(i-1>=0&&f[i-1][j-1]);
                    }else{
                        f[i][j]=(j-2>=0&&f[i][j-2])||(i-1>=0&&f[i-1][j]&&(s.charAt(i)==p.charAt(j-1)||p.charAt(j-1)=='.'));
                    }
                }
            }
            return f[slen-1][plen-1];
        }
    }

    //11 盛最多水的容器
    class Solution11 {
        public int maxArea(int[] height) {
            int i = 0;
            int j = height.length - 1;
            int res = 0;
            while (i <= j) {
                res = Math.max(res, Math.min(height[j], height[i]) * (j - i));
                if (height[j] < height[i]) {
                    j--;
                } else {
                    i++;
                }
            }
            return res;
        }
    }

    //12 整数转罗马数字
    class Solution12 {
        public String intToRoman(int num) {
            StringBuilder res = new StringBuilder();
            while (num != 0) {
                if (num >= 1000) {
                    num -= 1000;
                    res.append("M");
                } else if (num >= 500) {
                    if (num >= 900) {
                        num -= 900;
                        res.append("CM");
                    } else {
                        num -= 500;
                        res.append("D");
                    }
                } else if (num >= 100) {
                    if (num >= 400) {
                        num -= 400;
                        res.append("CD");
                    } else {
                        num -= 100;
                        res.append("C");
                    }
                } else if (num >= 50) {
                    if (num >= 90) {
                        num -= 90;
                        res.append("XC");
                    } else {
                        num -= 50;
                        res.append("L");
                    }
                } else if (num >= 10) {
                    if (num >= 40) {
                        num -= 40;
                        res.append("XL");
                    } else {
                        num -= 10;
                        res.append("X");
                    }
                } else if (num >= 5) {
                    if (num >= 9) {
                        num -= 9;
                        res.append("IX");
                    } else {
                        num -= 5;
                        res.append("V");
                    }
                } else if (num >= 1) {
                    if (num >= 4) {
                        num -= 4;
                        res.append("IV");
                    } else {
                        num -= 1;
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
            stringIntegerHashMap.put("I", 1);
            stringIntegerHashMap.put("IV", 4);
            stringIntegerHashMap.put("V", 5);
            stringIntegerHashMap.put("IX", 9);
            stringIntegerHashMap.put("X", 10);
            stringIntegerHashMap.put("XL", 40);
            stringIntegerHashMap.put("L", 50);
            stringIntegerHashMap.put("XC", 90);
            stringIntegerHashMap.put("C", 100);
            stringIntegerHashMap.put("CD", 400);
            stringIntegerHashMap.put("D", 500);
            stringIntegerHashMap.put("CM", 900);
            stringIntegerHashMap.put("M", 1000);
            int res = 0;
            for (int i = 0; i < s.length(); i++) {
                Integer integer = null;
                if (i + 2 <= s.length()) {
                    integer = stringIntegerHashMap.get(s.substring(i, i + 2));
                }
                if (integer != null) {
                    res += integer;
                    i++;
                } else {
                    res += stringIntegerHashMap.get(s.substring(i, i + 1));
                }
            }
            return res;
        }
    }

    //14 最长公共前缀
    class Solution14 {
        public String longestCommonPrefix(String[] strs) {
            int i = 0;
            HashSet<Character> characters = new HashSet<Character>();
            int j = 0;
            char size = ' ';
            while (j < strs.length) {
                if (i == strs[j].length()) {
                    break;
                }
                if (j == 0) {
                    size = strs[j].charAt(i);
                } else {
                    if (size != strs[j].charAt(i)) {
                        break;
                    }
                }
                j++;
                if (j == strs.length) {
                    j = 0;
                    i++;
                }
            }
            return strs[0].substring(0, i);
        }
    }

    //15 三数之和
    class Solution15 {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    if (nums[i] + nums[left] + nums[right] > 0) {
                        right--;
                    } else if (nums[i] + nums[left] + nums[right] < 0) {
                        left++;
                    } else {
                        List<Integer> ints = Arrays.asList(new Integer[]{nums[i], nums[left], nums[right]});
                        res.add(ints);
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (nums[right] == nums[right - 1] && left < right) {
                            right--;
                        }
                        left++;
                        right--;
                    }
                }
            }
            return res;
        }
    }

    //16 最接近的三数之和
    class Solution16 {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int res = Integer.MAX_VALUE;
            int res1 = 0;
            for (int i = 0; i < nums.length; i++) {
                int l = i + 1;
                int r = nums.length - 1;
                while (l < r) {
                    if (nums[i] + nums[l] + nums[r] - target == 0) {
                        return nums[i] + nums[l] + nums[r];
                    } else if (nums[i] + nums[l] + nums[r] - target > 0) {
                        res = Math.min(res, Math.abs(nums[i] + nums[l] + nums[r] - target));
                        if (res == Math.abs(nums[i] + nums[l] + nums[r] - target)) {
                            res1 = nums[i] + nums[l] + nums[r];
                        }
                        r--;
                    } else {
                        res = Math.min(res, Math.abs(nums[i] + nums[l] + nums[r] - target));
                        if (res == Math.abs(nums[i] + nums[l] + nums[r] - target)) {
                            res1 = nums[i] + nums[l] + nums[r];
                        }
                        l++;
                    }
                }
            }
            return res1;
        }
    }

    //17 电话号码的字母组合
    class Solution17 {
        List<String> res = new ArrayList<String>();

        public List<String> letterCombinations(String digits) {
            if (digits.length() == 0) {
                return res;
            }
            HashMap<Character, String> characterStringHashMap = new HashMap<Character, String>();
            characterStringHashMap.put('2', "abc");
            characterStringHashMap.put('3', "def");
            characterStringHashMap.put('4', "ghi");
            characterStringHashMap.put('5', "jkl");
            characterStringHashMap.put('6', "mno");
            characterStringHashMap.put('7', "pqrs");
            characterStringHashMap.put('8', "tuv");
            characterStringHashMap.put('9', "wxyz");
            huisu(digits, 0, characterStringHashMap, new StringBuilder());
            return res;
        }

        public void huisu(String digits, int index, HashMap<Character, String> characterStringHashMap, StringBuilder stringBuilder) {
            if (index == digits.length()) {
                res.add(stringBuilder.toString());
                return;
            }
            String s = characterStringHashMap.get(digits.charAt(index));
            for (int i = 0; i < s.length(); i++) {
                stringBuilder.append(s.charAt(i));
                huisu(digits, index + 1, characterStringHashMap, stringBuilder);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
        }

        ;
    }

    //18 四数之和
    class Solution18 {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                for (int j = i + 1; j < nums.length; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }
                    int left = j + 1;
                    int right = nums.length - 1;
                    while (left < right) {
                        long i1 = (long) nums[i] + nums[j] + nums[left] + nums[right];
                        if (i1 == target) {
                            res.add(Arrays.asList(new Integer[]{nums[i], nums[j], nums[left], nums[right]}));
                            while (left < right && nums[left] == nums[left + 1]) {
                                left++;
                            }
                            while (left < right && nums[right] == nums[right - 1]) {
                                right--;
                            }
                            left++;
                            right--;
                        } else if (i1 < target) {
                            left++;
                        } else {
                            right--;
                        }
                    }
                }
            }
            return res;
        }
    }

    //19 删除链表的倒数第 N 个结点
    class Solution19 {
        public class ListNode {
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

        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode vhead = new ListNode(-1, head);
            ListNode first = head;
            ListNode second = head;
            ListNode pre = vhead;
            for (int i = 0; i < n; i++) {
                first = first.next;
            }
            while (first != null) {
                pre = pre.next;
                second = second.next;
                first = first.next;
            }
            pre.next = second.next;
            return vhead.next;
        }
    }

    //20 有效的括号
    class Solution20 {

        public boolean isValid(String s) {
            Deque<Character> characters = new ArrayDeque<Character>();
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    characters.addFirst(')');
                } else if (c == '{') {
                    characters.addFirst('}');
                } else if (c == '[') {
                    characters.addFirst(']');
                } else {
                    if (characters.peekFirst() != null && c == characters.peekFirst()) {
                        characters.removeFirst();
                    } else {
                        return false;
                    }
                }
            }
            return characters.isEmpty();
        }
    }

    //21 合并两个有序链表
    class Solution21 {
        public class ListNode {
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

        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode res = new ListNode();
            ListNode curList1 = list1;
            ListNode curList2 = list2;
            ListNode curres = res;
            while (curList1 != null || curList2 != null) {
                if (curList1 != null && curList2 != null) {
                    if (curList1.val < curList2.val) {
                        curres.next = new ListNode(curList1.val);
                        curList1 = curList1.next;
                        curres = curres.next;
                    } else if (curList1.val > curList2.val) {
                        curres.next = new ListNode(curList2.val);
                        curList2 = curList2.next;
                        curres = curres.next;
                    } else {
                        curres.next = new ListNode(curList1.val);
                        curList1 = curList1.next;
                        curres = curres.next;
                        curres.next = new ListNode(curList2.val);
                        curList2 = curList2.next;
                        curres = curres.next;
                    }
                } else if (curList1 != null && curList2 == null) {
                    curres.next = new ListNode(curList1.val);
                    curList1 = curList1.next;
                    curres = curres.next;
                } else if (curList1 == null && curList2 != null) {
                    curres.next = new ListNode(curList2.val);
                    curList2 = curList2.next;
                    curres = curres.next;
                }
            }
            return res.next;
        }
    }

    //22 括号生成
    class Solution22 {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            huisu(res, new StringBuilder(), 0, 0, n);
            return res;
        }

        public void huisu(List<String> res, StringBuilder stringBuilder, int left, int right, int n) {
            if (left + right == 2 * n) {
                res.add(stringBuilder.toString());
            }
            if (left < n) {
                stringBuilder.append('(');
                huisu(res, stringBuilder, left + 1, right, n);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }

            if (right < left) {
                stringBuilder.append(')');
                huisu(res, stringBuilder, left, right + 1, n);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
        }
    }

    //23 合并k个升序链表
    class Solution23 {
        public class ListNode {
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

        public ListNode mergeKLists(ListNode[] lists) {
            return merge(lists, 0, lists.length - 1);
        }

        public ListNode merge(ListNode[] lists, int left, int right) {
            if (left == right) {
                return lists[left];
            }
            if (left > right) {
                return null;
            }
            int mid = (left + right) / 2;
            return twoMerge(merge(lists, left, mid), merge(lists, mid + 1, right));
        }

        public ListNode twoMerge(ListNode first, ListNode second) {
            if (first == null || second == null) {
                return first != null ? first : second;
            }
            ListNode res = new ListNode();
            ListNode cur1 = first, cur2 = second, cur3 = res;
            while (cur1 != null && cur2 != null) {

                if (cur1.val < cur2.val) {
                    cur3.next = new ListNode(cur1.val);
                    cur1 = cur1.next;
                } else {
                    cur3.next = new ListNode(cur2.val);
                    cur2 = cur2.next;
                }
                cur3 = cur3.next;
            }
            cur3.next = cur1 != null ? cur1 : cur2;
            return res.next;
        }


    }

    //24 两两交换链表中的节点
    class Solution24 {
        public class ListNode {
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

        public ListNode swapPairs(ListNode head) {
            ListNode phead = new ListNode(-1, head);
            ListNode cur = phead;
            while (cur.next != null && cur.next.next != null) {
                ListNode next = cur.next;
                ListNode next1 = cur.next.next.next;
                cur.next = cur.next.next;
                cur.next.next = next;
                cur.next.next.next = next1;
                cur = cur.next.next;
            }
            return phead.next;
        }
    }

    //25 K 个一组翻转链表 画图写谁变为谁
    class Solution25 {
        public class ListNode {
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

        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode listNode = new ListNode(0, head);
            ListNode cur=head;
            int count=0;
            while(cur!=null){
                cur=cur.next;
                count++;
            }
            ListNode pre=null;
            ListNode curr=head;
            ListNode p0=listNode;
            for(int i=count;count>=k;count-=k){
                for (int j=0;j<k;j++) {
                    ListNode currr = curr.next;
                    curr.next = pre;
                    pre = curr;
                    curr = currr;
                }
                ListNode next = p0.next;
                p0.next.next=curr;
                p0.next=pre;
                p0=next;
            }
            return listNode.next;
        }
    }

    //26 删除有序数组中的重复项
    class Solution26 {
        public int removeDuplicates(int[] nums) {
            int j=0;
            for(int i=1;i<nums.length;i++){
                if(nums[i]==nums[j]){

                }else{
                    nums[j+1]=nums[i];
                    j++;
                }
            }
            return j+1;
        }
    }

    //27 移除元素
    class Solution27 {
        public int removeElement(int[] nums, int val) {
            int j=0;
            for(int i=0;i<nums.length;i++){
                if(nums[i]==val){

                }else {
                    nums[j]=nums[i];
                    j++;
                }
            }
            return j;
        }
    }

    //28 找出字符串中第一个匹配项的下标 KMP
    static class Solution28 {
        public int strStr(String haystack, String needle) {
            int needlength = needle.length();
            int[] next = new int[needlength];
            int j=0;
            next[0]=j;
            for(int i=1;i<needlength;i++){
                while (j>0&&needle.charAt(i)!=needle.charAt(j)){
                    j=next[j-1];
                }
                if(needle.charAt(i)==needle.charAt(j)){
                    j++;
                }
                next[i]=j;
            }
            int i=0;
            j=0;
            while (i<haystack.length()){
                while (j>0&&haystack.charAt(i)!=needle.charAt(j)){
                    j=next[j-1];
                }
                if(haystack.charAt(i)==needle.charAt(j)){
                    j++;
                }
                if(j==needlength){
                    return i-j+1;
                }
                i++;
            }
            return -1;
        }
    }

    //29 两数相除 减最大 两倍两倍 减少时间复杂度 倍增法 奇数加
    class Solution29 {
        public int divide(int dividend, int divisor) {
            boolean flag=false;
            if(dividend>0){
                flag=!flag;
                dividend=-dividend;
            }
            if(divisor>0){
                flag=!flag;
                divisor=-divisor;
            }
            int count=0;
            while (dividend<=divisor){
                int temp=divisor;
                int times=1;
                while (temp>=(Integer.MIN_VALUE>>1)&&dividend<=(temp<<1)){
                    temp<<=1;
                    times<<=1;
                }
                dividend-=temp;
                count-=times;
            }
            if(count==Integer.MIN_VALUE && !flag){
                return Integer.MAX_VALUE;
            }
            return flag?count:-count;
        }
    }

    //30 串联所有单词的子串
    class Solution30 {
        public List<Integer> findSubstring(String s, String[] words) {
            HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                stringIntegerHashMap.put(words[i], stringIntegerHashMap.getOrDefault(words[i], 0) + 1);
            }
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                int i1 = words[0].length() * words.length;
                if (s.length() - i < i1) {
                    break;
                }
                HashMap<String, Integer> stringIntegerHashMap1 = new HashMap<>(stringIntegerHashMap);
                boolean flag = true;
                for (int j = i; j < i1 + i; j += words[0].length()) {
                    Integer integer = stringIntegerHashMap1.get(s.substring(j, j + words[0].length()));
                    if (integer == null || integer == 0) {
                        flag = false;
                        break;
                    } else {
                        stringIntegerHashMap1.put(s.substring(j, j + words[0].length()), integer - 1);
                    }
                }
                if (flag) {
                    res.add(i);
                }
            }

            return res;
        }
    }

    //31. 下一个排列 todo 不会 多看几遍
    class Solution31 {
        public void nextPermutation(int[] nums) {
            int i = nums.length - 2;
            while (i >= 0 && nums[i] >= nums[i + 1]) {
                i--;
            }
            if (i >= 0) {
                int j = nums.length - 1;
                while (j >= 0 && nums[i] >= nums[j]) {
                    j--;
                }
                swap(nums, i, j);
            }
            reverse(nums, i + 1);
        }

        public void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        public void reverse(int[] nums, int start) {
            int left = start, right = nums.length - 1;
            while (left < right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
    }

    //32. 最长有效括号
    class Solution32 {
        public int longestValidParentheses(String s) {
            int res=0;
            //每次记录的都是右的位置
            ArrayDeque<Integer> objects = new ArrayDeque<Integer>();
            objects.addFirst(-1);
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='('){
                    objects.addFirst(i);
                }else{
                    objects.removeFirst();
                    if(objects.isEmpty()){
                        objects.addFirst(i);
                    }else {
                        res = Math.max(res, i - objects.peekFirst().intValue());
                    }
                }
            }
            return res;
        }
    }

    //33. 搜索旋转排序数组
    class Solution33 {
        public int search(int[] nums, int target) {
            int left=0;
            int right=nums.length-1;
            while (left<=right){
                int mid=(left+right)/2;
                if(nums[mid]==target){
                    return mid;
                }
                if(nums[0]<=nums[mid]){
                    if(nums[0]<=target&&target<nums[mid]){
                        right=mid-1;
                    }else {
                        left=mid+1;
                    }
                }else{
                    if(target>nums[mid]&&target<=nums[nums.length-1]){
                        left=mid+1;
                    }else{
                        right=mid-1;
                    }
                }
            }
            return -1;
        }
    }

    //34. 在排序数组中查找元素的第一个和最后一个位置
    class Solution34 {
        public int[] searchRange(int[] nums, int target) {
            int left=0;
            int right=nums.length-1;
            int res=-2;
            int res2=-2;
            while(left<=right){
                int mid=(left+right)>>1;
                if(nums[mid]>=target){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }
            res=right+1;
            left=0;
            right=nums.length-1;
            while(left<=right){
                int mid=(left+right)>>1;
                if(nums[mid]>target){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }
            res2=left-1;
            if(nums.length>0 && res>=0 && res2<nums.length && res<=res2 && nums[res]==target){
                return new int[]{res,res2};
            }
            else{
                return new int[]{-1,-1};
            }
        }
    }

    //35. 搜索插入位置
    class Solution35 {
        public int searchInsert(int[] nums, int target) {
            int left=0;
            int right=nums.length-1;
            while (left<=right){
                int mid=(left+right)>>1;
                if(nums[mid]>target){
                    right=mid-1;
                }else if(nums[mid]==target){
                    return mid;
                }else{
                    left=mid+1;
                }
            }
            return left;
        }
    }

    //36. 有效的数独
    class Solution36 {
        public boolean isValidSudoku(char[][] board) {
            int[][] hang = new int[9][9];
            int[][] lie = new int[9][9];
            int[][][] th = new int[3][3][9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    char c = board[i][j];
                    if (c != '.') {
                        int i1 = c - '0' - 1;
                        hang[i][i1]++;
                        lie[j][i1]++;
                        th[i / 3][j / 3][i1]++;
                        if (hang[i][i1] > 1 ||
                                lie[j][i1] > 1 ||
                                th[i / 3][j / 3][i1] > 1) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
    }

    //37. 解数独 9*9 暴力回溯 放这个地方
    class Solution37 {
        boolean[][] hang = new boolean[9][9];
        boolean[][] lie = new boolean[9][9];
        boolean[][][] fangkuai = new boolean[3][3][9];
        ArrayList<int[]> ints = new ArrayList<>();
        boolean vaild=false;
        public void solveSudoku(char[][] board) {
            for(int i=0;i<9;i++){
                for (int j=0;j<9;j++){
                    if(board[i][j]=='.'){
                        ints.add(new int[]{i,j});
                    }else{
                        int i1 = board[i][j] - '0' - 1;
                        hang[i][i1]=lie[j][i1]=fangkuai[i/3][j/3][i1]=true;
                    }
                }
            }
            dfs(board,0);
        }

        private void dfs(char[][] board, int i) {
            if(i==ints.size()){
                vaild=true;
                return;
            }
            int[] ints = this.ints.get(i);
            int anInt = ints[0];
            int anInt1 = ints[1];
            for(int di=0;di<9 && !vaild;di++){
                if(!hang[anInt][di]&&!lie[anInt1][di]&&!fangkuai[anInt/3][anInt1/3][di])
                {
                    hang[anInt][di]=lie[anInt1][di]=fangkuai[anInt/3][anInt1/3][di]=true;
                    board[anInt][anInt1]=(char) (di+1+'0');
                    dfs(board,i+1);
                    hang[anInt][di]=lie[anInt1][di]=fangkuai[anInt/3][anInt1/3][di]=false;
                }

            }
        }
    }

    //38. 外观数列
    class Solution38 {
        String[] strings=new String[31];
        public String countAndSay(int n) {
            strings[1]="1";
            return digui(n);
        }

        public String digui(int n) {
            if (strings[n]!=null){
                return strings[n];
            }
            String s="";
            while (n>1){
                s=digui(n-1);
                if(s!=null){
                    break;
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            int res=0;
            char c = s.charAt(0);
            for(int i=1;i<s.length();i++){
                if(c==s.charAt(i)){
                    res++;
                }else {
                    stringBuilder.append(res+1);
                    stringBuilder.append(c);
                    res=0;
                    c=s.charAt(i);
                }
            }
            stringBuilder.append(res+1);
            stringBuilder.append(c);
            strings[n]=stringBuilder.toString();
            return strings[n];
        }

    }

    //39. 组合总和
    class Solution39 {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> res=new ArrayList<List<Integer>>();
            int length=candidates.length;
            if(length<=0){
                return res;
            }
            ArrayList<Integer> integers = new ArrayList<>();
            dfs(candidates,0,length,integers,res,target);
            return res;
        }
        public void dfs(int[] candidates,int begin,int end,List<Integer> path,List<List<Integer>> res,int target){
            if(target<0){
                return;
            }
            if(target==0){
                res.add(new ArrayList<>(path));
                return;
            }
            for(int i=begin;i<end;i++){
                path.add(candidates[i]);
                dfs(candidates,i,end,path,res,target-candidates[i]);
                path.remove(path.size()-1);
            }
        }
    }

    //40. 组合总和 II
    class Solution40 {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            Arrays.sort(candidates);
            dfs(candidates,0,candidates.length,new ArrayList<Integer>(),res,target);
            return res;
        }
        public void dfs(int[] candidates,int begin,int end,ArrayList<Integer> path,List<List<Integer>> res ,int target){
            if(target<0){
                return;
            }
            if(target==0){
                res.add(new ArrayList<>(path));
            }
            for (int i=begin;i<end;i++) {
                if ( i > begin && candidates[i] == candidates[i - 1] ) {
                    continue;
                }
                path.add(candidates[i]);
                dfs(candidates, i+1, end, path, res, target-candidates[i]);
                path.remove(path.size() - 1);
            }
        }
    }

    //41. 缺失的第一个正数 没有出现的正整数为1~N+1中 这个数出现了 这个位置有个标记
    class Solution41 {
        public int firstMissingPositive(int[] nums) {
            for(int i=0;i<nums.length;i++){
                if(nums[i]<=0){
                    nums[i]=nums.length+1;
                }
            }
            for(int i=0;i<nums.length;i++){
                int num=Math.abs(nums[i]);
                if(num<=nums.length){
                    nums[num-1]=-Math.abs(nums[num-1]);
                }
            }
            for(int i=0;i<nums.length;i++){
                if(nums[i]>0){
                    return i+1;
                }
            }
            return nums.length+1;
        }
    }

    //42. 接雨水
    class Solution42 {
        //解法1 最大数组
        public int trap1(int[] height) {
            int[] left = new int[height.length];
            int[] right = new int[height.length];
            left[0]=height[0];
            for(int i=1;i<height.length;i++){
                left[i]=Math.max(height[i],left[i-1]);
            }
            right[height.length-1]=height[height.length-1];
            for(int i=height.length-2;i>=0;i--){
                right[i]=Math.max(height[i],right[i+1]);
            }

            int res=0;
            for(int i=0;i<height.length;i++){
                res+=Math.max(0,Math.min(left[i],right[i])-height[i]);
            }
            return res;
        }
        //单调栈 从大到小
        public int trap(int[] height) {
            if(height.length<=2){
                return 0;
            }
            ArrayDeque<Integer> integers = new ArrayDeque<>();
            integers.addLast(0);
            int res=0;
            for (int i=1;i<height.length;i++){
                Integer integer = integers.peekLast();
                if(height[i]<height[integer]){
                    integers.addLast(i);
                }else if(height[i]==height[integer]){
                    integers.removeLast();
                    integers.addLast(i);
                }else{
                    while (!integers.isEmpty()&&height[integer]<height[i]){
                        Integer integer1 = integers.removeLast();
                        if(!integers.isEmpty()){
                            Integer peek = integers.peekLast();
                            int h = Math.min(height[peek], height[i]) - height[integer1];
                            int i1 = i - peek - 1;
                            res+=Math.max(0,h*i1);
                            integer=integers.peekLast();
                        }
                    }
                    integers.addLast(i);
                }
            }
            return res;
        }
    }

    //43. 字符串相乘 注意分完之后 数组0 表示最高位
    class Solution43 {
        public String multiply(String num1, String num2) {
            int length1 = num1.length();
            int length2 = num2.length();
            int[] ints1 = new int[length1];
            int[] ints2 = new int[length2];
            for(int i=0;i<length1;i++){
                ints1[i]=num1.charAt(i)-'0';
            }
            for(int i=0;i<length2;i++){
                ints2[i]=num2.charAt(i)-'0';
            }
            int[] ints = new int[length1 + length2];
            for(int i=0;i<length1;i++){
                for (int j=0;j<length2;j++){
                    ints[i+j+1]+=ints1[i]*ints2[j];
                }
            }
            int m=0;
            for(int i=length1 + length2-1;i>=0;i--){
                ints[i]+=m;
                m=ints[i]/10;
                ints[i]%=10;
                System.out.println(ints[i]);
            }
            int j=0;
            while (j<length1+length2&&ints[j]==0){
                j++;
            }
            StringBuilder res = new StringBuilder();
            for(int i=j;i<length1+length2;i++){
                res.append(ints[i]);
            }
            return res.length()==0?"0":res.toString();
        }
    }

    //44. 通配符匹配
    class Solution44 {
        public boolean isMatch(String s, String p) {
            int slen = s.length() + 1;
            int plen=p.length()+1;
            boolean[][] f = new boolean[slen][plen];
            f[0][0]=true;
            s=" "+s;
            p=" "+p;
            char[] schars = s.toCharArray();
            char[] pchars = p.toCharArray();
            for(int i=0;i<slen;i++){
                for(int j=1;j<plen;j++){
                    if(pchars[j]=='*'){
                        f[i][j]= f[i][j-1] || (i-1>=0&&f[i-1][j]);
                    }else{
                        f[i][j]=i-1>=0&&f[i-1][j-1]&&(schars[i]==pchars[j]||pchars[j]=='?');
                    }
                }
            }
            return f[slen-1][plen-1];
        }
    }

    //45. 跳跃游戏 II
    class Solution45 {
        public int jump(int[] nums) {
            int res=0;
            int sum=0;
            int end=0;
            for(int i=0;i<nums.length-1;i++){
                sum=Math.max(sum,i+nums[i]);
                if(i==end){
                    end=sum;
                    res++;
                }
            }
            return res;
        }
    }

    //46. 全排列
    class Solution46 {
        public List<List<Integer>> permute(int[] nums) {
            ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
            huisu(new ArrayList<>(),res,nums);
            return res;
        }

        public void huisu(ArrayList<Integer> path,List<List<Integer>> res,int[] nums) {
            HashSet<Integer> integers = new HashSet<>(path);
            if (integers.size()==nums.length){
                res.add(new ArrayList<Integer>(path));
                return;
            }
            for(int i=0;i<nums.length;i++){
                if(!integers.contains(nums[i])){
                    path.add(nums[i]);
                    huisu(path,res,nums);
                    path.remove(path.size()-1);
                }
            }
        }
    }

    //全排列 II
    class Solution47 {
        public List<List<Integer>> permuteUnique(int[] nums) {
            HashSet<List<Integer>> res = new HashSet<>();
            huisu(new HashSet<Integer>(),new ArrayList<Integer>(),res,nums);
            return new ArrayList<>(res);
        }

        public void huisu(HashSet<Integer> indexs,List<Integer> path,HashSet<List<Integer>> res,int[] nums){
            if(indexs.size()==nums.length){
                res.add(new ArrayList<>(path));
                return;
            }
            for (int i=0;i<nums.length;i++){
                if(!indexs.contains(i)){
                    indexs.add(i);
                    path.add(nums[i]);
                    huisu(indexs,path,res,nums);
                    path.remove(path.size()-1);
                    indexs.remove(i);
                }
            }
        }
    }

    //旋转图像
    class Solution48 {
        public void rotate(int[][] matrix) {
            int n=matrix.length;
            for(int i=0;i<n;i++){
                for(int j=0;j<i;j++){
                    int temp=matrix[i][j];
                    matrix[i][j]=matrix[j][i];
                    matrix[j][i]=temp;
                }
            }
            for(int i=0;i<n;i++){
                int j=0;
                int k=n-1;
                while (j<k){
                    int temp=matrix[i][j];
                    matrix[i][j]=matrix[i][k];
                    matrix[i][k]=temp;
                    j++;
                    k--;
                }
            }
        }
    }
}
