package com.potato.study.leetcode.p0746;

/**
 * 
 * @author liuzhao11
 * 
 * 	746. Min Cost Climbing Stairs
 *  
 *         On a staircase, the i-th step has some non-negative cost cost[i]
 *         assigned (0 indexed).
 * 
 *         Once you pay the cost, you can either climb one or two steps. You
 *         need to find minimum cost to reach the top of the floor, and you can
 *         either start from the step with index 0, or the step with index 1.
 * 
 *         Example 1: Input: cost = [10, 15, 20] Output: 15 Explanation:
 *         Cheapest is start on cost[1], pay that cost and go to the top.
 *         Example 2: Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1] Output:
 *         6 Explanation: Cheapest is start on cost[0], and only step on 1s,
 *         skipping cost[3]. Note: cost will have a length in the range [2,
 *         1000]. Every cost[i] will be an integer in the range [0, 999].
 *         
 *         思路：
 *         tc(total cost)[i]  代表走到了i 共花费了多少
 *         
 *         动态方程
 *         tc[i] = min {tc[i-1],tc[i-2]} + cost[i]
 *         tc[0] = cost[0]
 *         tc[1] = cost[1]
 *         tc[2] = min {tc[0],tc[1]} + cost[2]
 *         
 *         (可以压缩状态量)
 *         afterCost = min{currentCost + beforeCost} + cost[i];
 *         beforeCost = currentCost
 *         currentCost = afterCost
 * 
 */
public class Solution {

	public int minCostClimbingStairs(int[] cost) {
        if(null == cost || cost.length == 0) {
        	return 0;
        }
        int beforeCost = cost[0];
        if(cost.length == 1) {
        	return 0;
        } 
        int currentCost = cost[1];
        if(cost.length == 2) {
        	return currentCost > beforeCost ? beforeCost : currentCost;
        }
        for (int i = 2; i < cost.length; i++) {
			int afterCost = min(beforeCost, currentCost) + cost[i];
			beforeCost = currentCost;
			currentCost = afterCost;
		}
        return min(beforeCost, currentCost);
    }
	
	private int min(int a , int b) {
		return a > b ? b : a;
	}

	
	public static void main(String[] args) {
		Solution solution = new Solution();
//		int[] cost = {10, 15, 20};
		int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
		int totalCost = solution.minCostClimbingStairs(cost);
		System.out.println(totalCost);
	}
}
