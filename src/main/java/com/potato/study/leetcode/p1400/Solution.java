package com.potato.study.leetcode.p1400;


import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	1400. Construct K Palindrome Strings
 *  
 *
Given a string s and an integer k. You should construct k non-empty palindrome strings using all the characters in s.

Return True if you can use all the characters in s to construct k palindrome strings or False otherwise.



Example 1:

Input: s = "annabelle", k = 2
Output: true
Explanation: You can construct two palindromes using all characters in s.
Some possible constructions "anna" + "elble", "anbna" + "elle", "anellena" + "b"
Example 2:

Input: s = "leetcode", k = 3
Output: false
Explanation: It is impossible to construct 3 palindromes using all the characters of s.
Example 3:

Input: s = "true", k = 4
Output: true
Explanation: The only possible solution is to put each character in a separate string.
Example 4:

Input: s = "yzyzyzyzyzyzyzy", k = 2
Output: true
Explanation: Simply you can put all z's in one string and all y's in the other string. Both strings will be palindrome.
Example 5:

Input: s = "cr", k = 7
Output: false
Explanation: We don't have enough characters in s to construct 7 palindromes.


Constraints:

1 <= s.length <= 10^5
All characters in s are lower-case English letters.
1 <= k <= 10^5
 *         
 *         思路：
 *         https://leetcode-cn.com/problems/construct-k-palindrome-strings/solution/java-shuang-100-by-millby/
 *
 *         记录多少个 奇数个数字符，总数 <= k则必然成立
 *
 *
 *
 *
 */
public class Solution {

    public boolean canConstruct(String s, int k) {
        if (s.length() < k) {
            return false;
        }

        int[] count = new int[26];
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }
        int oddCount = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 == 1) {
                oddCount++;
            }
        }
        return oddCount <= k;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String s = "annabelle";
        int k = 2;
        boolean res = solution.canConstruct(s, k);
        System.out.println(res);
        Assert.assertEquals(true, res);


        s = "leetcode";
        k = 3;
        res = solution.canConstruct(s, k);
        System.out.println(res);
        Assert.assertEquals(false, res);


        s = "true";
        k = 4;
        res = solution.canConstruct(s, k);
        System.out.println(res);
        Assert.assertEquals(true, res);

        s = "yzyzyzyzyzyzyzy";
        k = 2;
        res = solution.canConstruct(s, k);
        System.out.println(res);
        Assert.assertEquals(true, res);
    }
}
