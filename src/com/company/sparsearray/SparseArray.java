package com.company.sparsearray;

/**
 * @author zhulei
 * @create 2021-03-23 20:07
 */
public class SparseArray {
    public static void main(String[] args) {
        //创建原始二维数组
        //1代表黑子 2代表白子
        int row = 11;
        int column = 11;
        int chessArr[][] = new int[row][column];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        chessArr[4][5] = 2;
        System.out.println("原始的二维数组");
        for (int[] rows : chessArr) {
            for (int data : rows) {
                System.out.print(data + "\t");
            }
            System.out.println();
        }

        //将二维数组转为稀疏数组
        //遍历二维数组，得到非0个数
        int sum = 0;
        for (int[] rows : chessArr) {
            for (int data : rows) {
                if (data != 0){
                    sum++;
                }
            }
        }
        System.out.println("非零值个数：" + sum);

        //创建对应的稀疏数组
        int sparseArr[][] = new int[sum + 1][sum];
        sparseArr[0][0] = row;
        sparseArr[0][1] = column;
        sparseArr[0][2] = sum;

        //遍历二维数组，将非0值放入稀疏数组中
        int count = 0;//记录是第几个非0值
        for (int i = 0;i < 11;i++){
            for(int j = 0;j < 11;j++){
                if(chessArr[i][j] != 0){
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr[i][j];
                }
            }
        }
        //输出稀疏数组
        System.out.println("稀疏数组");
        for (int[] ints : sparseArr) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }

        //把稀疏数组转为原始数组
        int restoreArr[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
        for(int i = 1;i < sparseArr.length;i++){
            restoreArr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        //输出还原的数组
        System.out.println("还原的二维数组");
        for (int[] ints : restoreArr) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
    }
}
