package com.jhj.algorithm.leetcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Leetcode {
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    class Solution {
        HashMap<Node, Node> map = new HashMap<>();
        public Node cloneGraph(Node node) {
            if(node==null){
                return node;
            }
            if (map.containsKey(node)){
                return map.get(node);
            }
            Node node1 = new Node(node.val, new ArrayList<>());
            map.put(node,node1);
            for(Node n:node.neighbors){
                node1.neighbors.add(cloneGraph(n));
            }
            return node1;
        }
    }
}
