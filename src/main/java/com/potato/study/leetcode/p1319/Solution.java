package com.potato.study.leetcode.p1319;


/**
 * 
 * @author liuzhao11
 * 
 * 	1319. Number of Operations to Make Network Connected
 *  
 *
There are n computers numbered from 0 to n-1 connected by ethernet cables connections forming a network where connections[i] = [a, b] represents a connection between computers a and b. Any computer can reach any other computer directly or indirectly through the network.

Given an initial computer network connections. You can extract certain cables between two directly connected computers, and place them between any pair of disconnected computers to make them directly connected. Return the minimum number of times you need to do this in order to make all the computers connected. If it's not possible, return -1.



Example 1:



Input: n = 4, connections = [[0,1],[0,2],[1,2]]
Output: 1
Explanation: Remove cable between computer 1 and 2 and place between computers 1 and 3.
Example 2:



Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
Output: 2
Example 3:

Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
Output: -1
Explanation: There are not enough cables.
Example 4:

Input: n = 5, connections = [[0,1],[0,2],[3,4],[2,3]]
Output: 0


Constraints:

1 <= n <= 10^5
1 <= connections.length <= min(n*(n-1)/2, 10^5)
connections[i].length == 2
0 <= connections[i][0], connections[i][1] < n
connections[i][0] != connections[i][1]
There are no repeated connections.
No two computers are connected by more than one cable.
 *         
 *         思路：
 *          https://leetcode-cn.com/problems/number-of-operations-to-make-network-connected/solution/qing-xi-tu-jie-jing-zhi-de-bing-cha-ji-mo-ban-by-h/
 *
 *
 *
 *
 */
public class Solution {

    int[] father;
    int[] sz;
    int num;

    public int find(int p) {
        if (p != father[p]) {
            p = find(father[p]);
        }
        return p;
    }
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) {
            return;
        }
        num -= 1;
        if (sz[i] < sz[j]) {
            father[i] = j;
            sz[j] += sz[i];
        } else {
            father[j] = i;
            sz[i] += sz[j];
        }
    }

    public void initUF(int n) {
        father = new int[n];
        sz = new int[n];
        num = n;
        for (int i = 0; i < n; i++) {
            father[i] = i;
            sz[i] = 1;
        }
    }
    public int makeConnected(int n, int[][] connections) {
        initUF(n);
        // 多余的线缆数量
        int cnt = 0;
        for (int[] c : connections) {
            int f = c[0], t = c[1];
            // 两个点已经连通，不需要这个线缆
            if (find(f) == find(t)) {
                cnt += 1;
                continue;
            }
            union(f, t);
        }
        // 所需要的线缆数量
        int cnt2 = num - 1;
        if (cnt < cnt2) {
            return -1;
        }
        return cnt2;
    }

}
