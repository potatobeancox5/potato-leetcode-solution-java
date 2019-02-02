package com.potato.study.leetcode.p0561;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 *         561. Array Partition I
 * 
 *         Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.

Example 1:
Input: [1,4,3,2]

Output: 4
Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
Note:
n is a positive integer, which is in the range of [1, 10000].
All the integers in the array will be in the range of [-10000, 10000].
 * 
 * 
 *         思路：
 *         排序，然后从后向前对偶数index求和
 *         因为最大的一定被淘汰，这个时候保住次大的 才能保证和最大 依照这个思维进行思考
 *       
 *          
 */
public class Solution {

    public int arrayPairSum(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int sum = 0;
        for (int i = nums.length - 2; i >= 0 ; i = i - 2) {
            sum += nums[i];
        }
        return sum;
    }
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {1,4,3,2};
        int sum = solution.arrayPairSum(nums);
        System.out.println(sum);
    }
}
