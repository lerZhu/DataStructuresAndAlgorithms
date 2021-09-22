package com.company.recursion;

import java.util.Map;

/**
 * @author zhulei
 * @create 2021-04-09 16:44
 */
public class Queue8 {
    //定义一个max表示有多少皇后
    int max = 8;
    //保存皇后位置放置的结果
    int[] arr = new int[max];
    static int count = 0;
    static int totalCount = 0;
    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.println("一共有" + count + "种解法");
        System.out.println("一共执行了" + totalCount + "次");
    }

    private void check(int n) {
        if (n == max) { //8个皇后已经放完了
            print();
            return;
        }
        //依次放入皇后，判断是否冲突
        for (int i = 0; i < max; i++) {
            totalCount++;
            //先把当前皇后n，放到改行的第一列
            arr[n] = i;
            //判断当放置完成后是否冲突
            if (judge(n)) { //不冲突
                //接着放n+1个皇后
                check(n + 1);
            }
            //如果冲突，就继续执行arr[n] = 1，第n个皇后后移
        }
    }

    /**
     * 查看放置第n个皇后时，检测该皇后是否和前面已经摆放的皇后冲突
     * @param n 第n个皇后
     * @return 若不冲突，返回true
     */
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            //1.arr[i] == arr[n] 判断是否在同一列
            //2.Math.abs(n - i) == Math.abs(arr[n] - arr[i]) 判断是否在斜线上，45度斜线，函数
            if (arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])){
                return false;
            }
        }
        return true;
    }

    /**
     * 输出皇后的位置
     */
    private void print() {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        count++;
        System.out.println();
    }
}
