package com.jhj.algorithm.leetcode;


import java.util.ArrayDeque;

public class Leetcode {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    class Solution {
        public Node connect(Node root) {
            if(root==null){
                return null;
            }
            ArrayDeque<Node> queue = new ArrayDeque<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int n = queue.size();
                Node last = null;
                for (int i = 1; i <= n; ++i) {
                    Node f = queue.poll();
                    if (f.left != null) {
                        queue.offer(f.left);
                    }
                    if (f.right != null) {
                        queue.offer(f.right);
                    }
                    if (i != 1) {
                        last.next = f;
                    }
                    last = f;
                }
            }
            return root;
        }
    }
}
