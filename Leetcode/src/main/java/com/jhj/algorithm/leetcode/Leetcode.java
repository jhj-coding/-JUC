package com.jhj.algorithm.leetcode;


class Solution {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode mergeKLists(ListNode[] lists) {
      if(lists.length==0){
        return null;
      }
      return merge(lists,0,lists.length-1);
    }

    public ListNode merge(ListNode[] lists,int left,int right){
      if(left>right){
        return null;
      }
      if(left==right){
        return lists[left];
      }
      int mid=(left+right)>>1;
      return mergeTwo(merge(lists,left,mid),merge(lists,mid+1,right));
    }
    public ListNode mergeTwo(ListNode l1,ListNode l2){
      ListNode ppre=new ListNode(-1);
      ListNode pre=ppre;
      ListNode cur1=l1;
      ListNode cur2=l2;
      while (cur1!=null||cur2!=null){
        if(cur1!=null&&cur2!=null){
          if(cur1.val<cur2.val){
            pre.next=new ListNode(cur1.val);
            cur1=cur1.next;
            pre=pre.next;
          }else{
            pre.next=new ListNode(cur2.val);
            cur2=cur2.next;
            pre=pre.next;
          }
        }else if(cur1!=null){
          pre.next=new ListNode(cur1.val);
          cur1=cur1.next;
          pre=pre.next;
        }else{
          pre.next=new ListNode(cur2.val);
          cur2=cur2.next;
          pre=pre.next;
        }
      }
      return ppre.next;
    }
}
