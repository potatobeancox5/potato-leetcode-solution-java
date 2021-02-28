package com.potato.study.leetcodecn.p00096.t001;


import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * 96. 不同的二叉搜索树
 *
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？

 示例:

 输入: 3
 输出: 5
 解释:
 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:

 1         3     3      2      1
 \       /     /      / \      \
 3     2     1      1   3      2
 /     /       \                 \
 2     1         2                 3

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/unique-binary-search-trees
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    private Map<String, Integer> countMap;

    /**
     * 也是 dfs 任意 从 1-n 选择一个点作为 当前的节点值 然后将 【1， n】 划分为 【1， i-1】，【i+1，n】递归生成子树 ，统计数字即可
     * @param n
     * @return
     */
    public int numTrees(int n) {
        countMap = new HashMap<>();
        return getNumTrees(1, n);
    }


    /**
     * 递归获取 数量
     * @param start
     * @param end
     * @return
     */
    private int getNumTrees(int start, int end) {
        // 0 map 记忆搜索剪枝
        String key = start + "_" + end;
        Integer count = countMap.get(key);
        if (count != null) {
            return count;
        }
        // 终止条件 递归
        if (start == end) {
            return 1;
        }
        if (start > end) {
            return 0;
        }
        // 1. 任意 从 1-n 选择一个点作为 当前的节点值 然后将
        int totalCount = 0;
        for (int i = start; i <= end; i++) {
            // 2. 然后将 【1， n】 划分为 【1， i-1】，【i+1，n】递归生成子树 ，统计数字即可 用一个 map 缓存 结果
            int left = getNumTrees(start, i - 1);
            int right = getNumTrees(i + 1, end);
            // left 和 right 组合数
            if (left == 0 || right == 0) {
                totalCount += (left + right);
            } else {
                totalCount += left * right;
            }

        }
        // 3. map 缓存 结果
        countMap.put(key, totalCount);
        return totalCount;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int numTrees = solution.numTrees(1);
        System.out.println(numTrees);
        Assert.assertSame(1, numTrees);

        numTrees = solution.numTrees(3);
        System.out.println(numTrees);
        Assert.assertSame(5, numTrees);
    }
}
