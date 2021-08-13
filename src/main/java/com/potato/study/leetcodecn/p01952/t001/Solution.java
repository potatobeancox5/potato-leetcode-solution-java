package com.potato.study.leetcodecn.p01952.t001;

import org.junit.Assert;

/**
 * 1952. 三除数
 *
 * 给你一个整数 n 。如果 n 恰好有三个正除数 ，返回 true ；否则，返回 false 。

 如果存在整数 k ，满足 n = k * m ，那么整数 m 就是 n 的一个 除数 。

  

 示例 1：

 输入：n = 2
 输出：false
 解释：2 只有两个除数：1 和 2 。
 示例 2：

 输入：n = 4
 输出：true
 解释：4 有三个除数：1、2 和 4 。
  

 提示：

 1 <= n <= 104

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/three-divisors
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 从 2 - n-1 判断个数 大于1 直接返回false
     * @param n
     * @return
     */
    public boolean isThree(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return count == 1;
    }

}
