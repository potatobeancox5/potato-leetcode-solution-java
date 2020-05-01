package com.potato.study.leetcode.p0842;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 * 	842. Split Array into Fibonacci Sequence
 *  
 *         Given a string S of digits, such as S = "123456579", we can split it into a Fibonacci-like sequence [123, 456, 579].

Formally, a Fibonacci-like sequence is a list F of non-negative integers such that:

0 <= F[i] <= 2^31 - 1, (that is, each integer fits a 32-bit signed integer type);
F.length >= 3;
and F[i] + F[i+1] = F[i+2] for all 0 <= i < F.length - 2.
Also, note that when splitting the string into pieces, each piece must not have extra leading zeroes, except if the piece is the number 0 itself.

Return any Fibonacci-like sequence split from S, or return [] if it cannot be done.

Example 1:

Input: "123456579"
Output: [123,456,579]
Example 2:

Input: "11235813"
Output: [1,1,2,3,5,8,13]
Example 3:

Input: "112358130"
Output: []
Explanation: The task is impossible.
Example 4:

Input: "0123"
Output: []
Explanation: Leading zeroes are not allowed, so "01", "2", "3" is not valid.
Example 5:

Input: "1101111"
Output: [110, 1, 111]
Explanation: The output [11, 0, 11, 11] would also be accepted.
Note:

1 <= S.length <= 200
S contains only digits.
 *         
 *         思路：
 *
 * 
 */
public class Solution {

    private List<Integer> result = new ArrayList<>();

    public List<Integer> splitIntoFibonacci(String s) {
        dfsBuildFibonacci(s, 0, 0, 0, 0);
        return result;
    }


    /**
     * dfs 生成 Fibonacci 数列
     * @param s 原字符串
     * @param index  当前到比较的位置 index
     */
    /**
     * dfs 生成 Fibonacci 数列
     * @param s         字符串
     * @param index     当前到比较的位置 index
     * @param pre1      之前的第一个数字
     * @param pre2      之前的第二个数字
     * @param deep      当前是第几个数字
     */
    private boolean dfsBuildFibonacci(String s, int index, int pre1, int pre2, int deep) {
        int len = s.length();
        if (index == len) {
            return deep >= 3;
        }
        //  当前index 到位了 直接返回
        for (int i = 1; i <= 11; i++) {
            // 如果当前没有办法生成下一个数字，直接结束吧
            if (index + i > len || (s.charAt(index) == '0' && i > 1)) {
                break;
            }
            // 生成下一个数字
            String nextNumStr = s.substring(index, index + i);
            long nextNum = Long.parseLong(nextNumStr);
            if (nextNum > Integer.MAX_VALUE ||
                    (deep != 0 && deep != 1 && nextNum > (pre1 + pre2))) {
                break;
            }
            Integer num = (int) nextNum;
            //满足条件的数,递归加回溯
            if (deep == 0 || deep == 1 || num == pre1 + pre2) {
                result.add(num);
                //index + i, s, pre2, num, deep + 1
                if (dfsBuildFibonacci(s, index + i, pre2, num, deep + 1)) {
                    return true;
                }
                result.remove(num);
            }
        }
        return false;
    }


	public static void main(String[] args) {
		Solution solution = new Solution();

		String s = "123456579";
        List<Integer> list = solution.splitIntoFibonacci(s);
        System.out.println(list); // 123,456,579
    }
}
