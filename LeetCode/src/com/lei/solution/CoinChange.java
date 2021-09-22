package com.lei.solution;

import com.sun.org.apache.xpath.internal.functions.FuncFalse;

/**
 * @author zhulei
 * @create 2021-05-06 10:25
 */
public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        CoinChange coinChange = new CoinChange();
        int i = coinChange.coinChange(coins, amount);
        System.out.println(i);
    }

    public int coinChange(int[] coins, int amount) {
        // write your code here
        int[] f = new int[amount + 1];
        int n = coins.length;

        //初始化
        f[0] = 0;

        for (int i = 1; i <= amount; i++) {
            //如果无法拼出，将值设置为无穷大
            f[i] = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                //i >= coins[j] 防止数组越下界
                //f[i - coins[j]] != Integer.MAX_VALUE 防止值过大，超出Integer的范围
                if (i >= coins[j] && f[i - coins[j]] != Integer.MAX_VALUE) {
                    f[i] = Math.min(f[i - coins[j]] + 1,f[i]);
                }
            }
        }

        if (f[amount] == Integer.MAX_VALUE) {
            return -1;
        }
        return f[amount];
    }
}
