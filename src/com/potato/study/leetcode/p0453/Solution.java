package com.potato.study.leetcode.p0453;


/**
 * 
 * @author liuzhao11
 * 
 *   453. Minimum Moves to Equal Array Elements
 * 
 *      Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.

Example:

Input:
[1,2,3]

Output:
3

Explanation:
Only three moves are needed (remember each move increments two elements):

[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 * 
 *         思路：
 *         逆向思维 相对于每次给数组中的一个值 - 1 直到数组均相同 
 *         那么 只需要找到最小值 求得其他数字与最小值的残差和 就可以了
 *         
 *         边找最小值 边求和 用和 - 最小值 * len
 *         https://www.cnblogs.com/grandyang/p/6053827.html
 * 				
 */	
public class Solution {
	
	public int minMoves(int[] nums) {
		if(null == nums || nums.length <= 1) {
			return 0;
		}
        int min = nums[0];
        long sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
			if(min > nums[i]) {
				min = nums[i];
			}
			sum += nums[i];
		}
        long residual = sum - nums.length * min; //残差
        return (int)residual;
    }
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {1,2,3};
//		int[] nums = {1};
		int times = solution.minMoves(nums);
		System.out.println(times);
	}
}
