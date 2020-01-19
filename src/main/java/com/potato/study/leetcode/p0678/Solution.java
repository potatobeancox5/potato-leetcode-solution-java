package com.potato.study.leetcode.p0678;

import org.junit.Assert;


/**
 * 
 * @author liuzhao11
 * 
 *         678. Valid Parenthesis String
 * 
 *         Given a string containing only three types of characters: '(', ')' and '*',
 *         write a function to check whether this string is valid. We define the validity of a string by these rules:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
An empty string is also valid.
Example 1:
Input: "()"
Output: True
Example 2:
Input: "(*)"
Output: True
Example 3:
Input: "(*))"
Output: True
Note:
The string size will be in the range [1, 100].
 *
 *         思路： 判断 给定 的字符串 是否是合法的，
 *
 *         解法2:
 *         最优解法，设两个变量cmin和cmax，cmin最少左括号的情况，cmax表示最多左括号的情况，其它情况在[cmin, cmax]之间。
 *         遍历字符串，遇到左括号时，cmin和cmax都自增1；
 *         当遇到右括号时，当cmin大于0时，cmin才自减1，否则保持为0(因为其它*情况可能会平衡掉)，而cmax减1；
 *         当遇到星号时，当cmin大于0时，cmin才自减1(当作右括号)，而cmax自增1(当作左括号)。
 *
 *         如果cmax小于0，说明到此字符时前面的右括号太多，有*也无法平衡掉，返回false。
 *         当循环结束后，返回cmin是否为0。
 *
 *         https://www.cnblogs.com/lightwindy/p/9746536.html
 *
 *
 */
public class Solution {

    /**
     * 通过 过程中 左括号最大值是否小于0 判定是否合法
     * @param str
     * @return
     */
    public boolean checkValidString(String str) {
        // 0 leftMin 左括号最小值 leftMax 左括号最大值
        int leftMin = 0;
        int leftMax = 0;
        // 1 遍历 str 3种情况
        for (char ch : str.toCharArray()) {
            if ('(' == ch) {
                // 2.1 (  min ++ and left ++
                leftMin++;
                leftMax++;
            } else if (')' == ch) {
                // 2.2 )  当cmin大于0时，cmin才自减1，否则保持为0  max--
                if (leftMin > 0) {
                    leftMin--;
                }
                leftMax--;

            } else if ('*' == ch) {
                // 2.3 *  当cmin大于0时，cmin才自减1，否则保持为0  cmax自增1
                if (leftMin > 0) {
                    leftMin--;
                }
                leftMax++;

            }

            if (leftMax < 0) {
                // 如果循环中出现 cmax 小于0 返回false
                return false;
            }
        }
        // 最后比较 cmin 是否为0
        return leftMin == 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String s = "";
        boolean res = solution.checkValidString(s);
        System.out.println(res);
        Assert.assertEquals(true, res);
    }
}
