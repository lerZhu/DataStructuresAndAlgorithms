package com.lei.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhulei
 * @create 2021-05-04 21:54
 */
public class AAA {
    public static void main(String[] args) {
        AAA aaa = new AAA();
//        char c = aaa.lowercaseToUppercase('c');
//        System.out.println(c);
//
//        boolean s = aaa.isAlphanumeric('类');
//        System.out.println(s);
//
//        int theMonthDays = aaa.getTheMonthDays(1996, 1);
//        System.out.println(theMonthDays);
        int fun = aaa.fun(2);
        System.out.println(fun);
    }

    public int fun(int x) {
        return (x == 1) ? 1 : fun(x + fun(x -1));
    }

    public float maxOfArray(float[] A) {
        // write your code here
        Arrays.sort(A);
        return A[A.length - 1];
    }

    public void sortIntegers(int[] A) {
        // write your code here
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = 0; j < A.length - i - 1; j++) {
                if (A[j] > A[j + 1]) {
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }
    }

    public void swapIntegers(int[] A, int index1, int index2) {
        // write your code here
        int temp = A[index1];
        A[index1] = A[index2];
        A[index2] = temp;
    }

    public List<Integer> generate(int size) {
        // write your code here
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        return list;
    }

    public int getTheMonthDays(int year, int month) {
        // write your code here
        int[] day = {0,31,28,31,30,31,30,31,31,30,31,30,31};
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            day[2] = 29;
        }
        return day[month];
    }

    public boolean isAlphanumeric(char c) {
        // write your code here
        String regex = "^[A-Za-z0-9]+$";
        String s = c + "";
        return s.matches(regex);
    }

    public int calculate(int a, char operator, int b) {
        // write your code here
        int res = 0;
        switch (operator) {
            case '+':
                res = a + b;
                break;
            case '-':
                res = a - b;
                break;
            case '*':
                res = a * b;
                break;
            case '/':
                res = a / b;
                break;
        }
        return res;
    }

    public int maxOfThreeNumbers(int num1, int num2, int num3) {
        // write your code here
        int max = num1 > num2 ? num1 : num2;
        max = max > num3 ? max : num3;
        return max;
    }

    public char lowercaseToUppercase(char character) {
        // write your code here
        char c = (char)(character - 32);
        return c;
    }
}
