package com.company.search;

/**
 * @author zhulei
 * @create 2021-04-12 13:29
 */
public class SeqSearch {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 123, 424, 5464, 232};
        int i = seqSearch(arr, 2);
        System.out.println(i);
    }

    public static int seqSearch(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
