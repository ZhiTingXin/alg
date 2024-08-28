package com.test.algorithm;

import java.util.Arrays;
import java.util.Stack;

/**
 * hard，矩阵中充满了0和1，求1的最大面积
 */
public class Question85 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int[][] left = new int[matrix.length][matrix[0].length];
        // 初始化左侧1的个数的dp数组，简单dp
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = j == 0 ? 1 : left[i][j - 1] + 1;
                }
            }
        }
        int maxArea = 0;
        for (int j = 0; j < matrix[0].length; j++) {
            int[] leftIndex = new int[matrix.length];
            int[] rightIndex = new int[matrix.length];
            Arrays.fill(rightIndex, matrix.length);
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < matrix.length; i++) {
                while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]) {
                    rightIndex[stack.peek()] = i;
                    stack.pop();
                }
                leftIndex[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }
            for (int i = 0; i < matrix.length; i++) {
                maxArea = Math.max(maxArea, (rightIndex[i] - leftIndex[i] - 1) * left[i][j]);
            }
            // 计算以i,j为右下角点的最大矩形面积
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Question85 q = new Question85();
        System.out.println(q.maximalRectangle(new char[][]{{'1','0','1','0','0'},
                {'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}}));
    }
}
