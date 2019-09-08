package com.potato.study.leetcode.p0334;

/**
 * 
 * @author liuzhao11
 * 
 *         334. Increasing Triplet Subsequence
 * 
 *         Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

Formally the function should:

Return true if there exists i, j, k
such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.

Example 1:

Input: [1,2,3,4,5]
Output: true
Example 2:

Input: [5,4,3,2,1]
Output: false
 * 
 *         思路：
 *         https://www.cnblogs.com/warmland/p/5735208.html
 *
 *
 * 
 */
public class Solution {

    public boolean increasingTriplet(int[] nums) {

        if (null == nums || nums.length < 3) {
            return false;
        }

        int first = nums[0];
        // second 设置成最大值 便于第一次获取secode
        int second = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > second) {
                return true;
            } else {
                if (nums[i] <= first) {
                    // 只改first 保证能之前如果再出现满足条件的third 满足之前的组合
                    first = nums[i];
                } else {
                    second = nums[i];
                }
            }
        }
        return false;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
//        int[] nums = {5,4,3,2,1};// false
//        int[] nums = {1,2,3,4,5};// true
//        int[] nums = {2,1,5,0,3};// false
        int[] nums = {1, 1,-2,6};// false
        boolean res = solution.increasingTriplet(nums);
        System.out.println(res);
	}
}
