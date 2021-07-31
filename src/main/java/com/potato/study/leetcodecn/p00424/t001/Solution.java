package com.potato.study.leetcodecn.p00424.t001;

import org.junit.Assert;

/**
 * 424. 替换后的最长重复字符
 *
 *
 * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
 *
 * 注意：字符串长度 和 k 不会超过 104。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "ABAB", k = 2
 * 输出：4
 * 解释：用两个'A'替换为两个'B',反之亦然。
 * 示例 2：
 *
 * 输入：s = "AABABBA", k = 1
 * 输出：4
 * 解释：
 * 将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
 * 子串 "BBBB" 有最长重复字母, 答案为 4。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-repeating-character-replacement
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    // 424 使用 窗口记录 历史最大的
    public int characterReplacement(String s, int k) {
        // 枚举right 如果当前 对于每个right 计数++
        int[] count = new int[26];
        // 窗口的左右边缘 include
        int left = 0;
        int right = 0;
        int maxCharAppear = 0;
        while (right < s.length()) {
            int index = s.charAt(right) - 'A';
            count[index]++;
            // 更新当前最大 窗口中历史最大 出现次数 or 当前字母个数
            maxCharAppear = Math.max(maxCharAppear, count[index]);
            // 如果当前窗口大小 - 历史最多次数 都比k 大，说明 窗口大了 左边需要缩小
            if (right - left + 1 - maxCharAppear > k) {
                int indexDel = s.charAt(left) - 'A';
                count[indexDel]--;
                left++;
            }
            // 否则就应该是窗口 增大， 过程中保持窗口值 并且窗口大小就是最终返回大小
            right++;
        }
        return right - left;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "ABAB";
        int k = 2;
        int i = solution.characterReplacement(s, k);
        System.out.println(i);
        Assert.assertEquals(4, i);


        s = "AABABBA";
        k = 1;
        i = solution.characterReplacement(s, k);
        System.out.println(i);
        Assert.assertEquals(4, i);
    }
}
