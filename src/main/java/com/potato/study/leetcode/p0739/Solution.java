package com.potato.study.leetcode.p0739;

import java.util.Arrays;
import java.util.Stack;

/**
 * 
 * @author liuzhao11
 * 
 * 	739. Daily Temperatures
 *  
 *         Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.

For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].

Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
 *         
 *         思路：
 *
 *         维护一个stack stack 内部是递减的
 *         遍历数字nums
 *          如果当前stack为null 将当前index i push stack
 *          否则
 *              如果当前数字 > stack.peek 对应的数字 记录差值结果为多少天
 *                  stack 之前都可以设置
 *              如果当前数字 <= stack.peek 当前节点 入stack
 *
 * 
 */
public class Solution {

    public int[] dailyTemperatures(int[] nums) {
        Stack<Integer> indexStack = new Stack<>();
        int[] dailyDis = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (indexStack.isEmpty() || nums[i] <= nums[indexStack.peek()]) {
                indexStack.add(i);
            } else { // 一直判断到 numsi <= stack.peek
                //nums[i] > nums[indexStack.peek()]
                while (!indexStack.isEmpty() && nums[i] > nums[indexStack.peek()]) {
                    int beforeDay = indexStack.pop();
                    dailyDis[beforeDay] = i - beforeDay;
                }
                indexStack.add(i);
            }
        }
        return dailyDis;
        
    }
	

	
	public static void main(String[] args) {
		Solution solution = new Solution();
        int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] days = solution.dailyTemperatures(nums);
        System.out.println(Arrays.toString(days));
    }
}
