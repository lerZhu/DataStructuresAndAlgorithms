package com.lei.solution;

/**
 * @author zhulei
 * @create 2021-04-27 22:46
 */
public class ProductExceptSelf {
    public static void main(String[] args) {
        int[] nums = {4,5,1,8,2};
        int[] ints = productExceptSelf(nums);
        for (int i : ints) {
            System.out.print(i + "\t");
        }
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] L = new int[nums.length];
        int[] R = new int[nums.length];

        int[] rest = new int[nums.length];

        L[0] = 1;
        R[nums.length - 1] = 1;

        for (int i = 1; i < nums.length; i++) {
            L[i] = L[i - 1] * nums[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            R[i] = R[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            rest[i] = L[i] * R[i];
        }

        return rest;
    }
}
