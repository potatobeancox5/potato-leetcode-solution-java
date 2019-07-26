package com.potato.study.leetcode.p0724;

/**
 * 
 * @author liuzhao11
 * 
 * 	724. Find Pivot Index
 *  
 *         Given an array of integers nums, write a method that returns the "pivot" index of this array.

We define the pivot index as the index where the sum of the numbers to the left of the index is equal to the sum of the numbers to the right of the index.

If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.

Example 1:

Input:
nums = [1, 7, 3, 6, 5, 6]
Output: 3
Explanation:
The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right of index 3.
Also, 3 is the first index where this occurs.


Example 2:

Input:
nums = [1, 2, 3]
Output: -1
Explanation:
There is no index that satisfies the conditions in the problem statement.


Note:

The length of nums will be in the range [0, 10000].
Each element nums[i] will be an integer in the range [-1000, 1000].
 *         
 *         思路：
 *             left right 两侧向中间进行累加 小的方向继续加 知道两个数一致且相差1
 *
 * 
 */
public class Solution {

    public int pivotIndex(int[] nums) {
        if (null == nums || nums.length == 0) {
            return -1;
        }
        int leftSum = 0;
        int rightSum = 0;
        // 遍历计算right
        for (int i = 1; i < nums.length; i++) {
            rightSum += nums[i];
        }
        if (leftSum == rightSum) {
            return 0;
        }
        for (int i = 1; i < nums.length; i++) {
            leftSum += nums[i - 1];
            rightSum -= nums[i];
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }
	

	
	public static void main(String[] args) {
		Solution solution = new Solution();
        int[] nums = {1, 7, 3, 6, 5, 6};// 3
//        int[] nums = {1, 2, 3};// -1
//        int[] nums = {-1,1,1,1,1,1};// -1
        int s = solution.pivotIndex(nums);
        System.out.println(s);
    }
}
