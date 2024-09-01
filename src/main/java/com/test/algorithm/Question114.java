package com.test.algorithm;

import com.test.common.tree.TreeNode;

public class Question114 {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flattenNode(root);
    }

    private TreeNode flattenNode(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }
        TreeNode rightNode = flattenNode(treeNode.right);
        treeNode.right = flattenNode(treeNode.left);
        treeNode.left = null;
        TreeNode prt = treeNode;
        while (prt.right != null) {
            prt = prt.right;
        }
        prt.right = rightNode;
        return treeNode;
    }

    public static void main(String[] args) {
        Question114 question114 = new Question114();
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode = new TreeNode(1, treeNode4, null);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode root = new TreeNode(3, treeNode1, treeNode);
        question114.flatten(root);
    }
}
