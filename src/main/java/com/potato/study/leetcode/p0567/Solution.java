package com.potato.study.leetcode.p0567;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 *         567. Permutation in String
 * 
 *         Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.



Example 1:

Input: s1 = "ab" s2 = "eidbaooo"
Output: True
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input:s1= "ab" s2 = "eidboaoo"
Output: False


Note:

The input strings only contain lower case letters.
The length of both given strings is in range [1, 10,000].
 * 
 * 
 *
 *         题目含义：
 *
 *         思路：
 *         567. Permutation in String

滑动窗口

统计 map s1 出现个数

map 统计s2窗口出现个数

每次移动修改map2 并判断是否相等

https://blog.csdn.net/juanqinyang/article/details/71373232
 *
 *       
 *          
 */
public class Solution {

    public boolean checkInclusion(String s1, String s2) {

        int[] count1 = new int[26];
        // 统计 map s1 出现个数
        for (int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i) - 'a']++;
        }
        // map 统计s2窗口出现个数
        int[] count2 = new int[26];
        for (int i = 0; i < s2.length(); i++) {
            if (i < s1.length() - 1) {
                count2[s2.charAt(i) - 'a']++;
                continue;
            }else if (i == s1.length() - 1) {
                count2[s2.charAt(i) - 'a']++;
            } else {
                // 增加一个并删除一个
                count2[s2.charAt(i) - 'a']++;
                // 删除最开始的哪个字母
                count2[s2.charAt(i-s1.length()) - 'a']--;
            }
            if (isArrayEquals(count1, count2)) {
                return true;
            }
        }
        return false;
    }


    private boolean isArrayEquals(int[] a1, int[] a2) {
        for (int i = 0; i < 26; i++) {
            if (a1[i] != a2[i]) {
                return false;
            }
        }
        return true;
    }
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
        String s1 = "ab";
        String s2 = "eidbaooo";
        boolean res = solution.checkInclusion(s1, s2);
        System.out.println(res);
        Assert.assertEquals(true, res);

        s1 = "ab";
        s2 = "eidboaoo";
        res = solution.checkInclusion(s1, s2);
        System.out.println(res);
        Assert.assertEquals(false, res);
    }
}
