package com.potato.study.leetcodecn.p01249.t001;


import org.junit.Assert;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 1249. 移除无效的括号
 *
 * 给你一个由 '('、')' 和小写字母组成的字符串 s。

 你需要从字符串中删除最少数目的 '(' 或者 ')' （可以删除任意位置的括号)，使得剩下的「括号字符串」有效。

 请返回任意一个合法字符串。

 有效「括号字符串」应当符合以下 任意一条 要求：

 空字符串或只包含小写字母的字符串
 可以被写作 AB（A 连接 B）的字符串，其中 A 和 B 都是有效「括号字符串」
 可以被写作 (A) 的字符串，其中 A 是一个有效的「括号字符串」
  

 示例 1：

 输入：s = "lee(t(c)o)de)"
 输出："lee(t(c)o)de"
 解释："lee(t(co)de)" , "lee(t(c)ode)" 也是一个可行答案。
 示例 2：

 输入：s = "a)b(c)d"
 输出："ab(c)d"
 示例 3：

 输入：s = "))(("
 输出：""
 解释：空字符串也是有效的
 示例 4：

 输入：s = "(a(b(c)d)"
 输出："a(b(c)d)"
  

 提示：

 1 <= s.length <= 10^5
 s[i] 可能是 '('、')' 或英文小写字母

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/minimum-remove-to-make-valid-parentheses
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * stack 存目前没有匹配的 括号的index （
     遍历字符串
     字母 cintinue
     左括号入栈 index
     右括号pop 如果没有可以pop的 将index 放入deleteSet中

     遍历结束
     如果stack 非空 将stack 放入 set中

     遍历字符串 生成新串
     * @param s
     * @return
     */
    public String minRemoveToMakeValid(String s) {

        Stack<Integer> indexStack = new Stack<>();
        Set<Integer> toDeleteSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ('(' == ch) {
                indexStack.push(i);
            } else if (')' == ch) {
                if (indexStack.size() == 0) {
                    toDeleteSet.add(i);
                } else {
                    indexStack.pop();
                }
            }
        }
        //  如果stack 非空 将stack 放入 set中
        while (!indexStack.isEmpty()) {
            toDeleteSet.add(indexStack.pop());
        }
        // 生成结果
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (toDeleteSet.contains(i)) {
                continue;
            } else {
                builder.append(ch);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "lee(t(c)o)de)";
        String result = solution.minRemoveToMakeValid(s);
        System.out.println(result);
        Assert.assertEquals("lee(t(c)o)de", result);

        s = "a)b(c)d";
        result = solution.minRemoveToMakeValid(s);
        System.out.println(result);
        Assert.assertEquals("ab(c)d", result);
    }
}
