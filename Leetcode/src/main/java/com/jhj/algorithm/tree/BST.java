package com.jhj.algorithm.tree;

public class BST {
    private BSTNode root;

    public class BSTNode{
        int key;
        BSTNode left;
        BSTNode right;
        BSTNode parent;
        public BSTNode(int key,BSTNode parent,BSTNode left,BSTNode right){
            this.key=key;
            this.left=left;
            this.right=right;
            this.parent=parent;
        }
    }
    //前序遍历
    private void preOrder(BSTNode root){
        if (root!=null){
            System.out.println(root.key);
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    public void preOrder(){
        preOrder(root);
    }

    //中序遍历
    private void midOrder(BSTNode root){
        if(root!=null){
            midOrder(root.left);
            System.out.println(root.key);
            midOrder(root.right);
        }
    }
    public void midOrder(){
        midOrder(root);
    }
    //后序遍历
    private void postOder(BSTNode root){
        if(root!=null){
            preOrder(root.left);
            preOrder(root.right);
            System.out.println(root.key);
        }
    }
    public void postOrder(){
        postOder(root);
    }

    //查找
    private BSTNode find(BSTNode root,int key){
        if(root==null){
            return root;
        }
        if(root.key>key){
            return find(root.left,key);
        }else if(root.key<key){
            return find(root.right,key);
        }else{
            return root;
        }
    }
    public BSTNode find(int key){
        return find(root,key);
    }
    //最大
    private BSTNode max(BSTNode root){
        if(root==null){
            return null;
        }
        while (root.right!=null){
            root=root.right;
        }
        return root;
    }
    public int max(){
        BSTNode max = max(root);
        return max==null?null:max.key;
    }

    //最小
    private BSTNode min(BSTNode root){
        if(root==null){
            return root;
        }
        while (root.left!=null){
            root=root.left;
        }
        return root;
    }
    public int min(){
        BSTNode min = min(root);
        return min==null?null:min.key;
    }
    //前驱节点
    //如果左子数不为空 则为左子树最大的
    //如果左子树为空 该节点为父的右子树 则为父节点
    //如果左子树为空 该节点为父的左子树 则为最进的父节点 且父节点有右子树
    // 中
    //   右
    //  左   中小于左
    public BSTNode predecessor(BSTNode root){
        if(root.left!=null)
            return max(root.left);
        BSTNode y=root.parent;
        while (y!=null&&(root==y.left)){
            root=y;
            y=y.parent;
        }
        return y;
    }

    //后继
    //有 右子树 右子树最小值
    //为父的左子树 为父
    //为父的右子树 该节点为父的右子树 且父有左子树
    //   左
    // 中
    //  右
    public BSTNode successor(BSTNode root){
        if(root.right!=null){
            return min(root.right);
        }
        BSTNode y = root.parent;
        while (y!=null&&(root==y.right)){
            root=y;
            y=y.parent;
        }
        return y;
    }
    //该插入的位置一定是子节点 所以找到该插入的位置 然后把z 插入进去 如果树为空则跟节点设为它
    private void insert(BST tree,BSTNode z){
        //找到的位置
        BSTNode y=null;
        BSTNode root=tree.root;
        while (root!=null){
            y=root;
            if(z.key< root.key){
                root=root.left;
            }else{
                root=root.right;
            }
        }
        z.parent=y;
        //如果y是null说明树是空的
        if(y==null){
            tree.root=z;
        }else {
            if(z.key< y.key){
                y.left=z;
            }else{
                y.right=z;
            }
        }


    }
    //插入
    public void insert(int key){
        BSTNode bstNode = new BSTNode(key, null, null, null);
        if(bstNode!=null){
            insert(this,bstNode);
        }
    }
    //删除
    public BSTNode remove(BST tree,BSTNode z){
        BSTNode x=null;
        BSTNode y=null;
        //左右有一个为null 由孩子节点替换
        if(z.left==null||z.right==null){
            y=z;
        }else{
            y=predecessor(z);
        }

        if(y.left!=null){
            x=y.left;
        }else{
            x=y.right;
        }

        //y是要删除的节点 x不为空则说明有子节点 子节点替换了
        if(x!=null){
            x.parent=y.parent;
        }
        //删除的是头
        if (y.parent == null)
            tree.root = x;
        else if (y == y.parent.left) //删除左节点
            y.parent.left = x;
        else        //删除右节点
            y.parent.right = x;

        if(y!=z){ //代表不右子节点替换 左右子树都有
            z.key=y.key;
        }
        return y;
    }
    public void remove(int key){
        BSTNode z,node;
        if((z=find(root,key))!=null){
            if((node=remove(this,z))!=null){
                node=null;
            }
        }
    }


    //销毁
    private void destory(BSTNode root){
        if(root==null){
            return;
        }
        if(root.left!=null){
            destory(root.left);
        }
        if(root.right!=null){
            destory(root.right);
        }
        root=null;
    }
    public void destory(){
        destory(root);
        root=null;
    }

    //打印
    private void print(BSTNode tree, int key, int direction) {

        if(tree != null) {

            if(direction==0)    // tree是根节点
                System.out.printf("%2d is root\n", tree.key);
            else                // tree是分支节点
                System.out.printf("%2d is %2d's %6s child\n", tree.key, key, direction==1?"right" : "left");

            print(tree.left, tree.key, -1);
            print(tree.right,tree.key,  1);
        }
    }

    public void print() {
        if (root != null)
            print(root, root.key, 0);
    }
    public static void main(String[] args) {
        final int arr[] = {3,4,5,6,10,15,16};

        int i, ilen;
        BST tree=new BST();

        System.out.print("== 依次添加: ");
        ilen = arr.length;
        for(i=0; i<ilen; i++) {
            System.out.print(arr[i]+" ");
            tree.insert(arr[i]);
        }

        System.out.print("\n== 前序遍历: ");
        tree.preOrder();

        System.out.print("\n== 中序遍历: ");
        tree.midOrder();

        System.out.print("\n== 后序遍历: ");
        tree.postOrder();
        System.out.println();

        System.out.println("== 最小值: "+ tree.min());
        System.out.println("== 最大值: "+ tree.max());
        System.out.println("== 树的详细信息: ");
        tree.print();

        System.out.print("\n== 删除根节点: "+ arr[4]);
        tree.remove(arr[3]);

        System.out.print("\n== 中序遍历: ");
        tree.midOrder();
        System.out.println();

        // 销毁二叉树
        tree.destory();
    }
}
