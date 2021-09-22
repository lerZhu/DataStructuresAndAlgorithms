package com.lei.datastr;

/**
 * @author zhulei
 * @create 2021-05-05 22:41
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    //前序遍历
    public void preOrder() {
        //先输出父节点
        System.out.println(this);
        //递归向左
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null){
            this.right.preOrder();
        }
    }
    //中序遍历
    public void infixOrder() {
        //递归向左
        if (this.left != null) {
            this.left.infixOrder();
        }
        //先输出父节点
        System.out.println(this);
        if (this.right != null){
            this.right.infixOrder();
        }
    }
    //后序遍历
    public void postOrder() {
        //递归向左
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null){
            this.right.postOrder();
        }
        //先输出父节点
        System.out.println(this);
    }
}
