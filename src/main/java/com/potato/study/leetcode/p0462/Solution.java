package com.potato.study.leetcode.p0462;

import org.junit.Assert;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 *        462. Minimum Moves to Equal Array Elements II
 * 
 *      Given a non-empty integer array, find the minimum number of moves required to make all array elements equal, where a move is incrementing a selected element by 1 or decrementing a selected element by 1.

You may assume the array's length is at most 10,000.

Example:

Input:
[1,2,3]

Output:
2

Explanation:
Only two moves are needed (remember each move increments or decrements one element):

[1,2,3]  =>  [2,2,3]  =>  [2,2,2]

 * 
 * 
 *         思路：
 *         462. Minimum Moves to Equal Array Elements II

最中间那个数 或者其中 之一

计算差值绝对值和

https://www.cnblogs.com/grandyang/p/6089060.html

题目含义
每次每个元素 加一或者减一  最少多少操作是的全部数组的值趋于一致

不管奇偶 都是中间的那个数 最终
于是 先排序

while i 《 j
sum +=     num j——  - num i++
 *
 * 				
 */	
public class Solution {

    public int minMoves2(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        int step = 0;
        while (i < j) {
            step += (nums[j--] - nums[i++]);
        }
        return step;
    }
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
        int[] nums = {};
		int dis = solution.minMoves2(nums);
		System.out.println(dis);
        Assert.assertEquals(0, dis);
	}
}
