package com.lei.solution;

import com.lei.datastr.TreeNode;

/**
 * @author zhulei
 * @create 2021-07-15 21:49
 */
public class SortedArrayToBST {
    public static void main(String[] args) {

    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0 , nums.length);
    }

    public TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = (left + right) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1,right);
        return root;
    }
}
