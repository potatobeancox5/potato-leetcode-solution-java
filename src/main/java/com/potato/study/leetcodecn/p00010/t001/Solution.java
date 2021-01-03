package com.potato.study.leetcodecn.p00010.t001;

import org.junit.Assert;

/**
 * 10. 正则表达式匹配
 *
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。

 '.' 匹配任意单个字符
 '*' 匹配零个或多个前面的那一个元素
 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。

 说明:

 s 可能为空，且只包含从 a-z 的小写字母。
 p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 示例 1:

 输入:
 s = "aa"
 p = "a"
 输出: false
 解释: "a" 无法匹配 "aa" 整个字符串。
 示例 2:

 输入:
 s = "aa"
 p = "a*"
 输出: true
 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 示例 3:

 输入:
 s = "ab"
 p = ".*"
 输出: true
 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 示例 4:

 输入:
 s = "aab"
 p = "c*a*b"
 输出: true
 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 示例 5:

 输入:
 s = "mississippi"
 p = "mis*is*p*."
 输出: false

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/regular-expression-matching
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * find i j 记录 使用 s串的前i个字符 能被 p的前j个字符匹配
     * 对于 j 有种可能 1小写字母 2. 3*
     * 如果是小写字母和.
     *  如果 ij 能够匹配的上 find i j = find i-1 j-1
     *  如果 ij 匹配不上 find i j = false
     *
     * 如果是 *， 要看 j-1 与 i-1，i-2,i-3 是否能匹配的上 或者不用 j-1
     *      if i == j-1 find ij = find i j-2 （不匹配任何字符）或者 find i-1 j 匹配了当前字符
     *      i != j-1  find ij = find i j-2
     *
     * 遍历方向：
     *   i 0 - len
     *      j 0 -len
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {

        // 如果前面有 *** 开头 那么就直接将 *** 去掉
        if (p.startsWith("*")) {
            return false;
        }

        boolean[][] find = new boolean[s.length()+1][p.length()+1];
        // 多一个位置 用来简化逻辑 （边界条件判断）find 0 0 代表没有匹配任何字符是的结果 0 其他 i == 0 结果使用推导计算
        find[0][0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j-1) == '*') {
                    // 能匹配上 有两种选择 使用这个系列通配符 或者不使用 通配符
                    if (mathChar(s, p, i-1, j-1-1)) {
                        find[i][j] = find[i][j - 2] || find[i - 1][j];
                    } else {
                        find[i][j] = find[i][j-2];
                    }
                } else {
                    // 当前不是通配符，那就匹配不上空
                    if (i == 0) {
                        find[i][j] = false;
                        continue;
                    }
                    // 不是通配符
                    if (mathChar(s, p, i-1, j-1)) {
                        find[i][j] = find[i-1][j-1];
                    } else {
                        find[i][j] = false;
                    }
                }
            }
        }

        return find[s.length()][p.length()];
    }

    /**
     * s 中 第i个 字母 是否能匹配上 p 中 第j个字母
     * @param s
     * @param p
     * @param i
     * @param j
     * @return
     */
    private boolean mathChar(String s, String p, int i, int j) {
        // 取不到字符串时 就返回false
        if (i < 0 || i >= s.length() || j < 0 || j >= p.length()) {
            return false;
        }
        // 万能匹配一个字符串
        if (p.charAt(j) == '.') {
            return true;
        }
        return s.charAt(i) == p.charAt(j);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String s = "aa";
        String p = "a";
        boolean match = solution.isMatch(s, p);
        System.out.println(match);
        Assert.assertEquals(false, match);


        s = "aa";
        p = "a*";
        match = solution.isMatch(s, p);
        System.out.println(match);
        Assert.assertEquals(true, match);


        s = "aaa";
        p = "a*";
        match = solution.isMatch(s, p);
        System.out.println(match);
        Assert.assertEquals(true, match);

        s = "ab";
        p = ".*";
        match = solution.isMatch(s, p);
        System.out.println(match);
        Assert.assertEquals(true, match);

        s = "aab";
        p = "c*a*b";
        match = solution.isMatch(s, p);
        System.out.println(match);
        Assert.assertEquals(true, match);

        s = "mississippi";
        p = "mis*is*p*.";
        match = solution.isMatch(s, p);
        System.out.println(match);
        Assert.assertEquals(false, match);



        s = "aa";
        p = "*a";
        match = solution.isMatch(s, p);
        System.out.println(match);
        Assert.assertEquals(false, match);

        s = "";
        p = ".*";
        match = solution.isMatch(s, p);
        System.out.println(match);
        Assert.assertEquals(true, match);
    }


}
