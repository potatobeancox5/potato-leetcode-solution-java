package com.potato.study.leetcodecn.p01750.t001;

import java.util.Arrays;

import org.junit.Assert;

/**
 * 1750. 删除字符串两端相同字符后的最短长度
 *
 * 给你一个只包含字符 'a'，'b' 和 'c' 的字符串 s ，你可以执行下面这个操作（5 个步骤）任意次：
 *
 * 选择字符串 s 一个 非空 的前缀，这个前缀的所有字符都相同。
 * 选择字符串 s 一个 非空 的后缀，这个后缀的所有字符都相同。
 * 前缀和后缀在字符串中任意位置都不能有交集。
 * 前缀和后缀包含的所有字符都要相同。
 * 同时删除前缀和后缀。
 * 请你返回对字符串 s 执行上面操作任意次以后（可能 0 次），能得到的 最短长度 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "ca"
 * 输出：2
 * 解释：你没法删除任何一个字符，所以字符串长度仍然保持不变。
 * 示例 2：
 *
 * 输入：s = "cabaabac"
 * 输出：0
 * 解释：最优操作序列为：
 * - 选择前缀 "c" 和后缀 "c" 并删除它们，得到 s = "abaaba" 。
 * - 选择前缀 "a" 和后缀 "a" 并删除它们，得到 s = "baab" 。
 * - 选择前缀 "b" 和后缀 "b" 并删除它们，得到 s = "aa" 。
 * - 选择前缀 "a" 和后缀 "a" 并删除它们，得到 s = "" 。
 * 示例 3：
 *
 * 输入：s = "aabccabba"
 * 输出：3
 * 解释：最优操作序列为：
 * - 选择前缀 "aa" 和后缀 "a" 并删除它们，得到 s = "bccabb" 。
 * - 选择前缀 "b" 和后缀 "bb" 并删除它们，得到 s = "cca" 。
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 105
 * s 只包含字符 'a'，'b' 和 'c' 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-length-of-string-after-deleting-similar-ends
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * left right
     * @param s
     * @return
     */
    public int minimumLength(String s) {
        if (null == s) {
            return 0;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            while (left + 1 < right && s.charAt(left + 1) == s.charAt(left)) {
                left++;
            }
            while (left < right - 1 && s.charAt(right - 1) == s.charAt(right)) {
                right--;
            }
            // left right 相同 不相同跳出 相同继续
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
                continue;
            } else {
                break;
            }
        }
        // left 是否 小于等于 right 是的话返回 right - left + 1
        if (left <= right) {
            return right - left + 1;
        }
        // 返回 0
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "ca";
        int i = solution.minimumLength(str);
        System.out.println(i);
        Assert.assertEquals(2, i);

        str = "cabaabac";
        i = solution.minimumLength(str);
        System.out.println(i);
        Assert.assertEquals(0, i);

        str = "aabccabba";
        i = solution.minimumLength(str);
        System.out.println(i);
        Assert.assertEquals(3, i);
    }
}
