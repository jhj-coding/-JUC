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
    public Node predecessor(Node root){
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
    //后继
    public Node successor(Node root){
        //右子树不为空 右子树中最小的
        if(root.right!=null){
            return min(root.right);
        }
        //右子树为空 该节点为左子树 则为父
        //该节点为右子树 则为最近的父 父为左子树 的父
        Node parent = root.parent;
        while (parent!=null&&parent.right==root){
            root=parent;
            parent=parent.parent;
        }
        return parent;
    }

    //插入
    private void insert(BST tree,Node z){
        Node root=tree.root;
        Node y=null;
        while (root!=null){
            y=root;
            if(z.key<root.key){
                root=root.left;
            }else{
                root=root.right;
            }
        }
        z.parent=y;
        if(y==null){
            tree.root=z;
        }else{
            if(z.key>y.key){
                y.right=z;
            }else {
                y.left=z;
            }
        }
    }
    public void insert(int key){
        Node z = new Node(null, null, null,key);
        if(z!=null)
            insert(this,z);
    }
    //删除
    private void remove(BST tree,Node z){
        if(z.left==null&&z.right==null){
            Node parent = z.parent;
            if(parent.left==z){
                parent.left=null;
            }else{
                parent.right=null;
            }
            z=null;
        } else if(z.left==null){
            Node parent = z.parent;
            if(parent==null){
                this.root=z.right;
            }else{
                if(z==parent.left){
                    z.left.parent=parent;
                    parent.left=z.left;
                }else{
                    z.right.parent=parent;
                    parent.right=z.right;
                }
            }
            z=null;
        }else if(z.right==null){
            Node parent = z.parent;
            if(parent==null){
                this.root=z.left;
            }else{
                if(z==parent.left){
                    z.left.parent=parent;
                    parent.left=z.left;
                }else{
                    z.right.parent=parent;
                    parent.right=z.right;
                }
            }
            z=null;
        }else{
            Node y = predecessor(z);
            z.key=y.key;
            Node parent = y.parent;
            if(parent.left==y){
                parent.left=null;
            }else{
                parent.right=null;
            }
            y=null;

        }
    }
    public void remove(int key){
        Node z=null;
        if((z=find(key,root))!=null){
            remove(this,z);
        }

    }

    //打印
    private void print(Node root,int d){
        if(root!=null){
            if(d==0){
                System.out.println("root:"+root.key);
            }else{
                System.out.print("Node:"+root.key+"Parent:"+root.parent.key);
                System.out.println(d==1?"right" : "left");
            }
            print(root.left,-1);
            print(root.right,1);
        }
    }

    public void print(){
        if(root!=null){
            print(root,0);
        }
    }

    //销毁
    private void destroy(Node tree) {
        if (tree!=null){
            destroy(tree.left);
            destroy(tree.right);
            tree=null;
        }
    }
    public void clear(){
        destroy(root);
        root=null;
    }

    public static void main(String[] args) {
        int i, ilen;
        BST tree=new BST();
        int arr[] = {10,5,15,4,6,16,3};
        System.out.print("== 依次添加: ");
        ilen = arr.length;
        for(i=0; i<ilen; i++) {
            System.out.print(arr[i]+" ");
            tree.insert(arr[i]);
        }

        System.out.print("\n== 前序遍历: ");
        tree.preOrder();

        System.out.print("\n== 中序遍历: ");
        tree.inOrder();

        System.out.print("\n== 后序遍历: ");
        tree.postOrder();
        System.out.println();

        System.out.println("== 最小值: "+ tree.min());
        System.out.println("== 最大值: "+ tree.max());
        System.out.println("== 树的详细信息: ");
        tree.print();

        System.out.print("\n== 删除节点: "+ arr[0]);
        tree.remove(arr[0]);

        System.out.print("\n== 中序遍历: ");
        tree.inOrder();
        System.out.println();

        System.out.print("\n== 删除节点: "+ arr[1]);
        tree.remove(arr[1]);

        System.out.print("\n== 中序遍历: ");
        tree.inOrder();
        System.out.println();

        System.out.print("\n== 删除节点: "+ arr[6]);
        tree.remove(arr[6]);

        System.out.print("\n== 中序遍历: ");
        tree.inOrder();
        System.out.println();
        // 销毁二叉树
        tree.clear();
    }
}
