package com.potato.study.leetcode.p0410;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 *        410. Split Array Largest Sum
 * 
 *         Given an array which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays. Write an algorithm to minimize the largest sum among these m subarrays.

Note:
If n is the length of array, assume the following constraints are satisfied:

1 ≤ n ≤ 1000
1 ≤ m ≤ min(50, n)
Examples:

Input:
nums = [7,2,5,10,8]
m = 2

Output:
18

Explanation:
There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8],
where the largest sum among the two subarrays is only 18.
 * 
 * 
 *         思路：
 *         https://blog.csdn.net/yeqiuzs/article/details/52723507
 *         计算 只分成一个组的最大值也就是整个组的和 max，和每一个元素独立成组 此时最大值就是 min
 *         如果当前m 是上述两种情况之一 直接返回
 *
 *          int result = 0;
 *
 *         int count = 1  记录总的分区数
 *         result = max;
 *         while min <= max
 *          计算 mid = max + min ） / 2
 *          currentSum 计算当前序列的和 初始值为 nums[0]
 *
 *          needBigger = false;
 *          for i = 1 i < nums.len i++
 *
 *              贪心发计算当前
     *           if (currentSum <= m) {
     *               currentSum += nums
     *           } else { // 大于
     *               currentSum = nums[i]
     *               count++;
     *
     *           }
     *            if count > m
 *                 needBigger = true;
 *                 break;
 *
 *           对应 while if needBigger min = mid + 1;
 *
 *            else () {
 *                max = mid - 1;
 *                ans = mid
 *            }
 *            https://blog.csdn.net/yeqiuzs/article/details/52723507
 *
 *
 *
 *
 *
 */
public class Solution {

    public int splitArray(int[] nums, int m) {
        int min = Integer.MIN_VALUE;
        int max = 0;
        int result = 0;
        if (null == nums || nums.length == 0) {
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            max += nums[i];
            min = Math.max(min, nums[i]);
        }
        if (m == 1) {
            return max;
        } else if (m == nums.length) {
            return min;
        }
        // 当前 分段个数
        int count;
        int high = max;
        int low = min;
        while (low <= high) {
            int mid = (low + high) / 2;
            int currentSum = nums[0];
            boolean needBigger = false;
            count = 1;
            for (int i = 1; i < nums.length; i++) {
                if (currentSum + nums[i] <= mid) {
                    currentSum += nums[i];
                } else {
                    currentSum = nums[i];
                    count++;
                }
                if (count > m) {
                    needBigger = true;
                    break;
                }
            }
            if (needBigger) {
                low = mid + 1;
            } else {
                high = mid - 1;
                result = mid;
            }
        }
        return result;
    }
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {7,2,5,10,8};
		int m = 2;
		int largestSum = solution.splitArray(nums, m);
		System.out.println(largestSum);
        Assert.assertEquals(18 , largestSum);


        int[] nums1 = {2,3,1,2,4,3};
        m = 5;
        largestSum = solution.splitArray(nums1, m);
        System.out.println(largestSum);
        Assert.assertEquals( 4, largestSum);
    }
}
