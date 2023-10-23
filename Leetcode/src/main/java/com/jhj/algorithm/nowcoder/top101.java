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

    //BM5 合并k个已排序的链表
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

    //BM6 判断链表中是否有环
    public class Solution6 {
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

    //BM7 链表中环的入口结点
    public class Solution7 {
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
                    fast = pHead;
                    while (fast != null) {
                        if (fast == low) {
                            return fast;
                        }
                        fast = fast.next;
                        low = low.next;
                    }
                }
            }
            return null;
        }
    }

    //BM8 链表中倒数最后k个结点
    public class Solution8 {
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
         * @param pHead ListNode类
         * @param k     int整型
         * @return ListNode类
         */
        public ListNode FindKthToTail(ListNode pHead, int k) {
            // write code here
            ListNode curr = pHead;
            ListNode cur = pHead;
            for (int i = 0; i < k; i++) {
                if (curr == null) {
                    return null;
                }
                curr = curr.next;
            }
            while (curr != null) {
                curr = curr.next;
                cur = cur.next;
            }
            return cur;
        }
    }

    //BM9 删除链表的倒数第n个节点
    public class Solution9 {

        public class ListNode {
            int val;
            ListNode next = null;

            public ListNode(int val) {
                this.val = val;
            }
        }

        public ListNode removeNthFromEnd(ListNode head, int n) {
            // write code here
            ListNode listNode = new ListNode(-1);
            listNode.next = head;
            ListNode cur = head;
            ListNode curr = head;
            ListNode pre = listNode;
            for (int i = 0; i < n; i++) {
                cur = cur.next;
            }
            while (cur != null) {
                curr = curr.next;
                cur = cur.next;
                pre = pre.next;
            }
            pre.next = curr.next;
            return listNode.next;
        }
    }

    //BM10 两个链表的第一个公共结点
    public class Solution10 {

        public class ListNode {
            int val;
            ListNode next = null;

            ListNode(int val) {
                this.val = val;
            }
        }

        public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
            ListNode cur1 = pHead1;
            ListNode cur2 = pHead2;
            int cur1l = 0;
            int cur2l = 0;
            while (cur1 != null) {
                cur1l++;
                cur1 = cur1.next;
            }
            while (cur2 != null) {
                cur2l++;
                cur2 = cur2.next;
            }
            cur1 = pHead1;
            cur2 = pHead2;
            if (cur1l > cur2l) {
                for (int i = 0; i < cur1l - cur2l; i++) {
                    cur1 = cur1.next;
                }
                while (cur1 != null && cur2 != null) {
                    if (cur1 == cur2) {
                        return cur1;
                    }
                    cur1 = cur1.next;
                    cur2 = cur2.next;
                }
            } else {
                for (int i = 0; i < cur2l - cur1l; i++) {
                    cur2 = cur2.next;
                }
                while (cur1 != null && cur2 != null) {
                    if (cur1 == cur2) {
                        return cur1;
                    }
                    cur1 = cur1.next;
                    cur2 = cur2.next;
                }
            }
            return null;
        }
    }

    //BM11 链表相加(二)
    public class Solution11 {
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
         * @param head1 ListNode类
         * @param head2 ListNode类
         * @return ListNode类
         */
        public ListNode addInList(ListNode head1, ListNode head2) {
            // write code here
            ListNode cur1 = head1;
            ListNode pre1 = null;
            while (cur1 != null) {
                ListNode next = cur1.next;
                cur1.next = pre1;
                pre1 = cur1;
                cur1 = next;
            }

            ListNode cur2 = head2;
            ListNode pre2 = null;
            while (cur2 != null) {
                ListNode next = cur2.next;
                cur2.next = pre2;
                pre2 = cur2;
                cur2 = next;
            }
            int i = 0;
            ListNode res = new ListNode(1);
            ListNode curr = res;
            while (pre1 != null || pre2 != null) {
                if (pre1 != null && pre2 != null) {
                    int i1 = pre1.val + pre2.val + i;
                    i = i1 / 10;
                    ListNode listNode = new ListNode(i1 % 10);
                    curr.next = listNode;
                    pre1 = pre1.next;
                    pre2 = pre2.next;
                } else if (pre1 != null && pre2 == null) {
                    int i1 = pre1.val + i;
                    i = i1 / 10;
                    ListNode listNode = new ListNode(i1 % 10);
                    curr.next = listNode;
                    pre1 = pre1.next;
                } else if (pre1 == null && pre2 != null) {
                    int i1 = pre2.val + i;
                    i = i1 / 10;
                    ListNode listNode = new ListNode(i1 % 10);
                    curr.next = listNode;
                    pre2 = pre2.next;
                }
                curr = curr.next;
            }
            if (i != 0) {
                curr.next = new ListNode(i);
            }
            ListNode next = res.next;
            ListNode pre = null;
            ListNode cur = next;
            while (cur != null) {
                ListNode next1 = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next1;
            }
            return pre;
        }
    }

    //BM12 单链表的排序
    public class Solution12 {
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
         * @param head ListNode类 the head node
         * @return ListNode类
         */
        public ListNode sortInList(ListNode head) {
            // write code here
            ArrayList<Integer> integers = new ArrayList<>();
            ListNode cur = head;
            while (cur != null) {
                integers.add(cur.val);
                cur = cur.next;
            }
            integers.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            ListNode res = new ListNode(1);
            ListNode cur1 = res;
            for (int i = 0; i < integers.size(); i++) {
                Integer integer = integers.get(i);
                ListNode listNode = new ListNode(integer);
                cur1.next = listNode;
                cur1 = cur1.next;
            }
            return res.next;
        }
    }

    //BM13 判断一个链表是否为回文结构
    public class Solution13 {
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
         * @param head ListNode类 the head
         * @return bool布尔型
         */
        public boolean isPail(ListNode head) {
            // write code here
            ListNode pre = null;
            ListNode cur = head;
            ListNode listNode = new ListNode(-1);
            ListNode cur3 = listNode;
            while (cur != null) {
                cur3.next = new ListNode(cur.val);
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
                cur3 = cur3.next;
            }
            ListNode cur1 = pre;
            ListNode cur2 = listNode.next;
            while (cur1 != null) {
                if (cur1.val != cur2.val) {
                    return false;
                }
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return true;
        }
    }

    //BM14 链表的奇偶重排
    public class Solution14 {
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
        public ListNode oddEvenList(ListNode head) {
            // write code here
            ListNode ji = new ListNode(-1);
            ListNode ou = new ListNode(-1);
            int count = 1;
            ListNode cur = head;
            ListNode curji = ji;
            ListNode curou = ou;
            while (cur != null) {
                if (count % 2 == 1) {
                    curji.next = new ListNode(cur.val);
                    curji = curji.next;
                } else {
                    curou.next = new ListNode(cur.val);
                    curou = curou.next;
                }
                cur = cur.next;
                count++;
            }
            curji.next = ou.next;
            return ji.next;
        }
    }

    //BM15 删除有序链表中重复的元素-I
    public class Solution15 {
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
            ListNode cur = head;
            if (cur == null) {
                return head;
            }
            ListNode cur1 = head.next;
            while (cur1 != null) {
                if (cur.val == cur1.val) {
                    cur1 = cur1.next;
                } else {
                    cur.next = cur1;
                    cur = cur.next;
                    cur1 = cur1.next;
                }
            }
            cur.next = null;
            return head;
        }
    }

    //BM16 删除有序链表中重复的元素-II
    public class Solution16 {
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
            if(head==null){
                return head;
            }
            ListNode listNode=new ListNode(-1);
            listNode.next=head;
            ListNode cur=listNode;
            while (cur.next!=null&&cur.next.next!=null){
                if(cur.next.val==cur.next.next.val){
                    int temp=cur.next.val;
                    while (cur.next!=null && cur.next.val==temp){
                        cur.next=cur.next.next;
                    }
                }else{
                    cur=cur.next;
                }
            }
            return listNode.next;
        }
    }

    //BM17 二分查找-I
    public class Solution17 {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         *
         * @param nums int整型一维数组
         * @param target int整型
         * @return int整型
         */
        public int search (int[] nums, int target) {
            // write code here
            int left=0;
            int right=nums.length-1;
            while (left<=right){
                int mid=(left+right)/2;
                if(nums[mid]==target){
                    return mid;
                }else if (nums[mid]>target){
                    right=mid-1;
                }else {
                    left=mid+1;
                }
            }
            return -1;
        }
    }

    //BM18 二维数组中的查找
    public class Solution18 {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         *
         * @param target int整型
         * @param array int整型二维数组
         * @return bool布尔型
         */
        public boolean Find (int target, int[][] array) {
            // write code here
            int hang=array.length-1;
            if(hang==-1){
                return false;
            }
            int lie=array[0].length;

            int hi=0;
            int li=lie-1;
            while (hi<=hang&&li>=0){
                int i = array[hi][li];
                if(i==target){
                    return true;
                }else if(i>target){
                    li--;
                }else {
                    hi++;
                }
            }
            return false;

        }
    }
}
