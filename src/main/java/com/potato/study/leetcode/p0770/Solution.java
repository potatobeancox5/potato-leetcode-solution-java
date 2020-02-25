package com.potato.study.leetcode.p0770;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 * 	770. Basic Calculator IV
 *  
 *         Given an expression such as expression = "e + 8 - a + 5" and an evaluation map such as {"e": 1} (given in terms of evalvars = ["e"] and evalints = [1]), return a list of tokens representing the simplified expression, such as ["-1*a","14"]

An expression alternates chunks and symbols, with a space separating each chunk and symbol.
A chunk is either an expression in parentheses, a variable, or a non-negative integer.
A variable is a string of lowercase letters (not including digits.) Note that variables can be multiple letters, and note that variables never have a leading coefficient or unary operator like "2x" or "-x".
Expressions are evaluated in the usual order: brackets first, then multiplication, then addition and subtraction. For example, expression = "1 + 2 * 3" has an answer of ["7"].

The format of the output is as follows:

For each term of free variables with non-zero coefficient, we write the free variables within a term in sorted order lexicographically. For example, we would never write a term like "b*a*c", only "a*b*c".
Terms have degree equal to the number of free variables being multiplied, counting multiplicity. (For example, "a*a*b*c" has degree 4.) We write the largest degree terms of our answer first, breaking ties by lexicographic order ignoring the leading coefficient of the term.
The leading coefficient of the term is placed directly to the left with an asterisk separating it from the variables (if they exist.)  A leading coefficient of 1 is still printed.
An example of a well formatted answer is ["-2*a*a*a", "3*a*a*b", "3*b*b", "4*a", "5*c", "-6"]
Terms (including constant terms) with coefficient 0 are not included.  For example, an expression of "0" has an output of [].
Examples:

Input: expression = "e + 8 - a + 5", evalvars = ["e"], evalints = [1]
Output: ["-1*a","14"]

Input: expression = "e - 8 + temperature - pressure",
evalvars = ["e", "temperature"], evalints = [1, 12]
Output: ["-1*pressure","5"]

Input: expression = "(e + 8) * (e - 8)", evalvars = [], evalints = []
Output: ["1*e*e","-64"]

Input: expression = "7 - 7", evalvars = [], evalints = []
Output: []

Input: expression = "a * b * c + b * a * c * 4", evalvars = [], evalints = []
Output: ["5*a*b*c"]

Input: expression = "((a - b) * (b - c) + (c - a)) * ((a - b) + (b - c) * (c - a))",
evalvars = [], evalints = []
Output: ["-1*a*a*b*b","2*a*a*b*c","-1*a*a*c*c","1*a*b*b*b","-1*a*b*b*c","-1*a*b*c*c","1*a*c*c*c","-1*b*b*b*c","2*b*b*c*c","-1*b*c*c*c","2*a*a*b","-2*a*a*c","-2*a*b*b","2*a*c*c","1*b*b*b","-1*b*b*c","1*b*c*c","-1*c*c*c","-1*a*a","1*a*b","1*a*c","-1*b*c"]
Note:

expression will have length in range [1, 250].
evalvars, evalints will have equal lengths in range [0, 100].


 *   题目大意：
 *      计算表达式 包括 自变量
 *
 *
 *   解题思路：
 *      https://leetcode.com/problems/basic-calculator-iv/discuss/507368/Well-I-tried-to-keep-it-short.-Java
 *
 *
 *
 * 
 */
public class Solution {

