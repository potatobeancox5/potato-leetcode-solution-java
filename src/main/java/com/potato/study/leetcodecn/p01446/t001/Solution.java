package com.potato.study.leetcodecn.p01446.t001;

import org.junit.Assert;

/**
 * 1446. 连续字符
 *
 * 给你一个字符串 s ，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。

 请你返回字符串的能量。

  

 示例 1：

 输入：s = "leetcode"
 输出：2
 解释：子字符串 "ee" 长度为 2 ，只包含字符 'e' 。
 示例 2：

 输入：s = "abbcccddddeeeeedcba"
 输出：5
 解释：子字符串 "eeeee" 长度为 5 ，只包含字符 'e' 。
 示例 3：

 输入：s = "triplepillooooow"
 输出：5
 示例 4：

 输入：s = "hooraaaaaaaaaaay"
 输出：11
 示例 5：

 输入：s = "tourist"
 输出：1
  

 提示：

 1 <= s.length <= 500
 s 只包含小写英文字母。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/consecutive-characters
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 遍历 字母 找到 count 最大值
     * @param s
     * @return
     */
    public int maxPower(String s) {
        int max = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                count++;
            } else {
                if (s.charAt(i) == s.charAt(i-1)) {
                    count++;
                } else {
                    count = 1;
                }
            }
            max = Math.max(max, count);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "leetcode";
        int max = solution.maxPower(s);
        System.out.println(max);
        Assert.assertEquals(2, max);

        s = "hooraaaaaaaaaaay";
        max = solution.maxPower(s);
        System.out.println(max);
        Assert.assertEquals(11, max);
    }
}
