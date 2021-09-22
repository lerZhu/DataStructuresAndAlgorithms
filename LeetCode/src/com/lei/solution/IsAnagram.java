package com.lei.solution;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhulei
 * @create 2021-04-24 23:09
 */
public class IsAnagram {
    public static void main(String[] args) {
//        String s = "anagram";
//        String t = "nagaram";
        String s = "a";
        String t = "a";
        boolean anagram = isAnagram(s, t);
        System.out.println(anagram);
    }

    public static boolean isAnagram(String s, String t) {
        if (s.equals(t)) {
            return true;
        }
        if (s.length() != t.length()) {
            return false;
        }
        byte[] sBytes = s.getBytes();
        byte[] tBytes = t.getBytes();
        Arrays.sort(sBytes);
        Arrays.sort(tBytes);
        for (int i = 0; i < sBytes.length; i++) {
            if (sBytes[i] != tBytes[i]){
                return false;
            }
        }
        return true;
    }
}
