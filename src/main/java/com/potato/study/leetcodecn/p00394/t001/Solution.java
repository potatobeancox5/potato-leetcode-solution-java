package com.potato.study.leetcodecn.p00394.t001;

import org.junit.Assert;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 394. 字符串解码
 *
 * 给定一个经过编码的字符串，返回它解码后的字符串。

 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。

 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。

 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。

  

 示例 1：

 输入：s = "3[a]2[bc]"
 输出："aaabcbc"
 示例 2：

 输入：s = "3[a2[c]]"
 输出："accaccacc"
 示例 3：

 输入：s = "2[abc]3[cd]ef"
 输出："abcabccdcdcdef"
 示例 4：

 输入：s = "abc3[cd]xyz"
 输出："abccdcdcdxyz"

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/decode-string
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 遍历 s
     * 使用 stack 记录 当前存在的数据 （使用 list 进行模拟） 因为需要搞成双端队列 最终进行 顺序进行
     * 1. 遍历 s 有几种情况
     *  1.1 数字 遇到了 数字 就开始往后找 一直找到 不是数字
     *  1.2 【   1.3 字符 直接入栈
     *  1.3 】 循环出栈，一直到 【， 将出栈字符进行收集 组成字符串
     * 2. 将 stack从栈底开始遍历 生成结果字符串
     * @param s
     * @return
     */
    public String decodeString(String s) {
        int index = 0;
        // 1. 遍历 s 有几种情况
        Deque<String> deque = new LinkedList<>();
        while (index < s.length()) {
            char ch = s.charAt(index);
            if (Character.isDigit(ch)) {
                // 数字 遇到了 数字 就开始往后找 一直找到 不是数字
                int num = (ch - '0');
                index++;
                while (Character.isDigit(s.charAt(index))) {
                    num *= 10;
                    num += (s.charAt(index) - '0');
                    index++;
                }
                deque.addLast(String.valueOf(num));
            } else if (Character.isAlphabetic(ch) || '[' == ch) {
                deque.addLast(String.valueOf(ch));
                index++;
            } else {
                // ']' == ch 循环出栈
                StringBuilder builder = new StringBuilder();
                while (!deque.isEmpty() && !"[".equals(deque.peekLast())) {

                    String sss = deque.pollLast();
                    if (sss.length() > 0) {
                        sss = new StringBuilder(sss).reverse().toString();
                    }
                    builder.append(sss);

                }
                if ("[".equals(deque.peekLast())) {
                    deque.pollLast();
                }

                String targetStr = builder.reverse().toString();
                // 获取数字
                int num = Integer.parseInt(deque.pollLast());
                // 获取一定次数的str
                String str = getStrCount(targetStr, num);
                deque.addLast(str);
                index++;
            }
        }
        // 2. 将 stack从栈底开始遍历 生成结果字符串
        StringBuilder builder = new StringBuilder();
        while (!deque.isEmpty()) {
            builder.append(deque.pollFirst());
        }
        return builder.toString();
    }

    /**
     *
     * @param targetStr
     * @param num
     * @return
     */
    private String getStrCount(String targetStr, int num) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < num; i++) {
            builder.append(targetStr);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "3[a]2[bc]";
        String string = solution.decodeString(s);
        System.out.println(string);
        Assert.assertEquals("aaabcbc", string);

        s = "3[a2[c]]";
        string = solution.decodeString(s);
        System.out.println(string);
        Assert.assertEquals("accaccacc", string);

        s = "2[abc]3[cd]ef";
        string = solution.decodeString(s);
        System.out.println(string);
        Assert.assertEquals("abcabccdcdcdef", string);

        s = "abc3[cd]xyz";
        string = solution.decodeString(s);
        System.out.println(string);
        Assert.assertEquals("abccdcdcdxyz", string);

        s = "abc";
        string = solution.decodeString(s);
        System.out.println(string);
        Assert.assertEquals("abc", string);

        s = "10[a]";
        string = solution.decodeString(s);
        System.out.println(string);
        Assert.assertEquals("aaaaaaaaaa", string);

        s = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
        string = solution.decodeString(s);
        System.out.println(string);
        Assert.assertEquals("zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef", string);

    }
}
