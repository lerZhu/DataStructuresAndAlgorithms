package com.company.huffmantree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author zhulei
 * @create 2021-04-16 11:03
 */
public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = new int[] {13,7,8,3,29,6,1};
        Node huffmanTree = createHuffmanTree(arr);
        huffmanTree.preOrder();

    }

    public static Node createHuffmanTree(int[] arr) {
        //遍历arr
        //将arr的每个元素构建成一个Node
        //将node放入ArrayList中
        List<Node> nodes = new ArrayList<>();
        for (int value : arr) {
            nodes.add(new Node(value));
        }

        while (nodes.size() > 1) {
            //排序
            Collections.sort(nodes);

            //取出根节点权值最小的两颗二叉树
            //取出权值最小的节点
            Node leftNode = nodes.get(0);
            //取出权值第二小的节点
            Node rightNode = nodes.get(1);

            //构建一颗新的树
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;

            //从arrlist中删除处理过的二叉树
            nodes.remove(leftNode);
            nodes.remove(rightNode);

            //将parent加入到nodes
            nodes.add(parent);
        }

        //返回赫夫曼树root节点
        return nodes.get(0);
    }
}

//创建节点类
class Node implements Comparable<Node>{

    int value;
    Node left;
    Node right;

    //前序遍历
    public void preOrder() {
        System.out.println(this.value);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null ) {
            this.right.preOrder();
        }
    }

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }
}
