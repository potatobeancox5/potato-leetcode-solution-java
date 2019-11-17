package com.potato.study.leetcode.p0523;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 *         523. Continuous Subarray Sum
 * 
 *         Given a list of non-negative numbers and a target integer k,
 *          write a function to check if the array has a continuous subarray of size at least 2 that sums up to a multiple of k, that is, sums up to n*k where n is also an integer.



Example 1:

Input: [23, 2, 4, 6, 7],  k=6
Output: True
Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
Example 2:

Input: [23, 2, 6, 4, 7],  k=6
Output: True
Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.


Note:

The length of the array won't exceed 10,000.
You may assume the sum of all the numbers is in the range of a signed 32-bit integer.


 * 
 * 
 *         思路：
 *
 *         523. Continuous Subarray Sum


https://www.jianshu.com/p/c8a039b1955d

用一个map 存 当前余数 and index
初始map 0 -1
for i 0 len-1
tmp += num i
tmp %= k
val = map.get tmp
if val null
map put tmp i
else
if i—val 大于1 至少2个数的和
return true


return false
 *
 *
 *          
 */
public class Solution {

    public boolean checkSubarraySum(int[] nums, int k) {
        // 用一个map 存 当前余数 and index
        Map<Integer, Integer> remindIndexMap = new HashMap<>();
        remindIndexMap.put(0, -1);

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (k != 0) {
                sum %= k;
            }

            Integer index = remindIndexMap.get(sum);
            if (index == null) {
                remindIndexMap.put(sum, i);
            } else {
                if (i - index > 1) {
                    return true;
                }
            }
        }
        return false;
    }

	
	public static void main(String[] args) {

        Solution solution = new Solution();
        int[] nums = {23, 2, 4, 6, 7};
        int k = 6;
        boolean res = solution.checkSubarraySum(nums, k);
        System.out.println(res);
        Assert.assertEquals(true, res);

        int[] nums1 = {23, 2, 4, 6, 7};
        k = 0;
        res = solution.checkSubarraySum(nums1, k);
        System.out.println(res);
        Assert.assertEquals(false, res);

        int[] nums2 = {0, 0};
        k = 0;
        res = solution.checkSubarraySum(nums2, k);
        System.out.println(res);
        Assert.assertEquals(true, res);

    }
}
