package com.potato.study.leetcodecn.p00166.t001;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

/**
 * 166. 分数到小数
 *
 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数 。

 如果小数部分为循环小数，则将循环的部分括在括号内。

 如果存在多个答案，只需返回 任意一个 。

 对于所有给定的输入，保证 答案字符串的长度小于 104 。

  

 示例 1：

 输入：numerator = 1, denominator = 2
 输出："0.5"
 示例 2：

 输入：numerator = 2, denominator = 1
 输出："2"
 示例 3：

 输入：numerator = 2, denominator = 3
 输出："0.(6)"
 示例 4：

 输入：numerator = 4, denominator = 333
 输出："0.(012)"
 示例 5：

 输入：numerator = 1, denominator = 5
 输出："0.2"
  

 提示：

 -231 <= numerator, denominator <= 231 - 1
 denominator != 0

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/fraction-to-recurring-decimal
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    /**
     * 166

     https://leetcode-cn.com/problems/fraction-to-recurring-decimal/

     被除数 除数

     符号位置判断

     正数处理

     如果 被除数大于等于除数
     除了k.  计算余数 给到被除数
     小于
     0.


     被除数 *=10


     while 循环做上面的东西

     每次把除法结果刚到 map中 value 是出现过的indez
     int numerator, int denominator
     再次出现的时候就知道
     xfirst appear 到
     * @param intNumerator
     * @param intDenominator
     * @return
     */
    public String fractionToDecimal(int intNumerator, int intDenominator) {
        long numerator = intNumerator;
        long denominator = intDenominator;
        // 处理 符号
        boolean isNegtive = false;
        if (numerator * denominator < 0) {
            isNegtive = true;
        }
        if (numerator < 0) {
            numerator *= -1;
        }
        if (denominator < 0) {
            denominator *= -1;
        }
        // 处理整数部分
        long numPart = numerator / denominator;
        long remind = numerator % denominator;
        if (remind == 0) {
            if (isNegtive) {
                numPart *= -1;
            }
            return String.valueOf(numPart);
        }
        // 记录 当前被除数出现的位置 的map
        Map<Long, Integer> appearIndexMap = new HashMap<>();
        StringBuilder builder = new StringBuilder();
        builder.append(numPart);
        builder.append(".");
        // 如果不能整除 循环使用余数 * 10 进行除法 ，利用map 记录每次出现的结果 和出现的位置 那么就是 （）增加的位置
        numerator = remind * 10;
        while (numerator != 0) {
            // map 存在就完了
            long num = numerator / denominator;
            remind = numerator % denominator;
            appearIndexMap.put(numerator, builder.length());
            numerator = remind * 10;
            builder.append(num);
            // 下一个之前出现过 增加 （） 跳出
            if (appearIndexMap.containsKey(numerator)) {
                Integer firstIndex = appearIndexMap.get(numerator);
                builder.insert(firstIndex, "(");
                builder.append(")");
                break;
            }
        }
        if (isNegtive) {
            builder.insert(0, "-");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int numerator = 1;
        int denominator = 2;
        String s = solution.fractionToDecimal(numerator, denominator);
        System.out.println(s);
        Assert.assertEquals("0.5", s);

        numerator = 2;
        denominator = 3;
        s = solution.fractionToDecimal(numerator, denominator);
        System.out.println(s);
        Assert.assertEquals("0.(6)", s);

        numerator = 2;
        denominator = 1;
        s = solution.fractionToDecimal(numerator, denominator);
        System.out.println(s);
        Assert.assertEquals("2", s);

        numerator = -50;
        denominator = 8;
        s = solution.fractionToDecimal(numerator, denominator);
        System.out.println(s);
        Assert.assertEquals("-6.25", s);

        numerator = -1;
        denominator = -2147483648;
        s = solution.fractionToDecimal(numerator, denominator);
        System.out.println(s);
        Assert.assertEquals("0.0000000004656612873077392578125", s);
    }
}
