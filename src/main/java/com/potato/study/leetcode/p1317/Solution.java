package com.potato.study.leetcode.p1317;



import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 * 	1317. Convert Integer to the Sum of Two No-Zero Integers
 *  
 *
Given an integer n. No-Zero integer is a positive integer which doesn't contain any 0 in its decimal representation.

Return a list of two integers [A, B] where:

A and B are No-Zero integers.
A + B = n
It's guarateed that there is at least one valid solution. If there are many valid solutions you can return any of them.



Example 1:

Input: n = 2
Output: [1,1]
Explanation: A = 1, B = 1. A + B = n and both A and B don't contain any 0 in their decimal representation.
Example 2:

Input: n = 11
Output: [2,9]
Example 3:

Input: n = 10000
Output: [1,9999]
Example 4:

Input: n = 69
Output: [1,68]
Example 5:

Input: n = 1010
Output: [11,999]


Constraints:

2 <= n <= 10^4
 *         
 *         思路： 将一个数 分割成两个数字之和  分割后的数 不能含有 0
 *
 *
 *          1317. Convert Integer to the Sum of Two No-Zero Integers

一个数变成两个数的和 不能包含0
https://leetcode-cn.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/solution/hen-yi-wai-guan-fang-ti-jie-jing-ran-zhi-you-mei-j


遍历 target 的每个最低位置
a 存当前值
帝国 i记录 当前十位还是百位
while targt 大于等于10
bit 等于 target %10
if bit 1
cur 2
else
cur=1
tar 减去 cur
a += difit *cur
digit 变更
tar 变更
 *
 *
 *
 */
public class Solution {

    public int[] getNoZeroIntegers(int n) {

        if (n < 10) {
            return new int[]{1, n-1};
        }

        int target = n;
        // 十进制 数位
        int digit = 1;
        // 其中一个数字
        int com = 0;
        while (target > 0) {

            if (target < 10) {
                break;
            }

            int cur = target % 10;
            // 组成数组 选这个吧
            int comCurBit = (cur == 1 ? 2 : 1);

            com += (comCurBit * digit);
            digit *= 10;
            target -= comCurBit;
            target /= 10;
        }
        return new int[]{com, n - com};
    }

	public static void main(String[] args) {
        Solution solution = new Solution();

        int n = 2;
        int[] flips = solution.getNoZeroIntegers(n);
        System.out.println(Arrays.toString(flips)); // 1,1


        n = 11;
        flips = solution.getNoZeroIntegers(n);
        System.out.println(Arrays.toString(flips)); // 2 , 9


        n = 19;
        flips = solution.getNoZeroIntegers(n);
        System.out.println(Arrays.toString(flips)); // 1 , 18
    }
}
