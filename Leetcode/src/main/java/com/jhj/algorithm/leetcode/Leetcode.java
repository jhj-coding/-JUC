package com.jhj.algorithm.leetcode;


import java.util.ArrayList;
import java.util.Comparator;

class Solution {
    public class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode sortList(ListNode head) {
        ArrayList<Integer> res = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            res.add(cur.val);
            cur = cur.next;
        }
        res.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        ListNode pre = new ListNode(-1);
        ListNode curr = pre;
        for (int i = 0; i < res.size(); i++) {
            curr.next = new ListNode(res.get(i));
            curr = curr.next;
        }
        return pre.next;
    }
}
