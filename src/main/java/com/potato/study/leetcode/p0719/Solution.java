package com.potato.study.leetcode.p0719;


import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	719. Find K-th Smallest Pair Distance
 *  
 *         Given an integer array, return the k-th smallest distance among all the pairs. The distance of a pair (A, B) is defined as the absolute difference between A and B.

Example 1:
Input:
nums = [1,3,1]
k = 1
Output: 0
Explanation:
Here are all the pairs:
(1,3) -> 2
(1,1) -> 0
(3,1) -> 2
Then the 1st smallest distance pair is (1,1), and its distance is 0.
Note:
2 <= len(nums) <= 10000.
0 <= nums[i] < 1000000.
1 <= k <= len(nums) * (len(nums) - 1) / 2.

 *         
 *         思路:
 *            开 1000000 个同作为技术器，计数 暴力搜索
 *            https://www.cnblogs.com/grandyang/p/8627783.html
 *
 * 
 */
public class Solution {

    public int smallestDistancePair(int[] nums, int k) {
        int[] count = new int[1000000];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                count[Math.abs(nums[j] - nums[i])]++;
            }
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] >= k) {
                return i;
            }
            k -= count[i];
        }
        return -1;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
        int[] nums = {1,3,1};
        int k = 1;
        int res = solution.smallestDistancePair(nums, k);
        System.out.println(res);
        Assert.assertEquals(0, res);
    }
}
