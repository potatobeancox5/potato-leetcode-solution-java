package com.potato.study.leetcodecn.p00394.t001;

import org.junit.Assert;

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
     * 遍历 字符串 s
     * 对于每个位置 i
     * 如果 i 是字母， append 到 builder 中
     * 如果 i 是数字  压入 numStack 栈中
     *              之前累积的 builder 压如 word 栈
     * 如果 i 是 【
     *      计算当前 numStack中的数字，并pushtimesStack 栈中
     * 如果 i 是 】时
     *      builder 清空 压栈
     *      分别从 word 栈和 times 栈中拿到两个值，如果 times 已经为空，
     *      将word 重复 n 次拼接 此时 不入栈 此时继续作为 bulider中的字母
     *
     *
     *
     * 最终 在从 word栈中 拿栈顶 append 之前拼好的元素 放回栈中
     *
     * 最终的返回就是 word 栈的peek
     * @param s
     * @return
     */
    public String decodeString(String s) {
        if (null == s) {
            return s;
        }
        // 暂时存放 字母
        StringBuilder builder = new StringBuilder();
        // 存放每个数字
        Queue<Integer> numQueue = new LinkedList<>();
        // 存放 每个单词组合 的目前生成的记录
        Stack<String> wordStack = new Stack<>();
        // 存放 当前 字母 组合 出现了 多少次
        Stack<Integer> timesStack = new Stack<>();
        // 记录当前有多少左边括号 用于 合并
        int status = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isLetter(ch)) {
                builder.append(ch);
            } else if (Character.isDigit(ch)) {
                numQueue.add(ch - '0');
                if (builder.length() > 0) {
                    wordStack.push(builder.toString());
                    builder = new StringBuilder();
                }
            } else if ('[' == ch) {
                // 计算次数
                int times = 0;
                while (!numQueue.isEmpty()) {
                    times *= 10;
                    times += numQueue.poll();
                }
                timesStack.push(times);
            } else {
                // '[' == ch
                if (builder.length() > 0) {
                    wordStack.push(builder.toString());
                    builder = new StringBuilder();
                }
                // 分别从 word 栈和 times 栈中拿到两个值，如果 times 已经为空，那就是 1
                int times = 1;
                if (!timesStack.isEmpty()) {
                    times = timesStack.pop();
                }
                String word = wordStack.pop();
                // 将word 重复 n 次拼接 在从 word栈中 拿栈顶 append 之前拼好的元素 放回栈中
                StringBuilder temp = new StringBuilder();
                for (int i = 0; i < times; i++) {
                    temp.append(word);
                }
                // 最终压栈
                builder = new StringBuilder(temp);
//                wordStack.push(temp.toString());
            }
        }
        // 最终的结果就是 栈内结果的组合
        if (builder.length() > 0) {
            wordStack.push(builder.toString());
        }
        // 依次出栈 组成最终结果
        if (wordStack.isEmpty()) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        while (!wordStack.isEmpty()) {
            result.insert(0, wordStack.pop());
        }
        return result.toString();
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
