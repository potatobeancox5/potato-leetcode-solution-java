package com.potato.study.leetcodecn.p01837.t001;

import java.util.Arrays;

/**
 * 1837. K 进制表示下的各位数字总和
 *
 * 给你一个整数 n（10 进制）和一个基数 k ，请你将 n 从 10 进制表示转换为 k 进制表示，计算并返回转换后各位数字的 总和 。

 转换后，各位数字应当视作是 10 进制数字，且它们的总和也应当按 10 进制表示返回。

  

 示例 1：

 输入：n = 34, k = 6
 输出：9
 解释：34 (10 进制) 在 6 进制下表示为 54 。5 + 4 = 9 。
 示例 2：

 输入：n = 10, k = 10
 输出：1
 解释：n 本身就是 10 进制。 1 + 0 = 1 。
  

 提示：

 1 <= n <= 100
 2 <= k <= 10

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/sum-of-digits-in-base-k
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * n 对于 k 取余数和商， 余数为低位，商为接下来继续计算使用的数字
     * @param n
     * @param k
     * @return
     */
    public int sumBase(int n, int k) {
        int bitSum = 0;
        while (n > 0) {
            int tmp = n % k;
            n = n / k;
            bitSum += tmp;
        }
        return bitSum;
    }
}
