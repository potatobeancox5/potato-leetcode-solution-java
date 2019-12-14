package com.potato.study.leetcode.p0679;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @author liuzhao11
 * 
 *         679. 24 Game
 * 
 *         You have 4 cards each containing a number from 1 to 9. You need to judge whether they could operated through *, /, +, -, (, ) to get the value of 24.

Example 1:
Input: [4, 1, 8, 7]
Output: True
Explanation: (8-4) * (7-1) = 24
Example 2:
Input: [1, 2, 1, 2]
Output: False
Note:
The division operator / represents real division, not integer division. For example, 4 / (1 - 2/3) = 12.
Every operation done is between two numbers. In particular, we cannot use - as a unary operator. For example, with [1, 1, 1, 1] as input, the expression -1 - 1 - 1 - 1 is not allowed.
You cannot concatenate numbers together. For example, if the input is [1, 2, 1, 2], we cannot write this as 12 + 12.
 *
 *         思路：
 *         题目含义 给定4个数 利用添加 + - * ／ 和括号 使得结果构成24点
 *
 *         回溯法， 给定一个 list《list》 每个元素 存的是 当前可选结果集，每次从其中选出来2个元素 分别做加减乘除，加入原来的元素里
 *
 *         https://www.cnblogs.com/ZhaoxiCheung/p/7545957.html
 *
 */
public class Solution {

    // 缓存结果集
    private boolean result = false;
    // double 判断相等的误差
    private double exp = 1e-7;

    public boolean judgePoint24(int[] nums) {
        result = false;
        // 1. 当前的4个元素方法当前的结果集
        List<Double> op = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            op.add((double)nums[i]);
        }
        // 2. 调用自函数进行回溯判断
        doJudgePoint24(op);
        return result;

    }

    /**
     * 回溯
     */
    private void doJudgePoint24(List<Double> op) {
        // 已经判断出来结果了
        if (result) {
            return;
        }
        // 终止条件 op只有一个数字 且为24
        if (op.size() == 1 && Math.abs(op.get(0) - 24) <= exp) {
            result = true;
            return;
        }
        // 从op中获取2个数字，计算加减乘除，递归判断生成的数字
        for (int i = 0; i < op.size(); i++) {
            for (int j = 0; j < i; j++) {
                double num1 = op.get(i);
                double num2 = op.get(j);

                List<Double> tmpRes = new ArrayList<>();
                tmpRes.add(num1 + num2);
                tmpRes.add(num1 * num2);
                tmpRes.add(num1 - num2);
                tmpRes.add(num2 - num1);
                // divide
                if (Math.abs(num2) > exp) {
                    tmpRes.add(num1 / num2);
                }
                if (Math.abs(num1) > exp) {
                    tmpRes.add(num2 / num1);
                }

                // 删除之前的数字 num1 num2
                op.remove(i);
                op.remove(j);

                // 递归判断
                for (Double tmp : tmpRes) {
                    op.add(tmp);
                    doJudgePoint24(op);
                    op.remove(tmp);
                }

                // 添加上之前删除的数字
                op.add(j, num2);
                op.add(i, num1);

            }
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {4, 1, 8, 7};
        boolean res = solution.judgePoint24(nums);
        System.out.println(res);
        Assert.assertEquals(true, res);

        int[] nums1 = {1, 2, 1, 2};
        res = solution.judgePoint24(nums1);
        System.out.println(res);
        Assert.assertEquals(false, res);

        int[] nums2 = {1, 3, 4, 6};
        res = solution.judgePoint24(nums2);
        System.out.println(res);
        Assert.assertEquals(true, res);
    }
}
