package com.potato.study.leetcode.p0466;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 *         466. Count The Repetitions
 * 
 *         Define S = [s,n] as the string S which consists of n connected strings s. For example, ["abc", 3] ="abcabcabc".

On the other hand, we define that string s1 can be obtained from string s2 if we can remove some characters from s2 such that it becomes s1. For example, “abc” can be obtained from “abdbec” based on our definition, but it can not be obtained from “acbbe”.

You are given two non-empty strings s1 and s2 (each at most 100 characters long) and two integers 0 ≤ n1 ≤ 106 and 1 ≤ n2 ≤ 106. Now consider the strings S1 and S2, where S1=[s1,n1] and S2=[s2,n2]. Find the maximum integer M such that [S2,M] can be obtained from S1.

Example:

Input:
s1="acb", n1=4
s2="ab", n2=2

Return:
2
 * 
 * 
 *         思路：
 *          466. Count The Repetitions

https://blog.csdn.net/xdhc304/article/details/79347650

总体思路

将s1重复n1次 在其中找s2个数 m个 返回m除以n2
s1index 为第几个s1串
c1index 为s1中第几个字符index

while s1index 小于 n1
比较 index1和index2 是否相同
相同 都加加
- [ ]   如果 index 1到了s1的末尾 重置换
- [ ]   同理s2到了末尾 置换s2

返回匹配的s2个数\n2
 *
 *
 * 				
 */	
public class Solution {

    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        // 当前比较的是第几个s1字符串
        int s1Index = 0;
        // 当前累计比较了多少哥s2字符串
        int s2Count = 0;
        int index2 = 0;
        while (s1Index < n1) {
            int index1 = 0;
            while (index1 < s1.length()) {
                if (s1.charAt(index1) == s2.charAt(index2)) {
                    index1++;
                    index2++;
                } else {
                    index1++;
                }
                // 判断是否达到了 s1 or s2 last char
                if (index1 == s1.length()) {
                    s1Index++;
                }
                if (index2 == s2.length()) {
                    s2Count++;
                    index2 = 0;
                }
            }
        }
        return s2Count / n2;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		String s1 = "acb";
		int n1 = 4;
		String s2 = "ab";
		int n2 = 2;
		int res = solution.getMaxRepetitions(s1, n1, s2, n2);
		System.out.println(res);
        Assert.assertEquals(2, res);
    }
}
