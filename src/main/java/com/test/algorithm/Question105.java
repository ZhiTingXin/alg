package com.test.algorithm;

import com.test.common.tree.TreeNode;

import java.util.Arrays;

public class Question105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildNode(preorder, inorder, 0, preorder.length - 1, 0, inorder.length-1);
    }

    private TreeNode buildNode(int[] preorder, int[] inorder, int left0, int right0, int left1, int right1) {
        if (left0 > right0) {
            return null;
        }
        int indexOfRoot = indexOfValue(inorder, left1, right1, preorder[left0]);
        return new TreeNode(preorder[left0],
                buildNode(preorder, inorder, left0 + 1, left0 + indexOfRoot - left1, left1, indexOfRoot - 1),
                buildNode(preorder, inorder, left0 + indexOfRoot - left1 + 1, right0, indexOfRoot + 1, right1)
                );
    }

    private int indexOfValue(int[] array, int left, int right, int value) {
        for (int i = left; i <= right; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Question105 question105 = new Question105();
        TreeNode node = question105.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
        System.out.println(node.val);
    }
}
