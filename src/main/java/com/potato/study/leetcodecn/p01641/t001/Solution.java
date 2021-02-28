package com.potato.study.leetcodecn.p01641.t001;

import org.junit.Assert;

/**
 * 1641. 统计字典序元音字符串的数目
 *
 * 给你一个整数 n，请返回长度为 n 、仅由元音 (a, e, i, o, u) 组成且按 字典序排列 的字符串数量。

 字符串 s 按 字典序排列 需要满足：对于所有有效的 i，s[i] 在字母表中的位置总是与 s[i+1] 相同或在 s[i+1] 之前。

  

 示例 1：

 输入：n = 1
 输出：5
 解释：仅由元音组成的 5 个字典序字符串为 ["a","e","i","o","u"]
 示例 2：

 输入：n = 2
 输出：15
 解释：仅由元音组成的 15 个字典序字符串为
 ["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"]
 注意，"ea" 不是符合题意的字符串，因为 'e' 在字母表中的位置比 'a' 靠后
 示例 3：

 输入：n = 33
 输出：66045
  

 提示：

 1 <= n <= 50 

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/count-sorted-vowel-strings
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * dp i j说明 达到 i个数字 最后位置选择 j号位置 有多少中组合
     * dp 0 0 - 4 每个都是 1
     * dp 1
     * dp ij = dp i-1 （小于等于 j的） 和
     *
     * 可以进行状态压缩
     * @param n
     * @return
     */
    public int countVowelStrings(int n) {
        // i 代表包括 位置 index = i的字符 ，j 表示最终的串是哪个
        int[][] dp = new int[n][5];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                if (j == 0 && i == 0) {
                    dp[i][j] = 1;
                } else if (j == 0) {
                    // 只有 以a 结尾 只有一种可能
                    dp[i][j] = dp[i - 1][j];
                } else if (i == 0) {
                    dp[i][j] = 1;
                } else {
                    for (int k = 0; k <= j; k++) {
                        dp[i][j] += dp[i-1][k];
                    }
                }
            }
        }
        // 求和
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += dp[n-1][i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 1;
        int i = solution.countVowelStrings(n);
        System.out.println(i);
        Assert.assertSame(5, i);
//        int[][] points = new int[][] {
//                {8,7},{9,9},{7,4},{9,7}
//        };
//        int max = solution.maxWidthOfVerticalArea(points);
//        System.out.println(max);
//        Assert.assertEquals(1, max);
//
//
//        points = new int[][] {
//                {3,1},{9,0},{1,0},{1,4},{5,3},{8,8}
//        };
//        max = solution.maxWidthOfVerticalArea(points);
//        System.out.println(max);
//        Assert.assertEquals(3, max);
    }
}
