package com.potato.study.leetcodecn.p00258.t001;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.potato.study.leetcode.domain.TreeNode;

/**
 * 258. 各位相加
 *
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 *
 * 示例:
 *
 * 输入: 38
 * 输出: 2
 * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
 * 进阶:
 * 你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     *
     * @param num
     * @return
     */
    public int addDigits(int num) {
        int sum = 0;
        boolean needContinue = true;
        while (needContinue) {
            while (num != 0) {
                int bit = num % 10;
                sum += bit;
                num /= 10;
            }
            if (sum < 10) {
                break;
            }
            num = sum;
            sum = 0;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int num = 38;
        int i = solution.addDigits(num);
        System.out.println(i);
        Assert.assertEquals(2, i);
    }


}
