package com.potato.study.leetcodecn.p01523.t001;

/**
 * 1523. 在区间范围内统计奇数数目
 *
 * 给你两个非负整数 low 和 high 。请你返回 low 和 high 之间（包括二者）奇数的数目。

  

 示例 1：

 输入：low = 3, high = 7
 输出：3
 解释：3 到 7 之间奇数数字为 [3,5,7] 。
 示例 2：

 输入：low = 8, high = 10
 输出：1
 解释：8 到 10 之间奇数数字为 [9] 。
  

 提示：

 0 <= low <= high <= 10^9

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/count-odd-numbers-in-an-interval-range
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 计算奇数数量
     * @param low
     * @param high
     * @return
     */
    public int countOdds(int low, int high) {
        int num = high - low + 1;
        if (low % 2 == 1 && high % 2 == 1) {
            // 奇数开头 奇数结尾
            return num / 2 + 1;
        } else if (low % 2 == 1 || high % 2 == 1) {
            // 开头结尾 任意一个为奇数
            return num / 2;
        } else {
            // 偶数开头 偶数结尾
            return num / 2;
        }
    }
}
