package com.potato.study.leetcode.p0198;

/**
 * 
 * @author liuzhao11
 * 
 *         198. House Robber
 * 
 *         You are a professional robber planning to rob houses along a street.
 *         Each house has a certain amount of money stashed, the only constraint
 *         stopping you from robbing each of them is that adjacent houses have
 *         security system connected and it will automatically contact the
 *         police if two adjacent houses were broken into on the same night.
 * 
 *         Given a list of non-negative integers representing the amount of
 *         money of each house, determine the maximum amount of money you can
 *         rob tonight without alerting the police.
 * 
 *         思路：
 *         动态规划题目
 *         设s[i] 代表 抢到i家是 robber能抢的最大金钱数    nums[i]代表第i家有多少钱
 *         s[i] = max {s[i-1] , s[i-2] + nums[i]};
 *         提示：
 *         是不是存在s[i-1] + nums[i] 的情况呢，答案是不存在
 *         因为这种情况存在的前提是没有选择nums[i-1]进行抢劫，那么此时s[i-1] == s[i-2] 故直接使用上面的公式就可以得到结果
 *         当i == 0 时 s[0] = nums[0], i ==1 时 选择两者中较大的进行赋值
 * 
 * 		   	可以进行状态量压缩
 * 			afterStatus = max{currentStatus , beforeStatus + nums[i]};
 * 			beforeStatus = currentStatus;
 * 			currentStatus = afterStatus;
 * 		
 */
public class Solution {
	
	public int rob(int[] nums) {
		if(null == nums || nums.length == 0) {
			return 0;
		}
		int beforeStatus = nums[0];
		if(nums.length == 1) {
			return beforeStatus;
		}
		int currentStatus = nums[1] > nums[0] ? nums[1] : nums[0];
		if (nums.length == 2) {
			return currentStatus;
		}
		for(int i = 2 ; i < nums.length ; i++) {
			int afterStatus = max(currentStatus , beforeStatus + nums[i]);
			beforeStatus = currentStatus;
			currentStatus = afterStatus;
		}
		return currentStatus;
	}
	
	private int max(int a , int b) {
		return a > b ? a : b;
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {9,2,6,4,9,6,7,9,10,19,12,8,14,6,17};
		int result = solution.rob(nums);
		System.out.println(result);
	}
}
