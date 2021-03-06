package com.potato.study.leetcodecn.p00084.t001;


import com.potato.study.leetcode.util.ArrayUtil;
import org.junit.Assert;

import java.util.Stack;

/**
 * 84. 柱状图中最大的矩形
 *
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。

 求在该柱状图中，能够勾勒出来的矩形的最大面积。

  



 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。

  



 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。

  

 示例:

 输入: [2,1,5,6,2,3]
 输出: 10

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 两个数组 left 和 right i
     *      left数组的业务含义是 当前 height i 左边第一个小于其的位置的index
     *      right 同理 右边 第一个 小于其的位置的index 一直通天 left 通天 = -1 right 通天 = length
     *      如此 height i 对应宽度为 right（2） - left（0） - 1   121 = 1 ；2.len = 1 right（1） - left（-1） - 1
     *
     * 如何生成两个数组 left 和right
     * stack 内部 保证 从 bottom -> top 递增
     * for i 0 - len - 1
     *      使用一个 stack 如果 当前stack 空 说明 当前 i 通天了 left i = -1， 当前i 入栈
     *      如果 stack 非空 那么 peek 元素
     *          while 大于等于 height i 说明 还可以往前找，一直找到 第一个小于 其的元素 pop
     *              （对于 i之后的每个位置 i+ 1当前i 挡住了 i-1们 因为 i位置更小）
     *          letf 为其 将i 入栈 干别的用
     * right 也从右往左来一次
     *
     * 左右数组都生成之后，遍历 每个位置 计算max 每个位置面积按照  （right - left - 1） * height i 计算
     *
     *
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        // 按照 height 升序排列的栈 botton - > top aesc
        Stack<Integer> aescHeightIndexStack = new Stack<>();
        // 生成left
        for (int i = 0; i < heights.length; i++) {
            if (aescHeightIndexStack.isEmpty()) {
                aescHeightIndexStack.push(i);
                left[i] = -1;
                continue;
            }
            // stack 非空 且大于 当前i高度 可以直接 pop了 因为之后点都用i 的就行了
            while (!aescHeightIndexStack.isEmpty()
                    && heights[aescHeightIndexStack.peek()] >= heights[i]) {
                aescHeightIndexStack.pop();
            }
            // 获取当前 left
            left[i] = (aescHeightIndexStack.isEmpty() ? -1 : aescHeightIndexStack.peek());
            aescHeightIndexStack.push(i);
        }
        // 生成 right
        aescHeightIndexStack = new Stack<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            if (aescHeightIndexStack.isEmpty()) {
                aescHeightIndexStack.push(i);
                right[i] = heights.length;
                continue;
            }
            // stack 非空 且大于 当前i高度 可以直接 pop了 因为之后点都用i 的就行了
            while (!aescHeightIndexStack.isEmpty()
                    && heights[aescHeightIndexStack.peek()] >= heights[i]) {
                aescHeightIndexStack.pop();
            }
            // 获取当前 left
            right[i] = (aescHeightIndexStack.isEmpty() ? heights.length : aescHeightIndexStack.peek());
            aescHeightIndexStack.push(i);
        }
        // 左右数组都生成之后，遍历 每个位置 计算max 每个位置面积按照  （right - left - 1） * height i 计算
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int area = (right[i] - left[i] - 1)* heights[i];
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] heights = ArrayUtil.string2ArrayiInt("[2,1,5,6,2,3]");
        int i = solution.largestRectangleArea(heights);
        System.out.println(i);
        Assert.assertEquals(10, i);
    }
}
