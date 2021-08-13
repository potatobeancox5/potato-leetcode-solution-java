package com.potato.study.leetcodecn.p00796.t001;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * 796. 旋转字符串
 *
 * 给定两个字符串, A 和 B。

 A 的旋转操作就是将 A 最左边的字符移动到最右边。 例如, 若 A = 'abcde'，在移动一次之后结果就是'bcdea' 。如果在若干次旋转操作之后，A 能变成B，那么返回True。

 示例 1:
 输入: A = 'abcde', B = 'cdeab'
 输出: true

 示例 2:
 输入: A = 'abcde', B = 'abced'
 输出: false
 注意：

 A 和 B 长度不超过 100。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/rotate-string
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     *
     * @param s
     * @param goal
     * @return
     */
    public boolean rotateString(String s, String goal) {
        if (s == null || goal == null) {
            return false;
        }
        if (s.length() != goal.length()) {
            return false;
        }
        // 从 s 的每个位置开始 比较 goal length 次 如果都成功 返回true
        for (int i = 0; i < s.length(); i++) {
            int index = i;
            boolean isSame = true;
            for (int j = 0; j < goal.length(); j++) {
                if (goal.charAt(j) == s.charAt(index)) {
                    index++;
                    index %= goal.length();
                } else {
                    isSame = false;
                    break;
                }
            }
            if (isSame) {
                return true;
            }
        }
        // 所有位置都比较完了 没有返回 就是没有匹配上
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String a = "abcde";
        String b = "cdeab";
        boolean res = solution.rotateString(a, b);
        System.out.println(res);
        Assert.assertEquals(true, res);
    }
}
