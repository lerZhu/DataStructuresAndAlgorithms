package com.lei.solution;

/**
 * @author zhulei
 * @create 2021-05-02 23:34
 */
public class IsPalindromeNum {
    public static void main(String[] args) {
        IsPalindromeNum isPalindromeNum = new IsPalindromeNum();
        boolean palindrome = isPalindromeNum.isPalindrome(0);
        System.out.println(palindrome);
    }

    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int reverseX = 0;
        while (x > reverseX) {
            reverseX = reverseX * 10 + x % 10;
            x = x / 10;
        }
        return x == reverseX || x == reverseX / 10;
    }
}
