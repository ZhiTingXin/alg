package com.test.algorithm;

import com.test.common.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Question98 {
    public boolean isValidBST(TreeNode root) {
        // 框定范围，递归检查
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        long left = Long.MIN_VALUE;
        long right = Long.MAX_VALUE;
        return valid(root, left, right);
    }

    public boolean valid(TreeNode tree, long left, long right) {
        if (tree == null) {
            return true;
        }
        int rootVal = tree.val;
        if (rootVal <= left || rootVal >= right) {
            return false;
        }
        return valid(tree.left, left, rootVal) && valid(tree.right, rootVal, right);
    }
    public boolean isValidBST2(TreeNode root) {
        // 采用中序遍历的思路进行解决
        List<Integer> res = inOrder(root);
        if (res.size() >= 2) {
            for (int i = 1; i < res.size(); i++) {
                if (res.get(i) <= res.get(i-1)) {
                    return false;
                }
            }
        }
        return true;
    }


    public List<Integer> inOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>(inOrder(root.left));
        res.add(root.val);
        res.addAll(inOrder(root.right));
        return res;
    }

    public static void main(String[] args) {
        Question98 question98 = new Question98();
        TreeNode treeNode = new TreeNode(2147483647);
        TreeNode treeNode1 = new TreeNode(0);
        TreeNode treeNode2 = new TreeNode(2, treeNode, treeNode1);
        System.out.println(question98.isValidBST(treeNode));
        System.out.println(question98.isValidBST2(treeNode));

        System.out.println(question98.isValidBST(treeNode1));
        System.out.println(question98.isValidBST2(treeNode1));
        System.out.println(question98.isValidBST(treeNode2));
        System.out.println(question98.isValidBST2(treeNode2));
    }
}
