package com.potato.study.leetcodecn.p01925.t001;

/**
 * 1925. 统计平方和三元组的数目
 *
 * 一个 平方和三元组 (a,b,c) 指的是满足 a2 + b2 = c2 的 整数 三元组 a，b 和 c 。

 给你一个整数 n ，请你返回满足 1 <= a, b, c <= n 的 平方和三元组 的数目。

  

 示例 1：

 输入：n = 5
 输出：2
 解释：平方和三元组为 (3,4,5) 和 (4,3,5) 。
 示例 2：

 输入：n = 10
 输出：4
 解释：平方和三元组为 (3,4,5)，(4,3,5)，(6,8,10) 和 (8,6,10) 。
  

 提示：

 1 <= n <= 250

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/count-square-sum-triples
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    public int countTriples(int n) {
        int count = 0;
        for (long i = 1; i <= n; i++) {
            for (long j = 1; j <= n; j++) {
                long target = i * i + j * j;
                long sqrt = (long)Math.sqrt(target + 1);
                if (sqrt <= n && sqrt * sqrt == target) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
//        String s = "daabcbaabcbc";
//        String part = "abc";
//        Solution solution = new Solution();
//        String s1 = solution.removeOccurrences(s, part);
//        System.out.println(s1);
//        Assert.assertEquals("dab", s1);
    }


}
