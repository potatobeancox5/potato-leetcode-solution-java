package com.potato.study.leetcode.p1347;


import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	1347. Minimum Number of Steps to Make Two Strings Anagram
 *  
 *
Given two equal-size strings s and t. In one step you can choose any character of t and replace it with another character.

Return the minimum number of steps to make t an anagram of s.

An Anagram of a string is a string that contains the same characters with a different (or the same) ordering.



Example 1:

Input: s = "bab", t = "aba"
Output: 1
Explanation: Replace the first 'a' in t with b, t = "bba" which is anagram of s.
Example 2:

Input: s = "leetcode", t = "practice"
Output: 5
Explanation: Replace 'p', 'r', 'a', 'i' and 'c' from t with proper characters to make t anagram of s.
Example 3:

Input: s = "anagram", t = "mangaar"
Output: 0
Explanation: "anagram" and "mangaar" are anagrams.
Example 4:

Input: s = "xxyyzz", t = "xxyyzz"
Output: 0
Example 5:

Input: s = "friend", t = "family"
Output: 4


Constraints:

1 <= s.length <= 50000
s.length == t.length
s and t contain lower-case English letters only.
 *         
 *         思路：
 *
 *
 *
 */
public class Solution {

    public int minSteps(String s, String t) {
        // 计数器 s
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        // 从计数器里 删除t 计算不匹配数量
        int misCount = 0;
        for (int i = 0; i < t.length(); i++) {
            if (count[t.charAt(i) - 'a'] <= 0) {
                misCount++;
            } else {
                count[t.charAt(i) - 'a']--;
            }
        }
        return misCount;
    }

	public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "xxyyzz";
        String t = "xxyyzz";
        int steps = solution.minSteps(s, t);
        System.out.println(steps);
        Assert.assertEquals(0, steps);

        s = "bab";
        t = "aba";
        steps = solution.minSteps(s, t);
        System.out.println(steps);
        Assert.assertEquals(1, steps);

        s = "leetcode";
        t = "practice";
        steps = solution.minSteps(s, t);
        System.out.println(steps);
        Assert.assertEquals(5, steps);

        s = "anagram";
        t = "mangaar";
        steps = solution.minSteps(s, t);
        System.out.println(steps);
        Assert.assertEquals(0, steps);

        s = "friend";
        t = "family";
        steps = solution.minSteps(s, t);
        System.out.println(steps);
        Assert.assertEquals(4, steps);
    }
}
