package com.potato.study.leetcode.p1124;


import org.junit.Assert;


/**
 * 
 * @author liuzhao11
 * 
 * 	1124. Longest Well-Performing Interval
 *  
 *         We are given hours, a list of the number of hours worked per day for a given employee.

A day is considered to be a tiring day if and only if the number of hours worked is (strictly) greater than 8.

A well-performing interval is an interval of days for which the number of tiring days is strictly larger than the number of non-tiring days.

Return the length of the longest well-performing interval.



Example 1:

Input: hours = [9,9,6,0,6,6,9]
Output: 3
Explanation: The longest well-performing interval is [9,9,6].


Constraints:

1 <= hours.length <= 10000
0 <= hours[i] <= 16

 *         
 *         思路：
 *          https://leetcode-cn.com/problems/longest-well-performing-interval/solution/1124java-bao-li-fa-ha-xi-biao-onde-fang-fa-xiang-j/
 *
 *
 */
public class Solution {

    public int longestWPI(int[] hours) {
        int n = hours.length;
        // 归一化
        for(int i = 0; i < n; i++){
            hours[i] = hours[i] > 8 ? 1 : -1;
        }
        int res = 0;
        for(int i = 0; i < n; i++){
            int count = 0;
            for(int j = i; j < n; j++){
                count += hours[j];
                // 说明 i j 属于 题目含义
                if(count > 0) {
                    res = Math.max(res, j - i + 1);
                }
            }
            // 剪枝
            if(n - i <= res) {
                return res;
            }
        }
        return res;
    }

	
	public static void main(String[] args) {
		Solution solution = new Solution();

        int[] hours = new int[]{9,9,6,0,6,6,9};
        int res = solution.longestWPI(hours);
        System.out.println(res);
        Assert.assertEquals(3, res);
    }
}
