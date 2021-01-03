package com.potato.study.leetcodecn.p00072.t001;


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


        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

//        int n = 2;
//        int species = solution.climbStairs(n);
//        System.out.println(species);
//        Assert.assertEquals(2, species);
//
//        n = 3;
//        species = solution.climbStairs(n);
//        System.out.println(species);
//        Assert.assertEquals(3, species);
//
//        n = 4;
//        species = solution.climbStairs(n);
//        System.out.println(species);
//        Assert.assertEquals(5, species);
    }
}
