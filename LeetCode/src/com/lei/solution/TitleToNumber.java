package com.lei.solution;

import java.util.Arrays;

/**
 * @author zhulei
 * @create 2021-04-30 22:35
 */
public class TitleToNumber {
    public static void main(String[] args) {
        String columnTitle = "A";
        int i = titleToNumber(columnTitle);
        System.out.println(i);
    }

    public static int titleToNumber(String columnTitle) {

        byte[] bytes = columnTitle.getBytes();

        int n = 1;

        int sum = 0;

        for (int i = columnTitle.length() - 1; i >= 0; i--,n = n * 26) {
            sum += (bytes[i] - 64) * n;
        }

        return sum;
    }
}
