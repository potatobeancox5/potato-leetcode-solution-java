package com.potato.study.leetcodecn.p00680.t001;

import java.util.Stack;

import org.junit.Assert;

/**
 * 680. 验证回文字符串 Ⅱ
 *
 * 定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 *
 * 示例 1:
 *
 * 输入: "aba"
 * 输出: True
 * 示例 2:
 *
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 * 注意:
 *
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 判断s 中删除一个字符串 是否可以作为会问字符串
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        return isvValidPalindromeDeleteAtmostOnce(s, start, end, false);
    }

    /**
     * 删除
     * @param s
     * @param start
     * @param end
     * @return
     */
    private boolean isvValidPalindromeDeleteAtmostOnce(String s, int start, int end,
            boolean hasEverDelete) {
        if (start == end) {
            return true;
        }
        if (start > end) {
            return true;
        }
        while (start < end
                && s.charAt(start) == s.charAt(end)) {
            start++;
            end--;
        }
        // 找到了不一致停止了
        if (s.charAt(start) != s.charAt(end)) {
            if (hasEverDelete) {
                return false;
            }
            return isvValidPalindromeDeleteAtmostOnce(s, start + 1, end, true)
                    || isvValidPalindromeDeleteAtmostOnce(s, start, end-1, true);
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "aba";
        boolean b = solution.validPalindrome(s);
        System.out.println(b);
        Assert.assertEquals(true, b);

        s = "abca";
        b = solution.validPalindrome(s);
        System.out.println(b);
        Assert.assertEquals(true, b);
    }
}
