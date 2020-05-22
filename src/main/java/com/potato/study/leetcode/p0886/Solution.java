package com.potato.study.leetcode.p0886;

import org.junit.Assert;

/**
 * @author liuzhao11
 *
 *
 * 886. Possible Bipartition
 *
 *
 * Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.

Each person may dislike some other people, and they should not go into the same group.

Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.

Return true if and only if it is possible to split everyone into two groups in this way.



Example 1:

Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
Output: true
Explanation: group1 [1,4], group2 [2,3]
Example 2:

Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
Output: false
Example 3:

Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
Output: false


Note:

1 <= N <= 2000
0 <= dislikes.length <= 10000
1 <= dislikes[i][j] <= N
dislikes[i][0] < dislikes[i][1]
There does not exist i != j for which dislikes[i] == dislikes[j].

 *
 *
 * 题目含义：
 *      https://leetcode-cn.com/problems/possible-bipartition/solution/javaunion-findgai-jin-guo-de-bing-cha-ji-zuo-fa-by/
 *      并查集合
 * 思路：
 */
public class Solution {

    public boolean possibleBipartition(int n, int[][] dislikes) {
        UnionFind uf = new UnionFind(n * 2 + 1);
        for (int i = 0; i < dislikes.length; i++) {
            //查找自己的根节点
            int x = uf.find(dislikes[i][0]);
            //不喜欢的人的根节点
            int y = uf.find(dislikes[i][1]);
            //查找自己不喜欢的人群根节点
            int a = uf.find(dislikes[i][0] + n);
            // 自己不喜欢的人不喜欢的人群节点
            int b = uf.find(dislikes[i][1] + n);
            if(x == y) {
                //发现这俩人已经在一组，GG
                return false;
            }
            else{
                // Union persons that are disliked
                uf.union(y, a);
                uf.union(b, x);
            }
        }
        return true;
    }

    /**
     * 并查集
     */
    class UnionFind {
        // 根数量
        public int roots;
        // val 是 其上层的祖先
        public int[] parent;

        public UnionFind(int size) {
            // 每个结点的 祖先都是自己
            this.roots = size;
            this.parent = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        /**
         * qp 连接
         * @param p
         * @param q
         */
        public void union(int p, int q) {
            int rootP = parent[p];
            int rootQ = parent[q];

            if (rootP != rootQ) {
                parent[rootP] = rootQ;
                roots--;
            }

            return;
        }

        /**
         * 找到 p 对应的 祖先
         * @param p
         * @return
         */
        public int find(int p) {
            while (p != parent[p]) {
                p = parent[parent[p]];
            }
            return p;
        }

        /**
         * 判断 p q 是否连接
         * @param p
         * @param q
         * @return
         */
        public boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }
    }


    public static void main(String[] args) {
		Solution solution = new Solution();

        int n = 4;
        int[][] dislikes = new int[][]{{1,2},{1,3},{2,4}};
        boolean res = solution.possibleBipartition(n, dislikes);
        System.out.println(res);
        Assert.assertEquals(true, res);
    }
}
