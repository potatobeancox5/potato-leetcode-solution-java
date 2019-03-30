package com.potato.study.leetcode.p0665;

/**
 * 
 * @author liuzhao11
 * 
 *         665. Non-decreasing Array
 * 
 *         Given an array with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.

We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).

Example 1:
Input: [4,2,3]
Output: True
Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
Example 2:
Input: [4,2,1]
Output: False
Explanation: You can't get a non-decreasing array by modify at most one element.
Note: The n belongs to [1, 10,000].*
 *
 *
 *          https://www.cnblogs.com/jimmycheng/p/7703350.html
 *         思路： 遍历数组 找到 i > i + 1 判断是否是第二次遇到
 *                  是的话 false
 *                  不是的话
 *                      判断 将i+ 1变成i 是否i + 1 <= i + 2 是的话 变
 *                             记录当前是遍历一次
 *                      否则 将i 变成 i + 1 是否 i - 1 还 <= i 是的话 变吧
 *                              记录当前是遍历一次
 *                      最后都不是 那么 直接返回false
 *                数组遍历完了 直接返回true
 *
 *
 */
public class Solution {

    public boolean checkPossibility(int[] nums) {

        return false;
    }

	
	public static void main(String[] args) {
		Solution solution = new Solution();
        int[] nums = {};
        boolean result = solution.checkPossibility(nums);
        System.out.println(result);
    }
}
