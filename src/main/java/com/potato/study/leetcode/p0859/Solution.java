package com.potato.study.leetcode.p0859;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	859. Buddy Strings
 *  
 *         Given two strings A and B of lowercase letters, return true if and only if we can swap two letters in A so that the result equals B.



Example 1:

Input: A = "ab", B = "ba"
Output: true
Example 2:

Input: A = "ab", B = "ab"
Output: false
Example 3:

Input: A = "aa", B = "aa"
Output: true
Example 4:

Input: A = "aaaaaaabc", B = "aaaaaaacb"
Output: true
Example 5:

Input: A = "", B = "aa"
Output: false


Note:

0 <= A.length <= 20000
0 <= B.length <= 20000
A and B consist only of lowercase letters.
 *         
 *
 *         题目含义：
 *=
 *
 *         思路：
 *https://leetcode-cn.com/problems/buddy-strings/solution/geng-xin-yi-ban-zhe-ban-su-du-huan-bu-cuo-ge-wei-k/
 *
 *
 */
public class Solution {

    public boolean buddyStrings(String a, String b) {
        // i 位置和哪个位置相同
        int[] diff = new int[a.length()];
        // 不同的数量
        int diffCount = 0;
        int[] count = new int[26];
        // 如果ab 相同 看看 a内部能不能构成交换
        if (a.equals(b)) {
            // 相同情况 （只能交换相同的字母）
            for (int i = 0; i < a.length(); ++i){
                count[a.charAt(i) - 'a']++;
                if(count[a.charAt(i) - 'a' ] > 1) {
                    return true;
                }
            }
            return false;
        } else if (a.length() != b.length()){
            return false;
        } else {
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    diff[diffCount] = i;
                    diffCount++;
                }
                if (diffCount > 2) {
                    return false;
                }
            }

            // 只有2个不同的且可以互换
            if (a.charAt(diff[0]) == b.charAt(diff[1])
                    && a.charAt(diff[1]) == b.charAt(diff[0])) {
                return true;
            } else {
                return false;
            }
        }
    }


	public static void main(String[] args) {
		Solution solution = new Solution();

        String a = "ab";
        String b = "ba";
        boolean result = solution.buddyStrings(a, b);
        System.out.println(result);
        Assert.assertEquals(true, result);
    }
}
