package com.potato.study.leetcode.p0395;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 *       395. Longest Substring with At Least K Repeating Characters
 * 
 *     Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.

Example 1:

Input:
s = "aaabb", k = 3

Output:
3

The longest substring is "aaa", as 'a' is repeated 3 times.
Example 2:

Input:
s = "ababbc", k = 2

Output:
5

The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 *         
 *         思路：
 *          https://blog.csdn.net/u010900754/article/details/62159601
 *
 *          分治法思想
 *          1.子函数 判断 从i 到j （包含 ij） 的个位置出现字符串次数，
 *          2. 统计完次数 （数组计数），遍历 a - z 遇到第一个个个数出现大于等于1 且小于 k 的，分治判断 start 位置使用indexof
 *              end 使用 start + count - 1获得
 *          3. 如果2中不存在分治，返回 j - i + 1
 *
 *
 *
 *
 *
 *
 *         
 */
public class Solution {

    public int longestSubstring(String s, int k) {
        return divideGetTheLongestSubstring(s, k, 0, s.length() - 1);
    }

    /**
     * 找到最大值
     * @param s
     * @param k
     * @param i 开始位置
     * @param j 结束位置
     * @return
     */
    private int divideGetTheLongestSubstring(String s, int k, int i, int j) {
        // 0 剪枝
        if (null == s || s.length() == 0) {
            return 0;
        }
        if (k == 1) {
            return s.length();
        }
        if (i > j) {
            return 0;
        }
        // 1.子函数 判断 从i 到j （包含 ij） 的个位置出现字符串次数，
        int[] countArr = new int[26];
        for (int l = i; l <= j; l++) {
            countArr[s.charAt(l) - 'a']++;
        }
        // 2. 统计完次数 （数组计数），遍历 a - z 遇到第一个个个数出现大于等于1 且小于 k 的，分治判断 start 位置使用indexof
        // end 使用 start + count - 1获得
        for (int l = 0; l < 26; l++) {
            char ch = (char) ('a' + l);
            if (countArr[l] >= 1 && countArr[l] < k) {
                int start = s.indexOf(ch, i);
                return Math.max(divideGetTheLongestSubstring(s, k, i, start - 1), divideGetTheLongestSubstring(s, k, start + 1, j));
            }
        }
        // 3. 如果2中不存在分治，返回 j - i + 1
        return j - i + 1;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "aaabb";
        int k = 3;
        int res = solution.longestSubstring(s, k);
        System.out.println(res);
        Assert.assertEquals(3, res);


        s = "ababbc";
        k = 2;
        res = solution.longestSubstring(s, k);
        System.out.println(res);
        Assert.assertEquals(5, res);

        s = "bbaaacbd";
        k = 3;
        res = solution.longestSubstring(s, k);
        System.out.println(res);
        Assert.assertEquals(3, res);


        s = "baaabcb";
        k = 3;
        res = solution.longestSubstring(s, k);
        System.out.println(res);
        Assert.assertEquals(3, res);

    }
}

