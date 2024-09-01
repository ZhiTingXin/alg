package com.test.algorithm;

import com.test.common.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Question104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int level = 0;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            level ++;
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.poll();
                if (node != null) {
                    if (node.left != null) {
                        nodes.offer(node.left);
                    }
                    if (node.right != null) {
                        nodes.offer(node.right);
                    }
                }
            }
        }
        return level;
    }

    public static void main(String[] args) {
        Question104 question104 = new Question104();
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);
        TreeNode node8 = new TreeNode(8);

        TreeNode nodeN1 = new TreeNode(1, node5, node1);
        TreeNode node3 = new TreeNode(3, null, node6);
        TreeNode node_1 = new TreeNode(-1, null ,node8);
        TreeNode node = new TreeNode(2, nodeN1, null);
        TreeNode node4 = new TreeNode(4, node3, node_1);
        TreeNode nodeRoot = new TreeNode(3, node, node4);
        System.out.println(question104.maxDepth(nodeRoot));
    }
}
