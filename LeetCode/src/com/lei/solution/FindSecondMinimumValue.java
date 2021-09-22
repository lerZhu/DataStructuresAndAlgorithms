package com.lei.solution;

import com.lei.datastr.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * @author zhulei
 * @create 2021-07-27 21:35
 */
public class FindSecondMinimumValue {
    public static void main(String[] args) {
        FindSecondMinimumValue demo = new FindSecondMinimumValue();
        TreeNode root = new TreeNode(5);
        TreeNode left1 = new TreeNode(5);
        TreeNode right1 = new TreeNode(6);
        root.left = left1;
        root.right = right1;
        int secondMinimumValue = demo.findSecondMinimumValue(root);
        System.out.println(secondMinimumValue);
    }

    public int findSecondMinimumValue(TreeNode root) {
        preOrder(root);
        int n = list.size();
        int[] res = new int[n];
        int i = 0;
        for (Integer integer : list) {
            res[i] = integer;
            i++;
        }
        Arrays.sort(res);
        if (res[0] == res[n - 1]) {
            return -1;
        }
        int result = res[0];
        for (int j = 0; j < n; j++) {
            if (res[0] != res[i]) {
                result = res[i];
                break;
            }
        }
        return result;
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
}
