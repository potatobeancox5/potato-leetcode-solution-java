package com.potato.study.leetcode.p0913;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	913. Cat and Mouse
 *  
 *      A game on an undirected graph is played by two players, Mouse and Cat, who alternate turns.

The graph is given as follows: graph[a] is a list of all nodes b such that ab is an edge of the graph.

Mouse starts at node 1 and goes first, Cat starts at node 2 and goes second, and there is a Hole at node 0.

During each player's turn, they must travel along one edge of the graph that meets where they are.  For example, if the Mouse is at node 1, it must travel to any node in graph[1].

Additionally, it is not allowed for the Cat to travel to the Hole (node 0.)

Then, the game can end in 3 ways:

If ever the Cat occupies the same node as the Mouse, the Cat wins.
If ever the Mouse reaches the Hole, the Mouse wins.
If ever a position is repeated (ie. the players are in the same position as a previous turn, and it is the same player's turn to move), the game is a draw.
Given a graph, and assuming both players play optimally, return 1 if the game is won by Mouse, 2 if the game is won by Cat, and 0 if the game is a draw.



Example 1:

Input: [[2,5],[3],[0,4,5],[1,4,5],[2,3],[0,2,3]]
Output: 0
Explanation:
4---3---1
|   |
2---5
\ /
0


Note:

3 <= graph.length <= 50
It is guaranteed that graph[1] is non-empty.
It is guaranteed that graph[2] contains a non-zero element.

 *         
 *         题目含义：
 *
 *         思路：
 *          https://leetcode-cn.com/problems/cat-and-mouse/solution/java-dfs-with-memorization-by-jake-song/
 *
 *
 *
 */
public class Solution {

    private int[][][] dp;
    private int[][] graph;
    private int n;


    public int catMouseGame(int[][] graph) {
        this.n = graph.length;
        this.dp = new int[2 * n + 1][n][n];
        this.graph = graph;
        return backtrack(0, 1, 2) - 1;
    }
    // t is timeRound, m is mouce positon, c is cat opsition
    private int backtrack(int t, int m, int c) {
        if (t == 2 * n) {
            return dp[t][m][c] = 1;
        } else if (m == 0) {
            return dp[t][m][c] = 2;
        } else if (c == m) {
            return dp[t][m][c] = 3;
        }
        if (dp[t][m][c] != 0) {
            return dp[t][m][c];
        }
        if (t % 2 == 0) {
            boolean catWin = true;
            for (int next : graph[m]) {
                int nextRound = backtrack(t + 1, next, c);
                if (nextRound == 2) {
                    return dp[t][m][c] = 2;
                } else if (nextRound != 3) {
                    catWin = false;
                }
            }
            if (catWin) {
                return dp[t][m][c] = 3;
            } else {
                return dp[t][m][c] = 1;
            }
        } else {
            boolean mouceWin = true;
            for (int next : graph[c]) {
                if (next == 0) continue;
                int nextRound = backtrack(t + 1, m, next);
                if (nextRound == 3) {
                    return dp[t][m][c] = 3;
                } else if (nextRound != 2) {
                    mouceWin = false;
                }
            }
            if (mouceWin) {
                return dp[t][m][c] = 2;
            } else {
                return dp[t][m][c] = 1;
            }
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[][] graph = new int[][]{{2,5}, {3},{0,4,5},{1,4,5},{2,3},{0,2,3}};
        int res = solution.catMouseGame(graph);
        System.out.println(res);
        Assert.assertEquals(0, res);

    }
}
