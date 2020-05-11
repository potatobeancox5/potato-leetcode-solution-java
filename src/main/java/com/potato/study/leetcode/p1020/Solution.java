package com.potato.study.leetcode.p1020;


/**
 * 
 * @author liuzhao11
 * 
 * 	1020. Number of Enclaves
 *  
 *        Given a 2D array A, each cell is 0 (representing sea) or 1 (representing land)

A move consists of walking from one land square 4-directionally to another land square, or off the boundary of the grid.

Return the number of land squares in the grid for which we cannot walk off the boundary of the grid in any number of moves.



Example 1:

Input: [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
Output: 3
Explanation:
There are three 1s that are enclosed by 0s, and one 1 that isn't enclosed because its on the boundary.
Example 2:

Input: [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
Output: 0
Explanation:
All 1s are either on the boundary or can reach the boundary.


Note:

1 <= A.length <= 500
1 <= A[i].length <= 500
0 <= A[i][j] <= 1
All rows have the same size.

 *         
 *         思路：
 *
 *      java 先把所有和边界相接的陆地淹没，剩下的就是飞陆了
 * https://leetcode-cn.com/problems/number-of-enclaves/solution/java-xian-ba-suo-you-he-bian-jie-xiang-jie-de-lu-d/
 *
 *
 *
 */
public class Solution {

    private int[][] arr;

    public int numEnclaves(int[][] arr) {

        if(arr == null || arr.length == 0) {
            return 0;
        }
        this.arr = arr;

        // 淹没所有和边界相接的陆地
        for (int i = 0; i < arr.length; i++) {
            dfs(i, 0);
            dfs(i, arr[0].length - 1);
        }
        for (int i = 0; i < arr[0].length; i++) {
            dfs(0, i);
            dfs(arr.length - 1, i);
        }
        // 统计剩下的飞陆
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 把此大陆淹没，即把 1 变成 0
     * @param r 起点
     * @param c
     */
    public void dfs(int r, int c){
        if(arr[r][c] == 0) {
            return;
        }
        arr[r][c] = 0;
        if(r > 0) {
            dfs(r - 1, c);
        }
        if(c > 0) {
            dfs(r,c - 1);
        }
        if(r < arr.length - 1 ) {
            dfs(r + 1, c);
        }
        if(c < arr[0].length - 1 ) {
            dfs(r,c + 1);
        }
    }

	
	public static void main(String[] args) {
//		Solution solution = new Solution();
//        int r = 2;
//        int c = 3;
//        int r0 = 1;
//        int c0 = 2;
//        int[][] ints = solution.allCellsDistOrder(r, c, r0, c0);
//        ArrayUtil.printMatrix(ints);
////        TreeNode root = solution.allCellsDistOrder(str);
////        TreePrintUtil.pirnt(root);
    }
}
