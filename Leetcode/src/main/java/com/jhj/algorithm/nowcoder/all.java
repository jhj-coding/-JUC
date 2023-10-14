package com.jhj.algorithm.nowcoder;

import java.util.ArrayDeque;

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

}


