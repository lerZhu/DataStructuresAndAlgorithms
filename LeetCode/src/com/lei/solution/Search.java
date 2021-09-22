package com.lei.solution;

/**
 * @author zhulei
 * @create 2021-07-16 23:31
 */
public class Search {
    public static void main(String[] args) {

    }

    public int search(int[] nums, int target) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
            }
        }
        return count;
    }
}
