package com.potato.study.leetcodecn.p00125.t001;

import org.junit.Assert;

/**
 * 125. 验证回文串
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

 说明：本题中，我们将空字符串定义为有效的回文串。

 示例 1:

 输入: "A man, a plan, a canal: Panama"
 输出: true
 示例 2:

 输入: "race a car"
 输出: false

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/valid-palindrome
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 验证字符串是不是回文串
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        if (null == s || "".equals(s)) {
            return true;
        }
        s = s.toLowerCase();
        int left = getNextLeftIndex(s, 0);
        int right = getNextRightIndex(s, s.length() -1);
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left = getNextLeftIndex(s, left+1);
            right = getNextRightIndex(s, right-1);
        }

        return true;
    }

    /**
     * 找到第一个字母的 left
     * @param s
     * @param index
     * @return
     */
    private int getNextLeftIndex(String s, int index) {
        while (index < s.length()
                && !Character.isAlphabetic(s.charAt(index))
                && !Character.isDigit(s.charAt(index))) {
            index++;
        }
        return index;
    }

    /**
     * 找到第一个字母的 left
     * @param s
     * @param index
     * @return
     */
    private int getNextRightIndex(String s, int index) {
        while (index >= 0
                && !Character.isAlphabetic(s.charAt(index))
                && !Character.isDigit(s.charAt(index))) {
            index--;
        }
        return index;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "A man, a plan, a canal: Panama";
        boolean palindrome = solution.isPalindrome(s);
        System.out.println(palindrome);
        Assert.assertEquals(true, palindrome);
    }
}
