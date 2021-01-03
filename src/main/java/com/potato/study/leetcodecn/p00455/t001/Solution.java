package com.potato.study.leetcodecn.p00455.t001;

import org.junit.Assert;

import java.util.Arrays;

/**
 * 455. 分发饼干
 *
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。

 注意：

 你可以假设胃口值为正。
 一个小朋友最多只能拥有一块饼干。

 示例 1:

 输入: [1,2,3], [1,1]

 输出: 1

 解释:
 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
 所以你应该输出1。
 示例 2:

 输入: [1,2], [1,2,3]

 输出: 2

 解释:
 你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
 你拥有的饼干数量和尺寸都足以让所有孩子满足。
 所以你应该输出2.

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/assign-cookies
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 贪心算法
     * 将 sg 从小到大排序
     * 对于每个孩子 找到第一个比他胃口大的饼干即可，
     * 剪枝
     *  对于任意一个孩子 遍历到饼干末尾都没有找到合适的饼干 直接break吧
     * @param g 每个孩子的胃口
     * @param s 饼干的大小
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int index = 0;
        int satisfyNum = 0;

        for (int i = 0; i < g.length; i++) {
            while (index < s.length && s[index] < g[i]) {
                index++;
            }
            // 剪枝
            if (index == s.length) {
                break;
            } else {
                // found
                satisfyNum++;
                index++;
            }
        }
        return satisfyNum;
    }


    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] g = new int[]{1,2,3};
        int[] s = new int[]{1,1};
        int contentChildren = solution.findContentChildren(g, s);
        System.out.println(contentChildren);
        Assert.assertEquals(1, contentChildren);

        g = new int[]{1,2};
        s = new int[]{1,2,3};
        contentChildren = solution.findContentChildren(g, s);
        System.out.println(contentChildren);
        Assert.assertEquals(2, contentChildren);
    }
}
