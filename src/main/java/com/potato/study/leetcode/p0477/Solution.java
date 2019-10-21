package com.potato.study.leetcode.p0477;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 *         477. Total Hamming Distance
 * 
 *         The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Now your job is to find the total Hamming distance between all pairs of the given numbers.

Example:
Input: 4, 14, 2

Output: 6

Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
showing the four bits relevant in this case). So the answer will be:
HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
Note:
Elements of the given array are in the range of 0 to 10^9
Length of the array will not exceed 10^4.
 *         思路：
 *         统计每一个位置1的个数count然后找到 不含邮1的个数 n-count 那么就有  n * （n-count） 个汉明计数
 *
 *         https://www.cnblogs.com/liujinhong/p/6206792.html
 *
 *         对于每一个数字 num 对其中每个位置进行计数 32位
 *
 *         
 * 
 */
public class Solution {

    public int totalHammingDistance(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int[] bitCount = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                int bit = num & 1;
                if (bit == 1) {
                    bitCount[i]++;
                }
                num = num >> 1;
            }
        }
        // 计算数量
        int totalCount = 0;
        for (int i = 0; i < 32; i++) {
            totalCount += (bitCount[i] * (nums.length - bitCount[i]));
        }
        return totalCount;
    }
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] num = {4, 14, 2};
		int result = solution.totalHammingDistance(num);
		System.out.println(result);
        Assert.assertEquals("not equals", 6, result);
	}
}
