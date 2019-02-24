package com.potato.study.leetcode.p0188;

/**
 * 
 * @author liuzhao11
 * 
 *    188. Best Time to Buy and Sell Stock IV

 *         
 *          
 *   Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most k transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Example 1:

Input: [2,4,1], k = 2
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
Example 2:

Input: [3,2,6,5,0,3], k = 2
Output: 7
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.


 *         思路： 
 *          https://www.cnblogs.com/grandyang/p/4295761.html
 *          http://www.cnblogs.com/grandyang/p/4280803.html
 *          状态转移方程
 *          local[i][j]  第j天卖出 到达i天最多进行j次买卖，且第i天卖出的最大利润
 *          global[i][j] 全局最大利润 到达i天最多进行j次买卖的最大利润
 *          由定义可以得到转移方程
 *          local[i][j] = max(global[i-1][j-1]+ max(0,p[i+1] - p[1]),  local[i - 1][j] + p[i+1] - p[1]);
 *          第i-1天就执行了 j-1 次以内的交易的全局最大 加上 明天卖 或者明天不卖0
 *          global[i][j] = max(local[i][j], global[i - 1][j])，
 *
 *
 *          dp问题
            allBest i j i天内做最多j次买卖最多
            all i j = max  （all i-1 j ；lastBest i j

            lastBest i j = all i-1 j-1 + 做生意 或者不做
            lastBest 表示 i天做至多 j次买卖 且 第j次在i当天的
            https://blog.csdn.net/jmspan/article/details/51295053
            last[d][t] = Math.max(last[d-1][t] + prices[d] - prices[d-1], total[d-1][t-1]
                + Math.max(0, prices[d] - prices[d-1]));
            d天最后一天完成第t次交易 = max (d-1天内最后一天完成t次交易 + 最后一次卖出，d-1天完成至多t-1次交易)
            total[d][t] = Math.max(total[d-1][t], last[d][t]);
 //我们先考虑total变量，第j日之前完成i次交易，可以分为两种情况，第一种情况是最后一日不作任何交易，
第二种是最后一日完成第i次交易，
则total[j][i] = max(total[j-1][i], last[j][i])

 *         
 *        
 */
public class Solution {

    public int maxProfit(int k, int[] prices) {
        if (null == prices || prices.length <= 1) {
            return 0;
        }
        if (k >= prices.length / 2 ) {
            return max(prices);
        }
        // dp
        int[][] total = new int[prices.length][k+1];
        int[][] last = new int[prices.length][k+1];
        for (int t = 1; t <= k; t++) {
            for (int d = 1; d < total.length; d++) {
                last[d][t] = Math.max(last[d-1][t] + prices[d] - prices[d-1], total[d-1][t-1]
                        + Math.max(0, prices[d] - prices[d-1]));
//                d天最后一天完成第t次交易 = max (d-1天内最后一天完成t次交易 + 最后一次卖出，d-1天完成至多t-1次交易)
                total[d][t] = Math.max(total[d-1][t], last[d][t]);
            }
        }
        return total[total.length-1][k];
    }
    /**
     * 计算无数次交易能得到的最大值
     * @param prices
     * @return
     */
    private int max(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            max += Math.max(0, prices[i+1] - prices[i]);
        }
        return max;
    }



	
	public static void main(String[] args) {
		Solution solution = new Solution();
//		String dna = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
////		String dna = "AAAAAAAAAAAAAAA";
//		List<String> result = solution.maxProfit(dna);
//        System.out.println(Arrays.toString(result.toArray()));

        Long ll = 90000010261712L;
        System.out.println(ll.intValue());
    }
}
