package com.potato.study.leetcodecn.p01319.t001;


import org.junit.Assert;

import com.potato.study.leetcode.domain.TreeNode;

/**
 * 1319. 连通网络的操作次数
 *
 * 用以太网线缆将 n 台计算机连接成一个网络，计算机的编号从 0 到 n-1。线缆用 connections 表示，其中 connections[i] = [a, b] 连接了计算机 a 和 b。
 *
 * 网络中的任何一台计算机都可以通过网络直接或者间接访问同一个网络中其他任意一台计算机。
 *
 * 给你这个计算机网络的初始布线 connections，你可以拔开任意两台直连计算机之间的线缆，并用它连接一对未直连的计算机。请你计算并返回使所有计算机都连通所需的最少操作次数。如果不可能，则返回 -1 。 
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：n = 4, connections = [[0,1],[0,2],[1,2]]
 * 输出：1
 * 解释：拔下计算机 1 和 2 之间的线缆，并将它插到计算机 1 和 3 上。
 * 示例 2：
 *
 *
 *
 * 输入：n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
 * 输出：2
 * 示例 3：
 *
 * 输入：n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
 * 输出：-1
 * 解释：线缆数量不足。
 * 示例 4：
 *
 * 输入：n = 5, connections = [[0,1],[0,2],[3,4],[2,3]]
 * 输出：0
 *  
 *
 * 提示：
 *
 * 1 <= n <= 10^5
 * 1 <= connections.length <= min(n*(n-1)/2, 10^5)
 * connections[i].length == 2
 * 0 <= connections[i][0], connections[i][1] < n
 * connections[i][0] != connections[i][1]
 * 没有重复的连接。
 * 两台计算机不会通过多条线缆连接。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-operations-to-make-network-connected
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    // 1319
    public int makeConnected(int n, int[][] connections) {
        // 如果 connection 数量少于 n-1 无论如何都完成不了链接
        if (connections.length < n-1) {
            return -1;
        }
        // 遍历 connection 利用 并查集 记录当前连通分量的个数
        UnionFind unionFind = new UnionFind(n);
        // 目前剩余的连通分量个数 为k 返回 k-1
        for (int[] connection : connections) {
            unionFind.union(connection[0], connection[1]);
        }
        return unionFind.apartCount - 1;
    }

    class UnionFind {
        public int[] parent;
        // 当前部分的数量
        public int apartCount;

        public UnionFind(int n) {
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            this.apartCount = n;
        }

        public void union(int target1, int target2) {
            int p1 = find(target1);
            int p2 = find(target2);
            if (p1 == p2) {
                return;
            }
            parent[p1] = p2;
            apartCount--;
        }

        public int find(int target) {
            while (parent[target] != target) {
                target = parent[target];
            }
            return target;
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 4;
        int[][] connections = new int[][] {
                {0,1},
                {0,2},
                {1,2}
        };
        int i = solution.makeConnected(n, connections);
        System.out.println(i);
        Assert.assertEquals(1, i);

        n = 6;
        connections = new int[][] {
                {0,1},
                {0,2},
                {0,3},
                {1,2},
                {1,3}
        };
        i = solution.makeConnected(n, connections);
        System.out.println(i);
        Assert.assertEquals(2, i);
        //        Solution solution = new Solution();
//        int[] nums = new int[]{1,1,2,3};
//        int[] res = solution.decompressRLElist(nums);
//        // [1,3,3]
//        System.out.println(Arrays.toString(res));
    }
}
