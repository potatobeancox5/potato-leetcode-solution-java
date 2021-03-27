package com.potato.study.leetcodecn.p00567.t001;


import org.junit.Assert;

/**
 * 567. 字符串的排列
 *
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。

 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。

  

 示例 1：

 输入: s1 = "ab" s2 = "eidbaooo"
 输出: True
 解释: s2 包含 s1 的排列之一 ("ba").
 示例 2：

 输入: s1= "ab" s2 = "eidboaoo"
 输出: False
  

 提示：

 输入的字符串只包含小写字母
 两个字符串的长度都在 [1, 10,000] 之间

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/permutation-in-string
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 滑动窗口
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        int[] time = getAppearanceTimes(s1);
        for (int i = 0; i < s2.length(); i++) {
            if (i + s1.length() > s2.length()) {
                break;
            }
            String substring = s2.substring(i, i + s1.length());
            int[] base = getAppearanceTimes(substring);
            if (isSame(base, time)) {
                return true;
            }
        }
        return false;
    }


    /**
     *
     * @param word  判断出现次数
     * @return
     */
    private int[] getAppearanceTimes(String word) {
        int[] times = new int[26];
        for (char ch : word.toCharArray()) {
            times[ch - 'a']++;
        }
        return times;
    }

    /**
     * 两个 数组 是否相等
     * @param times1
     * @param times2
     * @return
     */
    private boolean isSame(int[] times1, int[] times2) {
        for (int i = 0; i < 26; i++) {
            if (times1[i] != times2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "ab";
        String s2 = "eidbaooo";
        boolean b = solution.checkInclusion(s1, s2);
        System.out.println(b);
        Assert.assertEquals(true, b);


        s1 = "ab";
        s2 = "eidboaoo";
        b = solution.checkInclusion(s1, s2);
        System.out.println(b);
        Assert.assertEquals(false, b);
    }

}
