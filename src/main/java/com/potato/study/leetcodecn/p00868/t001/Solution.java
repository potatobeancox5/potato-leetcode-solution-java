package com.potato.study.leetcodecn.p00868.t001;

import org.junit.Assert;

/**
 * 868. 二进制间距
 *
 * 给定一个正整数 n，找到并返回 n 的二进制表示中两个 相邻 1 之间的 最长距离 。如果不存在两个相邻的 1，返回 0 。

 如果只有 0 将两个 1 分隔开（可能不存在 0 ），则认为这两个 1 彼此 相邻 。两个 1 之间的距离是它们的二进制表示中位置的绝对差。例如，"1001" 中的两个 1 的距离为 3 。

  

 示例 1：

 输入：n = 22
 输出：2
 解释：
 22 的二进制是 "10110" 。
 在 22 的二进制表示中，有三个 1，组成两对相邻的 1 。
 第一对相邻的 1 中，两个 1 之间的距离为 2 。
 第二对相邻的 1 中，两个 1 之间的距离为 1 。
 答案取两个距离之中最大的，也就是 2 。
 示例 2：

 输入：n = 5
 输出：2
 解释：
 5 的二进制是 "101" 。
 示例 3：

 输入：n = 6
 输出：1
 解释：
 6 的二进制是 "110" 。
 示例 4：

 输入：n = 8
 输出：0
 解释：
 8 的二进制是 "1000" 。
 在 8 的二进制表示中没有相邻的两个 1，所以返回 0 。
 示例 5：

 输入：n = 1
 输出：0
  

 提示：

 1 <= N <= 10^9

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/binary-gap
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     *
     * @param n
     * @return
     */
    public int binaryGap(int n) {
        // 编程2进制串 遍历 串 记录上一次出现1的位置
        int[] bitMap = new int[32];
        for (int i = 31; i >= 0; i--) {
            // int 就32 位还想让我咋的
            int bit = (n & 1);
            n >>>= 1;
            bitMap[i] = bit;
        }
        // bitMap 遍历 记录上一次出现1的index
        int lastIndex = -1;
        int maxLen = 0;
        for (int i = 0; i < 32; i++) {
            if (bitMap[i] == 0) {
                continue;
            }
            // 出现1 是否第一次出现
            if (lastIndex == -1) {
                lastIndex = i;
                continue;
            }
            // 不是第一次出现
            maxLen = Math.max(maxLen, i - lastIndex);
            lastIndex = i;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 5;
        int i = solution.binaryGap(n);
        System.out.println(i);
        Assert.assertEquals(2, i);


        n = 22;
        i = solution.binaryGap(n);
        System.out.println(i);
        Assert.assertEquals(2, i);
    }
}
