package com.jhj.algorithm.leetcode;

public class Test {
    class MyLinkedList {
        class My{
            int val;
            My next;
        }
        int size=0;
        My my;
        public MyLinkedList() {
            My my = new My();
            my.next=null;
            my.val=-1;
            this.my=my;
        }

        public int get(int index) {
            if(index>=size){
                return -1;
            }
            My cur=my.next;
            for(int i=0;i<index;i++){
                cur=cur.next;
            }
            return cur.val;
        }

        public void addAtHead(int val) {
            addAtIndex(0,val);
        }

        public void addAtTail(int val) {
            addAtIndex(size,val);
        }

        public void addAtIndex(int index, int val) {
            if(index>size){
                return;
            }
            My cur=my;
            for(int i=0;i<index;i++){
                cur=cur.next;
            }
            My my = new My();
            my.val=val;
            My next = cur.next;
            cur.next=my;
            my.next=next;
        }

        public void deleteAtIndex(int index) {
            if(index>=size){
                return;
            }
            My cur=my.next;
            My pre=my;
            for(int i=0;i<index;i++){
                pre=pre.next;
                cur=cur.next;
            }
            pre.next=cur.next;
            size--;
        }
    }

    /**
     * Your MyLinkedList object will be instantiated and called as such:
     * MyLinkedList obj = new MyLinkedList();
     * int param_1 = obj.get(index);
     * obj.addAtHead(val);
     * obj.addAtTail(val);
     * obj.addAtIndex(index,val);
     * obj.deleteAtIndex(index);
     */
    public static void main(String[] args) {

    }
}
