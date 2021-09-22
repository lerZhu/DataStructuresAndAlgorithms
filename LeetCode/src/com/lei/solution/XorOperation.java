package com.lei.solution;

/**
 * @author zhulei
 * @create 2021-05-07 20:13
 */
public class XorOperation {
    public static void main(String[] args) {
        XorOperation demo = new XorOperation();
        int i = demo.xorOperation(5, 0);
        System.out.println(i);
    }

    public int xorOperation(int n, int start) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = start + i * 2;
        }
        int res = nums[0];
        for (int i = 1; i < n; i++) {
            res = res ^ nums[i];
        }
        return res;
    }
}
