package com.potato.study.leetcode.p0121;

/**
 * 
 * @author liuzhao11
 * 
 *         121. Best Time to Buy and Sell Stock
 *         
 *          
 *         Say you have an array for which
 *         the ith element is the price of a given stock on day i.
 * 
 *         If you were only permitted to complete at most one transaction (ie,
 *         buy one and sell one share of the stock), design an algorithm to find
 *         the maximum profit.
 * 
 *         Example 1: Input: [7, 1, 5, 3, 6, 4] Output: 5
 * 
 *         max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be
 *         larger than buying price) Example 2: Input: [7, 6, 4, 3, 1] Output: 0
 * 
 *         In this case, no transaction is done, i.e. max profit = 0.
 * 
 *         思路：
 *         之前最小值设为index = 0 的值
 *         记录当前最大差值 0
 *         从前向后 遍历数组 i
 *         		若i大于最小值，计算差值   
 *         			若差值大于最大差值 更新最大差值
 *         		若i小于最小值， 更新当前最小值 continue；
 *         
 * 
 */
public class Solution {
	
	public int maxProfit(int[] prices) {
        if(null == prices || prices.length <= 1) {
        	return 0;
        }
        int minPriceBefore = prices[0];
        int maxProfit = 0;
        for(int i = 1 ; i < prices.length ; i++) {
        	if (prices[i] < minPriceBefore) {
				minPriceBefore = prices[i];
			} else if(prices[i] > minPriceBefore) {
				int tempMaxProfit = prices[i] - minPriceBefore;
				if(maxProfit < tempMaxProfit) {
					maxProfit = tempMaxProfit;
				}
			}
        }
        return maxProfit;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
//		int[] prices = {1, 5, 3, 6, 4};
		int[] prices = {7, 6, 4, 3, 1};
		int maxProfit = solution.maxProfit(prices);
		System.out.println(maxProfit);
		
	}
}
