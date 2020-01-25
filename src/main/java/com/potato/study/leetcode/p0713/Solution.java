package com.potato.study.leetcode.p0713;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	713. Subarray Product Less Than K
 *  
 *         Your are given an array of positive integers nums.
Count and print the number of (contiguous) subarrays where the product of all the elements
in the subarray is less than k.

Example 1:
Input: nums = [10, 5, 2, 6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are:
[10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
Note:

0 < nums.length <= 50000.
0 < nums[i] < 1000.
0 <= k < 10^6.
 *         
 *         思路：
 *
 *         求子连续数组 小于 k 的一共有多少个数量
 *
 *         //对于 [j, ... i] 范围内的元素, 满足条件的数组个数为 i + 1 - j.
 *         https://blog.csdn.net/Eric_1993/article/details/104012273
 *
 *
 *
 *
 *
 *
 * 
 */
public class Solution {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        // 遍历 nums 如果乘积小于 nums
        int product = 1;
        int j = 0;
        int totalCount = 0;
        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];
            // 找到j
            while (product >= k) {
                product /= nums[j];
                j++;
            }
            // 计算最终数量
            totalCount += (i + 1 - j);
        }
        return totalCount;
    }
	

	
	public static void main(String[] args) {

		Solution solution = new Solution();

        int[] nums = {10, 5, 2, 6};
        int k = 100;
        int res = solution.numSubarrayProductLessThanK(nums, k);
        System.out.println(res);
        Assert.assertEquals(8, res);

    }
}
