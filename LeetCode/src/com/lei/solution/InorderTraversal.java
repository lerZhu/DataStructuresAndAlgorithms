package com.lei.solution;

import com.lei.datastr.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhulei
 * @create 2021-05-06 23:47
 */
public class InorderTraversal {

    List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        infixOrder(root);
        return list;
    }

    public void infixOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            infixOrder(root.left);
        }
        list.add(root.val);
        if (root.right != null) {
            infixOrder(root.right);
        }
    }
}
