package com.lei.solution;

/**
 * @author zhulei
 * @create 2021-05-08 23:09
 */
public class MySqrt {
    public static void main(String[] args) {
        MySqrt demo = new MySqrt();
        int i = demo.mySqrt(2147395599);
        System.out.println(i);
    }

    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int res = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid * mid <= x) {
                res = mid;
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return res;
    }
}
