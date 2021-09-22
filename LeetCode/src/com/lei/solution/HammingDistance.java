package com.lei.solution;

/**
 * @author zhulei
 * @create 2021-05-10 22:49
 */
public class HammingDistance {
    public static void main(String[] args) {

        int x = 2342123;
        int y = 1024121;

        HammingDistance demo = new HammingDistance();
        int i = demo.hammingDistance(x, y);
        System.out.println(i);

    }

    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }


    public int myHammingDistance(int x, int y) {
        String xByte = to32Binary(x);
        String yByte = to32Binary(y);
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if (xByte.charAt(i) != yByte.charAt(i)){
                count++;
            }
        }
        return count;
    }

    public String to32Binary(int data) {
        String string = Integer.toBinaryString(data);
        while (string.length() < 32) {
            string = "0" + string;
        }
        System.out.println(string);
        return string;
    }
}
