package com.potato.study.leetcodecn.p00788.t001;

import org.junit.Assert;

/**
 * 788. 旋转数字
 *
 * 我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转。

 如果一个数的每位数字被旋转以后仍然还是一个数字， 则这个数是有效的。0, 1, 和 8 被旋转后仍然是它们自己；2 和 5 可以互相旋转成对方（在这种情况下，它们以不同的方向旋转，换句话说，2 和 5 互为镜像）；6 和 9 同理，除了这些以外其他的数字旋转以后都不再是有效的数字。

 现在我们有一个正整数 N, 计算从 1 到 N 中有多少个数 X 是好数？

  

 示例：

 输入: 10
 输出: 4
 解释:
 在[1, 10]中有四个好数： 2, 5, 6, 9。
 注意 1 和 10 不是好数, 因为他们在旋转之后不变。
  

 提示：

 N 的取值范围是 [1, 10000]。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/rotated-digits
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 好数字
     * 1. 首先不能有 3 4 7
     * 2. 其次 不能没有 2，5，6，9 中的任意一个
     * @param n
     * @return
     */
    public int rotatedDigits(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (isRotatedDigit(i)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 1. 首先不能有 3 4 7
     * 2. 其次 不能没有 2，5，6，9 中的任意一个
     * @param i
     * @return
     */
    private boolean isRotatedDigit(int i) {
        // 不能没有 2，5，6，9 中的任意一个
        boolean hasDigit = false;
        // 首先不能有 3 4 7
        boolean hasInvalid = false;
        while (i > 0) {
            int bit = i % 10;
            if (bit == 2 || bit == 5 || bit == 6 || bit == 9) {
                hasDigit = true;
            } else if (bit == 3 || bit == 4 || bit == 7) {
                return false;
            }
            i /= 10;
        }
        return hasDigit;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int count = solution.rotatedDigits(10);
        System.out.println(4);
        Assert.assertEquals(4, count);
    }
}
