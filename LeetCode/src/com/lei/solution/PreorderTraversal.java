package com.lei.solution;

import com.lei.datastr.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhulei
 * @create 2021-07-14 23:22
 */
public class PreorderTraversal {
    public static void main(String[] args) {

    }

    List<Integer> list = new ArrayList<>();

    public void preOrder(TreeNode node) {
        list.add(node.val);
        if (node.left != null) {
            preOrder(node.left);
        }
        if (node.right != null) {
            preOrder(node.right);
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }else {
            preOrder(root);
        }
        return list;
    }
}
