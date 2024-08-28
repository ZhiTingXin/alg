package com.test.algorithm;

import java.util.Arrays;
import java.util.Stack;

/**
 * 84. 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */
public class Question84 {
    public int largestRectangleArea(int[] heights) {
        // 固定高度实现
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            int left = i;
            while (left > 0 && heights[left - 1] >= height) {
                left--;
            }
            int right = i;
            while (right < heights.length - 1 && heights[right + 1] >= height) {
                right++;
            }
            maxArea = Math.max(maxArea, (right - left + 1) * height);
        }
        return maxArea;
    }
    public int largestRectangleArea2(int[] heights) {
        // 单调栈实现
        int[] leftIndex = new int[heights.length];
        int[] rightIndex = new int[heights.length];
        Arrays.fill(rightIndex, heights.length);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                // 比我大不需要care
                rightIndex[stack.peek()] = i;
                stack.pop();
            }
            leftIndex[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, (rightIndex[i] - leftIndex[i] - 1) * heights[i]);
        }
        return maxArea;
    }
    public static void main(String[] args) {
        Question84 q = new Question84();
        System.out.println(q.largestRectangleArea(new int[]{2,1,5,6,2,3}));
        System.out.println(q.largestRectangleArea2(new int[]{2,1,5,6,2,3}));
    }
}
