package com.company.tree;

import java.util.ArrayList;

/**
 * @author zhulei
 * @create 2021-04-14 10:53
 */
public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7};
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(arr);
        arrayBinaryTree.preOrder();

        System.out.println();
        arrayBinaryTree.infixOrder();
    }
}

class ArrayBinaryTree {
    private int[] arr;

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    //重载preOrder
    public void preOrder(){
        preOrder(0);
    }

    public void infixOrder(){
        infixOrder(0);
    }

    /**
     * 编写一个方法，完成顺序存储二叉树的前序遍历
     * @param index 数组的下标
     */
    public void preOrder(int index) {
        //如果数组为空，或者arr.length = 0
        if (arr == null || arr.length == 0){
            System.out.println("数组为空，不能打印");
        }
        //输出当前元素
        System.out.print(arr[index] + ",");
        //向左递归遍历
        if (index * 2 + 1 < arr.length) {
            preOrder(2 * index + 1);
        }
        //向右递归
        if (index * 2 + 2 < arr.length) {
            preOrder(index * 2 + 2);
        }
    }

    /**
     * 编写一个方法，完成顺序存储二叉树的中序遍历
     * @param index 数组的下标
     */
    public void infixOrder(int index) {
        //如果数组为空，或者arr.length = 0
        if (arr == null || arr.length == 0){
            System.out.println("数组为空，不能打印");
        }
        //向左递归遍历
        if (index * 2 + 1 < arr.length) {
            infixOrder(2 * index + 1);
        }
        //输出当前元素
        System.out.print(arr[index] + ",");
        //向右递归
        if (index * 2 + 2 < arr.length) {
            infixOrder(index * 2 + 2);
        }
    }
}