package com.potato.study.leetcodecn.p01884.t001;

import org.junit.Assert;

/**
 * 1884. 鸡蛋掉落-两枚鸡蛋
 *
 * 给你 2 枚相同 的鸡蛋，和一栋从第 1 层到第 n 层共有 n 层楼的建筑。

 已知存在楼层 f ，满足 0 <= f <= n ，任何从 高于 f 的楼层落下的鸡蛋都 会碎 ，从 f 楼层或比它低 的楼层落下的鸡蛋都 不会碎 。

 每次操作，你可以取一枚 没有碎 的鸡蛋并把它从任一楼层 x 扔下（满足 1 <= x <= n）。如果鸡蛋碎了，你就不能再次使用它。如果某枚鸡蛋扔下后没有摔碎，则可以在之后的操作中 重复使用 这枚鸡蛋。

 请你计算并返回要确定 f 确切的值 的 最小操作次数 是多少？

  

 示例 1：

 输入：n = 2
 输出：2
 解释：我们可以将第一枚鸡蛋从 1 楼扔下，然后将第二枚从 2 楼扔下。
 如果第一枚鸡蛋碎了，可知 f = 0；
 如果第二枚鸡蛋碎了，但第一枚没碎，可知 f = 1；
 否则，当两个鸡蛋都没碎时，可知 f = 2。
 示例 2：

 输入：n = 100
 输出：14
  

 提示：

 1 <= n <= 1000

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/egg-drop-with-2-eggs-and-n-floors
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * https://leetcode-cn.com/problems/egg-drop-with-2-eggs-and-n-floors/solution/dong-tai-gui-hua-shu-xue-tui-dao-by-tang-1zz1/
     dp ij  i=0只有一个鸡蛋 i=1 有2个鸡蛋
     j 层 需要最小次数

     dpij 等于 min
     k 鸡蛋在k层 抛下

     min dp 0k-1。+1
     dp i i-k

     * @param n
     * @return
     */
    public int twoEggDrop(int n) {
        // dp ij i=0 只有一个蛋 最少多少次能找到 j层答案   i=1 为两个蛋
        int[][] dp = new int[2][n+1];
        // 初始化 dp 0 k
        for (int i = 1; i < n + 1; i++) {
            dp[0][i] = i-1;
        }
        for (int i = 1; i < n + 1; i++) {
            // 选择一个位置做实验 dp 1i = 每次从j扔的结果的最小
            dp[1][i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                // 两种情况 1中 从j扔出去 鸡蛋没问题，说明 f在1-j中间， 一种是从k扔出去 鸡蛋碎了 说明
                int tryTime = Math.max(dp[1][j], dp[0][i-j]) + 1;
                dp[1][i] = Math.min(dp[1][i], tryTime);
            }
        }
        return dp[1][n];
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 2;
        int i = solution.twoEggDrop(n);
        System.out.println(i);
        Assert.assertEquals(2, i);


        n = 100;
        i = solution.twoEggDrop(n);
        System.out.println(i);
        Assert.assertEquals(14, i);
    }

//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int[] chalk = new int[]{5,1,5};
//        int k = 22;
//        int i = solution.chalkReplacer(chalk, k);
//        System.out.println(i);
//        Assert.assertEquals(0, i);
//    }


}
