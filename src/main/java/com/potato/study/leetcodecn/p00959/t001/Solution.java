package com.potato.study.leetcodecn.p00959.t001;

import org.junit.Assert;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 959. 由斜杠划分区域
 *
 * 在由 1 x 1 方格组成的 N x N 网格 grid 中，每个 1 x 1 方块由 /、\ 或空格构成。这些字符会将方块划分为一些共边的区域。

 （请注意，反斜杠字符是转义的，因此 \ 用 "\\" 表示。）。

 返回区域的数目。

  

 示例 1：

 输入：
 [
   " /",
   "/ "
 ]
 输出：2
 解释：2x2 网格如下：

 示例 2：

 输入：
 [
   " /",
   "  "
 ]
 输出：1
 解释：2x2 网格如下：

 示例 3：

 输入：
 [
   "\\/",
   "/\\"
 ]
 输出：4
 解释：（回想一下，因为 \ 字符是转义的，所以 "\\/" 表示 \/，而 "/\\" 表示 /\。）
 2x2 网格如下：

 示例 4：

 输入：
 [
   "/\\",
   "\\/"
 ]
 输出：5
 解释：（回想一下，因为 \ 字符是转义的，所以 "/\\" 表示 /\，而 "\\/" 表示 \/。）
 2x2 网格如下：

 示例 5：

 输入：
 [
   "//",
   "/ "
 ]
 输出：3
 解释：2x2 网格如下：

  

 提示：

 1 <= grid.length == grid[0].length <= 30
 grid[i][j] 是 '/'、'\'、或 ' '。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/regions-cut-by-slashes
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 并查集应用
     * 讲每个 grid中的 字符 当做一个正方向，左右斜杠当做对角线，划分成4个部分，并对每个部分进行标号
     *
     *
     *
     * 并查集
     * union val1 val2 将两个点 合并成一个集合
     *      find va1
     *      find va2
     *      相同 罢辽
     *      不相同 将v2的 parent 弄成v1
     *      底层数组 存储 int【n】   数组中每个值保存的是其父亲点 初始保存其自身
     * find val 查找 val的最终付钱点
     *      while val ！= num【val】
     *          val = num【val】
     * 返回val
     *
     * 并查集合 维护一个count 初始是每个小模块数量，每次union --；
     * 到时候 直接返回count 即可
     * @param grid
     * @return
     */
    public int regionsBySlashes(String[] grid) {
        // 总共有多少个格子
        int total = 4 * grid.length * grid[0].length();
        // 初始化 并查集
        UnionFind unionFind = new UnionFind(total);
        // 遍历 grid
        int n = grid.length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                int start = 4 * (i * n + j);
                // 先进行单元格内部的合并
                char ch = grid[i].charAt(j);
                if ('/' == ch) {
                    unionFind.union(start, start + 3);
                    unionFind.union(start + 1, start + 2);
                } else if ('\\' == ch) {
                    unionFind.union(start, start + 1);
                    unionFind.union(start + 2, start + 3);
                } else {
                    // 空格
                    unionFind.union(start, start + 1);
                    unionFind.union(start, start + 2);
                    unionFind.union(start + 3, start + 2);
                }
                // 进行相邻单元格之间的合并 当前与左边 当前与前边
                if (i != 0) {
                    int kk = 4 * ((i-1) * n + j);
                    unionFind.union(start, kk + 2);
                }
                if (j != 0) {
                    int kk = start - 4;
                    unionFind.union(start + 3, kk + 1);
                }
            }
        }
        return unionFind.count;
    }


    class UnionFind {
        public int count;

        public int[] parent;

        public UnionFind(int count) {
            this.count = count;
            // 初始化 parent 数组
            this.parent = new int[count];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        /**
         * 将val1 和val2 链接
         * @param val1
         * @param val2
         */
        public void union (int val1, int val2) {
            int parent1 = find(val1);
            int parent2 = find(val2);
            if (parent1 == parent2) {
                return;
            }
            // parent1 的父亲搞成 parent2
            parent[parent1] = parent2;
            // 部分的数量减少
            count--;
        }

        /**
         * 查找val 对应的最上面 的父亲节点
         * @param val
         * @return
         */
        public int find(int val) {
            while (parent[val] != val) {
                val = parent[val];
            }
            return val;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] grid = new String[] {
                " /",
                "/ "
        };
        int i = solution.regionsBySlashes(grid);
        System.out.println(i);
        Assert.assertEquals(2, i);


        grid = new String[] {
               " /",
               "  "
        };
        i = solution.regionsBySlashes(grid);
        System.out.println(i);
        Assert.assertEquals(1, i);
    }
}
