package com.jhj.algorithm.nowcoder;

import java.util.*;

public class all {

    //NC1 大数加法
    public class Solution1 {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         * <p>
         * 计算两个数之和
         *
         * @param s string字符串 表示第一个整数
         * @param t string字符串 表示第二个整数
         * @return string字符串
         */
        public String solve(String s, String t) {
            // write code here
            int res = 0;
            StringBuilder stringBuilder = new StringBuilder();
            int slen = s.length();//短的
            int tlen = t.length();
            if (slen > tlen) {
                String ss = t;
                t = s;
                s = ss;
                slen = s.length();
                tlen = t.length();
            }
            for (int i = slen - 1; i >= 0; i--) {
                int j = tlen - (slen - i);
                int i1 = s.charAt(i) - '0';
                int i2 = t.charAt(j) - '0';
                int i3 = i1 + i2 + res;
                res = i3 / 10;
                stringBuilder.insert(0, i3 % 10);
            }
            for (int i = tlen - slen - 1; i >= 0; i--) {
                int i2 = t.charAt(i) - '0';
                int i3 = i2 + res;
                res = i3 / 10;
                stringBuilder.insert(0, i3 % 10);
            }
            if (res != 0) {
                stringBuilder.insert(0, res);
            }
            return stringBuilder.toString();
        }
    }

    //NC2 重排链表
    public class Solution2 {
        class ListNode {
            int val;
            ListNode next;

            ListNode(int x) {
                val = x;
                next = null;
            }
        }

        public void reorderList1(ListNode head) {
            ArrayDeque<ListNode> listNodes = new ArrayDeque<>();
            ListNode cur = head;
            while (cur != null) {
                listNodes.addFirst(cur);
                cur = cur.next;
            }
            int size = listNodes.size();
            int i = size / 2;
            int i1 = size % 2;
            for (int j = 0; j < i; j++) {
                listNodes.removeLast().next = listNodes.peekFirst();
                listNodes.removeFirst().next = listNodes.peekLast();
            }
            if (i1 == 1) {
                listNodes.removeFirst().next = null;
            }
        }

        public void reorderList2(ListNode head) {
            if (head == null) {
                return;
            }
            ListNode low = head;
            ListNode fast = head;
            while (fast.next != null && fast.next.next != null) {
                low = low.next;
                fast = fast.next.next;
            }
            ListNode fir = head;
            ListNode sec = low.next;
            low.next = null;
            ListNode pre = null;
            while (sec != null) {
                ListNode next = sec.next;
                sec.next = pre;
                pre = sec;
                sec = next;
            }

            while (pre != null && fir != null) {
                ListNode next1 = fir.next;
                ListNode next2 = pre.next;
                fir.next = pre;
                pre.next = next1;
                fir = next1;
                pre = next2;
            }

        }
    }

    //NC3 链表中环的入口结点
    public class Solution3 {
        public class ListNode {
            int val;
            ListNode next = null;

            ListNode(int val) {
                this.val = val;
            }
        }

        public ListNode EntryNodeOfLoop(ListNode pHead) {
            ListNode low = pHead;
            ListNode fast = pHead;
            while (fast != null && fast.next != null) {
                low = low.next;
                fast = fast.next.next;
                if (low == fast) {
                    ListNode low1 = pHead;
                    while (low1 != fast) {
                        low1 = low1.next;
                        fast = fast.next;
                    }
                    return low1;
                }
            }
            return null;
        }
    }

    //NC4 判断链表中是否有环
    public class Solution4 {
        class ListNode {
            int val;
            ListNode next;

            ListNode(int x) {
                val = x;
                next = null;
            }
        }

        public boolean hasCycle(ListNode head) {
            ListNode low = head;
            ListNode fast = head;

            while (fast != null && fast.next != null) {
                low = low.next;
                fast = fast.next.next;
                if (low == fast) {
                    return true;
                }
            }
            return false;
        }
    }

    //NC5 二叉树根节点到叶子节点的所有路径和
    public class Solution5 {
        public class TreeNode {
            int val = 0;
            TreeNode left = null;
            TreeNode right = null;

