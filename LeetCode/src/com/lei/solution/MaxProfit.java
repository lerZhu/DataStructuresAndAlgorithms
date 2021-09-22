package com.lei.solution;

/**
 * @author zhulei
 * @create 2021-05-04 23:12
 */
public class MaxProfit {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        MaxProfit maxProfit = new MaxProfit();
        int i = maxProfit.maxProfit(prices);
        System.out.println(i);

    }

    public int maxProfit(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        int min = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }else if (prices[i] - min > maxProfit) {
                maxProfit = prices[i] - min;
            }
        }
        return maxProfit;
    }
}
