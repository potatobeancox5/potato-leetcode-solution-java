package com.potato.study.leetcode.p1318;


import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	1318. Minimum Flips to Make a OR b Equal to c
 *  
 *
Given 3 positives numbers a, b and c. Return the minimum flips required in some bits of a and b to make ( a OR b == c ). (bitwise OR operation).
Flip operation consists of change any single bit 1 to 0 or change the bit 0 to 1 in their binary representation.



Example 1:



Input: a = 2, b = 6, c = 5
Output: 3
Explanation: After flips a = 1 , b = 4 , c = 5 such that (a OR b == c)
Example 2:

Input: a = 4, b = 2, c = 7
Output: 1
Example 3:

Input: a = 1, b = 2, c = 3
Output: 0


Constraints:

1 <= a <= 10^9
1 <= b <= 10^9
1 <= c <= 10^9
 *         
 *         思路：
 *          https://hwchang0417.wordpress.com/2020/01/12/leetcode-1318-minimum-flips-to-make-a-or-b-equal-to-c/
 *
 *
 *
 *
 *
 */
public class Solution {

    public int minFlips(int a, int b, int c) {
        // 检查c的每一个位置 无符号填充向右移动
        int bit = 1;
        int step = 0;
        for (int i = 0; i < 32; i++) {
            int cBit = c & bit;
            int aBit = a & bit;
            int bBit = b & bit;
            // cBit == 1
            if (cBit > 0 ) {
                if (aBit > 0 || bBit > 0) {

                } else {
                    step++;
                }
            } else {
                if (aBit > 0) {
                    step++;
                }
                if (bBit > 0) {
                    step++;
                }

            }
            // bit 向右移动1位
            bit <<= 1;
        }
        return step;
    }

	public static void main(String[] args) {
        Solution solution = new Solution();

        int a = 2;
        int b = 6;
        int c = 5;
        int flips = solution.minFlips(a, b, c);
        System.out.println(flips);
        Assert.assertEquals(3, flips);

        a = 4;
        b = 2;
        c = 7;
        flips = solution.minFlips(a, b, c);
        System.out.println(flips);
        Assert.assertEquals(1, flips);

        a = 1;
        b = 2;
        c = 3;
        flips = solution.minFlips(a, b, c);
        System.out.println(flips);
        Assert.assertEquals(0, flips);


        a = 8;
        b = 3;
        c = 5;
        flips = solution.minFlips(a, b, c);
        System.out.println(flips);
        Assert.assertEquals(3, flips);
    }
}
