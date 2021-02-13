package com.potato.study.leetcodecn.p00150.t001;

import com.potato.study.leetcode.util.LeetcodeInputUtils;
import org.junit.Assert;

import java.util.Stack;

/**
 * 150. 逆波兰表达式求值
 *
 * 根据 逆波兰表示法，求表达式的值。

 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。

  

 说明：

 整数除法只保留整数部分。
 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
  

 示例 1：

 输入: ["2", "1", "+", "3", "*"]
 输出: 9
 解释: 该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 示例 2：

 输入: ["4", "13", "5", "/", "+"]
 输出: 6
 解释: 该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
 示例 3：

 输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 输出: 22
 解释:
 该算式转化为常见的中缀算术表达式为：
 ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 = ((10 * (6 / (12 * -11))) + 17) + 5
 = ((10 * (6 / -132)) + 17) + 5
 = ((10 * 0) + 17) + 5
 = (0 + 17) + 5
 = 17 + 5
 = 22
  

 逆波兰表达式：

 逆波兰表达式是一种后缀表达式，所谓后缀就是指算符写在后面。

 平常使用的算式则是一种中缀表达式，如 ( 1 + 2 ) * ( 3 + 4 ) 。
 该算式的逆波兰表达式写法为 ( ( 1 2 + ) ( 3 4 + ) * ) 。
 逆波兰表达式主要有以下两个优点：

 去掉括号后表达式无歧义，上式即便写成 1 2 + 3 4 + * 也可以依据次序计算出正确结果。
 适合用栈操作运算：遇到数字则入栈；遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/evaluate-reverse-polish-notation
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {


    /**
     * 使用栈 实现 逆波兰表达式 求值
     * 遍历 token 遇到数字 push 进入 数字 stack 遇到操作符pop 两个 操作数 进行计算，
     * 并将 结果 插入 stack
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        if (null == tokens) {
            return 0;
        }
        int result = 0;
        // 操作数栈
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (isOperator(token)) {
                Integer op2 = stack.pop();
                // 对于 减法和除法， 被减数 和被除数 放在里边
                Integer op1 = stack.pop();
                int res = compute(op1, op2, token);
                stack.push(res);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        if (stack.isEmpty()) {
            return 0;
        }
        return stack.peek();
    }

    /**
     * 计算
     * @param op1
     * @param op2
     * @param token
     * @return
     */
    private int compute(Integer op1, Integer op2, String token) {
        int res = -1;
        switch (token) {
            case "+" :
                res = op1 + op2;
                break;
            case "-" :
                res = op1 - op2;
                break;
            case "*" :
                res = op1 * op2;
                break;
            case "/" :
                res = op1 / op2;
                break;
        }
        return res;
    }

    /**
     * 是否操作符
     * @param token
     * @return
     */
    private boolean isOperator(String token) {
        return "+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] tokens = LeetcodeInputUtils.inputString2StringArray("[\"2\",\"1\",\"+\",\"3\", \"*\"]");
        int res = solution.evalRPN(tokens);
        System.out.println(res);
        Assert.assertEquals(9, res);
    }
}
