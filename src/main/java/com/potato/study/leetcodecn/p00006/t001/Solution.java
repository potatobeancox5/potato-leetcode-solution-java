package com.potato.study.leetcodecn.p00006.t001;

import org.junit.Assert;

/**
 * 6. Z 字形变换
 *
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。

 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：

 L   C   I   R
 E T O E S I I G
 E   D   H   N
 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。

 请你实现这个将字符串进行指定行数变换的函数：

 string convert(string s, int numRows);
 示例 1:

 输入: s = "LEETCODEISHIRING", numRows = 3
 输出: "LCIRETOESIIGEDHN"
 示例 2:

 输入: s = "LEETCODEISHIRING", numRows = 4
 输出: "LDREOEIIECIHNTSG"
 解释:

 L     D     R
 E   O E   I I
 E C   I H   N
 T     S     G

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/zigzag-conversion
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {


    /**
     *
     *
     *其实没那么难
     * 1.创建 Stringbuilder 数组 numRows 个 每个元素代表一行
     * 2.遍历s，每个位置ch 一次从第一行的Stringbuilder 放到最后一行的 Stringbuilder，再往回方
     * 3.遍历 Stringbuilder 数组 拼接结果
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (null == s || s.length() == 0) {
            return "";
        }
        if (numRows == 1) {
            return s;
        }
        // 1.创建 Stringbuilder 数组 numRows 个 每个元素代表一行
        StringBuilder[] stringBuilderArr = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            stringBuilderArr[i] = new StringBuilder();
        }
        // 2.遍历s，每个位置ch 一次从第一行的Stringbuilder 放到最后一行的 Stringbuilder，再往回方
        int lineIndex = 0;
        boolean goingDown = true;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            stringBuilderArr[lineIndex].append(ch);
            // lineIndex 移动
            if (goingDown) {
                lineIndex++;
                if (lineIndex == numRows) {
                    goingDown = false;
                    lineIndex = numRows - 2;
                }
            } else {
                lineIndex--;
                if (lineIndex < 0) {
                    goingDown = true;
                    lineIndex = 1;
                }
            }
        }
        // 3.遍历 Stringbuilder 数组 拼接结果
        StringBuilder total = new StringBuilder();
        for (StringBuilder stringBuilder : stringBuilderArr) {
            total.append(stringBuilder);
        }
        return total.toString();
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        String s = "LEETCODEISHIRING";
        int numRows = 3;
        String res = solution.convert(s, numRows);
        System.out.println(res);
        Assert.assertEquals("LCIRETOESIIGEDHN", res);

        s = "LEETCODEISHIRING";
        numRows = 4;
        res = solution.convert(s, numRows);
        System.out.println(res);
        Assert.assertEquals("LDREOEIIECIHNTSG", res);
    }

}
