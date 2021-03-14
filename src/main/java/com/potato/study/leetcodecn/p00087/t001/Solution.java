package com.potato.study.leetcodecn.p00087.t001;


import org.junit.Assert;

/**
 * 87. 扰乱字符串
 *
 * 给定一个字符串 s1，我们可以把它递归地分割成两个非空子字符串，从而将其表示为二叉树。

 下图是字符串 s1 = "great" 的一种可能的表示形式。

 great
 /    \
 gr    eat
 / \    /  \
 g   r  e   at
 / \
 a   t
 在扰乱这个字符串的过程中，我们可以挑选任何一个非叶节点，然后交换它的两个子节点。

 例如，如果我们挑选非叶节点 "gr" ，交换它的两个子节点，将会产生扰乱字符串 "rgeat" 。

 rgeat
 /    \
 rg    eat
 / \    /  \
 r   g  e   at
 / \
 a   t
 我们将 "rgeat” 称作 "great" 的一个扰乱字符串。

 同样地，如果我们继续交换节点 "eat" 和 "at" 的子节点，将会产生另一个新的扰乱字符串 "rgtae" 。

 rgtae
 /    \
 rg    tae
 / \    /  \
 r   g  ta  e
 / \
 t   a
 我们将 "rgtae” 称作 "great" 的一个扰乱字符串。

 给出两个长度相等的字符串 s1 和 s2，判断 s2 是否是 s1 的扰乱字符串。

 示例 1:

 输入: s1 = "great", s2 = "rgeat"
 输出: true
 示例 2:

 输入: s1 = "abcde", s2 = "caebd"
 输出: false

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/scramble-string
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * dp i j len 表示 从 s1 的i 位置 开始 的len 长度 字符串 和 从 s2 开始 的len 字符串 相同
     * @param s1
     * @param s2
     * @return
     */
    public boolean isScramble(String s1, String s2) {
        // 长度不匹配 没得比
        if (s1.length() != s2.length()) {
            return false;
        }
        int totalLength = s1.length();
        boolean[][][] dp = new boolean[s1.length()][s2.length()][totalLength + 1];
        // n * n 遍历s1 和s2 找到每个位置 的字符串 如果相等 那么 dp i j 1 = true
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j][1] = true;
                }
            }
        }
        // 控制 每次比较字符串长度 for i 2 -> len 枚举每种 环境 ll
        for (int len = 2; len <= totalLength; len++) {
            // 控制本次的分割情况
            for (int k = 1; k <= len-1; k++) {
                //    for ij 的开始位置 枚举每个开始的情况 i 0-> s1.len, j 0-> s2.len
                for (int i = 0; i < s1.length(); i++) {
                    for (int j = 0; j < s2.length(); j++) {
                        // 先行坐标正确性校验
                        if (i + len > s1.length() || j + len > s2.length()) {
                            continue;
                        }
                        //  都已经是 true了 就别凑热闹了
                        if (dp[i][j][len]) {
                            continue;
                        }
                        //   对于每个i 从 1 开始 到 i-1 长度进行分割 k  因此 变成 dp i j k && dp i+k,j+k,ll -k  or dp i j+ll-k k && dp i+k,j,ll -k (正向匹配)
                        dp[i][j][len] =
                                (dp[i][j][k] && dp[i+k][j+k][len-k]) || (dp[i][j+len-k][k] && dp[i+k][j][len-k]);
                    }
                }
            }


        }
        // dp 0 0 len 是所求
        return dp[0][0][totalLength];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "great";
        String s2 = "rgeat";
        boolean scramble = solution.isScramble(s1, s2);
        System.out.println(scramble);
        Assert.assertEquals(true, scramble);

        s1 = "abcde";
        s2 = "caebd";
        scramble = solution.isScramble(s1, s2);
        System.out.println(scramble);
        Assert.assertEquals(false, scramble);

        s1 = "abcdbdacbdac";
        s2 = "bdacabcdbdac";
        scramble = solution.isScramble(s1, s2);
        System.out.println(scramble);
        Assert.assertEquals(true, scramble);
    }

}
