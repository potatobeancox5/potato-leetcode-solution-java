package com.potato.study.leetcodecn.p00316.t001;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import org.junit.Assert;

/**
 * 316. 去除重复字母
 *
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。

 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters 相同

  

 示例 1：

 输入：s = "bcabc"
 输出："abc"
 示例 2：

 输入：s = "cbacdcbc"
 输出："acdb"
  

 提示：

 1 <= s.length <= 104
 s 由小写英文字母组成

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/remove-duplicate-letters
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * https://leetcode-cn.com/problems/remove-duplicate-letters/solution/qu-chu-zhong-fu-zi-mu-by-leetcode-soluti-vuso/
     *
     * 用一个 arr 记录每个字母出现次数
     * 单调栈 单调递增
     * set 记录 目前 栈中字母有哪些
     *
     * init 栈空且set 空 直接入栈和set，arr 计数--
     * 遍历 s 其他字母
     * 如果 ch 在 stack 中 说明 已经安置好了位置 continue
     * ch 为 stack 中没有出现过
     *
     * 如果 peek 元素 还有没有剩余 那就直接将 ch 进展 计数-- set增加
     * 否则 peek 有剩余  且 peek 大于 ch 循环出栈 出栈结束之后 ch 可以进栈了
     *
     *
     * @param s
     * @return
     */
    public String removeDuplicateLetters(String s) {
        // 用一个 arr 记录每个字母出现次数
        int[] count = new int[26];
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }
        // 单调栈 单调递增
        Stack<Character> stack = new Stack<>();
        // set 记录 目前 栈中字母有哪些
        Set<Character> set = new HashSet<>();
        // init 栈空且set 空 直接入栈和set，arr 计数--
        for (char ch : s.toCharArray()) {
            // 如果 ch 在 stack 中 说明 已经安置好了位置 continue
            if (set.contains(ch)) {
                count[ch - 'a']--;
                continue;
            }
            // 否则 peek 有剩余  且 peek 大于 ch 循环出栈 出栈结束之后 ch 可以进栈了
            while (!stack.isEmpty() && stack.peek() > ch && count[stack.peek() - 'a'] > 0) {
                Character pop = stack.pop();
                set.remove(pop);
            }
            // 如果 peek 元素 还有没有剩余 那就直接将 ch 进展 计数-- set增加
            count[ch - 'a']--;
            set.add(ch);
            stack.add(ch);
            continue;
        }
        // stack 正常顺序输出
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String input = "bcabc";
        String s = solution.removeDuplicateLetters(input);
        System.out.println(s);
        Assert.assertEquals("abc", s);


        input = "cbacdcbc";
        s = solution.removeDuplicateLetters(input);
        System.out.println(s);
        Assert.assertEquals("acdb", s);
    }
}
