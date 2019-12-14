package com.potato.study.leetcode.p0675;

import org.junit.Assert;

import java.util.*;

/**
 * 
 * @author liuzhao11
 * 
 *         675. Cut Off Trees for Golf Event
 * 
 *         You are asked to cut off trees in a forest for a golf event. The forest is represented as a non-negative 2D map, in this map:

0 represents the obstacle can't be reached.
1 represents the ground can be walked through.
The place with number bigger than 1 represents a tree can be walked through, and this positive number represents the tree's height.


You are asked to cut off all the trees in this forest in the order of tree's height - always cut off the tree with lowest height first. And after cutting, the original place has the tree will become a grass (value 1).

You will start from the point (0, 0) and you should output the minimum steps you need to walk to cut off all the trees. If you can't cut off all the trees, output -1 in that situation.

You are guaranteed that no two trees have the same height and there is at least one tree needs to be cut off.

Example 1:

Input:
[
[1,2,3],
[0,0,4],
[7,6,5]
]
Output: 6


Example 2:

Input:
[
[1,2,3],
[0,0,0],
[7,6,5]
]
Output: -1


Example 3:

Input:
[
[2,3,4],
[0,0,5],
[8,7,6]
]
Output: 6
Explanation: You started from the point (0,0) and you can cut off the tree in (0,0) directly without walking.


Hint: size of the given matrix will not exceed 50x50.
 *
 *         思路：
 *         1. 按照高度排序
 *         2. 依次 bfs求最短距离， key point
 *         3. 求距离和
 *
 *          https://blog.csdn.net/u012808902/article/details/78048536
 *
 *          code
 *          https://segmentfault.com/a/1190000017337029
 *
 */
public class Solution {

    private int[][] direction = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public int cutOffTree(List<List<Integer>> forest) {
        // 0. 将 点 ij value 数组形式存在list中
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(0).size(); j++) {
                int val = forest.get(i).get(j);
                if (val > 1) {
                    list.add(new int[]{i, j, val});
                }
            }
        }

        // 1, 按照value 从小到大排序
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        // 2. 从00 开始 依次bfs找到最小距离 如果找到 累加 并修改ij ，没找到直接返回-1
        int i = 0;
        int j = 0;
        int res = 0;
        for (int[] tree : list) {
            int distance = bfs(forest, i, j, tree[0], tree[1]);
            if (distance < 0) {
                return -1;
            } else {
                res += distance;
                i = tree[0];
                j = tree[1];
            }
        }
        return res;
    }

    /**
     *
     * @param forest
     * @param i
     * @param j
     * @param x
     * @param y
     * @return
     */
    private int bfs(List<List<Integer>> forest, int i, int j, int x, int y) {

        // 1. visited[][] 存当前点是否被访问过
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});

        int m = forest.size();
        int n = forest.get(0).size();
        boolean[][] visited = new boolean[m][n];

        visited[i][j] = true;
        int distance = -1;

        while (!queue.isEmpty()) {
            // 1. 当前层有多少个节点
            int laySize = queue.size();
            distance++;
            // 2. 遍历当前层节点 加入他们的临界点，并判断是否存在xy 存在 返回dist
            for (int k = 0; k < laySize; k++) {
                int[] node = queue.poll();
                if (node[0] == x && node[1] == y) {
                    return distance;
                }

                for (int l = 0; l < direction.length; l++) {


                    int nx = node[0] + direction[l][0];
                    int ny = node[1] + direction[l][1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n
                            || visited[nx][ny] || forest.get(nx).get(ny) <= 0) {
                        continue;
                    }
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        List<List<Integer>> forest = null;

        int value = solution.cutOffTree(forest);
        System.out.println(value);
        Assert.assertEquals(10,value);
    }
}
