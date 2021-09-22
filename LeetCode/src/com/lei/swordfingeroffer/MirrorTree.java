package com.lei.swordfingeroffer;

import com.lei.datastr.TreeNode;

/**
 * @author zhulei
 * @create 2021-07-22 23:11
 */
public class MirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);
        return root;
    }
}
