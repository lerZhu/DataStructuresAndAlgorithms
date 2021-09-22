package com.lei.InterviewQuestions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhulei
 * @create 2021-09-14 20:15
 */
public class longestPalindrome {

    public String longestPalindrome (String str) {
        // write code here
        if (str == null || str.length() == 0) {
            return "";
        }
        int strLen = str.length();
        int left = 0;
        int right = 0;
        int len = 1;
        int maxStart = 0;
        int maxLen = 0;

        for (int i = 0; i < strLen; i++) {
            left = i - 1;
            right = i + 1;
            while (left >= 0 && str.charAt(left) == str.charAt(i)) {
                len++;
                left--;
            }
            while (right < strLen && str.charAt(right) == str.charAt(i)) {
                len++;
                right++;
            }
            while (left >= 0 && right < strLen && str.charAt(right) == str.charAt(left)) {
                len = len + 2;
                left--;
                right++;
            }
            if (len > maxLen) {
                maxLen = len;
                maxStart = left;
            }
            len = 1;
        }
        return str.substring(maxStart + 1, maxStart + maxLen + 1);
    }

}
