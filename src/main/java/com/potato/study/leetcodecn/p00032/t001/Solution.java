package com.potato.study.leetcodecn.p00032.t001;

import org.junit.Assert;

import java.util.Stack;

/**
 * 32. 最长有效括号
 *
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。

  

 示例 1：

 输入：s = "(()"
 输出：2
 解释：最长有效括号子串是 "()"
 示例 2：

 输入：s = ")()())"
 输出：4
 解释：最长有效括号子串是 "()()"
 示例 3：

 输入：s = ""
 输出：0
  

 提示：

 0 <= s.length <= 3 * 104
 s[i] 为 '(' 或 ')'

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 其中一个关键点 是如果当前子串是 合法串，那他是不是能跟之前的串合并计数呢
     * 所以 要么的算法 就是 使用 一个栈记录 （ 开始的位置，然后每次 遇到 ） 时，都生成对应的区间 【a，b】，记录ab 并合并
     * 最终遍历 序列 找到最大的一个序列
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        // （ 个数 小于0为非法
        // 记录（  出现的 index 坐标
        Stack<Integer> indexStack = new Stack<>();
        // 记录 之前 合法的序列 起始终止位置
        Stack<int[]> intervalStack = new Stack<>();
        // 遍历 s 如果 是 （ 记录出现位置 并更新状态
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                indexStack.add(i);
            } else {
                // 达到了不可用的位置
                // 如果是 ） ，出栈，更新 状态 如果 状态 计算一下 当前 有效长度是多少呢，并加上之前的有效长度 更新max
                if (indexStack.isEmpty()) {
                    continue;
                }
                Integer starIndex = indexStack.pop();
                int[] interval = new int[]{starIndex, i};
                // 计算是够需要可以合并
                while (!intervalStack.isEmpty() && canMerge(intervalStack.peek(), interval)) {
                    interval = merge(intervalStack.pop(), interval);
                }
                // 入栈
                intervalStack.add(interval);
            }
        }
        // 遍历 intervalStack 获取最大值
        int maxLength = 0;
        while (!intervalStack.isEmpty()) {
            int[] pop = intervalStack.pop();
            maxLength = Math.max(maxLength, pop[1] - pop[0] + 1);
        }
        return maxLength;
    }

    /**
     * 判断两个区间是否 相交
     * @param interval1
     * @param interval2
     * @return
     */
    private boolean canMerge(int[] interval1, int[] interval2) {
        // 交换大小 interval1 的起始位置 一定是小的
        if (interval1[0] > interval2[1]) {
            int[] tmp = interval1;
            interval1 = interval2;
            interval2 = tmp;
        }
        // 不相交
        if (interval1[1] + 1 < interval2[0]) {
            return false;
        }
        return true;
    }

    /**
     * 合并两个区间
     * @param interval1
     * @param interval2
     * @return
     */
    private int[] merge(int[] interval1, int[] interval2) {
        return new int[] {Math.min(interval1[0], interval2[0]), Math.max(interval1[1], interval2[1])};
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "(()";
        int len = solution.longestValidParentheses(s);
        System.out.println(len);
        Assert.assertEquals(2, len);


        s = ")()())";
        len = solution.longestValidParentheses(s);
        System.out.println(len);
        Assert.assertEquals(4, len);

        s = "";
        len = solution.longestValidParentheses(s);
        System.out.println(len);
        Assert.assertEquals(0, len);

        s = "()(())";
        len = solution.longestValidParentheses(s);
        System.out.println(len);
        Assert.assertEquals(6, len);

        s = "(()()";
        len = solution.longestValidParentheses(s);
        System.out.println(len);
        Assert.assertEquals(4, len);
    }
}
