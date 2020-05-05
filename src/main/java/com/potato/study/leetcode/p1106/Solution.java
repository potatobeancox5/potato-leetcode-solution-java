package com.potato.study.leetcode.p1106;


import org.junit.Assert;

import java.util.Stack;

/**
 * 
 * @author liuzhao11
 * 
 * 	1106. Parsing A Boolean Expression
 *  
 *         Return the result of evaluating a given boolean expression, represented as a string.

An expression can either be:

"t", evaluating to True;
"f", evaluating to False;
"!(expr)", evaluating to the logical NOT of the inner expression expr;
"&(expr1,expr2,...)", evaluating to the logical AND of 2 or more inner expressions expr1, expr2, ...;
"|(expr1,expr2,...)", evaluating to the logical OR of 2 or more inner expressions expr1, expr2, ...


Example 1:

Input: expression = "!(f)"
Output: true
Example 2:

Input: expression = "|(f,t)"
Output: true
Example 3:

Input: expression = "&(t,f)"
Output: false
Example 4:

Input: expression = "|(&(t,f,t),!(t))"
Output: false


Constraints:

1 <= expression.length <= 20000
expression[i] consists of characters in {'(', ')', '&', '|', '!', 't', 'f', ','}.
expression is a valid expression representing a boolean, as given in the description.
 *
 *
 *
 *   解题思路：
 *      https://leetcode-cn.com/problems/parsing-a-boolean-expression/solution/java-ti-jie-by-huangzhouwu/
 *
 *      思路：

顺序遍历运算表达式中每个字符，并压入字符栈（遇到","时跳过，不入栈），在入栈时，如果遇到右括号，则做局部运算。
局部运算结果再压入栈，那么遍历到最后右括号，局部运算计算完成后，栈中只保留一个字符，即为结果。
 *
 *
 *
 */
public class Solution {


    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);
            Stack<Character> operTemp = new Stack<>();
            if (currentChar == ',') {
                continue;
            }
            if (currentChar != ')') {
                stack.push(currentChar);
            } else {
                while (stack.peek() != '(') {
                    operTemp.push(stack.pop());
                }
                stack.pop();
                char oper = stack.pop();
                char blockResult = blockExpr(operTemp, oper);
                stack.push(blockResult);
            }
        }
        return stack.pop() == 't';
    }

    /**
     * 进行 bool 表达式运算
     * @param operStack
     * @param op
     * @return
     */
    public char blockExpr(Stack<Character> operStack, char op) {
        if (op == '!') {
            return operStack.pop() == 't' ? 'f' : 't';
        } else if (op == '&') {
            while (!operStack.isEmpty()) {
                if (operStack.pop() == 'f') {
                    return 'f';
                }
            }
            return 't';
        }else if (op == '|') {
            while (!operStack.isEmpty()) {
                if (operStack.pop() == 't') {
                    return 't';
                }
            }
            return 'f';
        }
        return 'f';
    }


	public static void main(String[] args) {
		Solution solution = new Solution();

        String expression = "!(f)";
        boolean res = solution.parseBoolExpr(expression);
        System.out.println(res);
        Assert.assertEquals(true, res);

        expression = "|(f,t)";
        res = solution.parseBoolExpr(expression);
        System.out.println(res);
        Assert.assertEquals(true, res);
    }
}
