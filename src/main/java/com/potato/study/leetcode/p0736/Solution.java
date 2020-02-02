package com.potato.study.leetcode.p0736;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 * 	736. Parse Lisp Expression
 *  
 *         You are given a string expression representing a Lisp-like expression to return the integer value of.

The syntax for these expressions is given as follows.

An expression is either an integer, a let-expression, an add-expression, a mult-expression, or an assigned variable. Expressions always evaluate to a single integer.
(An integer could be positive or negative.)
A let-expression takes the form (let v1 e1 v2 e2 ... vn en expr), where let is always the string "let", then there are 1 or more pairs of alternating variables and expressions, meaning that the first variable v1 is assigned the value of the expression e1, the second variable v2 is assigned the value of the expression e2, and so on sequentially; and then the value of this let-expression is the value of the expression expr.
An add-expression takes the form (add e1 e2) where add is always the string "add", there are always two expressions e1, e2, and this expression evaluates to the addition of the evaluation of e1 and the evaluation of e2.
A mult-expression takes the form (mult e1 e2) where mult is always the string "mult", there are always two expressions e1, e2, and this expression evaluates to the multiplication of the evaluation of e1 and the evaluation of e2.
For the purposes of this question, we will use a smaller subset of variable names. A variable starts with a lowercase letter, then zero or more lowercase letters or digits. Additionally for your convenience, the names "add", "let", or "mult" are protected and will never be used as variable names.
Finally, there is the concept of scope. When an expression of a variable name is evaluated, within the context of that evaluation, the innermost scope (in terms of parentheses) is checked first for the value of that variable, and then outer scopes are checked sequentially. It is guaranteed that every expression is legal. Please see the examples for more details on scope.
Evaluation Examples:
Input: (add 1 2)
Output: 3

Input: (mult 3 (add 2 3))
Output: 15

Input: (let x 2 (mult x 5))
Output: 10

Input: (let x 2 (mult x (let x 3 y 4 (add x y))))
Output: 14
Explanation: In the expression (add x y), when checking for the value of the variable x,
we check from the innermost scope to the outermost in the context of the variable we are trying to evaluate.
Since x = 3 is found first, the value of x is 3.

Input: (let x 3 x 2 x)
Output: 2
Explanation: Assignment in let statements is processed sequentially.

Input: (let x 1 y 2 x (add x y) (add x y))
Output: 5
Explanation: The first (add x y) evaluates as 3, and is assigned to x.
The second (add x y) evaluates as 3+2 = 5.

Input: (let x 2 (add (let x 3 (let x 4 x)) x))
Output: 6
Explanation: Even though (let x 4 x) has a deeper scope, it is outside the context
of the final x in the add-expression.  That final x will equal 2.

Input: (let a1 3 b2 (add a1 1) b2)
Output 4
Explanation: Variable names can contain digits after the first character.

Note:

The given string expression is well formatted: There are no leading or trailing spaces, there is only a single space separating different components of the string, and no space between adjacent parentheses. The expression is guaranteed to be legal and evaluate to an integer.
The length of expression is at most 2000. (It is also non-empty, as that would not be a legal expression.)
The answer and all intermediate calculations of that answer are guaranteed to fit in a 32-bit integer.
 *
 *
 *         思路：
 *
 *          https://leetcode.com/problems/parse-lisp-expression/discuss/109718/Java-modularized-solution
 *
 *          https://blog.csdn.net/magicbean2/article/details/79413629
 *
 *          https://blog.csdn.net/u014688145/article/details/78665218
 *
 *
 *
 *
 *
 *
 * 
 */
public class Solution {

    public int evaluate(String expression) {
        // 使用 map 记录 key: 变量名 value ：变量值
        Map<String, Integer> operandMap = new HashMap<>();
        // 递归调用计算函数
        return this.evaluate(expression, operandMap);
    }

    /**
     *
     * @param expression    求解表达式
     * @param operandMap    参数列表
     * @return
     */
    private int evaluate(String expression, Map<String, Integer> operandMap) {

        char ch = expression.charAt(0);
        if ('(' == ch) {
            String dataLine = expression.substring(1, expression.length() - 1);
            String[] datas = dataLine.split(" ");
            String title = datas[0];
            List<String> nums = this.parseExpression(expression);
            if ("let".equals(title)) {
                //  去掉收尾 （）
                for (int i = 0; i < nums.size() - 1; i += 2) {
                    operandMap.put(nums.get(i), evaluate(nums.get(i + 1), clone(operandMap)));
                }
                return evaluate(nums.get(nums.size() - 1), clone(operandMap));

            } else if ("add".equals(title)) {
                return evaluate(nums.get(0), clone(operandMap)) + evaluate(nums.get(1), clone(operandMap));
            } else {
                // 乘法
                return evaluate(nums.get(0), clone(operandMap)) * evaluate(nums.get(1), clone(operandMap));
            }
        } else {
            if (ch == '-' || Character.isDigit(ch)) {
                return Integer.parseInt(expression);
            } else {
                return operandMap.get(expression);
            }
        }
    }


    private List<String> parseExpression (String expression) {
        List<String> result = new ArrayList<>();
        // 遍历 expression 每个位置 字符串 如果是 （ 找到 ） 位置 裂解 否则 找到空格之前
        int startIndex = 5;
        if ("mul".equals(expression.substring(1, 4))) {
            startIndex = 6;
        }
        int n = expression.length() - 1;

        for (int i = startIndex; i < n; ) {
            char ch = expression.charAt(i);
            if (ch == '(') {
                // 如果是 （ 找到 ） 位置 裂解
                int indexTmp = i + 1;
                int leftNum = 1;
                while (indexTmp < n) {
                    if (expression.charAt(indexTmp) == '(') {
                        leftNum++;
                    } else if (expression.charAt(indexTmp) == ')') {
                        leftNum--;
                        if (leftNum == 0) {
                            break;
                        }
                    }
                    indexTmp++;
                }
                result.add(expression.substring(i, indexTmp + 1));
                i = indexTmp + 2;
            } else {
                // 找到 空格 结束
                StringBuilder builder = new StringBuilder();
                while (i < n && expression.charAt(i) != ' ') {
                    builder.append(expression.charAt(i));
                    i++;
                }
                result.add(builder.toString());
                i++;
            }
        }
        return result;
    }

    Map<String, Integer> clone(Map<String, Integer> map){
        Map<String, Integer> clone = new HashMap<>();
        for (String key : map.keySet()) {
            clone.put(key, map.get(key));
        }
        return clone;
    }

	
	public static void main(String[] args) {
		Solution solution = new Solution();

        String expression = "(add 1 2)";
        int res = solution.evaluate(expression);
        System.out.println(res);
        Assert.assertEquals(res, 3);

        expression = "(mult 3 (add 2 3))";
        res = solution.evaluate(expression);
        System.out.println(res);
        Assert.assertEquals(res, 15);
    }
}
