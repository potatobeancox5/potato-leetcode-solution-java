package com.potato.study.leetcodecn.p00684.t001;

import java.util.Stack;

/**
 * 684. 冗余连接
 *
 * 树可以看成是一个连通且 无环 的 无向 图。
 *
 * 给定往一棵 n 个节点 (节点值 1～n) 的树中添加一条边后的图。添加的边的两个顶点包含在 1 到 n 中间，且这条附加的边不属于树中已存在的边。图的信息记录于长度为 n 的二维数组 edges ，edges[i] =
 * [ai, bi] 表示图中在 ai 和 bi 之间存在一条边。
 *
 * 请找出一条可以删去的边，删除后可使得剩余部分是一个有着 n 个节点的树。如果有多个答案，则返回数组 edges 中最后出现的边。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入: edges = [[1,2], [1,3], [2,3]]
 * 输出: [2,3]
 * 示例 2：
 *
 *
 *
 * 输入: edges = [[1,2], [2,3], [3,4], [1,4], [1,5]]
 * 输出: [1,4]
 *  
 *
 * 提示:
 *
 * n == edges.length
 * 3 <= n <= 1000
 * edges[i].length == 2
 * 1 <= ai < bi <= edges.length
 * ai != bi
 * edges 中无重复元素
 * 给定的图是连通的 
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/redundant-connection
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {



    // 684 并查集 union find
    public int[] findRedundantConnection(int[][] edges) {
        // 顶点个数
        int n = edges.length;
        // 声明 并查集
        UnionFind unionFind = new UnionFind(n);
        // 遍历 edges 判断 当前 edge 对应是够在同一个连通分量里边 在的话 直接返回这个边
        for (int[] edge : edges) {
            int parent1 = unionFind.find(edge[0]);
            int parent2 = unionFind.find(edge[1]);
            if (parent1 == parent2) {
                return edge;
            }
            unionFind.union(parent1, parent2);
        }
        return null;
    }

    // 并查集实现类
    class UnionFind {
        // 节点个数
        private int n;
        private int[] parent;

        /**
         * 创建并查集和
         * @param n
         */
        public UnionFind(int n) {
            this.n = n;
            this.parent = new int[n+1];
            // init parent
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }
        }

        // 找到 target 对应的 最开始节点
        public int find(int target) {
            int i = target;
            while (parent[i] != i) {
                i = parent[i];
            }
            return i;
        }

        // 合并
        public void union(int target1, int target2) {
            int parent1 = find(target1);
            int parent2 = find(target2);
            if (parent1 == parent2) {
                return;
            }
            parent[parent1] = parent2;
        }
    }
}
