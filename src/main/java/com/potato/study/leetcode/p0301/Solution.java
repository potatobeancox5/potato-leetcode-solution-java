package com.potato.study.leetcode.p0301;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author Administrator
 *
 *         301. Remove Invalid Parentheses
 *         
 *          
 *         Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

Note: The input string may contain letters other than the parentheses ( and ).

Example 1:

Input: "()())()"
Output: ["()()()", "(())()"]
Example 2:

Input: "(a)())()"
Output: ["(a)()()", "(a())()"]
Example 3:

Input: ")("
Output: [""]
 *         
 *         
 *         
 *         题目含义：
 *
 *
 *         思路：
 *          https://www.cnblogs.com/immiao0319/p/9074387.html
 *
 *          为了去除的括号数量最少，只要左右相等就可以 所以用L R来控制dfs递增的次数
 *          统计左右括号数量 让左右数量相等 则是最好的打算
 *          每次dfs 都必须保证 左括号 >= 右括号 就是 L 不能减到0
 *          途中必须保证左括号一直大于右括号 设置 leftNum 遇到一个左括号 + 1遇到右括号-1
 *
dfs 每次决定是否加入字符括号 达到终止条件结束
没看懂的写法
https://segmentfault.com/a/1190000013676627?utm_medium=referral&utm_source=tuicool
 *
 *         
 *         
 *         
 *         
 *         
 */
public class Solution {

    public List<String> removeInvalidParentheses(String s) {
        // 统计数量 终止搜索状态是除掉制定的括号
        Set<String> result = new HashSet<>();
        int left = 0;
        int right = 0;
        if (null != s) {
            for (char ch : s.toCharArray()) {
                // 这里边记录的是需要删除的lefy 和right 数量
                if (ch == '(') {
                    left++;
                } else if (ch == ')') {
                    if (left > 0) {
                        left--;
                    } else {
                        right++;
                    }
                }
            }

        }
        int open = 0;// 用于判定dfs过程中是否出现了不合法的现象
        StringBuilder sb = new StringBuilder();
        dfs (result, s, 0, left, right, 0, sb);
        if (result.size() == 0) {
            result.add("");
        }
        return new ArrayList<>(result);
    }

    /**
     *
     * @param result        记录结果
     * @param str           模式字符串
     * @param index         当前比较位置
     * @param left          左边括号多出来的数量
     * @param right         右边括号多出来的数量
     * @param open          当前是否合法 小于 0 不合法
     */
    private void dfs (Set<String> result, String str, int index, int left, int right,
                      int open, StringBuilder sb) {

        /**
         * 成功到达最后一个位置
         */
        if (index == str.length() && left == 0 && right == 0 && open == 0) {
            result.add(sb.toString());
        }
        // 出现异常情况 可以返回了
        if (index == str.length()) {
            return;
        }
        if (open < 0) {
            return;
        }
        // 继续dfs
        char ch = str.charAt(index);
        if (ch == '(') {
            // use
            StringBuilder child1sb = new StringBuilder(sb);
            child1sb.append(ch);
            dfs (result, str, index + 1, left, right,open + 1, child1sb);
            // unuse
            StringBuilder child2sb = new StringBuilder(sb);
            dfs (result, str, index + 1, left - 1, right,open, child2sb);
        } else if (ch == ')') {
            // use
            StringBuilder child1sb = new StringBuilder(sb);
            child1sb.append(ch);
            dfs (result, str, index + 1, left, right, open - 1, child1sb);
            // unuse
            StringBuilder child2sb = new StringBuilder(sb);
            dfs (result, str, index + 1, left, right - 1, open, child2sb);
        } else {// 字母 直接房后找把
            StringBuilder childSb = new StringBuilder(sb);
            dfs (result, str, index + 1, left, right , open, childSb.append(ch));
        }
    }


	public static void main(String[] args) {
		Solution solution = new Solution();
//		String s = "()())()";
//		String s = "(a)())()";
		String s = ")(f";


        List<String> res = solution.removeInvalidParentheses(s);
        System.out.println(res);
    }
}
