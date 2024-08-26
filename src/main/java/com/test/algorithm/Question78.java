package com.test.algorithm;

import java.util.*;

/**
 * 78. 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 子集不重复
 */
public class Question78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            // 不同个数的子集
            Stack<Integer> list = new Stack<>();
            dfs(nums, 0, i, list, res);
        }
        return res;
    }

    private void dfs(int[] nums, int index, int expectLen, Stack<Integer> list, List<List<Integer>> res) {
        if (list.size() == expectLen) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            list.push(nums[i]);
            dfs(nums, i + 1, expectLen, list, res);
            list.pop();
        }
    }

    public static void main(String[] args) {
        Question78 question78 = new Question78();
        System.out.println(question78.subsets(new int[]{1, 2, 3}));
    }
}
