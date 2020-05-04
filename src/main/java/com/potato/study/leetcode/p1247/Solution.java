package com.potato.study.leetcode.p1247;


import org.junit.Assert;


/**
 * 
 * @author liuzhao11
 * 
 * 	1247. Minimum Swaps to Make Strings Equal
 *  
 *      Given a string s of '(' , ')' and lowercase English characters.

You are given two strings s1 and s2 of equal length consisting of letters "x" and "y" only. Your task is to make these two strings equal to each other. You can swap any two characters that belong to different strings, which means: swap s1[i] and s2[j].

Return the minimum number of swaps required to make s1 and s2 equal, or return -1 if it is impossible to do so.



Example 1:

Input: s1 = "xx", s2 = "yy"
Output: 1
Explanation:
Swap s1[0] and s2[1], s1 = "yx", s2 = "yx".
Example 2:

Input: s1 = "xy", s2 = "yx"
Output: 2
Explanation:
Swap s1[0] and s2[0], s1 = "yy", s2 = "xx".
Swap s1[0] and s2[1], s1 = "xy", s2 = "xy".
Note that you can't swap s1[0] and s1[1] to make s1 equal to "yx", cause we can only swap chars in different strings.
Example 3:

Input: s1 = "xx", s2 = "xy"
Output: -1
Example 4:

Input: s1 = "xxyyxyxyxx", s2 = "xyyxyxxxyx"
Output: 4


Constraints:

1 <= s1.length, s2.length <= 1000
s1, s2 only contain 'x' or 'y'.
 *         
 *
 *
 *         思路：
 *
 *         1247. Minimum Swaps to Make Strings Equal

题目含义
给出 2哥串 只有 xy 组成

https://leetcode-cn.com/problems/minimum-swaps-to-make-strings-equal/solution/java-tan-xin-suan-fa-xiang-jie-zhi-xing-yong-shi-n

计算 xy 和yx 个数

如果sum 为奇数 返回-1

返回 xy +1）/2 + yx +1）/2
 *
 *

 *
 */
public class Solution {

    public int minimumSwap(String s1, String s2) {

        int xyCount = 0;
        int yxCount = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                continue;
            }

            if (s1.charAt(i) == 'x') {
                xyCount++;
            } else {
                yxCount++;
            }
        }

        if ((xyCount + yxCount) % 2 == 1) {
            return -1;
        }
        return (1 + xyCount) / 2 + (1 + yxCount) / 2;
    }

	public static void main(String[] args) {
        Solution solution = new Solution();

        String s1 = "xx";
        String s2 = "yy";
        int num = solution.minimumSwap(s1, s2);
        System.out.println(num);
        Assert.assertEquals(1, num);


        s1 = "xy";
        s2 = "yx";
        num = solution.minimumSwap(s1, s2);
        System.out.println(num);
        Assert.assertEquals(2, num);


        s1 = "xx";
        s2 = "xy";
        num = solution.minimumSwap(s1, s2);
        System.out.println(num);
        Assert.assertEquals(-1, num);


        s1 = "xxyyxyxyxx";
        s2 = "xyyxyxxxyx";
        num = solution.minimumSwap(s1, s2);
        System.out.println(num);
        Assert.assertEquals(4, num);
    }
}
