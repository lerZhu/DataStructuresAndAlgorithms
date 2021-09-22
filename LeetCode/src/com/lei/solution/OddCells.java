package com.lei.solution;

/**
 * @author zhulei
 * @create 2021-07-07 23:30
 */
public class OddCells {
    public static void main(String[] args) {
        int m = 48;
        int n = 37;
        int[][] indices = {{40,5}};
        int oddCells = oddCells(m, n, indices);
        System.out.println(oddCells);

    }

    public static int oddCells(int m, int n, int[][] indices) {
        int[][] initMatrix = new int[m][n];

        int rowNo = 0;
        int colNo = 0;

        int oddCount = 0;

        for (int i = 0; i < indices.length; i++) {
            rowNo = indices[i][0];
            colNo = indices[i][1];
            for (int j = 0; j < n; j++) {
                initMatrix[rowNo][j] += 1;
            }
            for (int j = 0; j < m; j++) {
                initMatrix[j][colNo] += 1;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (initMatrix[i][j] % 2 != 0) {
                    oddCount++;
                }
            }
        }

        return oddCount;
    }
}
