package com.jhj.algorithm.tree;

public class BST {
    Node root;
    class Node{
        Node left;
        Node right;
        int key;
        Node parent;
        public Node(Node left,Node right,Node parent,int key){
            this.left=left;
            this.right=right;
            this.parent=parent;
            this.key=key;
        }
    }

    //先序
    private void preOrder(Node root){
        if(root==null){
            return;
        }
        System.out.println(root.key);
        preOrder(root.left);
        preOrder(root.right);
    }
    public void preOrder(){
        preOrder(root);
    }

    //中序
    private void inOrder(Node root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.println(root.key);
        inOrder(root.right);
    }
    public void inOrder(){
        inOrder(root);
    }

    //后序
    private void postOrder(Node root){
        if(root==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.key);
    }
    public void postOrder(){
        postOrder(root);
    }

    //查找
    private Node find(int key,Node root){
        if(root==null){
            return null;
        }
        if(key<root.key){
            return find(key,root.left);
        }else if(key>root.key){
            return find(key,root.right);
        }else {
            return root;
        }
    }

    public int find(int key){
        Node node = find(key, root);
        return node==null?null:node.key;
    }

    //最大
    private Node max(Node root){
        if(root==null){
            return root;
        }
        while (root.right!=null){
            root=root.right;
        }
        return root;
    }
    public int max(){
        Node max = max(root);
        return max==null?null:max.key;
    }
    //最小
    private Node min(Node root){
        if(root==null){
            return root;
        }
        while (root.left!=null){
            root=root.left;
        }
        return root;
    }
    public int min(){
        Node min = min(root);
        return min==null?null:min.key;
    }
    //前驱
    private Node predecessor(Node root){
        if(root.left!=null){
            return max(root.left);
        }
        //节点如果是右节点 则为父
        //节点如果是左节点 找最近的父 并且该父为它的父的右
        Node parent = root.parent;
        while (parent!=null&&root==parent.left){
            root=parent;
            parent=parent.parent;
        }
        return parent;
    }
}
