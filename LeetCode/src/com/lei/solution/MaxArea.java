package com.lei.solution;

/**
 * @author zhulei
 * @create 2021-05-08 22:04
 */
public class MaxArea {
    public static void main(String[] args) {
        int[] height = {1,1};
        MaxArea demo = new MaxArea();
        int i = demo.maxArea(height);
        System.out.println(i);
    }

    public int maxArea(int[] height) {
        //定义左右执政
        int left = 0;
        int right = height.length - 1;

        //最大容积
        int max = 0;

        //左指针不能大于右指针
        while (left < right) {
            //如果左指针的值小于右指针，左指针后移
            if (height[left] <= height[right]) {
                max = Math.max(max,(right - left) * (Math.min(height[left],height[right])));
                left++;
            }else { //右指针左移
                max = Math.max(max,(right - left) * (Math.min(height[left],height[right])));
                right--;
            }
        }

        return max;
    }
}
