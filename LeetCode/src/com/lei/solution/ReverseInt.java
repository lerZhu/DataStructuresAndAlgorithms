package com.lei.solution;

/**
 * @author zhulei
 * @create 2021-05-03 22:27
 */
public class ReverseInt {
    public static void main(String[] args) {
        int x = 1123456789;
        int reverse = reverse(x);
        System.out.println(reverse);
    }

    public static int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int temp = x % 10;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && temp > 7)) {
                return 0;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && temp < -8)) {
                return 0;
            }
            res = res * 10 + temp;
            x = x / 10;
        }
        return res;
    }
}
