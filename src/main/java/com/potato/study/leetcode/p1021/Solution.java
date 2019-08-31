package com.potato.study.leetcode.p1021;


/**
 * 
 * @author liuzhao11
 * 
 * 	1021. Remove Outermost Parentheses
 *  
 *         A valid parentheses string is either empty (""), "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.  For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.

A valid parentheses string S is primitive if it is nonempty, and there does not exist a way to split it into S = A+B, with A and B nonempty valid parentheses strings.

Given a valid parentheses string S, consider its primitive decomposition: S = P_1 + P_2 + ... + P_k, where P_i are primitive valid parentheses strings.

Return S after removing the outermost parentheses of every primitive string in the primitive decomposition of S.



Example 1:

Input: "(()())(())"
Output: "()()()"
Explanation:
The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
Example 2:

Input: "(()())(())(()(()))"
Output: "()()()()(())"
Explanation:
The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".
Example 3:

Input: "()()"
Output: ""
Explanation:
The input string is "()()", with primitive decomposition "()" + "()".
After removing outer parentheses of each part, this is "" + "" = "".


Note:

S.length <= 10000
S[i] is "(" or ")"
S is a valid parentheses string
 *         
 *         思路：
 *          简化括号，去掉最外卖的括号
 *          计数器 count 计算 （  出现个数
 *          遍历字符串
 *          当 count == 0 且 是 （  count ++；
 *          当 count > 0 且 （ count++ 并 sb。appned
 *          当 count > 1 且 ） count-- 并 sb.append
 *          当 coun == 1 且 （ count--
 *          其他情况与本题不符
 *
 *
 */
public class Solution {

    public String removeOuterParentheses(String str) {
        if (null == str || "".equals(str)) {
            return "";
        }
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (char ch : str.toCharArray()) {
//            当 count == 0 且 是 （  count ++；
            if (count == 0 && '(' == ch) {
                count++;
            }  else if (count > 0 && '(' == ch) {
//          当 count > 0 且 （ count++ 并 sb。appned
                count++;
                sb.append(ch);
            } else if (count > 1 && ')' == ch) {
//            当 count > 1 且 ） count-- 并 sb.append
                count--;
                sb.append(ch);
            } else if (count == 1 && ')' == ch) {
//             当 coun == 1 且 （ count--
                count--;
            }
        }
        return sb.toString();
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
//        String s = "()()";// ""
//        String s = "(()())(())";// "()()()"
        String s = "(()())(())(()(()))";// "()()()()(())"
        String b = solution.removeOuterParentheses(s);
        System.out.println(b);
    }
}
