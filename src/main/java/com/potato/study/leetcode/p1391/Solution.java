package com.potato.study.leetcode.p1391;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author liuzhao11
 * 
 * 	1391. Check if There is a Valid Path in a Grid
 *  
 *
Given a m x n grid. Each cell of the grid represents a street. The street of grid[i][j] can be:
1 which means a street connecting the left cell and the right cell.
2 which means a street connecting the upper cell and the lower cell.
3 which means a street connecting the left cell and the lower cell.
4 which means a street connecting the right cell and the lower cell.
5 which means a street connecting the left cell and the upper cell.
6 which means a street connecting the right cell and the upper cell.


You will initially start at the street of the upper-left cell (0,0). A valid path in the grid is a path which starts from the upper left cell (0,0) and ends at the bottom-right cell (m - 1, n - 1). The path should only follow the streets.

Notice that you are not allowed to change any street.

Return true if there is a valid path in the grid or false otherwise.



Example 1:


Input: grid = [[2,4,3],[6,5,2]]
Output: true
Explanation: As shown you can start at cell (0, 0) and visit all the cells of the grid to reach (m - 1, n - 1).
Example 2:


Input: grid = [[1,2,1],[1,2,1]]
Output: false
Explanation: As shown you the street at cell (0, 0) is not connected with any street of any other cell and you will get stuck at cell (0, 0)
Example 3:

Input: grid = [[1,1,2]]
Output: false
Explanation: You will get stuck at cell (0, 1) and you cannot reach cell (0, 2).
Example 4:

Input: grid = [[1,1,1,1,1,1,3]]
Output: true
Example 5:

Input: grid = [[2],[2],[2],[2],[2],[2],[6]]
Output: true


Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
1 <= grid[i][j] <= 6
 *         
 *         思路：
 *         https://leetcode-cn.com/problems/check-if-there-is-a-valid-path-in-a-grid/solution/ji-lu-fang-xiang-bfs-by-ccdmw/
 *
 *
 */
public class Solution {


    public boolean hasValidPath(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        Queue<int[]> queue = new LinkedList<>();
        //方向 上下左右
        int[][] vectors = new int[][]{{-1, 0},{1, 0}, {0 , -1}, {0, 1}};
        queue.offer(new int[]{0, 0});
        visited[0][0] = 1;
        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            if (poll[0] == grid.length - 1 && poll[1] == grid[0].length - 1)
                return true;
            int way = 1;
            for (int[] vector : vectors) {
                int a = poll[0] + vector[0];
                int b = poll[1] + vector[1];
                if (a >= 0 && a < grid.length && b >= 0 && b < grid[0].length && visited[a][b] == 0){
                    int before = grid[poll[0]][poll[1]];
                    int after =  grid[a][b];
                    if (isOk(before, after, way)){
                        queue.offer(new int[]{a, b});
                        visited[a][b] = 1;
                        break;
                    }
                }
                way++;
            }
        }
        return false;
    }

    private boolean isOk(int a, int b, int way){
        // way 代表 1， 2， 3， 4
        // 分别代表 上 下 左 右
        if (way == 1){
            if ((a == 2 || a == 5 || a == 6) && (b == 2 || b == 3 || b == 4))
                return true;
        } else if (way == 2){
            if ((a == 2 || a == 3 || a == 4) && (b == 2 || b == 5 || b == 6))
                return true;
        } else if (way == 3){
            if ((a == 1 || a == 3 || a == 5) && (b == 1 || b == 4 || b == 6))
                return true;
        } else if (way == 4){
            if ((a == 1 || a == 4 || a == 6) && ((b == 1 || b == 3 || b == 5)))
                return true;
        }
        return false;
    }

}
