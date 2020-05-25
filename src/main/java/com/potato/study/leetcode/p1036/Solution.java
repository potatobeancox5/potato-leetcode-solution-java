package com.potato.study.leetcode.p1036;


import org.junit.Assert;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * @author liuzhao11
 * 
 * 	1036. Escape a Large Maze
 *  
 *        In a 1 million by 1 million grid, the coordinates of each grid square are (x, y) with 0 <= x, y < 10^6.

We start at the source square and want to reach the target square.  Each move, we can walk to a 4-directionally adjacent square in the grid that isn't in the given list of blocked squares.

Return true if and only if it is possible to reach the target square through a sequence of moves.



Example 1:

Input: blocked = [[0,1],[1,0]], source = [0,0], target = [0,2]
Output: false
Explanation:
The target square is inaccessible starting from the source square, because we can't walk outside the grid.
Example 2:

Input: blocked = [], source = [0,0], target = [999999,999999]
Output: true
Explanation:
Because there are no blocked cells, it's possible to reach the target square.


Note:

0 <= blocked.length <= 200
blocked[i].length == 2
0 <= blocked[i][j] < 10^6
source.length == target.length == 2
0 <= source[i][j], target[i][j] < 10^6
source != target
 *         
 *         思路：
 *          https://leetcode-cn.com/problems/escape-a-large-maze/solution/biao-zhun-bfs-ti-jie-by-tangweiqun-4/
 *
 *
 *
 *
 */
public class Solution {

    private int dirs[][] = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
    private int limit = (int)1e6;
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Set<String> blocks = new HashSet<>();
        for(int block[] : blocked) {
            blocks.add(block[0] + ":" + block[1]);
        }
        return bfs(source, target, blocks) && bfs(target, source, blocks);
    }
    public boolean bfs(int[] source, int[] target, Set<String> blocks){
        Set<String> seen = new HashSet<>();
        seen.add(source[0] + ":" + source[1]);
        Queue<int[]> bfs = new LinkedList<>();
        bfs.offer(source);

        while(!bfs.isEmpty()){
            int cur[] = bfs.poll();
            for(int dir[] : dirs){
                int nextX = cur[0] + dir[0];
                int nextY = cur[1] + dir[1];
                if(nextX < 0 || nextY < 0 || nextX >= limit || nextY >= limit) {
                    continue;
                }
                String key = nextX + ":" + nextY;
                if (seen.contains(key) || blocks.contains(key)) {
                    continue;
                }
                if(nextX == target[0] && nextY == target[1]) {
                    return true;
                }
                bfs.offer(new int[]{nextX, nextY});
                seen.add(key);
            }
            if(seen.size() == 20000) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
		Solution solution = new Solution();

        int[][] blocked = new int[][]{{0,1},{1,0}};
        int[] source = new int[]{0, 0};
        int[] target = new int[]{0, 2};
        boolean res = solution.isEscapePossible(blocked, source, target);
        System.out.println(res);
        Assert.assertEquals(false, res);


    }
}
