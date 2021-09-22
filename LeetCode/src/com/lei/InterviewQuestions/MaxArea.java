package com.lei.InterviewQuestions;

/**
 * @author zhulei
 * @create 2021-09-12 10:23
 */
public class MaxArea {
    public static void main(String[] args) {

    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int max = 0;
        while (left < right) {
            if (height[left] <= height[right]) {
                max = Math.max(max,(right - left) * Math.min(height[left],height[right]));
                left++;
            }else {
                max = Math.max(max,(left - right) * Math.min(height[left],height[right]));
                right--;
            }
        }
        return max;
    }
}
