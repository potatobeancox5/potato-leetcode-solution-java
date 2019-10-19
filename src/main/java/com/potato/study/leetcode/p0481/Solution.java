package com.potato.study.leetcode.p0481;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 *         481. Magical String
 * 
 *        A magical string S consists of only '1' and '2' and obeys the following rules:

The string S is magical because concatenating the number of contiguous occurrences of characters '1' and '2' generates the string S itself.

The first few elements of string S is the following: S = "1221121221221121122……"

If we group the consecutive '1's and '2's in S, it will be:

1 22 11 2 1 22 1 22 11 2 11 22 ......

and the occurrences of '1's or '2's in each group are:

1 2 2 1 1 2 1 2 2 1 2 2 ......

You can see that the occurrence sequence above is the S itself.

Given an integer N as input, return the number of '1's in the first N number in the magical string S.

Note: N will not exceed 100,000.

Example 1:
Input: 6
Output: 3
Explanation: The first 6 elements of magical string S is "12211" and it contains three 1's, so return 3.
 * 
 *         思路:
 *         维护两个状态 分别记录当前的字符与数字，保证两者可以互相参考执行
 *
 *         https://segmentfault.com/a/1190000008367439
 *         
 * 
 */
public class Solution {


    public int magicalString(int n) {
        if (n == 0) {
            return 0;
        }
        if (n <= 3) {
            return 1;
        }
        // 现在申请到哪个len 的index
        int lenIndex = 2;
        // 现在构造到哪个位置的串了 1,2,2
        int currentIndex = 3;
        // nums[] 存储其中的 数字
        int[] nums = new int[n + 1];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 2;
        int oneCount= 1;
        while (currentIndex < n) {
            int nextNum = 3 - nums[currentIndex - 1];
            int count = nums[lenIndex++];
            for (int i = 0; i < count; i++) {
                nums[currentIndex] = nextNum;
                if (nextNum == 1 && currentIndex < n) {
                    oneCount++;
                }
                currentIndex++;
            }
        }
        return oneCount;
    }
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int keyNum = 6;
		int s = solution.magicalString(keyNum);
		System.out.println(s);
        Assert.assertEquals(3, s);


        keyNum = 4;
        s = solution.magicalString(keyNum);
        System.out.println(s);
        Assert.assertEquals(2, s);
	}
}
