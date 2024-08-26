package com.test.algorithm;

import java.util.Arrays;

public class Question75 {

    public void sortColors(int[] nums) {
//        Arrays.sort(nums);
        int position0 = 0;
        int position1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[position1];
                nums[position1] = temp;
                position1 ++;
            }
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[position0];
                nums[position0] = temp;
                if (position0 < position1) {
                    int temp1 = nums[i];
                    nums[i] = nums[position1];
                    nums[position1] = temp1;
                }
                position1++;
                position0++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,0,2,1,1,0};
        Question75 question75 = new Question75();
        question75.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
