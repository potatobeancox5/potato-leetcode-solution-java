package com.potato.study.leetcode.p0392;

/**
 * 
 * @author liuzhao11
 * 
 *       392. Is Subsequence
 * 
 *     Given a string s and a string t, check if s is subsequence of t.

You may assume that there is only lower case English letters in both s and t. t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).

Example 1:
s = "abc", t = "ahbgdc"

Return true.

Example 2:
s = "axc", t = "ahbgdc"

Return false.

Follow up:
If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?

Credits:
Special thanks to @pbrother for adding this problem and creating all test cases.
 *         
 *         思路：
 *        https://www.cnblogs.com/271934Liao/p/7076176.html
 *        贪心算法
 *        遍历t 和s 找到s 即开始找下一个
 *         
 */
public class Solution {

    public boolean isSubsequence(String s, String t) {
        if (s == null && t == null) {
            return true;
        } else if (s == null && t != null) {
            return false;
        }
        if (s.equals(t)) {
            return true;
        }
        int sIndex = 0;
        for (int i = 0; i < t.length(); i++) {
            if (sIndex < s.length() && s.charAt(sIndex) == t.charAt(i)) {
                sIndex++;
            }
            if (sIndex >= s.length()) {
                return true;
            }
        }
        return false;
    }
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		String s = "axc";
		String t = "ahbgdc";
		boolean ch = solution.isSubsequence(s, t);
		System.out.println(ch);
	}
}

