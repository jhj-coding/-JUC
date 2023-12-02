package com.jhj.algorithm.nowcoder;

import java.util.*;

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
            if (head == null) {
                return head;
            }
            ListNode listNode = new ListNode(-1);
            listNode.next = head;
            ListNode cur = listNode;
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
            return listNode.next;
        }
    }

    //BM17 二分查找-I
    public class Solution17 {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * @param nums   int整型一维数组
         * @param target int整型
         * @return int整型
         */
        public int search(int[] nums, int target) {
            // write code here
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
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
         * @param target int整型
         * @param array  int整型二维数组
         * @return bool布尔型
         */
        public boolean Find(int target, int[][] array) {
            // write code here
            int hang = array.length - 1;
            if (hang == -1) {
                return false;
            }
            int lie = array[0].length;

            int hi = 0;
            int li = lie - 1;
            while (hi <= hang && li >= 0) {
                int i = array[hi][li];
                if (i == target) {
                    return true;
                } else if (i > target) {
                    li--;
                } else {
                    hi++;
                }
            }
            return false;

        }
    }

    //BM19 寻找峰值
    public class Solution19 {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * @param nums int整型一维数组
         * @return int整型
         */
        public int findPeakElement(int[] nums) {
            // write code here
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (nums[mid] > nums[mid + 1]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return right;
        }
    }

    //BM20 数组中的逆序对
    public class Solution20 {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * @param nums int整型一维数组
         * @return int整型
         */
        int res = 0;

        public int InversePairs(int[] nums) {
            // write code here
            mergeSort(nums);
            return res;
        }

        public int[] mergeSort(int[] arr) {
            if (arr.length <= 1) {
                return arr;
            }
            int middle = arr.length / 2;
            int[] arr_1 = Arrays.copyOfRange(arr, 0, middle);
            int[] arr_2 = Arrays.copyOfRange(arr, middle, arr.length);
            return merge(mergeSort(arr_1), mergeSort(arr_2));
        }

        public int[] merge(int[] arr_1, int[] arr_2) {
            int[] sorted_arr = new int[arr_1.length + arr_2.length];
            int idx = 0, idx_1 = 0, idx_2 = 0;
            while (idx_1 < arr_1.length && idx_2 < arr_2.length) {
                if (arr_1[idx_1] > arr_2[idx_2]) {
                    sorted_arr[idx] = arr_2[idx_2];
                    res += arr_1.length - idx_1;
                    res %= (1e9 + 7);
                    idx_2 += 1;
                } else {
                    sorted_arr[idx] = arr_1[idx_1];
                    idx_1 += 1;
                }
                idx += 1;
            }
            if (idx_1 < arr_1.length) {
                while (idx_1 < arr_1.length) {
                    sorted_arr[idx] = arr_1[idx_1];
                    idx_1 += 1;
                    idx += 1;
                }
            } else {
                while (idx_2 < arr_2.length) {
                    sorted_arr[idx] = arr_2[idx_2];
                    idx_2 += 1;
                    idx += 1;
                }
            }
            return sorted_arr;
        }
    }

    //BM21 旋转数组的最小数字
    public class Solution21 {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * @param nums int整型一维数组
         * @return int整型
         */
        public int minNumberInRotateArray(int[] nums) {
            // write code here
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (nums[mid] < nums[right]) {
                    right = mid;
                } else if (nums[mid] > nums[right]) {
                    left = mid + 1;
                } else {
                    right--;
                }
            }
            ;
            return nums[left];
        }
    }

    //BM22 比较版本号
    public class Solution22 {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         * <p>
         * 比较版本号
         *
         * @param version1 string字符串
         * @param version2 string字符串
         * @return int整型
         */
        public int compare(String version1, String version2) {
            int n1 = version1.length();
            int n2 = version2.length();
            int i = 0, j = 0;
            //直到某个字符串结束
            while (i < n1 || j < n2) {
                long num1 = 0;
                //从下一个点前截取数字
                while (i < n1 && version1.charAt(i) != '.') {
                    num1 = num1 * 10 + (version1.charAt(i) - '0');
                    i++;
                }
                //跳过点
                i++;
                long num2 = 0;
                //从下一个点前截取数字
                while (j < n2 && version2.charAt(j) != '.') {
                    num2 = num2 * 10 + (version2.charAt(j) - '0');
                    j++;
                }
                //跳过点
                j++;
                //比较数字大小
                if (num1 > num2)
                    return 1;
                if (num1 < num2)
                    return -1;
            }
            //版本号相同
            return 0;
        }
    }

    //BM23 二叉树的前序遍历
    public class Solution23 {
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
         * @return int整型一维数组
         */
        ArrayList integers = new ArrayList<Integer>();

        public int[] preorderTraversal(TreeNode root) {
            // write code here
            dfs(root);

            int[] ints = integers.stream().mapToInt(e -> (int) e).toArray();
            return ints;
        }

        public void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            integers.add(root.val);
            dfs(root.left);
            dfs(root.right);
        }
    }

    //BM24 二叉树的中序遍历
    public class Solution24 {
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
         * @return int整型一维数组
         */
        ArrayList integers = new ArrayList<Integer>();

        public int[] inorderTraversal(TreeNode root) {
            // write code here
            dfs(root);

            int[] ints = integers.stream().mapToInt(e -> (int) e).toArray();
            return ints;
        }

        public void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            dfs(root.left);
            integers.add(root.val);
            dfs(root.right);
        }
    }

    //BM25 二叉树的后序遍历
    public class Solution25 {
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
         * @return int整型一维数组
         */
        ArrayList integers = new ArrayList<Integer>();

        public int[] postorderTraversal(TreeNode root) {
            // write code here
            dfs(root);

            int[] ints = integers.stream().mapToInt(e -> (int) e).toArray();
            return ints;
        }

        public void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            dfs(root.left);
            dfs(root.right);
            integers.add(root.val);
        }
    }

    //BM26 求二叉树的层序遍历
    public class Solution26 {
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
            ArrayList<ArrayList<Integer>> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            ArrayDeque<TreeNode> treeNodes = new ArrayDeque<>();
            treeNodes.addLast(root);
            while (!treeNodes.isEmpty()) {
                int size = treeNodes.size();
                ArrayList<Integer> integers = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode treeNode = treeNodes.removeFirst();
                    integers.add(treeNode.val);
                    if (treeNode.left != null) {
                        treeNodes.addLast(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        treeNodes.addLast(treeNode.right);
                    }
                }
                res.add(integers);
            }
            return res;
        }
    }

    //BM27 按之字形顺序打印二叉树
    public class Solution27 {
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
            ArrayList<ArrayList<Integer>> res = new ArrayList<>();
            if (pRoot == null) {
                return res;
            }
            ArrayDeque<TreeNode> treeNodes = new ArrayDeque<>();
            treeNodes.addLast(pRoot);
            int count = 0;
            while (!treeNodes.isEmpty()) {
                ArrayDeque<Integer> integers = new ArrayDeque<Integer>();
                int size = treeNodes.size();
                for (int i = 0; i < size; i++) {
                    TreeNode treeNode = treeNodes.removeFirst();
                    if (count % 2 == 0) {
                        integers.addLast(treeNode.val);
                    } else {
                        integers.addFirst(treeNode.val);
                    }
                    if (treeNode.left != null) {
                        treeNodes.addLast(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        treeNodes.addLast(treeNode.right);
                    }
                }
                count++;
                res.add(new ArrayList<>(integers));
            }
            return res;
        }
    }

    //BM28 二叉树的最大深度
    public class Solution28 {
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
        public int maxDepth1(TreeNode root) {
            // write code here
            int res = 0;
            if (root == null) {
                return res;
            }
            ArrayDeque<TreeNode> deque = new ArrayDeque<>();
            deque.add(root);
            while (!deque.isEmpty()) {
                int size = deque.size();
                res++;
                for (int i = 0; i < size; i++) {
                    TreeNode treeNode = deque.removeFirst();
                    if (treeNode.left != null) {
                        deque.addLast(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        deque.addLast(treeNode.right);
                    }
                }
            }
            return res;
        }

        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }

    //BM29 二叉树中和为某一值的路径(一)
    public class Solution29 {
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
            boolean b1 = hasPathSum(root.right, sum);
            return b || b1;
        }
    }

    //BM30 二叉搜索树与双向链表
    public class Solution30 {
        public class TreeNode {
            int val = 0;
            TreeNode left = null;
            TreeNode right = null;

            public TreeNode(int val) {
                this.val = val;

            }

        }

        TreeNode head = null;
        TreeNode pre = null;

        public TreeNode Convert(TreeNode pRootOfTree) {
            if (pRootOfTree == null) {
                return null;
            }
            Convert(pRootOfTree.left);
            if (pre == null) {
                head = pRootOfTree;
                pre = pRootOfTree;
            } else {
                pre.right = pRootOfTree;
                pRootOfTree.left = pre;
                pre = pRootOfTree;
            }
            Convert(pRootOfTree.right);
            return head;
        }
    }

    //BM31 对称的二叉树
    public class Solution31 {
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
            if (pRoot == null) {
                return true;
            }
            return isSymmetricall(pRoot.left, pRoot.right);
        }

        public boolean isSymmetricall(TreeNode left, TreeNode right) {
            if (left == null && right == null) {
                return true;
            }
            if (left == null || right == null || right.val != left.val) {
                return false;
            }
            return isSymmetricall(left.left, right.right) && isSymmetricall(left.right, right.left);
        }
    }

    //BM32 合并二叉树
    public class Solution32 {
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
         * @param t1 TreeNode类
         * @param t2 TreeNode类
         * @return TreeNode类
         */
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            // write code here
            if (t1 == null) {
                return t2;
            }
            if (t2 == null) {
                return t1;
            }
            t1.left = mergeTrees(t1.left, t2.left);
            t1.val += t2.val;
            t1.right = mergeTrees(t1.right, t2.right);
            return t1;
        }
    }

    //BM33 二叉树的镜像
    public class Solution33 {
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
         * @return TreeNode类
         */
        public TreeNode Mirror(TreeNode pRoot) {
            // write code here
            if (pRoot == null) {
                return null;
            }
            TreeNode left = pRoot.left;
            pRoot.left = pRoot.right;
            pRoot.right = left;
            Mirror(pRoot.left);
            Mirror(pRoot.right);
            return pRoot;
        }
    }

    //BM34 判断是不是二叉搜索树
    public class Solution34 {
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
         * @return bool布尔型
         */
        public boolean isValidBST1(TreeNode root) {
            // write code here
            ArrayList<Integer> integers = new ArrayList<>();
            dfs(integers, root);
            for (int i = 0; i < integers.size() - 1; i++) {
                if (integers.get(i) >= integers.get(i + 1)) {
                    return false;
                }
            }
            return true;
        }

        public void dfs(ArrayList<Integer> res, TreeNode root) {
            if (root == null) {
                return;
            }
            dfs(res, root.left);
            res.add(root.val);
            dfs(res, root.right);
        }

        int pre = Integer.MIN_VALUE;

        public boolean isValidBST2(TreeNode root) {
            if (root == null)
                return true;
            //先进入左子树
            if (!isValidBST2(root.left))
                return false;
            if (root.val <= pre)
                return false;
            //更新最值
            pre = root.val;
            //再进入右子树
            if (!isValidBST2(root.right))
                return false;
            return true;
        }
    }

    //BM35 判断是不是完全二叉树
    public class Solution35 {
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
         * @return bool布尔型
         */
        public boolean isCompleteTree(TreeNode root) {
            //空树一定是完全二叉树
            if (root == null)
                return true;
            //辅助队列
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            TreeNode cur;
            //定义一个首次出现的标记位
            boolean notComplete = false;
            while (!queue.isEmpty()) {
                cur = queue.poll();
                //标记第一次遇到空节点
                if (cur == null) {
                    notComplete = true;
                    continue;
                }
                //后续访问已经遇到空节点了，说明经过了叶子
                if (notComplete)
                    return false;
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
            return true;
        }
    }

    //BM36 判断是不是平衡二叉树
    public class Solution36 {
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
        public boolean IsBalanced_Solution(TreeNode pRoot) {
            // write code here
            return getHeight(pRoot) != -1;
        }

        public int getHeight(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftheight = getHeight(root.left);
            if (leftheight == -1) {
                return -1;
            }
            int rightheight = getHeight(root.right);
            if (rightheight == -1) {
                return -1;
            }
            if (Math.abs(leftheight - rightheight) > 1) {
                return -1;
            }
            return Math.max(leftheight, rightheight) + 1;
        }
    }

    //BM37 二叉搜索树的最近公共祖先
    public class Solution37 {
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
         * @param p    int整型
         * @param q    int整型
         * @return int整型
         */
        public int lowestCommonAncestor(TreeNode root, int p, int q) {
            if (root == null) {
                return -1;
            }
            if (p > q) {
                int temp = p;
                p = q;
                q = temp;
            }
            // write code here
            if (p <= root.val && root.val <= q) {
                return root.val;
            } else if (p <= root.val && root.val >= q) {
                return lowestCommonAncestor(root.left, p, q);
            } else {
                return lowestCommonAncestor(root.right, p, q);
            }
        }
    }

    //BM38 在二叉树中找到两个节点的最近公共祖先 后序天然回溯
    public class Solution38 {
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
         * @param o1   int整型
         * @param o2   int整型
         * @return int整型
         */
        public int lowestCommonAncestor(TreeNode root, int o1, int o2) {
            // write code here
            if (root == null) {
                return -1;
            }
            if (root.val == o1 || root.val == o2) {
                return root.val;
            }
            int left = lowestCommonAncestor(root.left, o1, o2);
            int right = lowestCommonAncestor(root.right, o1, o2);
            if (left == -1 && right == -1) {
                return -1;
            } else if (left == -1 && right != -1) {
                return right;
            } else if (left != -1 && right == -1) {
                return left;
            } else {
                return root.val;
            }
        }
    }

    //BM39 序列化二叉树
    public class Solution39 {
        class TreeNode {
            int val = 0;
            TreeNode left = null;
            TreeNode right = null;

            public TreeNode(int val) {
                this.val = val;

            }

        }

        StringBuilder stringBuilder = new StringBuilder();

        String Serialize(TreeNode root) {
            if (root == null) {
                stringBuilder.append("#");
                return stringBuilder.toString();
            }
            stringBuilder.append(root.val).append("!");
            Serialize(root.left);
            Serialize(root.right);
            return stringBuilder.toString();
        }

        int index = 0;

        TreeNode Deserialize(String str) {
            if (str.charAt(index) == '#') {
                index++;
                return null;
            }
            int val = 0;
            while (str.charAt(index) != '!' && index != str.length()) {
                val *= 10;
                val += str.charAt(index) - '0';
                index++;
            }
            TreeNode treeNode = new TreeNode(val);
            if (index == str.length()) {
                return treeNode;
            } else {
                index++;
            }
            treeNode.left = Deserialize(str);
            treeNode.right = Deserialize(str);
            return treeNode;
        }
    }

    //BM40 重建二叉树
    public class Solution40 {
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
        public TreeNode reConstructBinaryTree(int[] preOrder, int[] vinOrder) {
            // write code here
            //后序数组出现的位置
            HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
            for (int i = 0; i < vinOrder.length; i++) {
                integerIntegerHashMap.put(vinOrder[i], i);
            }
            return hebing(preOrder, 0, preOrder.length - 1, vinOrder, 0, vinOrder.length - 1, integerIntegerHashMap);
        }

        public TreeNode hebing(int[] preOrder, int preStart, int preEnd, int[] vinOrder, int vinstart, int vinEnd, HashMap<Integer, Integer> integerIntegerHashMap) {
            if (preStart > preEnd || vinstart > vinEnd) {
                return null;
            }
            int val = preOrder[preStart];
            TreeNode root = new TreeNode(val);
            Integer midIndex = integerIntegerHashMap.get(val);
            root.left = hebing(preOrder, preStart + 1, midIndex - vinstart + preStart, vinOrder, vinstart, midIndex, integerIntegerHashMap);
            root.right = hebing(preOrder, midIndex - vinstart + preStart + 1, preEnd, vinOrder, midIndex + 1, vinEnd, integerIntegerHashMap);
            return root;
        }
    }

    //BM41 输出二叉树的右视图
    public class Solution41 {
        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            public TreeNode(int val) {
                this.val = val;
            }
        }

        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         * <p>
         * 求二叉树的右视图
         *
         * @param preOrder int整型一维数组 先序遍历
         * @param inOrder  int整型一维数组 中序遍历
         * @return int整型一维数组
         */
        public int[] solve(int[] preOrder, int[] inOrder) {
            // write code here
            //后序位置
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < inOrder.length; i++) {
                map.put(inOrder[i], i);
            }
            TreeNode treeNode = buildTree(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1, map);
            ArrayList<Integer> integers = new ArrayList<>();
            ArrayDeque<TreeNode> treeNodes = new ArrayDeque<>();
            treeNodes.add(treeNode);
            while (!treeNodes.isEmpty()) {
                int len = treeNodes.size();
                for (int i = 0; i < len; i++) {
                    TreeNode treeNode1 = treeNodes.removeFirst();
                    if (treeNode1.left != null) {
                        treeNodes.add(treeNode1.left);
                    }
                    if (treeNode1.right != null) {
                        treeNodes.add(treeNode1.right);
                    }
                    if (i == len - 1) {
                        integers.add(treeNode1.val);
                    }
                }
            }
            int[] res = new int[integers.size()];
            for (int i = 0; i < integers.size(); i++) {
                res[i] = integers.get(i);
            }
            return res;
        }

        public TreeNode buildTree(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd, HashMap<Integer, Integer> map) {
            if (preStart > preEnd || inStart > inEnd) {
                return null;
            }
            int val = preOrder[preStart];
            TreeNode treeNode = new TreeNode(val);
            Integer midIndex = map.get(val);
            treeNode.left = buildTree(preOrder, preStart + 1, midIndex - inStart + preStart, inOrder, inStart, midIndex - 1, map);
            treeNode.right = buildTree(preOrder, midIndex - inStart + preStart + 1, preEnd, inOrder, midIndex + 1, inEnd, map);
            return treeNode;
        }
    }

    //BM42 用两个栈实现队列
    public class Solution42 {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        public void push(int node) {
            stack1.add(node);
        }

        public int pop() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.add(stack1.pop());
                }
            }
            return stack2.pop();
        }
    }

    //BM43 包含min函数的栈
    public class Solution43 {

        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> stack1 = new Stack<Integer>();

        public void push(int node) {
            stack.push(node);
            if (stack1.isEmpty() || stack1.peek() > node) {
                stack1.push(node);
            } else {
                stack1.push(stack1.peek());
            }
        }

        public void pop() {
            stack.pop();
            stack1.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return stack1.peek();
        }
    }

    //BM44 有效括号序列
    public class Solution44 {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * @param s string字符串
         * @return bool布尔型
         */
        public boolean isValid(String s) {
            // write code here
            HashMap<Character, Character> map = new HashMap<>();
            map.put(')', '(');
            map.put(']', '[');
            map.put('}', '{');
            HashSet<Character> set = new HashSet<>();
            set.add('(');
            set.add('[');
            set.add('{');
            ArrayDeque<Character> characters = new ArrayDeque<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (set.contains(c)) {
                    characters.addLast(c);
                } else {
                    Character character = map.get(c);
                    if (characters.isEmpty()) {
                        return false;
                    }
                    Character character1 = characters.removeLast();
                    if (character != character1) {
                        return false;
                    }
                }
            }
            return characters.isEmpty();
        }
    }

    //BM45 滑动窗口的最大值
    public class Solution45 {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * @param num  int整型一维数组
         * @param size int整型
         * @return int整型ArrayList
         */
        public ArrayList<Integer> maxInWindows(int[] num, int size) {
            // write code here
            ArrayList<Integer> res = new ArrayList<Integer>();
            if (size > num.length) {
                return res;
            }
            if (size == 0) {
                return res;
            }
            ArrayDeque<Integer> deque = new ArrayDeque<>();
            int i = 0;
            int j = 0;
            while (j < size) {
                while (!deque.isEmpty() && num[j] > num[deque.peekFirst()]) {
                    deque.removeFirst();
                }
                if (deque.isEmpty() || num[j] < num[deque.peekFirst()]) {
                    deque.addLast(j);
                }
                j++;
            }
            while (j < num.length) {
                Integer integer = deque.peekFirst();
                res.add(num[integer]);
                if (i == integer) {
                    deque.removeFirst();
                }
                while (!deque.isEmpty() && num[j] > num[deque.peekFirst()]) {
                    deque.removeFirst();
                }
                if (deque.isEmpty() || num[j] < num[deque.peekFirst()]) {
                    deque.addLast(j);
                }
                i++;
                j++;
            }
            int max = Integer.MIN_VALUE;
            while (i < j) {
                max = Math.max(num[i], max);
            }
            res.add(max);
            return res;
        }
    }

    //BM46 最小的K个数
    public class Solution46 {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * @param input int整型一维数组
         * @param k     int整型
         * @return int整型ArrayList
         */
        public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
            // write code here
            ArrayList<Integer> res = new ArrayList<Integer>();
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for (int i = 0; i < input.length; i++) {
                queue.add(input[i]);
            }
            int count = 0;
            while (!queue.isEmpty()) {
                if (count == k) {
                    break;
                }
                res.add(queue.remove());
                count++;
            }
            return res;
        }
    }

    //BM47 寻找第K大
    public class Solution47 {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * @param a int整型一维数组
         * @param n int整型
         * @param K int整型
         * @return int整型
         */
        public int findKth(int[] a, int n, int K) {
            // write code here
            Arrays.sort(a);
            return a[n - K];
        }
    }

    //BM48 数据流中的中位数
    public class Solution48 {
        ArrayList<Integer> list = new ArrayList<Integer>();
        public void Insert(Integer num) {
            list.add(num);
        }

        public Double GetMedian() {
            list.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            int size = list.size();
            if (size % 2 == 0) {
                return (list.get(size / 2) + list.get(size / 2 - 1)) / 2.0;
            } else {
                return Double.valueOf(list.get(size / 2));
            }
        }
    }

    //BM49 表达式求值
    public class Solution49 {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * 返回表达式的值
         * @param s string字符串 待计算的表达式
         * @return int整型
         */
        public int solve (String s) {
            // write code here
            s = s.replaceAll(" ", "");
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            map.put('+', 1);
            map.put('-', 1);
            map.put('*', 2);
            ArrayDeque<Integer> nums = new ArrayDeque<>();
            nums.addLast(0);
            ArrayDeque<Character> ops = new ArrayDeque<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    ops.add(c);
                } else if (c == ')') {
                    //计算到下一个左括号位置
                    while (!ops.isEmpty()) {
                        if (ops.peekLast() != '(') {
                            calc(nums, ops);
                        } else {
                            ops.removeLast();
                            break;
                        }
                    }
                } else {
                    if (c >= '0' && c <= '9') {
                        int u = 0;
                        int j = i;
                        while (j < s.length() && s.charAt(j) >= '0' && s.charAt(j) <= '9') {
                            u = u * 10 + (s.charAt(j) - '0');
                            j++;
                        }
                        nums.addLast(u);
                        i = j - 1;
                    } else {
                        //计算
                        if (i > 0 && (s.charAt(i - 1) == '(' || s.charAt(i - 1) == '+' ||
                                s.charAt(i - 1) == '-')) {
                            nums.addLast(0);
                        }
                        while (!ops.isEmpty() && ops.peekLast() != '(') {
                            Character prePos = ops.peekLast();
                            if (map.get(prePos) >= map.get(c)) {
                                calc(nums, ops);
                            } else {
                                break;
                            }
                        }
                        ops.addLast(c);
                    }
                }
            }
            while (!ops.isEmpty() && ops.peekLast() != '(') calc(nums, ops);
            return nums.peekLast();
        }

        void calc(Deque<Integer> nums, Deque<Character> ops) {
            if (nums.isEmpty() || nums.size() < 2) return;
            if (ops.isEmpty()) return;
            int b = nums.removeLast(), a = nums.removeLast();
            char op = ops.removeLast();
            int ans = 0;
            if (op == '+') ans = a + b;
            else if (op == '-') ans = a - b;
            else if (op == '*') ans = a * b;
            nums.addLast(ans);
        }
    }

    //BM50 两数之和
    public class Solution50 {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         *
         * @param numbers int整型一维数组
         * @param target int整型
         * @return int整型一维数组
         */
        public int[] twoSum (int[] numbers, int target) {
            // write code here
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            for(int i=0;i<numbers.length;i++){
                map.put(target-numbers[i],i);
            }
            for(int i=0;i<numbers.length;i++){
                Integer integer = map.get(numbers[i]);
                if(integer!=null && i!=integer){
                    if(i<integer){
                        return new int[]{i+1,integer+1};
                    }else {
                        return new int[]{integer+1,i+1};
                    }
                }
            }
            return new int[]{-1,-1};
        }
    }

    //BM51 数组中出现次数超过一半的数字
    public class Solution51 {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         *
         * @param numbers int整型一维数组
         * @return int整型
         */
        public int MoreThanHalfNum_Solution (int[] numbers) {
            // write code here
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i=0;i<numbers.length;i++){
                map.put(numbers[i],map.getOrDefault(numbers[i],0)+1);
            }
            for (Map.Entry<Integer,Integer> e:map.entrySet()){
                if(e.getValue()>numbers.length/2){
                    return e.getKey();
                }
            }
            return -1;
        }
    }

    //BM52 数组中只出现一次的两个数字
    public class Solution52 {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         *
         * @param nums int整型一维数组
         * @return int整型一维数组
         */
        public int[] FindNumsAppearOnce (int[] nums) {
            // write code here
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i=0;i<nums.length;i++){
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            }
            int a=0;
            int b=0;
            for (Map.Entry<Integer,Integer> e:map.entrySet()){
                if(e.getValue()==1){
                    if(a!=0){
                        b=e.getKey();
                    }else{
                        a=e.getKey();
                    }
                }
            }
            if(a>b){
                return new int[]{b,a};
            }else{
                return new int[]{a,b};
            }
        }
    }

    //BM53 缺失的第一个正整数
    public class Solution53 {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         *
         * @param nums int整型一维数组
         * @return int整型
         */
        public int minNumberDisappeared (int[] nums) {
            // write code here
            HashSet<Integer> set = new HashSet<>();
            for(int i=0;i<nums.length;i++){
                set.add(nums[i]);
            }
            for(int i=1;i<nums.length+1;i++){
                if(!set.contains(i)){
                    return i;
                }
            }
            return nums.length+1;
        }
    }

    //BM54 三数之和
    public class Solution54 {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         *
         * @param num int整型一维数组
         * @return int整型ArrayList<ArrayList<>>
         */
        public ArrayList<ArrayList<Integer>> threeSum (int[] num) {
            // write code here
            ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
            Arrays.sort(num);
            int n=num.length;
            for(int i=0;i<n;i++){
                if(i>0 && num[i]==num[i-1]){
                    continue;
                }
                int left=i+1;
                int right=n-1;
                while (left<right){
                    if(num[i]+num[left]+num[right]==0){
                        ArrayList<Integer> integers = new ArrayList<>();
                        integers.add(num[i]);
                        integers.add(num[left]);
                        integers.add(num[right]);
                        res.add(integers);
                        while (left<right && num[left]==num[left+1]){
                            left++;
                        }
                        while (left<right&&num[right]==num[right-1]){
                            right--;
                        }
                        left++;
                        right--;
                    }else if(num[i]+num[left]+num[right]>0){
                        right--;
                    }else{
                        left++;
                    }
                }
            }
            return res;
        }
    }
}
