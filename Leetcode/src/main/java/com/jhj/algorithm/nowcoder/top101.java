package com.jhj.algorithm.nowcoder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class top101 {

    //BM1 反转链表
    public class Solution1 {
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
        public ListNode ReverseList(ListNode head) {
            // write code here
            ListNode pre = null;
            ListNode cur = head;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }
    }

    //BM2 链表内指定区间反转
    public class Solution2 {
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
            ListNode cur = head;
            ListNode pree = pre;
            for (int i = 1; i < m; i++) {
                pree = pree.next;
                cur = cur.next;
            }
            ListNode next = cur.next;
            for (int i = m; i < n; i++) {
                next = next.next;
            }
            for (int i = m; i < n; i++) {
                ListNode cur1 = cur.next;
                cur.next = next;
                next = cur;
                cur = cur1;
            }
            cur.next = next;
            pree.next = cur;
            return pre.next;
        }
    }

    //BM3 链表中的节点每k个一组翻转
    public class Solution3 {
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
         * @param k    int整型
         * @return ListNode类
         */
        public ListNode reverseKGroup(ListNode head, int k) {
            // write code here
            ListNode cur = head;
            int count = 0;
            while (cur != null) {
                cur = cur.next;
                count++;
            }
            ListNode pre = new ListNode(0);
            pre.next = head;
            ListNode p0 = pre;
            ListNode pp = null;
            cur = head;
            for (int i = count; i >= k; i -= k) {
                for (int j = 0; j < k; j++) {
                    ListNode next = cur.next;
                    cur.next = pp;
                    pp = cur;
                    cur = next;
                }
                ListNode next = p0.next;
                p0.next.next = cur;
                p0.next = pp;
                p0 = next;
            }
            return pre.next;
        }
    }

    //BM4 合并两个排序的链表
    public class Solution4 {
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
         * @param pHead1 ListNode类
         * @param pHead2 ListNode类
         * @return ListNode类
         */
        public ListNode Merge(ListNode pHead1, ListNode pHead2) {
            // write code here
            ListNode cur1 = pHead1;
            ListNode cur2 = pHead2;
            ListNode head = new ListNode(0);
            ListNode cur3 = head;
            while (cur1 != null || cur2 != null) {
                if (cur1 == null) {
                    cur3.next = cur2;
                    break;
                } else if (cur2 == null) {
                    cur3.next = cur1;
                    break;
                } else {
                    if (cur1.val < cur2.val) {
                        cur3.next = new ListNode(cur1.val);
                        cur1 = cur1.next;
                    } else {
                        cur3.next = new ListNode(cur2.val);
                        cur2 = cur2.next;
                    }
                    cur3 = cur3.next;
                }
            }
            return head.next;
        }
    }

    public class Solution5 {
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
         * @param lists ListNode类ArrayList
         * @return ListNode类
         */
        public ListNode mergeKLists1(ArrayList<ListNode> lists) {
            ArrayList<Integer> integers = new ArrayList<>();
            // write code here
            for (int i = 0; i < lists.size(); i++) {
                ListNode listNode = lists.get(i);
                while (listNode != null) {
                    integers.add(listNode.val);
                    listNode = listNode.next;
                }
            }
            integers.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            ListNode head = new ListNode(0);
            ListNode cur = head;
            for (int i = 0; i < integers.size(); i++) {
                cur.next = new ListNode(integers.get(i));
                cur = cur.next;
            }
            return head.next;
        }

        public ListNode mergeKLists2(ArrayList<ListNode> lists) {
            // write code here
            PriorityQueue<ListNode> objects = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    return o1.val - o2.val;
                }
            });

            for (ListNode cur : lists) {
                if (cur != null) objects.add(cur);
            }
            ListNode head = new ListNode(0);
            ListNode curr = head;
            while (!objects.isEmpty()) {
                ListNode remove = objects.remove();
                curr.next = remove;
                curr = curr.next;
                if (remove.next != null)
                    objects.add(remove.next);
            }
            return head.next;
        }

        public ListNode mergeKLists(ArrayList<ListNode> lists) {
            // write code here
            return merge(lists, 0, lists.size() - 1);
        }

        public ListNode merge(ArrayList<ListNode> lists, int l, int right) {
            if (l == right) {
                return lists.get(l);
            }
            if (l > right) {
                return null;
            }
            int mid = l + (right - l) / 2;
            return mergeTwoList(merge(lists, l, mid), merge(lists, mid + 1, right));
        }

        public ListNode mergeTwoList(ListNode l1, ListNode l2) {
            ListNode cur1 = l1;
            ListNode cur2 = l2;
            ListNode head = new ListNode(0);
            ListNode cur3 = head;
            while (cur1 != null || cur2 != null) {
                if (cur1 == null) {
                    cur3.next = cur2;
                    break;
                } else if (cur2 == null) {
                    cur3.next = cur1;
                    break;
                } else {
                    if (cur1.val < cur2.val) {
                        cur3.next = cur1;
                        cur1 = cur1.next;
                    } else {
                        cur3.next = cur2;
                        cur2 = cur2.next;
                    }
                    cur3 = cur3.next;
                }
            }
            return head.next;
        }
    }
}
