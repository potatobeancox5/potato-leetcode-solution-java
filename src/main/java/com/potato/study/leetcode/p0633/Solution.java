package com.potato.study.leetcode.p0633;


/**
 * 
 * @author liuzhao11
 * 
 *         633. Sum of Square Numbers
 * 
 *         Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.

Example 1:

Input: 5
Output: True
Explanation: 1 * 1 + 2 * 2 = 5


Example 2:

Input: 3
Output: False
 * 
 *         思路：
 *         https://blog.csdn.net/gqk289/article/details/74942295
 *         双指针，end最大为c开根号，beg最小为0.判断当前beg和end是否满足，然后相应移动beg或者end
 */
public class Solution {


    public boolean judgeSquareSum(int c) {

        int start = 0;
        int end = (int) Math.sqrt(c);

        while (start <= end) {
            int tmp = start * start + end * end;
            if (c == tmp) {
                return true;
            } else if (c > tmp) {
                start++;
            } else {
                end--;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
//        int c = 5;// true
        int c = 3;// f

        boolean result = solution.judgeSquareSum(c);
        System.out.println(result);
    }
}
