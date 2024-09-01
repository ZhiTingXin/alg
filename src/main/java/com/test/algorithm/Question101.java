package com.test.algorithm;

import com.test.common.tree.TreeNode;

public class Question101 {
    public boolean isSymmetric(TreeNode root) {
        return recursion(root, root);
    }

    public boolean recursion(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            //其中一个为null
            return false;
        }
        return left.val == right.val
                && recursion(left.left, right.right) && recursion(left.right, right.left);
    }

    public static void main(String[] args) {
        Question101 question101 = new Question101();
        System.out.println(question101.isSymmetric(null));
    }
}
