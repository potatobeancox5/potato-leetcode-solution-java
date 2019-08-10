package com.potato.study.leetcode.p0309;


/**
 * 
 * @author Administrator
 *
 *         309. Best Time to Buy and Sell Stock with Cooldown
 *         
 *          
 *         Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:

Input: [1,2,3,0,2]
Output: 3
Explanation: transactions = [buy, sell, cooldown, buy, sell]
 *         
 *         
 *         
 *         题目含义：
 *          309. Best Time to Buy and Sell Stock with Cooldown

https://blog.csdn.net/qq508618087/article/details/51671504

一次一个交易 一天cooldown


第i天行为

买
卖
等待

buy i为第i天为已经买状态下的利润
状态转移方程
buy i = max buy i-1 ，sell i-2 - price i
sell i 为第i天处于买完状态的利润
sell i = max sell i-1   ， buyi-1  +price i

https://www.cnblogs.com/grandyang/p/4997417.html
更好解答
buy 0 = -price 0
sell 0 =0
buy1 = max buy 0 ，-price1
转移方程
return sell len-1
 *
 *         思路：
 *         https://blog.csdn.net/x_i_y_u_e/article/details/50724390
 *
 *         
 *         
 *         
 *         
 *         
 */
public class Solution {

    public int maxProfit(int[] prices) {

        if (null == prices || prices.length == 0) {
            return 0;
        }

        // 当前i天 处于buy状态的结果
        int[] buy = new int[prices.length];
        // 当前i天 处于buy状态的结果
        int[] sell = new int[prices.length];

        buy[0] = -1 * prices[0];
        sell[0] = 0;
        if (prices.length > 1) {
            buy[1] = Math.max(buy[0], -1 * prices[1]);
            sell[1] = Math.max(sell[0], buy[0] + prices[1]);
        }

        for (int i = 2; i < prices.length; i++) {
            buy[i] = Math.max(buy[i-1], sell[i-2] - prices[i]);
//            sell i 为第i天处于买完状态的利润
            sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i]);
        }
        return sell[prices.length - 1];
    }




	public static void main(String[] args) {
		Solution solution = new Solution();

		int[] num = {1,2,3,0,2};

        int maxProfit = solution.maxProfit(num);
        System.out.println(maxProfit);
    }
}
