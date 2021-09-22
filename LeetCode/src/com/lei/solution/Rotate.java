package com.lei.solution;

/**
 * @author zhulei
 * @create 2021-04-25 23:08
 */
public class Rotate {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        rotate(nums,0);
    }

    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        int realK = k % nums.length;

        if (realK == 0) {
            for (int num : nums) {
                System.out.print(num + "\t");
            }
            return;
        }

        int[] newNums = new int[len];
        for (int i = 0; i < realK; i++) {
            newNums[i] = nums[len - realK + i];
        }

        for (int i = 0; i < nums.length - realK; i++) {
            newNums[realK + i] = nums[i];
        }

        for (int i = 0; i < len; i++) {
            nums[i] = newNums[i];
        }
    }
}
