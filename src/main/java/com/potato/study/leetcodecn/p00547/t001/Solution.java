package com.potato.study.leetcodecn.p00547.t001;


import org.junit.Assert;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 547. 省份数量
 *
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。

 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。

 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。

 返回矩阵中 省份 的数量。

  

 示例 1：


 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 输出：2
 示例 2：


 输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 输出：3
  

 提示：

 1 <= n <= 200
 n == isConnected.length
 n == isConnected[i].length
 isConnected[i][j] 为 1 或 0
 isConnected[i][i] == 1
 isConnected[i][j] == isConnected[j][i]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/number-of-provinces
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     *
     * 1. 使用一个visit set 记录已经访问过的点
     * 2. 遍历 isConnected for i 0 - n
     *      如果 当前i 访问过 continue
     *      没有 访问过 放入队列中 根据  isConnected i k 状态 决定 下一个访问的节点
     * @param isConnected
     * @return
     */
    public int findCircleNum(int[][] isConnected) {
        if (null == isConnected || isConnected.length == 0) {
            return 0;
        }
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinceCount = 0;
        Queue<Integer> nextVisitQueue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            // 之前访问过
            if (visited[i]) {
                continue;
            }
            provinceCount++;
            nextVisitQueue.add(i);
            while (!nextVisitQueue.isEmpty()) {
                Integer current = nextVisitQueue.poll();
                visited[current] = true;
                for (int j = 0; j < n; j++) {
                    // 没访问 且可达
                    if (!visited[j] && isConnected[current][j] == 1) {
                        nextVisitQueue.add(j);
                    }
                }
            }

        }
        return provinceCount;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] isConnected = new int[][] {
                {1,1,0},
                {1,1,0},
                {0,0,1}
        };
        int circleNum = solution.findCircleNum(isConnected);
        System.out.println(circleNum);
        Assert.assertEquals(2, circleNum);

        isConnected = new int[][] {
                {1,0,0},
                {0,1,0},
                {0,0,1}
        };
        circleNum = solution.findCircleNum(isConnected);
        System.out.println(circleNum);
        Assert.assertEquals(3, circleNum);
    }

}
