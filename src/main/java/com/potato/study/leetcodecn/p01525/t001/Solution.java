package com.potato.study.leetcodecn.p01525.t001;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;

/**
 * 1525. 字符串的好分割数目
 *
 * 给你一个字符串 s ，一个分割被称为 「好分割」 当它满足：将 s 分割成 2 个字符串 p 和 q ，它们连接起来等于 s 且 p 和 q 中不同字符的数目相同。
 *
 * 请你返回 s 中好分割的数目。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "aacaba"
 * 输出：2
 * 解释：总共有 5 种分割字符串 "aacaba" 的方法，其中 2 种是好分割。
 * ("a", "acaba") 左边字符串和右边字符串分别包含 1 个和 3 个不同的字符。
 * ("aa", "caba") 左边字符串和右边字符串分别包含 1 个和 3 个不同的字符。
 * ("aac", "aba") 左边字符串和右边字符串分别包含 2 个和 2 个不同的字符。这是一个好分割。
 * ("aaca", "ba") 左边字符串和右边字符串分别包含 2 个和 2 个不同的字符。这是一个好分割。
 * ("aacab", "a") 左边字符串和右边字符串分别包含 3 个和 1 个不同的字符。
 * 示例 2：
 *
 * 输入：s = "abcd"
 * 输出：1
 * 解释：好分割为将字符串分割成 ("ab", "cd") 。
 * 示例 3：
 *
 * 输入：s = "aaaaa"
 * 输出：4
 * 解释：所有分割都是好分割。
 * 示例 4：
 *
 * 输入：s = "acbadbaada"
 * 输出：2
 *  
 *
 * 提示：
 *
 * s 只包含小写英文字母。
 * 1 <= s.length <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-good-ways-to-split-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 分别计数
     * @param s
     * @return
     */
    public int numSplits(String s) {
        // 全局计数
        int[] end = new int[26];
        for (int i = 0; i < s.length(); i++) {
            end[s.charAt(i) - 'a']++;
        }
        int[] start = new int[26];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int charIndex = s.charAt(i) - 'a';
            end[charIndex]--;
            start[charIndex]++;
            if (hasSameKindChar(end, start)) {
                count++;
            }
        }
        return count;
    }

    /**
     *
     * @param num1
     * @param num2
     * @return
     */
    private boolean hasSameKindChar(int[] num1, int[] num2) {
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < 26; i++) {
            if (num1[i] > 0) {
                count1++;
            }
            if (num2[i] > 0) {
                count2++;
            }
        }
        return count1 == count2;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "aacaba";
        int i = solution.numSplits(s);
        System.out.println(i);
        Assert.assertEquals(i, 2);


        s = "aaaaa";
        i = solution.numSplits(s);
        System.out.println(i);
        Assert.assertEquals(i, 4);
    }
}
