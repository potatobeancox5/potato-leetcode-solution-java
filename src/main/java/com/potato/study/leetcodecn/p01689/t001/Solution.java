package com.potato.study.leetcodecn.p01689.t001;

/**
 * 1689. 十-二进制数的最少数目
 *
 * 如果一个十进制数字不含任何前导零，且每一位上的数字不是 0 就是 1 ，那么该数字就是一个 十-二进制数 。例如，101 和 1100 都是 十-二进制数，而 112 和 3001 不是。

 给你一个表示十进制整数的字符串 n ，返回和为 n 的 十-二进制数 的最少数目。

  

 示例 1：

 输入：n = "32"
 输出：3
 解释：10 + 11 + 11 = 32
 示例 2：

 输入：n = "82734"
 输出：8
 示例 3：

 输入：n = "27346209830709182346"
 输出：9
  

 提示：

 1 <= n.length <= 105
 n 仅由数字组成
 n 不含任何前导零并总是表示正整数

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 直接 找 n 中 最大的位置 的数字
     * @param n
     * @return
     */
    public int minPartitions(String n) {
        if (null == n || n.length() == 0) {
            return 0;
        }
        int max = 0;
        for (char ch : n.toCharArray()) {
            max = Math.max(ch - '0', max);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String n = "32";
        int i = solution.minPartitions(n);
        System.out.println(i);
    }


}
