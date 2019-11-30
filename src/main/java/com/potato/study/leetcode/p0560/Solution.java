package com.potato.study.leetcode.p0560;

import org.junit.Assert;


/**
 * 
 * @author liuzhao11
 * 
 *         560. Subarray Sum Equals K
 * 
 *         Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2
Note:
The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 * 
 * 
 *         思路：
 *          560. Subarray Sum Equals K

map key sum  value count
fori 0 len-1
求sum
sum 减去 target 找map中值 计数
map put sum count +1
 *       https://www.cnblogs.com/grandyang/p/6810361.html
 *          
 */
public class Solution {

    public int subarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            sum[i] = nums[i];
            if (i > 0) {
                sum[i] += sum[i-1];
            }
        }

        int kindCount = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (sum[i] == k) {
                kindCount++;
            }
            for (int j = 0; j < i; j++) {
                if (sum[i] - sum[j] == k) {
                    kindCount++;
                }
            }
        }
        return kindCount;
    }
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();

		int[] nums = {1,1,1};
        int k = 2;
        int sum = solution.subarraySum(nums, k);
        System.out.println(sum);
        Assert.assertEquals(2, sum);

        int[] nums1 = {0,0,0,0,0,0,0,0,0,0};
        k = 0;
        sum = solution.subarraySum(nums1, k);
        System.out.println(sum);
        Assert.assertEquals(55, sum);
    }
}
