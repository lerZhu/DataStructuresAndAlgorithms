package com.lei.solution;

import com.lei.datastr.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhulei
 * @create 2021-05-10 21:57
 */
public class LeafSimilar {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(9);
        TreeNode node6 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(4);

        root1.left = node1;
//        root1.right = node2;
//        node1.left = node3;
//        node1.right = node4;
//        node2.left = node5;
//        node2.right = node6;
//        node4.left = node7;
//        node4.right = node8;

        root2.left = node2;
//        root2.right = node2;
//        node1.left = node3;
//        node1.right = node7;
//        node2.left = node8;
//        node2.right = node4;
//        node4.left = node5;
//        node4.right = node6;



        LeafSimilar demo = new LeafSimilar();
        List<Integer> list = new ArrayList<>();

        boolean b = demo.leafSimilar(root1, root2);
        System.out.println(b);

    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        Order(root1, list1);
        Order(root2, list2);

        if (list1.size() != list2.size()) {
            return false;
        }

        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }


        return true;
    }

    public void Order(TreeNode root,List<Integer> list) {
        if (root.right == null && root.left == null) {
            list.add(root.val);
        }else {
            if (root.left != null) {
                Order(root.left,list);
            }
            if (root.right != null) {
                Order(root.right,list);
            }
        }
    }
}
