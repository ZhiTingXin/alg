package com.test.algorithm;

import com.test.common.tree.TreeNode;

import java.util.*;

public class Question102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);
        while (!treeNodes.isEmpty()) {
            List<Integer> integers = new ArrayList<>();
            int levelSize = treeNodes.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = treeNodes.poll();
                if (node != null) {
                    integers.add(node.val);
                    if (node.left != null) {
                        treeNodes.offer(node.left);
                    }
                    if (node.right != null) {
                        treeNodes.offer(node.right);
                    }
                }
            }
            result.add(integers);
        }
        return result;
    }

    public static void main(String[] args) {
        Question102 question102 = new Question102();
        System.out.println(question102.levelOrder(null));
        TreeNode node = new TreeNode(2);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(4, node1, node);

        System.out.println(question102.levelOrder(null));
        System.out.println(question102.levelOrder(node2));
        System.out.println(question102.levelOrder(node1));
    }
}
