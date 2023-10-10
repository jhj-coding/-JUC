package com.jhj.algorithm.nowcoder;

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
            ListNode pre=new ListNode(0);
            pre.next=head;
            ListNode cur=head;
            ListNode pree=pre;
            for(int i=1;i<m;i++){
                pree=pree.next;
                cur=cur.next;
            }
            ListNode next=cur.next;
            for (int i=m;i<n;i++){
                next=next.next;
            }
            for(int i=m;i<n;i++){
                ListNode cur1 = cur.next;
                cur.next=next;
                next=cur;
                cur=cur1;
            }
            cur.next=next;
            pree.next=cur;
            return pre.next;
        }
    }
}
