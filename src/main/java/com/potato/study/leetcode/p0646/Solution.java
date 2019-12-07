package com.potato.study.leetcode.p0646;

import org.junit.Assert;

import java.util.Arrays;
import java.util.Comparator;


/**
 * 
 * @author liuzhao11
 * 
 *         646. Maximum Length of Pair Chain
 * 
 *         You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.

Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c. Chain of pairs can be formed in this fashion.

Given a set of pairs, find the length longest chain which can be formed. You needn't use up all the given pairs. You can select pairs in any order.

Example 1:
Input: [[1,2], [2,3], [3,4]]
Output: 2
Explanation: The longest chain is [1,2] -> [3,4]
Note:
The number of given pairs will be in the range [1, 1000].
 * 
 *         思路：
 *
 *         646. Maximum Length of Pair Chain



https://blog.csdn.net/huanghanqian/article/details/76139735

排序后dp解决
dpi 当前末尾元素为i的最长链跳数

贪心

按照end 生序排序
记录当前end 为int 最小值

遍历 如果
start 大于当前end
count ++
修改当前end
 *
 *
 *
 */
public class Solution {

	public int findLongestChain(int[][] pairs) {
		// 1. 按照end 生序排序
		Arrays.sort(pairs, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		// 2.遍历 curEnd 当前已经遍历到的结束时间
		int curEnd = Integer.MIN_VALUE;
		int count = 0;
		for (int i = 0; i < pairs.length; i++) {
			// 当前结束时间比开始时间小 说明满足了条件
			if (curEnd < pairs[i][0]) {
				curEnd = pairs[i][1];
				count++;
			}
		}
		return count;
	}

	
	public static void main(String[] args) {
		Solution solution = new Solution();

		int[][] pairs = {{1,2}, {2,3}, {3,4}};

		int res = solution.findLongestChain(pairs);
		System.out.println(res);
		Assert.assertEquals(2,res);
	}
}
