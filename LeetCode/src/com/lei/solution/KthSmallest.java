package com.lei.solution;

import java.util.Arrays;

/**
 * @author zhulei
 * @create 2021-04-28 23:35
 */
public class KthSmallest {
    public static void main(String[] args) {
        int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
        int k = 8;
        int i = kthSmallest(matrix, k);
        System.out.println(i);
    }

    public static int kthSmallest(int[][] matrix, int k) {
        int[] arr = new int[matrix.length * matrix.length];
        int index = 0;
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                arr[index++] = anInt;
            }
        }
        Arrays.sort(arr);
        return arr[k - 1];
    }
}
