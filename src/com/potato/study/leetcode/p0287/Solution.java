package com.potato.study.leetcode.p0287;

/**
 * 
 * @author liuzhao11
 * 
 * 
 * 287. Find the Duplicate Number
Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Example 1:

Input: [1,3,4,2,2]
Output: 2
Example 2:

Input: [3,1,3,4,2]
Output: 3
Note:

You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.
 *   https://blog.csdn.net/monkeyduck/article/details/50439840
 * 	题目含义：
 *      一个数组中只有一个数字重复了 找到这个数字
 * 	思路：
 * 	    抽象成链表的快慢指针找到环开始点
 * 	    1. 找到快慢指针交点
 * 	    2. 焦点和开始的点一起一步一步走，交点就是环开始点
 *
 */
public class Solution {


    public int findDuplicate(int[] nums) {
        int fastIndex = nums[nums[0]];
        int slowIndex = nums[0];
        while (fastIndex != slowIndex) {
            fastIndex = nums[nums[fastIndex]];
            slowIndex = nums[slowIndex];
        }
        int meetIndex = fastIndex;
        int newStartIndex = 0;
        while (meetIndex != newStartIndex) {
            meetIndex = nums[meetIndex];
            newStartIndex = nums[newStartIndex];
        }
        return newStartIndex;
    }
	
	
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	int[] nums = {1,3,4,2,2}; // 2
//    	int[] nums = {3,1,3,4,2}; // 3

        int duplicate = solution.findDuplicate(nums);
        System.out.println("duplicate: " + duplicate);
    }
}
