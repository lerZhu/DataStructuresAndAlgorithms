package com.lei.solution;

/**
 * @author zhulei
 * @create 2021-04-23 22:24
 */
public class SearchMatrix {
    public static void main(String[] args) {
        //int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int[][] matrix = {{-1,3}};
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
        boolean b = searchMatrix(matrix, 1);
        System.out.println(b);
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[m -1][n - 1]) {
            return false;
        }
        for (int i = 0;m > 0 && i < n;){
            if (target == matrix[m - 1][i]) {
                return true;
            }else if (target > matrix[m - 1][i]) {
                i++;
            }else {
                m--;
            }
        }
        return false;
    }
}
