package com.potato.study.leetcode.p0485;

/**
 * 
 * @author liuzhao11
 * 
 *         485. Max Consecutive Ones
 * 
 *        Given a binary array, find the maximum number of consecutive 1s in this array.

Example 1:
Input: [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
    The maximum number of consecutive 1s is 3.
Note:

The input array will only contain 0 and 1.
The length of input array is a positive integer and will not exceed 10,000
 * 
 *         思路：  查找数组中 最长的连续的1的个数
 *         
 * 
 */
public class Solution {
	
	public int findMaxConsecutiveOnes(int[] nums) {
        if(null == nums || nums.length == 0) {
        	return 0;
        }
        int count = 0;
        int maxConsecutiveOnes = 0;
        for (int i = 0; i < nums.length; i++) {
			if(nums[i] == 1) {
				count++;
			} else {
				if(maxConsecutiveOnes < count) {
					maxConsecutiveOnes = count;
				}
				count = 0;
			}
		}
        //处理最后一段
        if(maxConsecutiveOnes < count) {
			maxConsecutiveOnes = count;
		}
        return maxConsecutiveOnes;
    }
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {1,1,0,1,1,1};
		int count = solution.findMaxConsecutiveOnes(nums);
		System.out.println(count);
	}
}
