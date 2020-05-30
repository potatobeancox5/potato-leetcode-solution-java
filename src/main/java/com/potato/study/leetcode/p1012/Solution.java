package com.potato.study.leetcode.p1012;


import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 * 	1012. Numbers With Repeated Digits
 *  
 *        Given a positive integer N, return the number of positive integers less than or equal to N that have at least 1 repeated digit.



Example 1:

Input: 20
Output: 1
Explanation: The only positive number (<= 20) with at least 1 repeated digit is 11.
Example 2:

Input: 100
Output: 10
Explanation: The positive numbers (<= 100) with atleast 1 repeated digit are 11, 22, 33, 44, 55, 66, 77, 88, 99, and 100.
Example 3:

Input: 1000
Output: 262


Note:

1 <= N <= 10^9
 *         
 *         思路：
 *         https://leetcode-cn.com/problems/numbers-with-repeated-digits/solution/javaxiang-xi-ti-jie-by-ryan-157/
 *    *
 */
public class Solution {

    public int numDupDigitsAtMostN(int num) {
        List<Integer> list = new ArrayList<>();
        for (int x = num + 1; x > 0; x /= 10) {
            list.add(0, x % 10);
        }
        int res = 0, n = list.size();
        // 考虑 XXX形式的数
        for (int i = 1; i < n; ++i) {
            res += 9 * permutations(9, i - 1);
        }
        boolean[] seen = new boolean[10];
        for (int i = 0; i < n; ++i) {
            for (int j = i > 0 ? 0 : 1 ; j < list.get(i); ++j) {
                // 遍历当前位置i的所有可能
                if (!seen[j]) {
                    res += permutations(9 - i, n - i - 1);
                }
            }
            // 剪枝 如果 N = 4456; 当遍历到 44XX， 没必要再向后遍历了，因为一定是重复的
            if (seen[list.get(i)]) {
                break;
            }
            seen[list.get(i)] = true;
            // 将当前位置的数组放入seen中，防止后边数字与其重复
        }
        return num - res;
    }

    // 排列组合数计算
    public int permutations(int n, int m) {
        return m == 0 ? 1 : permutations(n, m - 1) * (n - m + 1);
    }
	
	public static void main(String[] args) {
    }
}
