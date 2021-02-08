package com.potato.study.leetcodecn.p00925.t001;

import org.junit.Assert;

/**
 * 925. 长按键入
 *
 * 你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。

 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。

  

 示例 1：

 输入：name = "alex", typed = "aaleex"
 输出：true
 解释：'alex' 中的 'a' 和 'e' 被长按。
 示例 2：

 输入：name = "saeed", typed = "ssaaedd"
 输出：false
 解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样。
 示例 3：

 输入：name = "leelee", typed = "lleeelee"
 输出：true
 示例 4：

 输入：name = "laiden", typed = "laiden"
 输出：true
 解释：长按名字中的字符并不是必要的。
  

 提示：

 name.length <= 1000
 typed.length <= 1000
 name 和 typed 的字符都是小写字母。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/long-pressed-name
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 每次从name拿出一个字母，一旦匹配 往下找 如果不匹配，看下这个字母是不是跟之前遍历过的一一致，如果一致 type 往后找
     * 如果 不一致或者 之前没有字母，那就返回false
     * @param name
     * @param typed
     * @return
     */
    public boolean isLongPressedName(String name, String typed) {
        if (name == null) {
            return true;
        }
        if (typed == null) {
            return false;
        }
        int i = 0;
        int j = 0;
        while (i < name.length() && j < typed.length()) {
            char target = name.charAt(i);
            char input = typed.charAt(j);
            if (target == input) {
                i++;
                j++;
                continue;
            }
            // 字母不相同
            if (j == 0 || input != typed.charAt(j-1)) {
                return false;
            } else {
                j++;
            }
        }
        // 如果 没有到默认 一直看看是不是还是ok
        if (i < name.length()) {
            return false;
        }
        while (j < typed.length()) {
            char input = typed.charAt(j);
            // 字母不相同
            if (j == 0 || input != typed.charAt(j-1)) {
                return false;
            } else {
                j++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String name = "alex";
        String typed = "aaleex";
        boolean res = solution.isLongPressedName(name, typed);
        System.out.println(res);
        Assert.assertEquals(true, res);

        name = "saeed";
        typed = "ssaaedd";
        res = solution.isLongPressedName(name, typed);
        System.out.println(res);
        Assert.assertEquals(false, res);

        name = "alex";
        typed = "aaleexa";
        res = solution.isLongPressedName(name, typed);
        System.out.println(res);
        Assert.assertEquals(false, res);

    }


}
