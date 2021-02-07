package com.potato.study.leetcodecn.p00028.t001;

import org.junit.Assert;

/**
 * 28. 实现 strStr()
 *
 * 实现 strStr() 函数。

 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

 示例 1:

 输入: haystack = "hello", needle = "ll"
 输出: 2
 示例 2:

 输入: haystack = "aaaaa", needle = "bba"
 输出: -1
 说明:

 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/implement-strstr
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 遍历 haystack 返回
     * 其实就是 kmp 算法
     * 说下 kmp 的思想
     * 子串 和 原来的串
     * 首先比较 假设 i 原串 j子串 之前 的均可以匹配上，如果 ij能够对的上 i++ j++
     * 否则 与i 比较的位置就是 next [j-1] + 1, 边界情况 j == 0 那就直接从头开始吧
     * 然后 比较j 是不是已经到了 子串的最后位置，到了的话 返回 true 本题就是 返回 i 对应位置 减去 子串的长度
     *
     *
     *
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        // 边界条件
        if ("".equals(needle) || needle == null) {
            return 0;
        }
        if (null == haystack || "".equals(haystack)) {
            return -1;
        }

        // 遍历 hay stack 查找 needle 正常是会生成next 数组 作为查找的下一步指向
        int[] nextArray = this.getNextArray(needle);
        // 对于 haystack 每一个位置 找到位置与之进行匹配，如果不匹配就一直找，匹配了 ij 均++
        int j = -1;
        // j 标识 已经比较完了 子串的index
        for (int i = 0; i < haystack.length(); i++) {
            // 如果不匹配就一直找，匹配了 ij 均++
            while (j >= 0 && haystack.charAt(i) != needle.charAt(j+1)) {
                j = nextArray[j];
            }
            if (haystack.charAt(i) == needle.charAt(j+1)) {
                j++;
            }
            // 已经比较完了 所有位置 结果满意
            if (j == needle.length() - 1) {
                return i - needle.length() + 1;
            }
        }
        return -1;
    }

    /**
     * next 数组的生成办法，
     * 先说下next的业务含义是什么，next j = i 说明 从0到i的 字符串 可以与从 x-j 位置匹配
     * 这样一旦 j + 1 不能匹配，就可用继续从 next[j] + 1 开始有当前位置 主串字符进行比较
     *
     * 如果 没有字符可以与  x-j 位置 匹配，那么返回  -1
     * @param needle
     * @return
     */
    private int[] getNextArray(String needle) {
        // next数组
        int[] result = new int[needle.length()];
        // 第一个位置 肯定是没有匹配的
        result[0] = -1;
        // 子串中 已经比较完了的位置
        int index = -1;
        for (int i = 1; i < needle.length(); i++) {
            // 子串中下一个比较位置
            // 循环找到第一个 匹配的位置
            while (index >= 0 && needle.charAt(i) != needle.charAt(index + 1)) {
                index = result[index];
            }
            int currentIndex = index + 1;
            // 当前串 可以再进进一步
            if (needle.charAt(i) == needle.charAt(currentIndex)) {
                index++;
            }
            // 匹配了就是 index， 匹配不上就是 -1
            result[i] = index;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String haystack = "hello";
        String needle = "ll";
        int index = solution.strStr(haystack, needle);
        System.out.println(index);
        Assert.assertEquals(2, index);

        haystack = "aaaaa";
        needle = "bba";
        index = solution.strStr(haystack, needle);
        System.out.println(index);
        Assert.assertEquals(-1, index);

        haystack = "";
        needle = "";
        index = solution.strStr(haystack, needle);
        System.out.println(index);
        Assert.assertEquals(0, index);

        haystack = "a";
        needle = "";
        index = solution.strStr(haystack, needle);
        System.out.println(index);
        Assert.assertEquals(0, index);

        haystack = "aaa";
        needle = "aaaa";
        index = solution.strStr(haystack, needle);
        System.out.println(index);
        Assert.assertEquals(-1, index);

        haystack = "mississippi";
        needle = "issip";
        index = solution.strStr(haystack, needle);
        System.out.println(index);
        Assert.assertEquals(4, index);
    }
}
