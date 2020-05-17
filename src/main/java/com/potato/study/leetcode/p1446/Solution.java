package com.potato.study.leetcode.p1446;


import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	1446. Consecutive Characters
 *  
 *
Given a string s, the power of the string is the maximum length of a non-empty substring that contains only one unique character.

Return the power of the string.



Example 1:

Input: s = "leetcode"
Output: 2
Explanation: The substring "ee" is of length 2 with the character 'e' only.
Example 2:

Input: s = "abbcccddddeeeeedcba"
Output: 5
Explanation: The substring "eeeee" is of length 5 with the character 'e' only.
Example 3:

Input: s = "triplepillooooow"
Output: 5
Example 4:

Input: s = "hooraaaaaaaaaaay"
Output: 11
Example 5:

Input: s = "tourist"
Output: 1


Constraints:

1 <= s.length <= 500
s contains only lowercase English letters.
 *         
 *
 *
 *
 *  思路：
 *
 *      https://leetcode-cn.com/problems/consecutive-characters/solution/shi-jian-onkong-jian-o1-by-qq994300880/
 *
 *
 *
 */
public class Solution {


    public int maxPower(String s) {

        // 记录 第一个单词
        char lastCH = s.charAt(0);
        int count = 1;
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == lastCH) {
                count++;
            } else {
                max = Math.max(max, count);
                lastCH = ch;
                count = 1;
            }
        }
        // 兜底 最后一次
        max = Math.max(max, count);
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String s = "leetcode";
        int res = solution.maxPower(s);
        System.out.println(res);
        Assert.assertEquals(2, res);

    }
}
