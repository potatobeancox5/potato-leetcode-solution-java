package com.potato.study.leetcode.p0338;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 *         338. Counting Bits
 * 
 *         Given a non negative integer number num. For every numbers i in the
 *         range 0 ≤ i ≤ num calculate the number of 1's in their binary
 *         representation and return them as an array.
 * 
 *         Example: For num = 5 you should return [0,1,1,2,1,2].
 * 
 *         Follow up:
 * 
 *         It is very easy to come up with a solution with run time
 *         O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly
 *         in a single pass? Space complexity should be O(n). Can you do it like
 *         a boss? Do it without using any builtin function like
 *         __builtin_popcount in c++ or in any other language.
 * 
 *         思路： 动态规划题目 
 * 
 *         我得解答：
 *     	主要是观察到
 * 		1
 * 		10
 * 		11
 * 		100
 * 		101
 * 		110
 * 		111
 * 		1000
 * 上述观察到1->10/11  10->100/101 11->110/111
 * 即循环地在每个数后面加0、1可得接下来的数字。因此第i位就是第i/2位+（i%2）的值。
 * 
 */
public class Solution {
	
	public int[] countBits(int num) {
		if(num < 0) {
			return new int[0];
		}
        int[] result = new int[num + 1];
        result[0] = 0;
        for(int i = 1 ; i < num + 1 ; i++) {
        		result[i] = result[i / 2] + (i & 1);
        }
        return result;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] result = solution.countBits(0);
		System.out.println(Arrays.toString(result));
	}
}
