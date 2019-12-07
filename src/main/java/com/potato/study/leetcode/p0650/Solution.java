package com.potato.study.leetcode.p0650;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 *         650. 2 Keys Keyboard
 * 
 *         Initially on a notepad only one character 'A' is present. You can perform two operations on this notepad for each step:

Copy All: You can copy all the characters present on the notepad (partial copy is not allowed).
Paste: You can paste the characters which are copied last time.


Given a number n. You have to get exactly n 'A' on the notepad by performing the minimum number of steps permitted. Output the minimum number of steps to get n 'A'.

Example 1:

Input: 3
Output: 3
Explanation:
Intitally, we have one character 'A'.
In step 1, we use Copy All operation.
In step 2, we use Paste operation to get 'AA'.
In step 3, we use Paste operation to get 'AAA'.


Note:

The n will be in the range [1, 1000].
 * 
 *         思路：
 *         650. 2 Keys Keyboard

https://www.cnblogs.com/grandyang/p/7439616.html

dp i 组成i的最小次数

for i 1 n
dp i =i
for j i-1 2
if i能被j整除
dp i  =dp j + i/j  min dp[i]
break


返回dp n
 */
public class Solution {

	public int minSteps(int n) {
		int[] dp = new int[n+1];

		if (n == 1) {
			return 0;
		}

		for (int i = 2; i <= n; i++) {
			// 最笨的方法直接复制i次
			dp[i] = i;
			for (int j = i-1; j > 1; j--) {
				if (i % j == 0) {
					dp[i] = dp[j] + i/j;
					break;
				}
			}
		}
		return dp[n];
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int n = 3;
		int count = solution.minSteps(n);
		System.out.println(count);
		Assert.assertEquals(3, count);


		n = 1;
		count = solution.minSteps(n);
		System.out.println(count);
		Assert.assertEquals(0, count);

		n = 4;
		count = solution.minSteps(n);
		System.out.println(count);
		Assert.assertEquals(4, count);

		n = 6;
		count = solution.minSteps(n);
		System.out.println(count);
		Assert.assertEquals(5, count);
	}
}
