package com.potato.study.leetcode.p0592;

/**
 * 
 * @author liuzhao11
 * 
 *         592. Fraction Addition and Subtraction
 * 
 *         Given a string representing an expression of fraction addition and subtraction, you need to return the calculation result in string format. The final result should be irreducible fraction. If your final result is an integer, say 2, you need to change it to the format of fraction that has denominator 1. So in this case, 2 should be converted to 2/1.

Example 1:
Input:"-1/2+1/2"
Output: "0/1"
Example 2:
Input:"-1/2+1/2+1/3"
Output: "1/3"
Example 3:
Input:"1/3-1/2"
Output: "-1/6"
Example 4:
Input:"5/3+1/3"
Output: "2/1"
Note:
The input string only contains '0' to '9', '/', '+' and '-'. So does the output.
Each fraction (input and output) has format ±numerator/denominator. If the first input fraction or the output is positive, then '+' will be omitted.
The input only contains valid irreducible fractions, where the numerator and denominator of each fraction will always be in the range [1,10]. If the denominator is 1, it means this fraction is actually an integer in a fraction format defined above.
The number of given fractions will be in the range [1,10].
The numerator and denominator of the final result are guaranteed to be valid and in the range of 32-bit int.
 * 
 * 
 *         思路：
 *
 *         592. Fraction Addition and Subtraction


https://www.jianshu.com/p/880baecb524f



使用scanner 函数 分割字符串 Scanner(expression).useDelimiter

totalA 总分子
totalB 总分母


for e 分数
求和
找到gcd  of 分子分母 分子分母 除gcd

拼结果
 *
 *       
 *          
 */
public class Solution {

    public String fractionAddition(String expression) {



        return null;
    }

    // 递归遭到最大公约数


    public static void main(String[] args) {
		Solution solution = new Solution();
        String expression = "";
        String sum = solution.fractionAddition(expression);
        System.out.println(sum);
    }
}
