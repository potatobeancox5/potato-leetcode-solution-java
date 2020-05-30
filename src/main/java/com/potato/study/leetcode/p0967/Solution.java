package com.potato.study.leetcode.p0967;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author liuzhao11
 * 
 * 	967. Numbers With Same Consecutive Differences
 *  
 *      Return all non-negative integers of length N such that the absolute difference between every two consecutive digits is K.

Note that every number in the answer must not have leading zeros except for the number 0 itself. For example, 01 has one leading zero and is invalid, but 0 is valid.

You may return the answer in any order.



Example 1:

Input: N = 3, K = 7
Output: [181,292,707,818,929]
Explanation: Note that 070 is not a valid number, because it has leading zeroes.
Example 2:

Input: N = 2, K = 1
Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]


Note:

1 <= N <= 9
0 <= K <= 9

 *         
 *         题目含义：
 *
 *         思路：
 *
 *
 *          https://leetcode-cn.com/problems/numbers-with-same-consecutive-differences/solution/lian-xu-chai-xiang-tong-de-shu-zi-by-leetcode-2/
 *
 * 
 */
public class Solution {

    public int[] numsSameConsecDiff(int num, int k) {
        Set<Integer> cur = new HashSet<>();
        for (int i = 1; i <= 9; ++i) {
            cur.add(i);
        }

        for (int steps = 1; steps <= num-1; ++steps) {
            Set<Integer> cur2 = new HashSet();
            for (int x: cur) {
                int d = x % 10;
                if (d-k >= 0) {
                    cur2.add(10*x + (d-k));
                }
                if (d+k <= 9) {
                    cur2.add(10*x + (d+k));
                }
            }
            cur = cur2;
        }

        if (num == 1) {
            cur.add(0);
        }

        int[] ans = new int[cur.size()];
        int t = 0;
        for (int x: cur) {
            ans[t++] = x;
        }
        return ans;
    }




    public static void main(String[] args) {
    }
}
