package com.lei.solution;

import com.lei.datastr.TreeNode;

/**
 * @author zhulei
 * @create 2021-07-15 22:15
 */
public class MinDepth {
    public static void main(String[] args) {

    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null || root.right == null) {
            return 1;
        }

        int minDepth = Integer.MAX_VALUE;

        if (root.left != null) {
            return Math.min(minDepth(root.left),minDepth);
        }

        if (root.right != null) {
            return Math.min(minDepth(root.right),minDepth);
        }

        return minDepth + 1;
    }
}
