package com.lei.solution;

/**
 * @author zhulei
 * @create 2021-07-06 22:33
 */
public class FindNumbers {
    public static void main(String[] args) {

    }

    public static int findNumbers(int[] nums) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            String numberStr = nums[i] + "";
            if (numberStr.length() % 2 == 0) {
                count++;
            }
        }

        return count;
    }
}
