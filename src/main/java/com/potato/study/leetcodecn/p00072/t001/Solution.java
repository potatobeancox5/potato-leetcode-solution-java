package com.potato.study.leetcodecn.p00072.t001;


import org.junit.Assert;

import java.util.Arrays;

/**
 * 72. 编辑距离
 *
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。

 你可以对一个单词进行如下三种操作：

 插入一个字符
 删除一个字符
 替换一个字符
  

 示例 1：

 输入：word1 = "horse", word2 = "ros"
 输出：3
 解释：
 horse -> rorse (将 'h' 替换为 'r')
 rorse -> rose (删除 'r')
 rose -> ros (删除 'e')
 示例 2：

 输入：word1 = "intention", word2 = "execution"
 输出：5
 解释：
 intention -> inention (删除 't')
 inention -> enention (将 'i' 替换为 'e')
 enention -> exention (将 'n' 替换为 'x')
 exention -> exection (将 'n' 替换为 'c')
 exection -> execution (插入 'u')

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/edit-distance
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * step 数组 step ij 为 当前 前ij 之前位置匹配 需要执行的最少操作
     * step ij = min {
     *     if ij 位置相等 step i-1 j-1
     *     else ij 位置不相等
     *          替换操作 step i-1 j-1 + 1
     *          插入操作 step i-1 j + 1   step i j-1 + 1
     *          删除操作 step i+1 j + 1   step i j+1 + 1
     *
     *
     * }
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] step = new int[m+1][n+1];
        // 初始化 为 int 最大值
        for (int i = 0; i <= m; i++) {
            Arrays.fill(step[i], Integer.MAX_VALUE);
        }
        // 都没有需要匹配的 自然为0
        step[0][0] = 0;
        // 行为 0 列为0
        for (int i = 1; i <= m; i++) {
            step[i][0] = i;
        }
        for (int i = 1; i <= n; i++) {
            step[0][i] = i;
        }
        // 生成 step
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 字符相同 就不用增加了
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    step[i][j] = step[i-1][j-1];
                    continue;
                }
                // 直接变换就是 step[i-1][j-1] ， 删除i Math.min(step[i-1][j]，新增与j相同的 step[i][j-1]
                step[i][j] = Math.min(step[i-1][j-1], Math.min(step[i-1][j], step[i][j-1]));
                if (step[i][j] != Integer.MAX_VALUE) {
                    step[i][j] += 1;
                }
            }
        }
        return step[m][n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String word1 = "horse";
        String word2 = "ros";
        int distance = solution.minDistance(word1, word2);
        System.out.println(distance);
//        Assert.assertSame(3, distance);


        word1 = "intention";
        word2 = "execution";
        distance = solution.minDistance(word1, word2);
        System.out.println(distance);
        Assert.assertSame(5, distance);


    }
}
