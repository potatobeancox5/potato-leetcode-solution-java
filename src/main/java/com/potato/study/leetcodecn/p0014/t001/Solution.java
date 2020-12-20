package com.potato.study.leetcodecn.p0014.t001;

import org.junit.Assert;

/**
 * 14. 最长公共前缀
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。

 如果不存在公共前缀，返回空字符串 ""。

 示例 1:

 输入: ["flower","flow","flight"]
 输出: "fl"
 示例 2:

 输入: ["dog","racecar","car"]
 输出: ""
 解释: 输入不存在公共前缀。
 说明:

 所有输入只包含小写字母 a-z 。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/longest-common-prefix
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {


    /**
     * 最长公共前缀
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (null == strs || strs.length == 0) {
            return "";
        }
        StringBuilder lcp = new StringBuilder();
        // 找到最短的字符串长度
        int shortestLength = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            shortestLength = Math.min(shortestLength, strs[i].length());
        }

        // 遍历 每个字符串的每个字母，知道任意一个不匹配
        for (int i = 0; i < shortestLength; i++) {
            char baseChar = strs[0].charAt(i);
            boolean isSame = true;
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) == baseChar) {
                    isSame = true;
                } else {
                    isSame = false;
                    break;
                }
            }
            if (!isSame) {
                break;
            } else {
                lcp.append(baseChar);
            }
        }
        return lcp.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] strs = new String[]{
                "flower","flow","flight"
        };
        String match = solution.longestCommonPrefix(strs);
        System.out.println(match);
        Assert.assertEquals("fl", match);

        strs = new String[]{
                "dog","racecar","car"
        };
        match = solution.longestCommonPrefix(strs);
        System.out.println(match);
        Assert.assertEquals("", match);

        strs = new String[]{
                "aaaa"
        };
        match = solution.longestCommonPrefix(strs);
        System.out.println(match);
        Assert.assertEquals("aaaa", match);


        strs = new String[]{
                "ab", "a"
        };
        match = solution.longestCommonPrefix(strs);
        System.out.println(match);
        Assert.assertEquals("a", match);
    }


}
