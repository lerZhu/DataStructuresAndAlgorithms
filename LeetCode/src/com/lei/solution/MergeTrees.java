package com.lei.solution;

import com.lei.datastr.TreeNode;

/**
 * @author zhulei
 * @create 2021-05-10 23:03
 */
public class MergeTrees {
    public static void main(String[] args) {
        Integer[] tree1 = {1,3,2,5};
        Integer[] tree2 = {2,1,3,null,4,null,7};

        MergeTrees demo = new MergeTrees();
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode merged = new TreeNode(root1.val + root2.val);
        merged.left = mergeTrees(root1.left,root2.left);
        merged.right = mergeTrees(root1.right,root2.right);
        return merged;
    }
}
