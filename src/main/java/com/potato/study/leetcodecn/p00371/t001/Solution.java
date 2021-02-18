package com.potato.study.leetcodecn.p00371.t001;

import org.junit.Assert;

/**
 * 371. 两整数之和
 *
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。

 示例 1:

 输入: a = 1, b = 2
 输出: 3
 示例 2:

 输入: a = -2, b = 3
 输出: 1

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/sum-of-two-integers
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * https://blog.csdn.net/qq_32534441/article/details/89255605
     * 不进位的加法 可以使用 异或替代，通过通过& 求得进位 如此 循环求和
     * @param a
     * @param b
     * @return
     */
    public int getSum(int a, int b) {
        int tmp1 = a ^ b;
        int tmp2 = ((a & b)  << 1);
        // 判断使用 非等于 防止负数问题
        while (tmp2 != 0) {
            a = tmp1;
            b = tmp2;
            tmp1 = a ^ b;
            tmp2 = ((a & b)  << 1);
        }
        return tmp1;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int a = -1;
        int b = 1;
        int sum = solution.getSum(a, b);
        System.out.println(sum);
        Assert.assertEquals(0, sum);
    }


}
