package com.test.algorithm;

/**
 * 给定整数n，求n个节点的二叉搜索树的不同形态个数
 */
public class Question96 {
    public int numTrees(int n) {
        if (n == 1 || n == 0) {
            // 仅有一个点的时候仅存在一种情况
            return 1;
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + numTrees(i) * numTrees(n -i -1);
        }
        return sum;
    }

    public static void main(String[] args) {
        Question96 question96 = new Question96();
        System.out.println(question96.numTrees(3));
    }
}
