package com.potato.study.leetcode.p1210;


/**
 * 
 * @author liuzhao11
 * 
 * 	1210. Minimum Moves to Reach Target with Rotations
 *  
 *In an n*n grid, there is a snake that spans 2 cells and starts moving from the top left corner at (0, 0) and (0, 1). The grid has empty cells represented by zeros and blocked cells represented by ones. The snake wants to reach the lower right corner at (n-1, n-2) and (n-1, n-1).

In one move the snake can:

Move one cell to the right if there are no blocked cells there. This move keeps the horizontal/vertical position of the snake as it is.
Move down one cell if there are no blocked cells there. This move keeps the horizontal/vertical position of the snake as it is.
Rotate clockwise if it's in a horizontal position and the two cells under it are both empty. In that case the snake moves from (r, c) and (r, c+1) to (r, c) and (r+1, c).

Rotate counterclockwise if it's in a vertical position and the two cells to its right are both empty. In that case the snake moves from (r, c) and (r+1, c) to (r, c) and (r, c+1).

Return the minimum number of moves to reach the target.

If there is no way to reach the target, return -1.



Example 1:



Input: grid = [[0,0,0,0,0,1],
[1,1,0,0,1,0],
[0,0,0,0,1,1],
[0,0,1,0,1,0],
[0,1,1,0,0,0],
[0,1,1,0,0,0]]
Output: 11
Explanation:
One possible solution is [right, right, rotate clockwise, right, down, down, down, down, rotate counterclockwise, right, down].
Example 2:

Input: grid = [[0,0,1,1,1,1],
[0,0,0,0,1,1],
[1,1,0,0,0,1],
[1,1,1,0,0,1],
[1,1,1,0,0,1],
[1,1,1,0,0,0]]
Output: 9


Constraints:

2 <= n <= 100
0 <= grid[i][j] <= 1
It is guaranteed that the snake starts at empty cells.
 *         
 *         思路：
 *         https://leetcode-cn.com/problems/minimum-moves-to-reach-target-with-rotations/solution/dong-tai-gui-hua-xiang-xi-zhu-shi-jie-da-bian-yu-l/
 *
 *
 *
 *
 */
public class Solution {

    public int minimumMoves(int[][] grid) {
        int n = grid.length;
        int[][][] dp = new int[n][n][2]; // 放上三种状态，尾巴的横纵坐标和垂直或水平,0表示水平,1表示垂直。
        int[] dx = {0, 1}, dy = {1, 0}; // 如果让蛇向右移动一格，那么蛇整个身体x轴不变，y轴+1，同理向下也一样。
        dp[0][0][0] = 1;
        // base case是1，为什么是一呢，因为java开辟数组时默认会把所有数组归为0，本来应该是0，但是为了方便先让他比答案多1，最后返回时再-1就行了
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Rotate
                for (int k = 0; k < 2; k++) {
                    if (dp[i][j][k] == 0) {
                        continue; // 等于0说明当前位置不可达，不用计算。
                    }
                    if (i + 1 >= n || j + 1 >= n) {
                        continue; // 如果i+1或j+1超出边界，说明它不可能做翻转操作，因为另一种状态以及越界了。
                    }
                    if (k == 0) { // 水平位置判断下面以及右下位置是否有障碍，没有才能更新
                        if (grid[i+1][j] != 1 && grid[i+1][j+1] != 1) {
                            // 如果要更新的状态本来里面存的次数要少，那就不用更新了。
                            if (dp[i][j][1-k] == 0 || dp[i][j][1-k] > dp[i][j][k] + 1) {
                                dp[i][j][1-k] = dp[i][j][k] + 1;
                            }
                        }
                    } else { // 垂直位置判断右边以及右下位置
                        if (grid[i][j+1] != 1 && grid[i+1][j+1] != 1) {
                            if (dp[i][j][1-k] == 0 || dp[i][j][1-k] > dp[i][j][k] + 1) {
                                dp[i][j][1-k] = dp[i][j][k] + 1;
                            }
                        }
                    }
                }

                // move
                for (int k = 0; k < 2; k++) {
                    if (dp[i][j][k] == 0) {
                        continue; // 同理当前位置不可达，结束
                    }
                    int[] nx = new int[2], ny = new int[2]; // nx,ny表示蛇身体的位置，前一个是尾巴，后一个是头
                    for (int w = 0; w < 2; w++) { // w循环表示蛇向右移动和向下移动
                        boolean flag = true; // 用于判断蛇是否能到达，就是有没有障碍物
                        nx[0] = i;nx[1] = i + dx[k]; // 计算蛇的身体位置。
                        ny[0] = j;ny[1] = j + dy[k];
                        for (int mv = 0; mv < 2; mv++) { // mv循环表示移动蛇的尾巴和头，先移尾巴后头。
                            nx[mv] += dx[w];ny[mv] += dy[w]; // 计算移动后的位置。
                            if (nx[mv] < 0 || nx[mv] >= n || ny[mv] < 0 || ny[mv] >= n) {
                                // 如果移动后身体的某个位置超出数组，说明不可达。
                                flag = false;
                            } else if (grid[nx[mv]][ny[mv]] == 1) {
                                flag = false; // 同样有障碍也不可达。
                            }
                        }
                        if (flag == false) {
                            continue; // 不可达就不能更新。
                        }
                        if (dp[nx[0]][ny[0]][k] == 0 || dp[nx[0]][ny[0]][k] > dp[i][j][k] + 1) {
                            dp[nx[0]][ny[0]][k] = dp[i][j][k] + 1;
                        }
                    }
                }
            }
        }
        return dp[n-1][n-2][0] - 1; // 蛇最后结束的位置就是尾巴在(n-1, n-2)上处于水平状态。然后别忘了之前的-1。
    }
}
