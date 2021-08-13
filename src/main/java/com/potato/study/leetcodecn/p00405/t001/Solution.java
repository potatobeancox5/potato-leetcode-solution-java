package com.potato.study.leetcodecn.p00405.t001;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * 405. 数字转换为十六进制数
 *
 * 给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。

 注意:

 十六进制中所有字母(a-f)都必须是小写。
 十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，十六进制字符串中的第一个字符将不会是0字符。 
 给定的数确保在32位有符号整数范围内。
 不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。
 示例 1：

 输入:
 26

 输出:
 "1a"
 示例 2：

 输入:
 -1

 输出:
 "ffffffff"

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/convert-a-number-to-hexadecimal
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 直接转
     * @param num
     * @return
     */
    public String toHex(int num) {
        // 因为 int 是 32 位的 将其分成 8分 即可 首先转成2进制 数组
        int[] bit = new int[32];
        int index = bit.length - 1;
        while (num != 0) {
            int thisBit = num & 1;
            bit[index--] = thisBit;
            // 无符号右移
            num >>>= 1;
        }
        // 每 4个二进制位 进行一次合并 生成一个 数字
        char[] hexChar = new char[]{
                '0', '1', '2', '3', '4', '5', '6', '7',
                '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
        };
        // 查表获取对应字母
        StringBuilder resultBuilder = new StringBuilder();
        int tmp = 0;
        for (int i = 0; i < bit.length; i++) {
            tmp <<= 1;
            tmp += bit[i];
            // 如果是4
            if (i % 4 == 3) {
                char ch = hexChar[tmp];
                resultBuilder.append(ch);
                tmp = 0;
            }
        }
        // 返回 之前去除先导0
        while (resultBuilder.length() > 1 && resultBuilder.charAt(0) == '0') {
            resultBuilder.deleteCharAt(0);
        }
        return resultBuilder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int num = 26;
        String s = solution.toHex(num);
        System.out.println(s);
        Assert.assertEquals("1a", s);

        num = -1;
        s = solution.toHex(num);
        System.out.println(s);
        Assert.assertEquals("ffffffff", s);
    }
}
