package com.potato.study.leetcodecn.p01227.t001;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1227. 飞机座位分配概率
 *
 * 有 n 位乘客即将登机，飞机正好有 n 个座位。第一位乘客的票丢了，他随便选了一个座位坐下。
 *
 * 剩下的乘客将会：
 *
 * 如果他们自己的座位还空着，就坐到自己的座位上，
 *
 * 当他们自己的座位被占用时，随机选择其他座位
 * 第 n 位乘客坐在自己的座位上的概率是多少？
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 1
 * 输出：1.00000
 * 解释：第一个人只会坐在自己的位置上。
 * 示例 2：
 *
 * 输入: n = 2
 * 输出: 0.50000
 * 解释：在第一个人选好座位坐下后，第二个人坐在自己的座位上的概率是 0.5。
 *  
 *
 * 提示：
 *
 * 1 <= n <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/airplane-seat-assignment-probability
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     *  F1 = 1
     *  F 其他 = 0.5
     * @param n
     * @return
     */
    public double nthPersonGetsNthSeat(int n) {
        // 一定的
        if (n == 1) {
            return 1;
        }
        return 0.5;
    }
}