    public List<String> basicCalculatorIV(String expression, String[] evalvars, int[] evalints) {

        // 0 已知的变量
        Map<String, Integer> knownVars = new HashMap<>();
        for (int i = 0; i < evalvars.length; i++) {
            knownVars.put(evalvars[i], evalints[i]);
        }

        // 1 拆分出表达式和运算符
        LinkedList<Expr> expressions = new LinkedList<>();
        LinkedList<String> ops = new LinkedList<>();
        for (String token : parseExpression(expression)) {
            if (Character.isDigit(token.charAt(0))) {
                expressions.push(new Expr("", Integer.parseInt(token)));
            } else if (token.equals("(")) {
                ops.push("(");
            } else if (token.equals(")")) {
                while (!ops.peek().equals("("))
                    doOneEval(ops, expressions);
                ops.pop();
            } else if (token.equals("+") || token.equals("-") || token.equals("*")) {
                int rank = getRank(token);
                while (!ops.isEmpty() && !ops.peek().equals("(") && getRank(ops.peek()) >= rank)
                    doOneEval(ops, expressions);
                ops.push(token);
            } else if (knownVars.containsKey(token)) {
                expressions.push(new Expr("", knownVars.get(token)));
            } else {
                expressions.push(new Expr(token, 1));
            }
        }

        // 2 计算每一个表达式的值
        while (!ops.isEmpty()) {
            doOneEval(ops, expressions);
        }

        Expr expr = expressions.peek();
        List<String> output = new ArrayList<>();
        for (String term : expr.terms.keySet()) {
            if (expr.terms.get(term) != 0) {
                output.add("" + expr.terms.get(term) + (term.equals("") ? "" : "*" + term));
            }
        }

        Collections.sort(output, (a, b) -> {
            int a_star = 0, b_star = 0;
            for (int i = 0; i < a.length(); i++)
                if (a.charAt(i) == '*') a_star++;
            for (int i = 0; i < b.length(); i++)
                if (b.charAt(i) == '*') b_star++;

            if (a_star != b_star) return b_star - a_star;

            return a.split("\\*", 2)[1].compareTo(b.split("\\*", 2)[1]);
        });

        return output;
    }


    /**
     * 将 expression 听过空格分隔 并输出
     * @param expression
     * @return
     */
    private List<String> parseExpression(String expression) {

        List<String> output = new ArrayList<>();

        String[] split = expression.split(" ");

        // 对每个表达式进行处理
        for (String token : split) {
            // 计算 （ 数量
            int opening = 0;
            while (token.charAt(opening) == '(') {
                output.add("(");
                opening++;
            }
            int closing = 0;
            while (token.charAt(token.length() - 1 - closing) == ')') {
                closing++;
            }
            output.add(token.substring(opening, token.length() - closing));
            while (closing > 0) {
                output.add(")");
                closing--;
            }
        }

        return output;
    }

    /**
     * 计算 运算符的优先级
     * @param op
     * @return
     */
    private int getRank(String op) {
        if (op.equals("+") || op.equals("-")) {
            return 1;
        }
        return 2;
    }


    /**
     * 计算每一个表达式
     * @param ops
     * @param expressions
     */
    private void doOneEval(LinkedList<String> ops, LinkedList<Expr> expressions) {
        Expr e2 = expressions.pop();
        Expr e1 = expressions.pop();
        Expr res = new Expr("", 0);

        String op = ops.pop();

        if (op.equals("+") || op.equals("-")) {
            int sign = op.equals("-") ? -1 : 1;

            res.terms = e1.terms;
            for (String term : e2.terms.keySet())
                res.terms.put(term, sign * e2.terms.get(term) + res.terms.getOrDefault(term, 0));
        } else {
            // *
            for (String t1 : e1.terms.keySet())
                for (String t2 : e2.terms.keySet()) {
                    String resTerm = generateTerm(t1, t2);
                    res.terms.put(resTerm, e1.terms.get(t1) * e2.terms.get(t2) + res.terms.getOrDefault(resTerm, 0));
                }
        }

        expressions.push(res);
    }

    private String generateTerm(String t1, String t2) {
        if (t1.equals("")) return t2;
        if (t2.equals("")) return t1;

        List<String> parts = new ArrayList<>();
        for (String part : t1.split("\\*")) {
            parts.add(part);
        }
        for (String part : t2.split("\\*")) {
            parts.add(part);
        }

        Collections.sort(parts);

        StringBuilder sb = new StringBuilder();
        for (String part : parts) {
            sb.append(part + "*");
        }

        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }

        return sb.toString();
    }


    class Expr {
        public Map<String, Integer> terms;

        public Expr(String term, int val) {
            terms = new HashMap<>();
            terms.put(term, val);
        }
    }

	
	public static void main(String[] args) {
		Solution solution = new Solution();

        String expression = "";
        String[] evalvars = new String[]{};
        int[] evalints = {};
        List<String> list = solution.basicCalculatorIV(expression, evalvars, evalints);
        System.out.println(list);
//        Assert.assertEquals(1, num);

    }



}
