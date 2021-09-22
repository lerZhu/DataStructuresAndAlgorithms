package com.company.recursion;

/**
 * @author zhulei
 * @create 2021-04-09 14:23
 */
public class RecursionTest {

    public static void main(String[] args) {
        test(5);

        int factorial = factorial(5);
        System.out.println(factorial);
    }

    public static void test(int n) {
        if (n > 2) {
            test(n - 1);
        }
        System.out.println("n=" + n);
    }

    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        }else {
            return factorial(n - 1) * n;
        }
    }

}
