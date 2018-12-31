package com.potato.study.leetcode.p0137;

/**
 * 
 * @author liuzhao11
 * 
 *         137. Single Number II
 *         
 *          Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,3,2]
Output: 3
Example 2:

Input: [0,1,0,1,0,1,99]
Output: 99
  
 *         思路：
 *         	int型 32 位 开一个bits[32] 数组 对每一个数字的每一个位置 进行计数 
 *         	对最终记得计数 % 3 得到单独那个数字的每一个位置 然后利用bits 生成 int型32位数
 *         
 *         https://blog.csdn.net/feliciafay/article/details/19004479
 * 
 */
public class Solution {
	
	public int singleNumber(int[] nums) {
        int[] bits = new int[32];
        for(int i = 0 ; i < 32 ; i++) { // 控制累加的位置
        		for(int j = 0 ; j < nums.length ; j++) { //控制累加的数字
        			bits[i] += ((nums[j] >> i ) & 1);
        		}
        		bits[i] %= 3;
        }
        int num = bitsToInt(bits);
        return num;
    }
	
	/**
	 *  代表2进制每个位置的数字
	 * @param bits
	 * @return
	 */
	private int bitsToInt(int[] bits) {
		int num = 0;
		for(int i = 0 ; i < 32 ; i++) {
			num += (bits[i] << i);
		}
		return num;
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
//		int[] nums = {2,2,3,2};
		int[] nums = {0,1,0,1,0,1,99};
		int num = solution.singleNumber(nums);
		System.out.println(num);
	}
}
