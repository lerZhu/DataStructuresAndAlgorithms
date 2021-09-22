package com.lei.solution;

import java.util.Arrays;

/**
 * @author zhulei
 * @create 2021-05-02 20:23
 */
public class WiggleSort {
    public static void main(String[] args) {
        int[] nums = {1,2,2,3};
        WiggleSort wiggleSort = new WiggleSort();
        wiggleSort.wiggleSort(nums);
    }

    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] newArr = nums.clone();
        int n = nums.length;
        for (int i = 1; i < nums.length; i += 2) {
            nums[i] = newArr[--n];
        }
        for (int i = 0; i < nums.length; i += 2) {
            nums[i] = newArr[--n];
        }
        System.out.println(Arrays.toString(nums));
    }
}
