package com.potato.study.leetcodecn.p01189.t001;

import org.junit.Assert;

/**
 * 1189. “气球” 的最大数量
 *
 * 给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。

 字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。

  

 示例 1：



 输入：text = "nlaebolko"
 输出：1
 示例 2：



 输入：text = "loonbalxballpoon"
 输出：2
 示例 3：

 输入：text = "leetcode"
 输出：0
  

 提示：

 1 <= text.length <= 10^4
 text 全部由小写英文字母组成

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/maximum-number-of-balloons
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 统计 text 中 每次出现的字母 数量
     * 然后 按照 balloon 计算最多有多少个
     * @param text
     * @return
     */
    public int maxNumberOfBalloons(String text) {
        if (null == text) {
            return 0;
        }
        int[] count = new int[26];
        for (char ch : text.toCharArray()) {
            count[ch - 'a']++;
        }
        int max = count[0];
        max = Math.min(max, count[1]);
        max = Math.min(max, count['l' - 'a'] / 2);
        max = Math.min(max, count['o' - 'a'] / 2);
        max = Math.min(max, count['n' - 'a']);
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String text = "nlaebolko";
        int max = solution.maxNumberOfBalloons(text);
        System.out.println(max);
        Assert.assertEquals(1, max);

        text = "loonbalxballpoon";
        max = solution.maxNumberOfBalloons(text);
        System.out.println(max);
        Assert.assertEquals(2, max);

        text = "leetcode";
        max = solution.maxNumberOfBalloons(text);
        System.out.println(max);
        Assert.assertEquals(0, max);
    }
}
