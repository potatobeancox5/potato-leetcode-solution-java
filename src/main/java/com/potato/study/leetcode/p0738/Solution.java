package com.potato.study.leetcode.p0738;

import org.junit.Assert;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 * 	738. Monotone Increasing Digits
 *  
 *         Given a non-negative integer N, find the largest number that is less than or equal to N with monotone increasing digits.

(Recall that an integer has monotone increasing digits if and only if each pair of adjacent digits x and y satisfy x <= y.)

Example 1:
Input: N = 10
Output: 9
Example 2:
Input: N = 1234
Output: 1234
Example 3:
Input: N = 332
Output: 299
Note: N is an integer in the range [0, 10^9].
 *         
 *         思路：
 *         找到单调递增的数字 of 比给定数字调
 *
 *         从高位向低位遍历 找到第一个下降的 位置i+1   324  i+1 就是2 i是3
 *         将i 位置的数字-- 此时为 224 已经满足需求在将后边的位置都改成99
 *
 *         331  i+1 - 1  321 -> 221 -> 299
 *
 *         https://www.cnblogs.com/grandyang/p/8068326.html
 *
 *
 *
 * 
 */
public class Solution {

    public int monotoneIncreasingDigits(int n) {
        // 将n 转换成数组 方便比较
        char[] numArr = String.valueOf(n).toCharArray();
        // 0 从高位向低位遍历 找到第一个下降的 位置i+1
        int firstDownIndex = -1;
        for (int i = 0; i < numArr.length - 1; i++) {
            if (numArr[i] > numArr[i+1]) {
                firstDownIndex = i + 1;
                break;
            }
        }
        if (firstDownIndex == -1) {
            return n;
        }
        // 1 依次将i 位置 -- 并 重新比较i 与 i-1，记录最后一次修改的位置
        int i = firstDownIndex;
        numArr[i]--;
        while (i >= 1 && numArr[i-1] > numArr[i]) {
            numArr[i-1]--;
            i--;
        }
        // 2 将2 记录后的位置 之后的数字都变成9
        Arrays.fill(numArr, i+1, numArr.length, '9');
        return Integer.parseInt(new String(numArr));
    }
	

	
	public static void main(String[] args) {
		Solution solution = new Solution();

        int n = 10;
        int num = solution.monotoneIncreasingDigits(n);
        System.out.println(num);
        Assert.assertEquals(9, num);

        n = 1234;
        num = solution.monotoneIncreasingDigits(n);
        System.out.println(num);
        Assert.assertEquals(1234, num);

        n = 332;
        num = solution.monotoneIncreasingDigits(n);
        System.out.println(num);
        Assert.assertEquals(299, num);
    }
}
