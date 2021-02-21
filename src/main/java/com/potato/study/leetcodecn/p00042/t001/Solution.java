package com.potato.study.leetcodecn.p00042.t001;

import com.potato.study.leetcode.util.ArrayUtil;
import org.junit.Assert;

import java.util.Stack;

/**
 * 42. 接雨水
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

  

 示例 1：



 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 输出：6
 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 示例 2：

 输入：height = [4,2,0,3,2,5]
 输出：9
  

 提示：

 n == height.length
 0 <= n <= 3 * 104
 0 <= height[i] <= 105

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/trapping-rain-water
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 使用一个栈 记录目前 还没有计算的位置的边界 或者底部位置
     * 遍历 数组 如果当前栈空 入栈，说明这是一个边界
     * 如果当前 元素 小于等于栈顶元素 入栈，说明 这是一个 还没有边计算到的边界
     * 如果当前 元素 大于 栈顶元素 说明找到了右边界 循环pop 栈顶元素 记录 当前pop作为底 其左右边界距离 和高度
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int sum = 0;
        Stack<Integer> indexStack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            if (indexStack.isEmpty()) {
                indexStack.add(i);
                continue;
            }
            // 找到了右边界
            while (indexStack.size() > 1 && height[indexStack.peek()] < height[i]) {
                // 本次的底部
                Integer botton = indexStack.pop();
                // 两边边界最小值
                int minHeight = Math.min(height[indexStack.peek()], height[i]) - height[botton];
                // 为啥要算坐标 考虑一种情况 左边的数字连续为同一个高度 此时 (minHeight - height[botton]) 会出现 0
                if (minHeight > 0) {
                    sum += minHeight * (i - indexStack.peek() - 1);
                }
            }
            indexStack.add(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] height = ArrayUtil.string2ArrayiInt("[0,1,0,2,1,0,1,3,2,1,2,1]");
        int sum = solution.trap(height);
        System.out.println(sum);
        Assert.assertEquals(6, sum);


        height = ArrayUtil.string2ArrayiInt("[4,2,0,3,2,5]");
        sum = solution.trap(height);
        System.out.println(sum);
        Assert.assertEquals(9, sum);
    }
}
