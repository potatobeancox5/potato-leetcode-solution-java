package com.potato.study.leetcodecn.p00070.t001;


import org.junit.Assert;

/**
 * 70. 爬楼梯
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

 注意：给定 n 是一个正整数。

 示例 1：

 输入： 2
 输出： 2
 解释： 有两种方法可以爬到楼顶。
 1.  1 阶 + 1 阶
 2.  2 阶
 示例 2：

 输入： 3
 输出： 3
 解释： 有三种方法可以爬到楼顶。
 1.  1 阶 + 1 阶 + 1 阶
 2.  1 阶 + 2 阶
 3.  2 阶 + 1 阶

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/climbing-stairs
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     *
     * 这难道不是 菲波那切数列
     * species i 表示 爬到 i 层 现在有的尝试种类数  species 1 = 1 species 2 = 2；
     * i 从 1开始
     * 状态转移 方程
     * species i = species i- 1 + species i- 2
     * 其实从上面算式 可以发现 可以压缩状态
     * i1 == i- 1
     * i2 == i- 2
     * tmp = i1 + i2
     *
     * i2 = i1
     * i1 = tmp
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int i2 = 1;
        int i1 = 2;
        if (n <= 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        for (int i = 3; i <= n; i++) {
            int tmp = i1 + i2;
            i2 = i1;
            i1 = tmp;
        }
        return i1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n = 2;
        int species = solution.climbStairs(n);
        System.out.println(species);
        Assert.assertEquals(2, species);

        n = 3;
        species = solution.climbStairs(n);
        System.out.println(species);
        Assert.assertEquals(3, species);

        n = 4;
        species = solution.climbStairs(n);
        System.out.println(species);
        Assert.assertEquals(5, species);
    }
}
