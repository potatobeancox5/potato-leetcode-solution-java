package com.potato.study.leetcodecn.p01006.t001;

import java.util.Stack;

import org.junit.Assert;

/**
 * 1006. 笨阶乘
 *
 * 通常，正整数 n 的阶乘是所有小于或等于 n 的正整数的乘积。例如，factorial(10) = 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1。
 *
 * 相反，我们设计了一个笨阶乘 clumsy：在整数的递减序列中，我们以一个固定顺序的操作符序列来依次替换原有的乘法操作符：乘法(*)，除法(/)，加法(+)和减法(-)。
 *
 * 例如，clumsy(10) = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 *
 * 1。然而，这些运算仍然使用通常的算术运算顺序：我们在任何加、减步骤之前执行所有的乘法和除法步骤，并且按从左到右处理乘法和除法步骤。
 *
 * 另外，我们使用的除法是地板除法（floor division），所以 10 * 9 / 8 等于 11。这保证结果是一个整数。
 *
 * 实现上面定义的笨函数：给定一个整数 N，它返回 N 的笨阶乘。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：4
 * 输出：7
 * 解释：7 = 4 * 3 / 2 + 1
 * 示例 2：
 *
 * 输入：10
 * 输出：12
 * 解释：12 = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1
 *  
 *
 * 提示：
 *
 * 1 <= N <= 10000
 * -2^31 <= answer <= 2^31 - 1  （答案保证符合 32 位整数。）
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/clumsy-factorial
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {


//
    // 1006
    public int clumsy(int n) {
        char[] op = new char[] {
                '*','/','+','-'
        };
        // 一个操作数栈 一样op栈
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> opStack = new Stack<>();
        int index = 0;
        for (int i = n; i > 0 ; i--) {
            // 数字入栈
            numStack.push(i);
            if (i == 1) {
                continue;
            }
            // 操作符 获取
            char currentOp = op[index];
            index++;
            index %= op.length;
            // 操作符栈空 入栈 否则比较 如果peek 操作符优先级大于等于 当前 先算栈里边的
            if (opStack.isEmpty()) {
                opStack.push(currentOp);
                continue;
            }
            while (!opStack.isEmpty() && getOpPriority(opStack.peek()) >= getOpPriority(currentOp)) {
                int num2 = numStack.pop();
                int num1 = numStack.pop();
                int res = compute(num1, num2, opStack.pop());
                numStack.push(res);
            }
            opStack.push(currentOp);
        }
        // 计算最终的操作符号
        while (!opStack.isEmpty()) {
            int num2 = numStack.pop();
            int num1 = numStack.pop();
            int res = compute(num1, num2, opStack.pop());
            numStack.push(res);
        }
        // 枚举 n 进行计算 求值
        return numStack.peek();
    }

    private int getOpPriority(char op) {
        if (op == '*' || op == '/') {
            return 2;
        } else {
            return 1;
        }
    }

    private int compute(int num1, int num2, char op) {
        if (op == '+') {
            return num1 + num2;
        } else if (op == '-') {
            return num1 - num2;
        } else if (op == '*') {
            return num1 * num2;
        } else {
            return num1 / num2;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 5;
        int valid = solution.clumsy(n);
        System.out.println(valid);
        // 5 * 4 / 3 + 2 - 1 = 7
        Assert.assertEquals(7, valid);


        n = 10;
        valid = solution.clumsy(n);
        System.out.println(valid);
        // 12 = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1
        Assert.assertEquals(12, valid);
//
//        s = "aa";
//        valid = solution.isValid(s);
//        System.out.println(valid);
//        Assert.assertEquals(false, valid);
    }
}
