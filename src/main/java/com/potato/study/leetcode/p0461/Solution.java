package com.potato.study.leetcode.p0461;

/**
 * 
 * @author liuzhao11
 * 
 *        461. Hamming Distance
 * 
 *       The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.

Note:
0 ≤ x, y < 231.

Example:

Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

The above arrows point to positions where the corresponding bits are different.

 * 
 * 
 *         思路： 
 * 			按位异或  同 = 1 异 = 1
 *            count 1 个数
 * 				
 */	
public class Solution {
	
	public int hammingDistance(int x, int y) {
        int tmp = x ^ y;
        int count = 0;
        while(tmp != 0) {
        	tmp = tmp & (tmp -1);
        	count ++;
        }
        return count;
    }
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int x = 1;
		int y = 4;
		int dis = solution.hammingDistance(x, y);
		System.out.println(dis);
	}
}
