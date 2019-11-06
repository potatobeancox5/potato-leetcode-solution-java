package com.potato.study.leetcode.p0467;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 *         467. Unique Substrings in Wraparound String
 * 
 *         Consider the string s to be the infinite wraparound string of "abcdefghijklmnopqrstuvwxyz", so s will look like this: "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".

Now we have another string p. Your job is to find out how many unique non-empty substrings of p are present in s. In particular, your input is the string p and you need to output the number of different non-empty substrings of p in the string s.

Note: p consists of only lowercase English letters and the size of p might be over 10000.

Example 1:
Input: "a"
Output: 1

Explanation: Only the substring "a" of string "a" is in the string s.
Example 2:
Input: "cac"
Output: 2
Explanation: There are two substrings "a", "c" of string "cac" in the string s.
Example 3:
Input: "zab"
Output: 6
Explanation: There are six substrings "z", "a", "b", "za", "ab", "zab" of string "zab" in the string s.
 * 
 * 
 *         思路：
 *          467. Unique Substrings in Wraparound String

依次求 p 中以 a-z结尾的每个字符串的最大连续数

https://www.cnblogs.com/grandyang/p/6143071.html
//数组 26个位置 每个存 当前字母 结束时最大连续
//continuesLen记录 当前i 按照字母顺序连续的数量
//for i 0  s len
//if  i 大于0 且  i字符与i-1 差一 或者 i-1 -i 等于25
//len++
//else  len = 1
//
//cpunt p i - a  = max len 其自身
 *
 *
 * 				
 */	
public class Solution {

    public int findSubstringInWraproundString(String p) {
        // 数组 26个位置 每个存 当前字母 结束时最大连续
        int[] count = new int[26];
        // continuesLen 记录 当前i 按照字母顺序连续的数量
        int continuesLen = 1;
        //for i 0  s len
        for (int i = 0; i < p.length(); i++) {
            //if  i 大于0 且  i字符与i-1 差一 或者 i-1 -i 等于25
            if (i > 0 && (p.charAt(i) - p.charAt(i -1) == 1 || p.charAt(i) - p.charAt(i -1) == -25)) {
                continuesLen++;
            } else {
                continuesLen = 1;
            }
            // 当前字母最大值
            int index = p.charAt(i) - 'a';
            count[index] = Math.max(continuesLen, count[index]);
        }
        // 求和
        int total = 0;
        for (int countEach : count) {
            total += countEach;
        }
        return total;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
        String p = "a";
		int res = solution.findSubstringInWraproundString(p);
		System.out.println(res);
        Assert.assertEquals(1, res);

        p = "cac";
        res = solution.findSubstringInWraproundString(p);
        System.out.println(res);
        Assert.assertEquals(2, res);

        p = "zab";
        res = solution.findSubstringInWraproundString(p);
        System.out.println(res);
        Assert.assertEquals(6, res);
    }
}
