package com.potato.study.leetcodecn.p00738.t001;

import java.util.Arrays;
import java.util.Stack;

/**
 * 738. 单调递增的数字
 *
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 *
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 *
 * 示例 1:
 *
 * 输入: N = 10
 * 输出: 9
 * 示例 2:
 *
 * 输入: N = 1234
 * 输出: 1234
 * 示例 3:
 *
 * 输入: N = 332
 * 输出: 299
 * 说明: N 是在 [0, 10^9] 范围内的一个整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/monotone-increasing-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 如果这个数字本身就是单调递增的 直接返回
     * 否则找到第一个 递减的点 i  ， i变成 9 i之前的点 -- ，如果影响了 之前的点，那么这个点也变成9了 再往前搞
     * @param n
     * @return
     */
    public int monotoneIncreasingDigits(int n) {
        // 将 n 转换数字 string 数组
        String s = String.valueOf(n);
        if (s.length() == 1) {
            return n;
        }
        // 找到找到第一个 递减的位置 i
        char[] numChar = s.toCharArray();

//        for (int i = 1; i < numChar.length; i++) {
//            if (numChar[i]) {
//
//            }
//        }

        // i位置之后 都是 9（包括i位置）

        // i位置之前 找到 与i位置相等的位置

        return -1;
    }

//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int[] temp = new int[] {73, 74, 75, 71, 69, 72, 76, 73};
//        // [1, 1, 4, 2, 1, 1, 0, 0]
//        int[] res = solution.dailyTemperatures(temp);
//        System.out.println(Arrays.toString(res));
//    }
}
