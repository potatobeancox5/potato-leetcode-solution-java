package com.potato.study.leetcodecn.p01869.t001;

import org.junit.Assert;

/**
 * 1869. 哪种连续子字符串更长
 *
 * 给你一个二进制字符串 s 。如果字符串中由 1 组成的 最长 连续子字符串 严格长于 由 0 组成的 最长 连续子字符串，返回 true ；否则，返回 false 。
 *
 * 例如，s = "110100010" 中，由 1 组成的最长连续子字符串的长度是 2 ，由 0 组成的最长连续子字符串的长度是 3 。
 * 注意，如果字符串中不存在 0 ，此时认为由 0 组成的最长连续子字符串的长度是 0 。字符串中不存在 1 的情况也适用此规则。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "1101"
 * 输出：true
 * 解释：
 * 由 1 组成的最长连续子字符串的长度是 2："1101"
 * 由 0 组成的最长连续子字符串的长度是 1："1101"
 * 由 1 组成的子字符串更长，故返回 true 。
 * 示例 2：
 *
 * 输入：s = "111000"
 * 输出：false
 * 解释：
 * 由 1 组成的最长连续子字符串的长度是 3："111000"
 * 由 0 组成的最长连续子字符串的长度是 3："111000"
 * 由 1 组成的子字符串不比由 0 组成的子字符串长，故返回 false 。
 * 示例 3：
 *
 * 输入：s = "110100010"
 * 输出：false
 * 解释：
 * 由 1 组成的最长连续子字符串的长度是 2："110100010"
 * 由 0 组成的最长连续子字符串的长度是 3："110100010"
 * 由 1 组成的子字符串不比由 0 组成的子字符串长，故返回 false 。
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 100
 * s[i] 不是 '0' 就是 '1'
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longer-contiguous-segments-of-ones-than-zeros
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {










    /**
     * 遍历 s 过程中记录 连续字符串的长度
     * @param s
     * @return
     */
    public boolean checkZeroOnes(String s) {
        if (s == null || s.length() == 0) {
            throw new RuntimeException("入参长度有误");
        }
        int zeroMax = 0;
        int oneMax = 0;
        int tmp = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                tmp++;
                continue;
            }
            if (s.charAt(i) == s.charAt(i-1)) {
                tmp++;
            } else {
                // 计数
                if (s.charAt(i-1) == '0') {
                    zeroMax = Math.max(zeroMax, tmp);
                } else {
                    oneMax = Math.max(oneMax, tmp);
                }
                // 切换
                tmp = 1;
            }
        }
        // 处理最后一个结果
        if (tmp > 0) {
            if (s.charAt(s.length() - 1) == '0') {
                zeroMax = Math.max(zeroMax, tmp);
            } else {
                oneMax = Math.max(oneMax, tmp);
            }
        }
        return oneMax > zeroMax;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "1101";
        boolean b = solution.checkZeroOnes(str);
        System.out.println(b);
        Assert.assertEquals(true, b);

        str = "111000";
        b = solution.checkZeroOnes(str);
        System.out.println(b);
        Assert.assertEquals(false, b);
    }
}
