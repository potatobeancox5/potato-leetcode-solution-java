package com.potato.study.leetcodecn.p00326.t001;

import org.junit.Assert;

/**
 * 326. 3的幂
 *
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。

 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x

  

 示例 1：

 输入：n = 27
 输出：true
 示例 2：

 输入：n = 0
 输出：false
 示例 3：

 输入：n = 9
 输出：true
 示例 4：

 输入：n = 45
 输出：false
  

 提示：

 -231 <= n <= 231 - 1
  

 进阶：

 你能不使用循环或者递归来完成本题吗？

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/power-of-three
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {


    /**
     * 判断 n 是不是 3的幂 不使用 循环和递归
     * @param n
     * @return
     */
    public boolean isPowerOfThree(int n) {
        while (n > 0 && n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean powerOfThree = solution.isPowerOfThree(27);
        System.out.println(powerOfThree);
        Assert.assertEquals(true, powerOfThree);


        powerOfThree = solution.isPowerOfThree(0);
        System.out.println(powerOfThree);
        Assert.assertEquals(false, powerOfThree);

        powerOfThree = solution.isPowerOfThree(9);
        System.out.println(powerOfThree);
        Assert.assertEquals(true, powerOfThree);

        powerOfThree = solution.isPowerOfThree(45);
        System.out.println(powerOfThree);
        Assert.assertEquals(false, powerOfThree);

        powerOfThree = solution.isPowerOfThree(1);
        System.out.println(powerOfThree);
        Assert.assertEquals(true, powerOfThree);
    }
}
