package com.lei.solution;

/**
 * @author zhulei
 * @create 2021-04-23 23:38
 */
public class IsPalindrome {
    public static void main(String[] args) {
//        String s = "A man, a plan, a canal: Panama";
        String s = ".,";
        boolean palindrome = isPalindrome(s);
        System.out.println(palindrome);
    }

    public static boolean isPalindrome(String s) {
        String s1 = s.toLowerCase();
        if (s1.length() == 0) {
            return true;
        }
        int i = 0;
        int j = s1.length() - 1;
        while (i < j) {
            while (i < j &&!Character.isLetterOrDigit(s1.charAt(i))){
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(s1.charAt(j))){
                j--;
            }
            while (s1.charAt(i) != s1.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
