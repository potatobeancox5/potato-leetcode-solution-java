package com.potato.study.leetcodecn.p01812.t001;

import org.junit.Assert;

/**
 * 1812. 判断国际象棋棋盘中一个格子的颜色
 *
 * 给你一个坐标 coordinates ，它是一个字符串，表示国际象棋棋盘中一个格子的坐标。下图是国际象棋棋盘示意图。



 如果所给格子的颜色是白色，请你返回 true，如果是黑色，请返回 false 。

 给定坐标一定代表国际象棋棋盘上一个存在的格子。坐标第一个字符是字母，第二个字符是数字。

  

 示例 1：

 输入：coordinates = "a1"
 输出：false
 解释：如上图棋盘所示，"a1" 坐标的格子是黑色的，所以返回 false 。
 示例 2：

 输入：coordinates = "h3"
 输出：true
 解释：如上图棋盘所示，"h3" 坐标的格子是白色的，所以返回 true 。
 示例 3：

 输入：coordinates = "c7"
 输出：false
  

 提示：

 coordinates.length == 2
 'a' <= coordinates[0] <= 'h'
 '1' <= coordinates[1] <= '8'

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/determine-color-of-a-chessboard-square
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * + 和 是偶数 那就是 黑色 否则是白色
     * @param coordinates
     * @return
     */
    public boolean squareIsWhite(String coordinates) {
        char[] chars = coordinates.toCharArray();
        int sum = (chars[1] - '0');
        sum += (chars[0] - 'a' + 1);
        return sum % 2 == 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean b = solution.squareIsWhite("a1");
        System.out.println(b);
        Assert.assertEquals(false, b);

    }
}
