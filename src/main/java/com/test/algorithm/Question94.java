package com.test.algorithm;

import com.test.common.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * easy 二叉树的中序遍历
 */
public class Question94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        return reverse(root);
    }

    public List<Integer> reverse(TreeNode treeNode) {
        List<Integer> result = new ArrayList<>();
        if (treeNode.left != null) {
            result.addAll(reverse(treeNode.left));
        }
        result.add(treeNode.val);
        if (treeNode.right != null) {
            result.addAll(reverse(treeNode.right));
        }
        return result;
    }

    public static void main(String[] args) {
        Question94 question94 = new Question94();
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2, treeNode3, null);
        TreeNode treeNode = new TreeNode(1, null, treeNode2);
        List<Integer> res = question94.inorderTraversal(treeNode);
        System.out.println(res.toString());
        System.out.println(question94.inorderTraversal(null).toString());
        System.out.println(question94.inorderTraversal(treeNode3).toString());
    }
}
