package com.potato.study.leetcodecn.p00921.t001;

import org.junit.Assert;

/**
 * 921. 使括号有效的最少添加
 *
 * 给定一个由 '(' 和 ')' 括号组成的字符串 S，我们需要添加最少的括号（ '(' 或是 ')'，可以在任何位置），以使得到的括号字符串有效。

 从形式上讲，只有满足下面几点之一，括号字符串才是有效的：

 它是一个空字符串，或者
 它可以被写成 AB （A 与 B 连接）, 其中 A 和 B 都是有效字符串，或者
 它可以被写作 (A)，其中 A 是有效字符串。
 给定一个括号字符串，返回为使结果字符串有效而必须添加的最少括号数。

  

 示例 1：

 输入："())"
 输出：1
 示例 2：

 输入："((("
 输出：3
 示例 3：

 输入："()"
 输出：0
 示例 4：

 输入："()))(("
 输出：4
  

 提示：

 S.length <= 1000
 S 只包含 '(' 和 ')' 字符。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/minimum-add-to-make-parentheses-valid
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     *
     * @param str
     * @return
     */
    public int minAddToMakeValid(String str) {
        if (null == str || str.length() == 0) {
            return 0;
        }
        // 使用数字 记录其中的非法数字 （负数出现的绝对值最大值）or 技术时，正数的最大值
        int blocStatus = 0;
        int step = 0;
        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                // 单签是 （ 但是之前有多余的 ） 即小于0
                if (blocStatus < 0) {
                    step += Math.abs(blocStatus);
                    blocStatus = 0;
                }
                blocStatus++;
            } else if (ch == ')'){
                blocStatus--;
            }
        }
        // final conpute
        if (blocStatus > 0) {
            // (( 比较多
            step += blocStatus;
        } else if (blocStatus < 0) {
            step += Math.abs(blocStatus);
        }
        return step;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "())";
        int num = solution.minAddToMakeValid(str);
        System.out.println(num);
        Assert.assertEquals(1, num);

        str = "(((";
        num = solution.minAddToMakeValid(str);
        System.out.println(num);
        Assert.assertEquals(3, num);

        str = "()";
        num = solution.minAddToMakeValid(str);
        System.out.println(num);
        Assert.assertEquals(0, num);


        str = "()))((";
        num = solution.minAddToMakeValid(str);
        System.out.println(num);
        Assert.assertEquals(4, num);
    }


}
