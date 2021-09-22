package com.lei.swordfingeroffer;

/**
 * @author zhulei
 * @create 2021-07-25 23:40
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int target = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                target = i;
                break;
            }
        }
        return target;
    }
}
