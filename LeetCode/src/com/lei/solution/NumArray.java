package com.lei.solution;

/**
 * @author zhulei
 * @create 2021-05-06 19:14
 */
public class NumArray {

    public int[] nums;

    public NumArray(int[] nums) {
        this.nums = new int[nums.length];
        int i = 0;
        for (int num : nums) {
            this.nums[i] = num;
            i++;
        }
    }

    public int sumRange(int left, int right) {
        int sum = 0;
        for (int i = left; i <= right ; i++) {
            sum += nums[i];
        }
        return sum;
    }

}
