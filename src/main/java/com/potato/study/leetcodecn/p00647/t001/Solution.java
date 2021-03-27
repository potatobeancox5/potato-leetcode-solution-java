package com.potato.study.leetcodecn.p00647.t001;

import org.junit.Assert;

/**
 * 647. 回文子串
 *
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。

 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。

  

 示例 1：

 输入："abc"
 输出：3
 解释：三个回文子串: "a", "b", "c"
 示例 2：

 输入："aaa"
 输出：6
 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
  

 提示：

 输入的字符串长度不会超过 1000 。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/palindromic-substrings
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 每个位置作为起点 往外扩展
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            // single
            count++;
            for (int j = 1; j < s.length(); j++) {
                if (i - j < 0 || i + j >= s.length()) {
                    break;
                }
                if (s.charAt(i-j) == s.charAt(i+j)) {
                    count++;
                } else {
                    break;
                }
            }
            // doubel
            if (i+1 >= s.length()) {
                continue;
            }
            if (s.charAt(i+1) != s.charAt(i)) {
                continue;
            }
            count++;
            for (int j = 1; j < s.length(); j++) {
                if (i - j < 0 || i + j + 1 >= s.length()) {
                    break;
                }
                if (s.charAt(i-j) == s.charAt(i+j + 1)) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abc";
        int count = solution.countSubstrings(s);
        System.out.println(count);
        Assert.assertEquals(3, count);


        s = "aaa";
        count = solution.countSubstrings(s);
        System.out.println(count);
        Assert.assertEquals(6, count);
    }
}
