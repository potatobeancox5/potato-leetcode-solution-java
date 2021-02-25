package com.potato.study.leetcodecn.p00405.t001;

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
     * 十六进制
     * 整数直接求
     * @param num
     * @return
     */
    public String toHex(int num) {
        return null;
    }

    private List<Integer> toBinary (int num) {
        List<Integer> result = new ArrayList<>();
        if (num == 0) {
            result.add(0);
            return result;
        }
        boolean isNegative = false;
        if (num < 0) {
            isNegative = true;
            num *= -1;
        }
        // 转成2进制
        while (num > 0) {

        }
        if (isNegative) {
            // 取反码
            for (int i = 0; i < result.size(); i++) {
                if (result.get(i) == 1) {
                    result.set(i, 0);
                } else {
                    result.set(i, 1);
                }
            }
            // 算补码
            for (int i = result.size() - 1; i >= 0; i--) {
//                result.get(i) + 1;
            }

        }
//        Integer integer = new Integer();
//        Integer.toHexString()
        return null;
    }
}
