package com.test.algorithm;

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

    }
    public static void main(String[] args) {
        Question84 q = new Question84();
        System.out.println(q.largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
}
