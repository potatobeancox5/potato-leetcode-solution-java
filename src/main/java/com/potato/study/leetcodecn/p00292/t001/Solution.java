package com.potato.study.leetcodecn.p00292.t001;


import org.junit.Assert;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 292. Nim 游戏
 *
 * 你和你的朋友，两个人一起玩 Nim 游戏：

 桌子上有一堆石头。
 你们轮流进行自己的回合，你作为先手。
 每一回合，轮到的人拿掉 1 - 3 块石头。
 拿掉最后一块石头的人就是获胜者。
 假设你们每一步都是最优解。请编写一个函数，来判断你是否可以在给定石头数量为 n 的情况下赢得游戏。如果可以赢，返回 true；否则，返回 false 。

  

 示例 1：

 输入：n = 4
 输出：false
 解释：如果堆中有 4 块石头，那么你永远不会赢得比赛；
      因为无论你拿走 1 块、2 块 还是 3 块石头，最后一块石头总是会被你的朋友拿走。
 示例 2：

 输入：n = 1
 输出：true
 示例 3：

 输入：n = 2
 输出：true
  

 提示：

 1 <= n <= 231 - 1

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/nim-game
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {
    /**
     * 递归
     * 终止条件 如果当前石头 小于等于 3 那么 返回true
     * 否则
     * canWinNim (n-1) || canWinNim(n-2) || canWinNim(n-3)
     * 感觉会堆栈溢出
     *
     * fn 代表结果 true 表示 当前用户赢，false 表示对手赢球
     * 如果 fn-1 & fn-2 & fn3 为 true 那么 fn = false，否则fn = true
     * @param n
     * @return
     */
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean b = solution.canWinNim(4);
        System.out.println(b);
        Assert.assertEquals(false , b);

        b = solution.canWinNim(1);
        System.out.println(b);
        Assert.assertEquals(true , b);


        b = solution.canWinNim(2);
        System.out.println(b);
        Assert.assertEquals(true , b);

        b = solution.canWinNim(6);
        System.out.println(b);
        Assert.assertEquals(true , b);
    }
}
