package com.lei.solution;

/**
 * @author zhulei
 * @create 2021-05-03 22:39
 */
public class RomanToInt {
    public static void main(String[] args) {
        RomanToInt romanToInt = new RomanToInt();
        String s = "IV";
        int i = romanToInt.romanToInt(s);
        System.out.println(i);
    }

    public int romanToInt(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int num = getValue(s.charAt(i));
            if (num > preNum) {
                sum -= preNum;
            }else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
