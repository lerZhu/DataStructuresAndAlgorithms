package com.company.binarysorttree;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhulei
 * @create 2021-04-17 15:40
 */
public class binarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = new int[] {7,3,10,12,5,1,9,2};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }

        binarySortTree.infixOrder();
        System.out.println();

        //删除叶子结点
        binarySortTree.delNode(7);
        binarySortTree.infixOrder();
    }
}

//创建二叉排序树
class BinarySortTree{

    private Node root;

    /**
     * 查找要删除的节点
     * @param value
     * @return
     */
    public Node search(int value) {
        if (root == null) {
            return null;
        }else {
            return root.search(value);
        }
    }

    /**
     * 查找要删除节点的父节点
     * @param value
     * @return
     */
    public Node searchParent(int value) {
        if (root == null) {
            return null;
        }else {
            return root.searchParent(value);
        }
    }

    /**
     *  1、返回以node为根节点的二叉排序树的最小节点的值
     *  2、删除node为根节点的二叉排序树的最小节点
     * @param node  传入的节点（当做一颗二叉排序树的根节点）
     * @return  以node为根节点的二叉排序树的最小节点的值
     */
    public int delRightTreeMin(Node node) {
        Node temp = node;
        //循环左节点，找到最小值
        while (temp.left != null) {
            temp = temp.left;
        }
        //这时，temp指向最小节点
        delNode(temp.value);
        return temp.value;
    }

    /**
     * 1、返回以node为根节点的二叉排序树的左子树的最大节点的值
     * 2、删除node为根节点的二叉排序树的左子树的最大节点
     * @param node 传入的节点（当做一颗二叉排序树的根节点）
     * @return 以node为根节点的二叉排序树的左子树的最大节点的值
     */
    public int delLeftTreeMax(Node node) {
        Node temp = node;
        //循环右节点，找到最大值
        while (temp.right != null) {
            temp = temp.right;
        }
        delNode(temp.value);
        return temp.value;
    }

    /**
     * 删除节点
     * @param value
     */
    public void delNode(int value) {
        if (root == null) {
            return;
        }else {
            //1、先找到要删除的节点targetNode
            Node targetNode = search(value);
            //没有找到要删除的节点
            if (targetNode == null) {
                return;
            }
            //当前二叉排序树只有一个节点
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }
            //找到targetNode的父节点
            Node parent = searchParent(value);
            //targetNode是叶子结点
            if (targetNode.left == null && targetNode.right == null) {
                //要删除的是左子节点
                if (parent.left != null && parent.left.value == value) {
                    parent.left = null;
                }else if (parent.right != null && parent.right.value == value) {
                    parent.right = null;
                }
            }else if (targetNode.left!= null && targetNode.right != null) { //删除有两颗子树的节点
//                int minValue = delRightTreeMin(targetNode.right);
//                targetNode.value = minValue;
                int maxValue = delLeftTreeMax(targetNode.left);
                targetNode.value = maxValue;
            }else { //删除只有一颗子树的节点
                //要删除的节点有左子节点
                if (targetNode.left != null) {
                    if (parent != null) {
                        //targetNode是parent的左子节点
                        if (parent.left.value == value) {
                            parent.left = targetNode.left;
                        }else { //targetNode是parent的右子节点
                            parent.right = targetNode.left;
                        }
                    }else {
                        root = targetNode.left;
                    }

                }else { //要删除的节点有右子节点
                    if (parent != null) {
                        //targetNode是parent的左子节点
                        if (parent.left.value == value) {
                            parent.left = targetNode.right;
                        }else { //targetNode是parent的右子节点
                            parent.right = targetNode.right;
                        }
                    }else {
                        root = targetNode.right;
                    }
                }
            }
        }
    }

    /**
     * 添加节点
     * @param node
     */
    public void add(Node node) {
        if (root == null) {
            root = node;
        }else {
            root.add(node);
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        }else {
            System.out.println("二叉排序树为空");
        }
    }

}

//创建Node节点
class Node{

    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    /**
     * 查找要删除的节点
     * @param value 希望要删除的节点的值
     * @return 该节点
     */
    public Node search(int value) {
        if (value == this.value) {
            return this;
        }else if (value < this.value) {//如果查找的值小于当前节点，向左子树递归查找
            if (this.left == null) {
                return null;
            }
            return this.left.search(value);
        }else {//查找的值不小于当前节点，向右子树递归
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }
    }

    /**
     * 查找严删除节点的父节点
     * @param value 要删除的值
     * @return  要删除的节点的父节点
     */
    public Node searchParent(int value) {
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;
        }else {
            //如果查找的值小于当前的值，并且当前节点的左子节点不为空
            if (value < this.value && this.left != null) {
                return this.left.searchParent(value);
            }else if (value >= this.value && this.right != null) {
                return this.right.searchParent(value);
            }else {
                //没有找到父节点
                return null;
            }
        }
    }

    //添加节点
    //递归的形式添加节点，需要满足二叉排序树的要求
    public void add(Node node) {
        if (node == null) {
            return;
        }

        //判断传入节点的值，和当前子树的根节点的值得关系
        if (node.value < this.value) {
            if (this.left == null)  {
                this.left = node;
            }else {
                this.left.add(node);
            }
        }else {
            if (this.right == null) {
                this.right = node;
            }else {
                this.right.add(node);
            }
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }
}
