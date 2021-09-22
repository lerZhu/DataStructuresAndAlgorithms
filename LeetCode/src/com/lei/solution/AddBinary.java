package com.lei.solution;

/**
 * @author zhulei
 * @create 2021-07-12 23:13
 *
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 */
public class AddBinary {
    public static void main(String[] args) {
        String a = "101010101";
        String b = "111111111";
        String s = addBinary(a, b);
        System.out.println(s);
    }

    public static String addBinary(String a, String b) {
        int aLength = a.length();
        int bLength = b.length();
        int n = Math.max(aLength, bLength);

        if (aLength > bLength) {
            for (int i = 0; i < aLength - bLength; i++) {
                b = "0" + b;
            }
        }else {
            for (int i = 0; i < bLength - aLength; i++) {
                a = "0" + a;
            }
        }

        int plus = 0;
        StringBuilder sum = new StringBuilder();

        for (int i = n - 1; i >= 0 ; i--) {
            int numA = a.charAt(i) - '0';
            int numB = b.charAt(i) - '0';

            int temp = numA + numB + plus;
            if (temp >= 2) {
                temp = temp % 2;
                plus = 1;
            }

            sum.append(temp);
        }

        if (plus == 1) {
            sum.append(1);
        }

        String returnsum = sum.reverse().toString();


        return returnsum;
    }
}
