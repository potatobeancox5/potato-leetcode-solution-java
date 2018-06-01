package com.potato.study.leetcode.p0123;

/**
 * 
 * @author liuzhao11
 * 
 *         123. Best Time to Buy and Sell Stock III
 *         
 *          
 *       Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

Example 1:

Input: [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
             Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
Example 2:

Input: [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
             engaging multiple transactions at the same time. You must sell before buying again.
Example 3:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
 *         
 *         
 *         思路：
 *         原始的办法是开两个数组 分别记录 i位置之前做一笔交易和i位置之后做一笔交易的挣钱数
 *         最后求和 
 *         但是 下面这个帖子提出了一种新的想法
 *         https://blog.csdn.net/u012501459/article/details/46514309
 *         四个状态量
 *         buy1  buy2  sell1 sell2
 *         sell2[i]  第i天前 执行 第二次卖出的最大值
 *         sell2[i] = max {sell2[i-1] , buy2[i-1] + prices[i]} // i - 1 已经办利索了，或者今天办
 *         buy2[i]	 第i天前 执行 第二次买入的最大收益
 *         buy2[i] = max {buy2[i-1], sell1[i - 1] - prices[i]}
 *         sell1[i]	第i天前 执行 第一次卖出的最大收益
 *         sell1[i] = max {sell1[i-1] , buy1[i-1] + prices[i]}
 *         buy1[i]  第i天前 执行 第一次买入的最大收益 
 *         buy1[i] = max {buy1[i-1], 0 - prices[i]}
 *         压缩状态量可得
 *         sell2 = max {sell2 , buy2 + prices[i]}
 * 		   buy2 = max {buy2, sell1 - prices[i]}
 * 		   sell1 = max {sell1 , buy1 + prices[i]}
 *         buy1 = max {buy1, 0 - prices[i]}
 *         别忘了设置初始值
 *         buy1 = Integer.MIN_VALUE;
 *         buy2 = Integer.MIN_VALUE;
 *         sell1 = 0;
 *         sell2 = 0;
 *         最多两笔生意
 */
public class Solution {
	
	public int maxProfit(int[] prices) {
		int buy1 = Integer.MIN_VALUE;// 不设置成最小值会造成一致都不买入的现象
		int buy2 = Integer.MIN_VALUE;
		int sell1 = 0;
		int sell2 = 0;
		
        for(int i = 0 ; i < prices.length ; i++) {
        	sell2 = max (sell2 , buy2 + prices[i]);
        	buy2 = max (buy2, sell1 - prices[i]);
        	sell1 = max (sell1 , buy1 + prices[i]); // 隐含没有做生意
        	buy1 = max (buy1, 0 - prices[i]);
        }
        return sell2;
    }
	
	private int max(int a, int b) {
		return a > b ? a : b;
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
//		int[] prices = {3,3,5,0,0,3,1,4};
//		int[] prices = {1,2,3,4,5};
		int[] prices = {7,6,4,3,1};
		int profit = solution.maxProfit(prices);
		System.out.println(profit);
	}
}
