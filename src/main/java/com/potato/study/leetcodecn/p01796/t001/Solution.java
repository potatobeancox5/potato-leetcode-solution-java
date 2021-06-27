package com.potato.study.leetcodecn.p01796.t001;

import com.potato.study.leetcode.util.LeetcodeInputUtils;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * 1796. 字符串中第二大的数字
 *
 * 给你一个混合字符串 s ，请你返回 s 中 第二大 的数字，如果不存在第二大的数字，请你返回 -1 。

 混合字符串 由小写英文字母和数字组成。

  

 示例 1：

 输入：s = "dfa12321afd"
 输出：2
 解释：出现在 s 中的数字包括 [1, 2, 3] 。第二大的数字是 2 。
 示例 2：

 输入：s = "abc1111"
 输出：-1
 解释：出现在 s 中的数字只包含 [1] 。没有第二大的数字。
  

 提示：

 1 <= s.length <= 500
 s 只包含小写英文字母和（或）数字。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/second-largest-digit-in-a-string
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     *
     * @param s
     * @return
     */
    public int secondHighest(String s) {
        if ("".equals(s)) {
            return -1;
        }
        int[] count = new int[10];
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                count[ch - '0']++;
            }
        }
        int big = 0;
        for (int i = 9; i >= 0; i--) {
            if (count[i] > 0) {
                big++;
            }
            if (big == 2) {
                return i;
            }
        }
        return -1;
    }



    public static void main(String[] args) {

    }
}
