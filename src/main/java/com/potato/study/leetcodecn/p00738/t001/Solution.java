package com.potato.study.leetcodecn.p00738.t001;

import java.util.Arrays;
import java.util.Stack;

import org.junit.Assert;

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
        boolean isUp = true;
        int targetIndex = -1;
        for (int i = 0; i < numChar.length; i++) {
            if (i == 0) {
                continue;
            }
            if (numChar[i] >= numChar[i-1]) {
                continue;
            }
            // 找到第一个 1221 中 最后一个1的位置
            isUp = false;
            targetIndex = i;
            break;
        }
        if (isUp) {
            return n;
        }

        // i位置之后 都是 9（包括i位置）
        char[] targetNumChar = numChar.clone();
        for (int i = targetIndex; i < numChar.length; i++) {
            targetNumChar[i] = '9';
        }
        // i位置之前 找到 第一个 比i 小的位置 的位置 如果这个位置 -- 其他的位置 如果有的话 直接 9了
        int lastMinIndex = -1;
        for (int i = targetIndex - 1; i > 0; i--) {
            if (numChar[i] > numChar[i+1]) {
                lastMinIndex = i;
                break;
            }
        }
        if (lastMinIndex != -1) {
            // lastMinIndex -- ，
            targetNumChar[lastMinIndex] = (char) (targetNumChar[lastMinIndex] - 1);
            for (int i = lastMinIndex+1; i < targetIndex; i++) {
                targetNumChar[i] = '9';
            }
        } else {
            // 前边全一样 第一个位置 -- 其他全是9
            targetNumChar[0] = (char) (targetNumChar[0] - 1);
            for (int i = 1; i < targetIndex; i++) {
                targetNumChar[i] = '9';
            }
        }

        // 计算返回结果
        int num = 0;
        for (char ch : targetNumChar) {
            num *= 10;
            num += (ch - '0');
        }
        return num;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 10;
        int res = solution.monotoneIncreasingDigits(n);
        System.out.println(res);
        Assert.assertEquals(9, res);
        // 1234
        n = 1234;
        res = solution.monotoneIncreasingDigits(n);
        System.out.println(res);
        Assert.assertEquals(1234, res);

        n = 332;
        res = solution.monotoneIncreasingDigits(n);
        System.out.println(res);
        Assert.assertEquals(299, res);

        n = 120;
        res = solution.monotoneIncreasingDigits(n);
        System.out.println(res);
        Assert.assertEquals(119, res);
    }
}
