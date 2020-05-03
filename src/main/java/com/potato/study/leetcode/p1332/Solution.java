package com.potato.study.leetcode.p1332;



import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	1332. Remove Palindromic Subsequences
 *  
 *
Given a string s consisting only of letters 'a' and 'b'. In a single step you can remove one palindromic subsequence from s.

Return the minimum number of steps to make the given string empty.

A string is a subsequence of a given string, if it is generated by deleting some characters of a given string without changing its order.

A string is called palindrome if is one that reads the same backward as well as forward.



Example 1:

Input: s = "ababa"
Output: 1
Explanation: String is already palindrome
Example 2:

Input: s = "abb"
Output: 2
Explanation: "abb" -> "bb" -> "".
Remove palindromic subsequence "a" then "bb".
Example 3:

Input: s = "baabb"
Output: 2
Explanation: "baabb" -> "b" -> "".
Remove palindromic subsequence "baab" then "b".
Example 4:

Input: s = ""
Output: 0


Constraints:

0 <= s.length <= 1000
s only consists of letters 'a' and 'b'
 *         
 *         思路：
 *
 *
 *          https://leetcode-cn.com/problems/remove-palindromic-subsequences/solution/bao-bao-ye-neng-kan-dong-de-leetcode-ti-jie-shen-t/
 *
 *          判断 整体是不是回文 是的话1次 不是的话 2次 （删除 a， 删除 b）
 *
 *
 */
public class Solution {

    public int removePalindromeSub(String s) {

        if (null == s || s.length() == 0) {
            return 0;
        }

        boolean isPali = true;
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                isPali = false;
                break;
            }
            left++;
            right--;
        }
        if (isPali) {
            return 1;
        }
        return 2;
    }

	public static void main(String[] args) {
        Solution solution = new Solution();

        String s = "ababa";
        int res = solution.removePalindromeSub(s);
        System.out.println(res);
        Assert.assertEquals(1, res);

        s = "abb";
        res = solution.removePalindromeSub(s);
        System.out.println(res);
        Assert.assertEquals(2, res);

        s = "baabb";
        res = solution.removePalindromeSub(s);
        System.out.println(res);
        Assert.assertEquals(2, res);

        s = "";
        res = solution.removePalindromeSub(s);
        System.out.println(res);
        Assert.assertEquals(0, res);
    }
}