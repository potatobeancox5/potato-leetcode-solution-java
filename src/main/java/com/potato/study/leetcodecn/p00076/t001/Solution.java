package com.potato.study.leetcodecn.p00076.t001;


import org.junit.Assert;

/**
 * 76. 最小覆盖子串

 *
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。

 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。

  

 示例 1：

 输入：s = "ADOBECODEBANC", t = "ABC"
 输出："BANC"
 示例 2：

 输入：s = "a", t = "a"
 输出："a"
  

 提示：

 1 <= s.length, t.length <= 105
 s 和 t 由英文字母组成
  

 进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/minimum-window-substring
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 使用 left和 right 记录窗口初始 为 00
     * 往右移动right 直到 t中的字符能被完全表示，然后记录min
     * 再往右移动left 直到无法表示全t 期间每次移动都记录一个最小的串
     * 依次执行 知道 right到了 s.len 且 无法表示全了
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        int[] tCount = countWord(t);
        int left = 0;
        int right = 0;
        int[] count = new int[100];
        String minWin = "";
        while (right < s.length()) {
            // 一直往右 知道完全包含
            while (right < s.length() && !isCovered(tCount, count)) {
                count[s.charAt(right) - 'A']++;
                right++;
            }
            // 记录最小值
            if (("".equals(minWin) || minWin.length() > right - left) && isCovered(tCount, count)) {
                minWin = s.substring(left, right);
            }
            while (left < s.length() && isCovered(tCount, count)) {
                if ("".equals(minWin) || minWin.length() > right - left) {
                    minWin = s.substring(left, right);
                }
                count[s.charAt(left) - 'A']--;
                left++;
            }
        }
        return minWin;
    }


    /**
     * target 是否可以 覆盖 origin
     * @param origin
     * @param target
     * @return
     */
    private boolean isCovered(int[] origin, int[] target) {
        for (int i = 0; i < 100; i++) {
            if (target[i] < origin[i]) {
                return false;
            }
        }
        return true;
    }


    /**
     * 对单词进行计数
     * @param word
     * @return
     */
    private int[] countWord (String word) {
        int[] count = new int[100];
        if (null == word) {
            return count;
        }
        for (char ch : word.toCharArray()) {
            count[ch - 'A']++;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String min = solution.minWindow(s, t);
        System.out.println(min);
        Assert.assertEquals("BANC", min);


        s = "a";
        t = "a";
        min = solution.minWindow(s, t);
        System.out.println(min);
        Assert.assertEquals("a", min);


        s = "a";
        t = "aa";
        min = solution.minWindow(s, t);
        System.out.println(min);
        Assert.assertEquals("", min);

        s = "a";
        t = "b";
        min = solution.minWindow(s, t);
        System.out.println(min);
        Assert.assertEquals("", min);
    }


}
