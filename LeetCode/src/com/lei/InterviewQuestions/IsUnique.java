package com.lei.InterviewQuestions;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhulei
 * @create 2021-08-04 23:33
 */
public class IsUnique {
    public boolean isUnique(String astr) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < astr.length(); i++) {
            if (!set.add(astr.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
