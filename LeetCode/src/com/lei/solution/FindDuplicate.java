package com.lei.solution;

import java.util.Arrays;

/**
 * @author zhulei
 * @create 2021-05-02 21:10
 */
public class FindDuplicate {
    public static void main(String[] args) {
        int[] nums = {3,1,4,4,2};
        FindDuplicate findDuplicate = new FindDuplicate();
        int duplicate = findDuplicate.findDuplicate(nums);
        System.out.println(duplicate);
    }

    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] == nums[i]) {
                return nums[i];
            }
        }
        return -1;
    }
}
