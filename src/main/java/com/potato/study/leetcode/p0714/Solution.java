package com.potato.study.leetcode.p0714;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	714. Best Time to Buy and Sell Stock with Transaction Fee
 *  
 *         Your are given an array of integers prices,
 *         for which the i-th element is the price of a given stock on day i;
 *         and a non-negative integer fee representing a transaction fee.

You may complete as many transactions as you like,
but you need to pay the transaction fee for each transaction.
You may not buy more than 1 share of a stock at a time
(ie. you must sell the stock share before you buy again.)

Return the maximum profit you can make.

Example 1:
Input: prices = [1, 3, 2, 8, 4, 9], fee = 2
Output: 8
Explanation: The maximum profit can be achieved by:
Buying at prices[0] = 1
Selling at prices[3] = 8
Buying at prices[4] = 4
Selling at prices[5] = 9
The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
Note:

0 < prices.length <= 50000.
0 < prices[i] < 50000.
0 <= fee < 50000.
 *         
 *         思路：
 *
 *         https://www.jianshu.com/p/21ad8b5394cb
 *
 *         维护两个状态
 *
 *         目前持有 股票 hold i  i 天还持有股票赚的钱
 *
 *              不持有 notHold
 *
 *
 *
 *
 *
 *
 *
 *
 * 
 */
public class Solution {

    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int[] hold = new int[len];
        int[] notHold = new int[len];

        // 预设 hold
        hold[0] -= prices[0];
        for (int i = 1; i < len; i++) {
            // 之前就已经买了 跟之前没买，刚买的
            hold[i] = Math.max(hold[i-1], notHold[i-1] - prices[i]);
            // 不持有 最大 之前就没有 之前有今天卖
            notHold[i] = Math.max(notHold[i -1], hold[i - 1] + prices[i] - fee);
        }
        return notHold[len -1];
    }
	

	
	public static void main(String[] args) {

		Solution solution = new Solution();

        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        int res = solution.maxProfit(prices, fee);
        System.out.println(res);
        Assert.assertEquals(8, res);

    }
}
