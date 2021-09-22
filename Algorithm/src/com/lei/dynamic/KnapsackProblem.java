package com.lei.dynamic;

import java.io.OutputStream;
import java.util.function.IntPredicate;

/**
 * @author zhulei
 * @create 2021-04-20 10:19
 */
public class KnapsackProblem {
    public static void main(String[] args) {

        //物品的重量
        int[] weight = {1,3,4};
        //物品的价值
        int[] val = {1500,2000,3000};
        //背包的容量
        int m = 4;
        //物品的个数
        int n = val.length;

        //为了记录商品的情况，定义一个二维数组
        int[][] path = new int[n+1][m+1];

        //创建二维数组，
        //表示在前i个武平中能够装入容量为j的背包中的最大值
        int[][] v = new int[n+1][m+1];

        //初始化第一行第一列
        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0;
        }
        for (int i = 0; i < v[0].length; i++) {
            v[0][i] = 0;
        }

        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[i].length; j++) {
                if (weight[i - 1] > j) {
                    v[i][j] = v[i-1][j];
                }else {
                    //v[i][j] = Math.max(v[i-1][j],val[i - 1] + v[i-1][j-weight[i - 1]]);
                    //为了记录商品存放到背包的情况，需要使用if-else取代
                    if (v[i-1][j] < val[i - 1] + v[i-1][j-weight[i - 1]]) {
                        v[i][j] = val[i - 1] + v[i-1][j-weight[i - 1]];
                        path[i][j] = 1;
                    }else {
                        v[i][j] = v[i-1][j];
                    }
                }
            }
        }

        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                System.out.print(v[i][j] + "\t");
            }
            System.out.println();
        }

        int i = path.length - 1;
        int j = path[0].length - 1;
        while (i > 0 && j > 0) {
            if (path[i][j] == 1) {
                System.out.println("第" + i + "个物品放入背包");
                j -= weight[i - 1];
            }
            i--;
        }
    }
}
