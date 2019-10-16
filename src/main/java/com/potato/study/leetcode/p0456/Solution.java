package com.potato.study.leetcode.p0456;

import java.util.Stack;

/**
 * 
 * @author liuzhao11
 * 
 *   456. 132 Pattern
 * 
 *      Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, ak such that i < j < k and ai < ak < aj. Design an algorithm that takes a list of n numbers as input and checks whether there is a 132 pattern in the list.

Note: n will be less than 15,000.

Example 1:
Input: [1, 2, 3, 4]

Output: False

Explanation: There is no 132 pattern in the sequence.
Example 2:
Input: [3, 1, 4, 2]

Output: True

Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
Example 3:
Input: [-1, 3, 2, 0]

Output: True

Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
 * 
 *         思路：
 *         https://blog.csdn.net/jmspan/article/details/53402983
 *
 *         1. 从后往前 遍历 使用数字 记录当前2这个数字应该的位置，2越接近3越好，stack 存放 当前比s2大的值
 *         2. 如果当前s2 小说明达成
 *              大于s2，从stack找离这个数字最新的s2
 *            当前数字 放到stack中
 *
 *
 *          
 *          
 * 			
 * 				
 */	
public class Solution {

    public boolean find132pattern(int[] nums) {
        int s2 = Integer.MIN_VALUE;
        Stack<Integer> s3Stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0 ; i--) {
            if (nums[i] < s2) {
                return true;
            } else if (nums[i] > s2) {
                // nums[i] 找新的s2 s3
                while (!s3Stack.isEmpty() && s3Stack.peek() < nums[i]) {
                    s2 = s3Stack.pop();
                }
            }
            s3Stack.push(nums[i]);
        }
        return false;
    }
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
        int[] nums = {};
		boolean res = solution.find132pattern(nums);
		System.out.println(res);
		
	}
}
