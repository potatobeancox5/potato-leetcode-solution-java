package com.potato.study.leetcodecn.p00132.t001;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

/**
 * 132. 分割回文串 II
 *
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
 *
 * 返回符合要求的 最少分割次数 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "aab"
 * 输出：1
 * 解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
 * 示例 2：
 *
 * 输入：s = "a"
 * 输出：0
 * 示例 3：
 *
 * 输入：s = "ab"
 * 输出：1
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 2000
 * s 仅由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {
    /**
     * isPalindrome 判断 ij 之间字符串 包括 两边 是不是回文
     * minSplitTime i 0-i 之前字符串 最少的分割次数
     * @param s
     * @return
     */
    public int minCut(String s) {
        // gij bool 判断 ij 中间 串是否回文 gij = gi+1j-1 && chi==chj
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        // 全部初始化 为 true 因为 有不一致的检测 所以无所谓
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(isPalindrome[i], true);
        }
        for (int i = s.length() - 2; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                char ch1 = s.charAt(i);
                char ch2 = s.charAt(j);
                // 不相同
                if (ch1 != ch2) {
                    isPalindrome[i][j] = false;
                    continue;
                } else {
                    // ij 位置相同
                    isPalindrome[i][j] = isPalindrome[i+1][j-1];
                }
            }
        }
        // fi 从0开始 作为 回文数组的最小分割数
        int[] minSplitTime = new int[s.length()];
        Arrays.fill(minSplitTime, Integer.MAX_VALUE);
        for (int i = 0; i < s.length(); i++) {
            // 如果 0 - i 整体 是回文直接返回 0
            if (isPalindrome[0][i]) {
                minSplitTime[i] = 0;
                continue;
            }
            // 否则 遍历 0 - i 每次分割 j - i 如果 ji 是回文 计算最小值
            for (int j = 0; j < i; j++) {
                // if j+1 到 i 是回文
                if (isPalindrome[j+1][i]) {
                    long time = minSplitTime[j] + 1L;
                    minSplitTime[i] = (int) Math.min(minSplitTime[i], time);
                }
            }
        }
        return minSplitTime[s.length() - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "aab";
        int i = solution.minCut(s);
        System.out.println(i);
        Assert.assertEquals(1, i);

        s = "ab";
        i = solution.minCut(s);
        System.out.println(i);
        Assert.assertEquals(1, i);

        s = "a";
        i = solution.minCut(s);
        System.out.println(i);
        Assert.assertEquals(0, i);

        s = "cabababcbc";
        i = solution.minCut(s);
        System.out.println(i);
        Assert.assertEquals(3, i);
    }
}
