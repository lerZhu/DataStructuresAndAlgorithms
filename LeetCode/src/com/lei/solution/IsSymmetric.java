package com.lei.solution;

import com.lei.datastr.TreeNode;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhulei
 * @create 2021-05-05 22:42
 */
public class IsSymmetric {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);

        root.left = node1;
        root.right = node2;

        IsSymmetric isSymmetric = new IsSymmetric();
        boolean symmetric = isSymmetric.isSymmetric(root);
        System.out.println(symmetric);

    }


    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        //如果同时满足下面的条件，两个树互为镜像：
        //它们的两个根结点具有相同的值
        //每个树的右子树都与另一个树的左子树镜像对称
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }

}
