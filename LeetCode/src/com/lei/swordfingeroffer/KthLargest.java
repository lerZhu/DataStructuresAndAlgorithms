package com.lei.swordfingeroffer;

import com.lei.datastr.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhulei
 * @create 2021-07-26 21:42
 */
public class KthLargest {
    List<Integer> list = new ArrayList<>();

    public int kthLargest(TreeNode root, int k) {
        preOrder(root);
        int n = list.size();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = list.get(i);
        }
        Arrays.sort(res);
        return res[n - k];
    }

    public void preOrder(TreeNode node) {
        list.add(node.val);

        if (node.left != null) {
            preOrder(node.left);
        }

        if (node.right != null) {
            preOrder(node.right);
        }
    }
}
