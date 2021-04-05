package com.potato.study.leetcodecn.p00856.t001;

import org.junit.Assert;

/**
 * 856. 括号的分数
 *
 * 给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：

 () 得 1 分。
 AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
 (A) 得 2 * A 分，其中 A 是平衡括号字符串。
  

 示例 1：

 输入： "()"
 输出： 1
 示例 2：

 输入： "(())"
 输出： 2
 示例 3：

 输入： "()()"
 输出： 2
 示例 4：

 输入： "(()(()))"
 输出： 6
  

 提示：

 S 是平衡括号字符串，且只含有 ( 和 ) 。
 2 <= S.length <= 50

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/score-of-parentheses
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 递归解法
     * @param s
     * @return
     */
    public int scoreOfParentheses(String s) {
        // s 找到 第一个 左右括号，然后 计算
        if (null == s || s.length() == 0) {
            return 0;
        }
        if ("()".equals(s)) {
            return 1;
        }
        int left = 0;
        int status = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                status++;
            } else {
                // 右括号
                status--;
            }
            // 状态判断
            if (status == 0) {
                right = i;
                break;
            }
        }
        String other = s.substring(right + 1);
        if (right == left + 1) {
            return 1 + scoreOfParentheses(other);
        }
        String sub = s.substring(left + 1, right);
        return 2 * scoreOfParentheses(sub) + scoreOfParentheses(other);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "()";
        int i = solution.scoreOfParentheses(s);
        System.out.println(i);
        Assert.assertEquals(1, i);

        s = "(())";
        i = solution.scoreOfParentheses(s);
        System.out.println(i);
        Assert.assertEquals(2, i);


        s = "()()";
        i = solution.scoreOfParentheses(s);
        System.out.println(i);
        Assert.assertEquals(2, i);


        s = "(()(()))";
        i = solution.scoreOfParentheses(s);
        System.out.println(i);
        Assert.assertEquals(6, i);
    }
}
