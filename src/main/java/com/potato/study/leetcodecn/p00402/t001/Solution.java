package com.potato.study.leetcodecn.p00402.t001;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

import com.potato.study.leetcode.domain.TreeNode;

/**
 * 402. 移掉 K 位数字
 *
 * 给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。
 *
 *  
 * 示例 1 ：
 *
 * 输入：num = "1432219", k = 3
 * 输出："1219"
 * 解释：移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219 。
 * 示例 2 ：
 *
 * 输入：num = "10200", k = 1
 * 输出："200"
 * 解释：移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 ：
 *
 * 输入：num = "10", k = 2
 * 输出："0"
 * 解释：从原数字移除所有的数字，剩余为空就是 0 。
 *  
 *
 * 提示：
 *
 * 1 <= k <= num.length <= 105
 * num 仅由若干位数字（0 - 9）组成
 * 除了 0 本身之外，num 不含任何前导零
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-k-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {


    /**
     * 从 num 中 移除 k 个数字 保证 移除后的结果 最小
     * @param num
     * @param k
     * @return
     */
    public String removeKdigits(String num, int k) {
        // 遍历 num 使用一个 stack 记录留下的数字
        Deque<Character> deque = new LinkedList<>();
        // 如果 当前数字 比 stack peek 大的话 那么入栈 否则 出栈 并计数
        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            if (k == 0) {
                deque.add(ch);
                continue;
            }
            if (deque.isEmpty()) {
                deque.add(ch);
                continue;
            }
            while (k > 0 && !deque.isEmpty() && deque.peekLast() > ch) {
                k--;
                deque.pollLast();
            }
            deque.add(ch);
        }
        while (k > 0 && !deque.isEmpty()) {
            deque.removeLast();
            k--;
        }
        // 如果到最后 都没有 删除 足够个数 直接取前几个
        StringBuilder builder = new StringBuilder();
        boolean hasNotZero = false;
        while (!deque.isEmpty()) {
            Character ch = deque.removeFirst();
            if ('0' == ch && !hasNotZero) {
                // 删除先导0
                continue;
            } else {
                hasNotZero = true;
                builder.append(ch);
            }
        }
        if (builder.length() == 0) {
            builder.append(0);
        }
        return builder.toString();
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        String num = "1432219";
        int k = 3;
        String s = solution.removeKdigits(num, k);
        System.out.println(s);
        Assert.assertEquals("1219", s);

        num = "112";
        k = 1;
        s = solution.removeKdigits(num, k);
        System.out.println(s);
        Assert.assertEquals("11", s);
    }

    @Test
    public void testCase1() {
        Solution solution = new Solution();
        String num = "10200";
        int k = 1;
        String s = solution.removeKdigits(num, k);
        System.out.println(s);
        Assert.assertEquals("200", s);
    }

    @Test
    public void testCase2() {
        Solution solution = new Solution();
        String num = "10";
        int k = 2;
        String s = solution.removeKdigits(num, k);
        System.out.println(s);
        Assert.assertEquals("0", s);
    }
}
