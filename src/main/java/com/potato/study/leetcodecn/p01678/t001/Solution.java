package com.potato.study.leetcodecn.p01678.t001;

import org.junit.Assert;

/**
 * 1678. 设计 Goal 解析器
 *
 * 请你设计一个可以解释字符串 command 的 Goal 解析器 。command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成。Goal 解析器会将 "G" 解释为字符串 "G"、"()" 解释为字符串 "o" ，"(al)" 解释为字符串 "al" 。然后，按原顺序将经解释得到的字符串连接成一个字符串。

 给你字符串 command ，返回 Goal 解析器 对 command 的解释结果。

  

 示例 1：

 输入：command = "G()(al)"
 输出："Goal"
 解释：Goal 解析器解释命令的步骤如下所示：
 G -> G
 () -> o
 (al) -> al
 最后连接得到的结果是 "Goal"
 示例 2：

 输入：command = "G()()()()(al)"
 输出："Gooooal"
 示例 3：

 输入：command = "(al)G(al)()()G"
 输出："alGalooG"
  

 提示：

 1 <= command.length <= 100
 command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/goal-parser-interpretation
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 遍历 command   找到左括号 往右找右括号 比较下标
     * @param command
     * @return
     */
    public String interpret(String command) {
        int leftIndex;
        int rightIndex;
        int index = 0;
        StringBuilder builder = new StringBuilder();
        while (index < command.length()) {
            StringBuilder tmp = new StringBuilder();
            // 找到 左括号
            while (index < command.length() && '(' != command.charAt(index) ) {
                builder.append(command.charAt(index));
                index++;
            }
            // 没有左边括号 直接返回
            if (index >= command.length()) {
                break;
            }
            leftIndex = index;
            index++;
            // 找到 右括号
            while (')' != command.charAt(index)) {
                tmp.append(command.charAt(index));
                index++;
            }
            rightIndex = index;
            index++;
            // 比较index 左右括号 相邻
            if (rightIndex - leftIndex == 1) {
                builder.append("o");
            } else {
                builder.append(tmp);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String command = "G()(al)";
        String interpret = solution.interpret(command);
        System.out.println(interpret);
        Assert.assertEquals("Goal", interpret);
    }
}
