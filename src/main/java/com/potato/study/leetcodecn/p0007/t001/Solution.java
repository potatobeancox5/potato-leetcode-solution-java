package com.potato.study.leetcodecn.p0007.t001;

import org.junit.Assert;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 7. 整数反转
 *
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

 示例 1:

 输入: 123
 输出: 321
  示例 2:

 输入: -123
 输出: -321
 示例 3:

 输入: 120
 输出: 21
 注意:

 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/reverse-integer
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 反转 用栈吧
     * @param x
     * @return
     */
    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        boolean negtive = false;
        long target = x;
        if (x < 0) {
            negtive = true;
            target *= -1;
        }
        Queue<Integer> queue = new LinkedList<>();

        while (target > 0) {
            queue.add((int)(target % 10));
            target /= 10;
        }

        // pop
        long res = 0;
        while (!queue.isEmpty()) {
            res = res * 10;
            res += queue.remove();
        }
        if (negtive) {
            res *= -1;
        }
        if (Integer.MIN_VALUE <= res && res <= Integer.MAX_VALUE){
            return (int) res;
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int reverse = solution.reverse(123);
        System.out.println(reverse);
        Assert.assertEquals(321, reverse);
    }


}
