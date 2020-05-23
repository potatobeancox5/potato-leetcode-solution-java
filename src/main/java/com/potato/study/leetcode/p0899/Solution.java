package com.potato.study.leetcode.p0899;

import org.junit.Assert;

import java.util.Arrays;

/**
 * @author liuzhao11
 *
 * 899. Orderly Queue
 *
 * A string S of lowercase letters is given.  Then, we may make any number of moves.

In each move, we choose one of the first K letters (starting from the left), remove it, and place it at the end of the string.

Return the lexicographically smallest string we could have after any number of moves.



Example 1:

Input: S = "cba", K = 1
Output: "acb"
Explanation:
In the first move, we move the 1st character ("c") to the end, obtaining the string "bac".
In the second move, we move the 1st character ("b") to the end, obtaining the final result "acb".
Example 2:

Input: S = "baaca", K = 3
Output: "aaabc"
Explanation:
In the first move, we move the 1st character ("b") to the end, obtaining the string "aacab".
In the second move, we move the 3rd character ("c") to the end, obtaining the final result "aaabc".


Note:

1 <= K <= S.length <= 1000
S consists of lowercase letters only.

 * 题目含义：
 *
 *
 *
 * 思路：
 *      https://leetcode-cn.com/problems/orderly-queue/solution/you-xu-dui-lie-by-leetcode/
 *      数学推导 得出 k大于2时 可以进行任意交换
 *
 */
public class Solution {

    public String orderlyQueue(String s, int k) {
        if (k == 1) {
            String ans = s;
            // 每个位置 前后重置 比较 得出最小的字符串
            for (int i = 0; i < s.length(); ++i) {
                String t = s.substring(i) + s.substring(0, i);
                if (t.compareTo(ans) < 0) {
                    ans = t;
                }
            }
            return ans;
        } else {
            // 大于2时 直接返回即可
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            return new String(ca);
        }
    }




    public static void main(String[] args) {
		Solution solution = new Solution();
        String s = "baaca";
        int k = 3;
        String res = solution.orderlyQueue(s, k);
        System.out.println(res);
        Assert.assertEquals("aaabc", res);
    }
}