            public TreeNode(int val) {
                this.val = val;
            }

            /**
             * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
             *
             * @param root TreeNode类
             * @return int整型
             */
            int res = 0;

            public int sumNumbers(TreeNode root) {
                // write code here
                tt(root, 0);
                return res;
            }

            public void tt(TreeNode root, int num) {
                num *= 10;
                num += root.val;
                if (root.left != null) {
                    tt(root.left, num);
                }
                if (root.right != null) {
                    tt(root.right, num);
                }
                res += num;
            }
        }
    }

    //NC6 二叉树中的最大路径和
    public class Solution6 {
        public class TreeNode {
            int val = 0;
            TreeNode left = null;
            TreeNode right = null;

            public TreeNode(int val) {
                this.val = val;
            }
        }

        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * @param root TreeNode类
         * @return int整型
         */
        int max = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            // write code here
            if (root == null) {
                return 0;
            }
            maxPath(root);
            return max;
        }

        public int maxPath(TreeNode root) {
            // write code here
            if (root == null) {
                return 0;
            }
            int left = Math.max(maxPath(root.left), 0);
            int right = Math.max(maxPath(root.right), 0);
            max = Math.max(max, root.val + left + right);
            return root.val + Math.max(left, right);
        }

    }

    //NC7 买卖股票的最好时机(一)
    public class Solution7 {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * @param prices int整型一维数组
         * @return int整型
         */
        public int maxProfit(int[] prices) {
            // write code here
            int min = prices[0];
            int res = 0;
            for (int i = 1; i < prices.length; i++) {
                min = Math.min(min, prices[i]);
                res = Math.max(res, prices[i] - min);
            }
            return res;
        }
    }

    //NC8 二叉树中和为某一值的路径(二)
    public class Solution8 {
        public class TreeNode {
            int val = 0;
            TreeNode left = null;
            TreeNode right = null;

            public TreeNode(int val) {
                this.val = val;
            }
        }

        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * @param root   TreeNode类
         * @param target int整型
         * @return int整型ArrayList<ArrayList <>>
         */
        private ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        private LinkedList<Integer> path = new LinkedList<>();

        void dfs(TreeNode root, int number) {
            // 处理树为空
            if (root == null) return;
            // 路径更新
            path.add(root.val);
            // number更新
            number -= root.val;
            // 如果递归当前节点为叶子节点且该条路径的值已经达到了expectNumber，则更新ret
            if (root.left == null && root.right == null && number == 0) {
                ret.add(new ArrayList<>(path));
            }
            // 左右子树递归
            dfs(root.left, number);
            dfs(root.right, number);
            path.removeLast();
        }

        public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int expectNumber) {
            dfs(root, expectNumber);
            return ret;
        }
    }

    //NC9 二叉树中和为某一值的路径(一)
    public class Solution9 {
        public class TreeNode {
            int val = 0;
            TreeNode left = null;
            TreeNode right = null;

            public TreeNode(int val) {
                this.val = val;
            }
        }

        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * @param root TreeNode类
         * @param sum  int整型
         * @return bool布尔型
         */
        public boolean hasPathSum(TreeNode root, int sum) {
            // write code here
            if (root == null) {
                return false;
            }
            sum -= root.val;
            if (sum == 0 && root.left == null && root.right == null) {
                return true;
            }
            boolean b = hasPathSum(root.left, sum);
            boolean a = hasPathSum(root.right, sum);
            return a || b;
        }
    }

    //NC10 大数乘法
    public class Solution10 {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * @param s string字符串 第一个整数
         * @param t string字符串 第二个整数
         * @return string字符串
         */
        public String solve(String s, String t) {
            // write code here
            int[] ints = new int[s.length()];
            int[] ints1 = new int[t.length()];
            for (int i = 0; i < s.length(); i++) {
                ints[i] = s.charAt(i) - '0';
            }
            for (int i = 0; i < t.length(); i++) {
                ints1[i] = t.charAt(i) - '0';
            }
            int[] ints2 = new int[s.length() + t.length()];
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < t.length(); j++) {
                    int i1 = ints[i] * ints1[j];
                    ints2[i + j + 1] += i1;
                }
            }
            int m = 0;
            for (int i = s.length() + t.length() - 1; i >= 0; i--) {
                int i1 = ints2[i] + m;
                ints2[i] = i1 % 10;
                m = i1 / 10;
            }
            StringBuilder stringBuilder = new StringBuilder();
            int j = 0;
            while (j < s.length() + t.length() && ints2[j] == 0) {
                j++;
            }
            for (int i = j; i < s.length() + t.length(); i++) {
                stringBuilder.append(ints2[i]);
            }
            return stringBuilder.length() == 0 ? "0" : stringBuilder.toString();
        }
    }

    //NC11 将升序数组转化为平衡二叉搜索树 找中间 然后左右
    public class Solution11 {
        public class TreeNode {
            int val = 0;
            TreeNode left = null;
            TreeNode right = null;

            public TreeNode(int val) {
                this.val = val;
            }
        }

        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * @param nums int整型一维数组
         * @return TreeNode类
         */
        public TreeNode sortedArrayToBST(int[] nums) {
            // write code here
            return hebing(nums, 0, nums.length - 1);
        }

        public TreeNode hebing(int[] nums, int left, int right) {
            if (left > right) {
                return null;
            }
            int mid = left + ((right - left) / 2);
            TreeNode treeNode = new TreeNode(nums[mid]);
            treeNode.left = hebing(nums, left, mid - 1);
            treeNode.right = hebing(nums, mid + 1, right);
            return treeNode;
        }
    }

    //NC12 重建二叉树
    public class Solution12 {
        public class TreeNode {
            int val = 0;
            TreeNode left = null;
            TreeNode right = null;

            public TreeNode(int val) {
                this.val = val;
            }
        }

        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * @param preOrder int整型一维数组
         * @param vinOrder int整型一维数组
         * @return TreeNode类
         */
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        public TreeNode reConstructBinaryTree(int[] preOrder, int[] vinOrder) {
            // write code here
            for (int i = 0; i < vinOrder.length; i++) {
                map.put(vinOrder[i], i);
            }
            return build(preOrder, 0, preOrder.length, vinOrder, 0, vinOrder.length);
        }

        public TreeNode build(int[] preOrder, int pres, int preend, int[] vinOrder, int vstart, int vend) {
            if (pres >= preend || vstart >= vend) {
                return null;
            }
            TreeNode root = new TreeNode(preOrder[pres]);
            Integer integer = map.get(preOrder[pres]);
            root.left = build(preOrder, pres + 1, integer - vstart + pres + 1, vinOrder, vstart, integer);
            root.right = build(preOrder, pres + integer - vstart + 1, preend, vinOrder, integer + 1, vend);
            return root;
        }
    }

    //NC13 二叉树的最大深度
    public class Solution13 {
        public class TreeNode {
            int val = 0;
            TreeNode left = null;
            TreeNode right = null;

            public TreeNode(int val) {
                this.val = val;
            }
        }

        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * @param root TreeNode类
         * @return int整型
         */
        public int maxDepth(TreeNode root) {
            // write code here
            ArrayDeque<TreeNode> objects = new ArrayDeque<TreeNode>();
            if (root == null) {
                return 0;
            }
            objects.addLast(root);
            int count = 0;
            while (!objects.isEmpty()) {
                int size = objects.size();
                while (size > 0) {
                    TreeNode treeNode = objects.removeFirst();
                    if (treeNode.left != null) {
                        objects.addLast(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        objects.addLast(treeNode.right);
                    }
                    size--;
                }
                count += 1;
            }
            return count;
        }
    }

    //NC14 按之字形顺序打印二叉树
    public class Solution14 {
        public class TreeNode {
            int val = 0;
            TreeNode left = null;
            TreeNode right = null;

            public TreeNode(int val) {
                this.val = val;
            }
        }

        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * @param pRoot TreeNode类
         * @return int整型ArrayList<ArrayList <>>
         */

        public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
            // write code here
            ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
            if (pRoot == null) {
                return res;
            }
            ArrayDeque<TreeNode> objects = new ArrayDeque<TreeNode>();
            objects.addLast(pRoot);
            int count = 0;
            while (!objects.isEmpty()) {
                int size = objects.size();
                ArrayDeque<Integer> objects1 = new ArrayDeque<>();
                while (size > 0) {
                    TreeNode treeNode = objects.removeFirst();
                    //反转
                    if (count % 2 == 0) {
                        objects1.addLast(treeNode.val);
                    } else {
                        objects1.addFirst(treeNode.val);
                    }
                    if (treeNode.left != null) {
                        objects.addLast(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        objects.addLast(treeNode.right);
                    }
                    size--;
                }
                res.add(new ArrayList<>(objects1));
                count++;
            }
            return res;
        }
    }

    //NC15 求二叉树的层序遍历
    public class Solution15 {
        public class TreeNode {
            int val = 0;
            TreeNode left = null;
            TreeNode right = null;

            public TreeNode(int val) {
                this.val = val;
            }
        }

        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * @param root TreeNode类
         * @return int整型ArrayList<ArrayList <>>
         */
        public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
            // write code here
            ArrayDeque<TreeNode> treeNodes = new ArrayDeque<>();
            ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
            if (root == null) {
                return arrayLists;
            }
            treeNodes.addLast(root);
            while (!treeNodes.isEmpty()) {
                int size = treeNodes.size();
                ArrayList<Integer> integers = new ArrayList<>();
                while (size > 0) {
                    TreeNode treeNode = treeNodes.removeFirst();
                    integers.add(treeNode.val);
                    if (treeNode.left != null) {
                        treeNodes.addLast(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        treeNodes.addLast(treeNode.right);
                    }
                    size--;
                }
                arrayLists.add(integers);
            }
            return arrayLists;
        }
    }

    //NC16 对称的二叉树
    public class Solution16 {
        public class TreeNode {
            int val = 0;
            TreeNode left = null;
            TreeNode right = null;

            public TreeNode(int val) {
                this.val = val;
            }
        }

        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * @param pRoot TreeNode类
         * @return bool布尔型
         */
        public boolean isSymmetrical(TreeNode pRoot) {
            // write code here
            if (pRoot == null)
                return true;
            return is(pRoot.left, pRoot.right);
        }

        public boolean is(TreeNode left, TreeNode right) {
            if (left == null && right == null) {
                return true;
            }
            if (left == null || right == null || left.val != right.val) {
                return false;
            }
            return is(left.left, right.right) && is(left.right, right.left);
        }
    }

    //NC17 最长回文子串
    public class Solution17 {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * @param A string字符串
         * @return int整型
         */
        public int getLongestPalindrome(String A) {
            // write code here
            int length = A.length();
            int max = 1;
            int[][] ints = new int[length][length];
            for (int i = 0; i < length; i++) {
                ints[i][i] = 1;
            }
            for (int j = 0; j < length; j++) {
                for (int i = 0; i < j; i++) {
                    if (A.charAt(i) != A.charAt(j)) {
                        ints[i][j] = 0;
                    } else {
                        if (j - i < 3) {
                            ints[i][j] = 1;
                        } else {
                            ints[i][j] = ints[i + 1][j - 1];
                        }
                        if (ints[i][j] == 1) {
                            max = Math.max(max, j - i + 1);
                        }
                    }
                }
            }

            return max;
        }
    }

    //NC18 顺时针旋转矩阵
    public class Solution18 {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * @param mat int整型二维数组
         * @param n   int整型
         * @return int整型二维数组
         */
        public int[][] rotateMatrix(int[][] mat, int n) {
            // write code here
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    int temp = mat[i][j];
                    mat[i][j] = mat[j][i];
                    mat[j][i] = temp;
                }
            }
            for (int i = 0; i < n; i++) {
                int left = 0;
                int right = n - 1;
                while (left < right) {
                    int temp = mat[i][left];
                    mat[i][left] = mat[i][right];
                    mat[i][right] = temp;
                    left++;
                    right--;
                }
            }
            return mat;
        }
    }

    //NC19 连续子数组的最大和
    public class Solution19 {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * @param array int整型一维数组
         * @return int整型
         */
        public int FindGreatestSumOfSubArray(int[] array) {
            // write code here
            int res = array[0];
            int max = array[0];
            for (int i = 1; i < array.length; i++) {
                res = Math.max(res + array[i], array[i]);
                max = Math.max(res, max);
            }
            return max;
        }
    }

    //NC20 数字字符串转化成IP地址
    public class Solution20 {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * @param s string字符串
         * @return string字符串ArrayList
         */
        public ArrayList<String> restoreIpAddresses1(String s) {
            // write code here
            int n = s.length();
            ArrayList<String> res = new ArrayList<>();
            for (int i = 1; i < 4 && i < n - 2; i++) {
                for (int j = i + 1; j < i + 4 && j < n - 1; j++) {
                    for (int k = j + 1; k < j + 4 && k < n; k++) {
                        if (n - k >= 4)
                            continue;
                        String a = s.substring(0, i);
                        String b = s.substring(i, j);
                        String c = s.substring(j, k);
                        String d = s.substring(k);
                        //IP每个数字不大于255
                        if (Integer.parseInt(a) > 255 || Integer.parseInt(b) > 255 || Integer.parseInt(c) > 255 || Integer.parseInt(d) > 255)
                            continue;
                        if ((a.length() != 1 && a.charAt(0) == '0') || (b.length() != 1 && b.charAt(0) == '0') || (c.length() != 1 && c.charAt(0) == '0') || (d.length() != 1 && d.charAt(0) == '0'))
                            continue;
                        String temp = a + "." + b + "." + c + "." + d;
                        res.add(temp);
                    }
                }
            }
            return res;
        }

        public ArrayList<String> restoreIpAddresses(String s) {
            // write code here
            ArrayList<String> strings = new ArrayList<>();
            dfs(s, strings, 0, 0, new StringBuilder(""));
            return strings;
        }

        public void dfs(String s, ArrayList<String> res, int step, int index, StringBuilder path) {
            if (step == 4) {
                if (index == s.length()) {
                    res.add(new String(path));
                } else {
                    return;
                }
            } else {
                for (int i = index; i < index + 3 && i < s.length(); i++) {
                    String substring = s.substring(index, i + 1);
                    int i1 = Integer.parseInt(substring);
                    if (i1 <= 255 && (substring.length() == 1 || substring.charAt(0) != '0')) {
                        if (step - 3 != 0) {
                            path.append(substring + ".");
                            dfs(s, res, step + 1, i + 1, path);
                            path.delete(path.length() - substring.length() - 1, path.length());
                        } else {
                            path.append(substring);
                            dfs(s, res, step + 1, i + 1, path);
                            path.delete(path.length() - substring.length(), path.length());
                        }
                    }
                }
            }
        }
    }

    //NC21 链表内指定区间反转
    public class Solution21 {
        public class ListNode {
            int val;
            ListNode next = null;

            public ListNode(int val) {
                this.val = val;
            }
        }

        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * @param head ListNode类
         * @param m    int整型
         * @param n    int整型
         * @return ListNode类
         */
        public ListNode reverseBetween(ListNode head, int m, int n) {
            // write code here
            ListNode pre = new ListNode(0);
            pre.next = head;
            ListNode ppre = pre;
            ListNode ppcur = head;
            for (int i = 1; i < m; i++) {
                ppre = ppre.next;
                ppcur = ppcur.next;
            }
            ListNode next = ppcur.next;
            for (int i = m; i < n; i++) {
                next = next.next;
            }
            for (int i = m; i < n; i++) {
                ListNode next1 = ppcur.next;
                ppcur.next = next;
                next = ppcur;
                ppcur = next1;
            }
            ppcur.next = next;
            ppre.next = ppcur;
            return pre.next;
        }
    }

    //NC22 合并两个有序的数组
    public class Solution22 {
        public void merge(int A[], int m, int B[], int n) {
            int i = m - 1;
            int j = n - 1;
            for (int k = m + n - 1; k >= 0; k--) {
                if (i >= 0 && j >= 0) {
                    if (A[i] > B[j]) {
                        A[k] = A[i];
                        i--;
                    } else {
                        A[k] = B[j];
                        j--;
                    }
                } else {
                    if (i >= 0) {
                        A[k] = A[i];
                        i--;
                    } else {
                        A[k] = B[j];
                        j--;
                    }
                }
            }
        }
    }

    //NC23 划分链表
    public class Solution23 {
        public class ListNode {
            int val;
            ListNode next = null;

            public ListNode(int val) {
                this.val = val;
            }
        }

        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * @param head ListNode类
         * @param x    int整型
         * @return ListNode类
         */
        public ListNode partition(ListNode head, int x) {
            // write code here
            ListNode pre = new ListNode(0);
            pre.next = head;

            ListNode cur = pre;
            while (cur.next != null && cur.next.val < x) {
                cur = cur.next;
            }
            ListNode next = cur.next;
            ListNode big = cur.next;
            while (next != null && next.next != null) {
                if (next.next.val < x) {
                    cur.next = next.next;
                    next.next = next.next.next;
                    cur.next.next = big;
                    cur = cur.next;
                } else {
                    next = next.next;
                }
            }
            return pre.next;
        }
    }

    //NC24 删除有序链表中重复的元素-II
    public class Solution24 {
        public class ListNode {
            int val;
            ListNode next = null;

            public ListNode(int val) {
                this.val = val;
            }
        }

        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * @param head ListNode类
         * @return ListNode类
         */
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) {
                return null;
            }
            // write code here
            ListNode pre = new ListNode(-1);
            pre.next = head;
            ListNode cur = pre;
            while (cur.next != null && cur.next.next != null) {
                if (cur.next.val == cur.next.next.val) {
                    int temp = cur.next.val;
                    while (cur.next != null && cur.next.val == temp) {
                        cur.next = cur.next.next;
                    }
                } else {
                    cur = cur.next;
                }
            }
            return pre.next;
        }
    }

    //NC25 删除有序链表中重复的元素-I
    public class Solution25 {
        public class ListNode {
            int val;
            ListNode next = null;

            public ListNode(int val) {
                this.val = val;
            }
        }

        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * @param head ListNode类
         * @return ListNode类
         */
        public ListNode deleteDuplicates(ListNode head) {
            // write code here
            ListNode pre = new ListNode(-1000);
            pre.next = head;
            ListNode ppre = pre;
            ListNode cur = head;
            while (cur != null) {
                if (cur.val != ppre.val) {
                    ppre = ppre.next;
                    cur = cur.next;
                } else {
                    ppre.next = cur.next;
                    cur = cur.next;
                }
            }
            return pre.next;
        }
    }

    //NC26 括号生成
    public class Solution26 {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         *
         * @param n int整型
         * @return string字符串ArrayList
         */
        public ArrayList<String> generateParenthesis (int n) {
            // write code here
            ArrayList<String> res = new ArrayList<>();
            recursion(n,n,new String(),res);
            return res;
        }

        public void recursion(int left,int right,String path,ArrayList<String> res){
            if(left==0&&right==0){
                res.add(new String(path));
            }
            if(left>0){
                recursion(left-1,right,path+"(",res);
            }

            if(right>0 && right>left){
                recursion(left,right-1,path+")",res);
            }
        }
    }

    //NC27 集合的所有子集(一)
    public class Solution27 {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         *
         * @param S int整型一维数组
         * @return int整型ArrayList<ArrayList<>>
         */
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        public ArrayList<ArrayList<Integer>> subsets (int[] S) {
            // write code here
            Arrays.sort(S);
            res.add(new ArrayList<>());
            for(int i=1;i<=S.length;i++){
                huisu(0,i,S,new ArrayList<Integer>());
            }
            return res;
        }
        public void huisu(int startIndex,int k,int[] S,ArrayList<Integer> path){
            if(path.size()==k){
                res.add(new ArrayList<>(path));
                return;
            }
            for(int j=startIndex;j<S.length;j++){
                path.add(S[j]);
                huisu(j+1,k,S,path);
                path.remove(path.size()-1);
            }
        }
    }
}


