package com.potato.study.leetcodecn.p01021.t001;

/**
 * 1021. 删除最外层的括号
 *
 * 有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。

 如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。

 给出一个非空有效字符串 S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。

 对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。

  

 示例 1：

 输入："(()())(())"
 输出："()()()"
 解释：
 输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
 删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
 示例 2：

 输入："(()())(())(()(()))"
 输出："()()()()(())"
 解释：
 输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
 删除每个部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。
 示例 3：

 输入："()()"
 输出：""
 解释：
 输入字符串为 "()()"，原语化分解得到 "()" + "()"，
 删除每个部分中的最外层括号后得到 "" + "" = ""。
  

 提示：

 S.length <= 10000
 S[i] 为 "(" 或 ")"
 S 是一个有效括号字符串

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/remove-outermost-parentheses
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 用一个 flag 记录 当前是不是最外层的括号
     * @param s
     * @return
     */
    public String removeOuterParentheses(String s) {
        int flag = 0;
        StringBuilder builder = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ('(' == ch) {
                if (flag == 0) {
                    tmp = new StringBuilder();
                }
                flag++;
            } else if (')' == ch) {
                flag--;
            } else {
                tmp.append(tmp);
            }
        }
        return builder.toString();
    }
}
