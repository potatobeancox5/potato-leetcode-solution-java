package com.potato.study.leetcode.p1001;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author liuzhao11
 * 
 * 	1001. Grid Illumination
 *  
 *         On a N x N grid of cells, each cell (x, y) with 0 <= x < N and 0 <= y < N has a lamp.

Initially, some number of lamps are on.  lamps[i] tells us the location of the i-th lamp that is on.  Each lamp that is on illuminates every square on its x-axis, y-axis, and both diagonals (similar to a Queen in chess).

For the i-th query queries[i] = (x, y), the answer to the query is 1 if the cell (x, y) is illuminated, else 0.

After each query (x, y) [in the order given by queries], we turn off any lamps that are at cell (x, y) or are adjacent 8-directionally (ie., share a corner or edge with cell (x, y).)

Return an array of answers.  Each value answer[i] should be equal to the answer of the i-th query queries[i].



Example 1:

Input: N = 5, lamps = [[0,0],[4,4]], queries = [[1,1],[1,0]]
Output: [1,0]
Explanation:
Before performing the first query we have both lamps [0,0] and [4,4] on.
The grid representing which cells are lit looks like this, where [0,0] is the top left corner, and [4,4] is the bottom right corner:
1 1 1 1 1
1 1 0 0 1
1 0 1 0 1
1 0 0 1 1
1 1 1 1 1
Then the query at [1, 1] returns 1 because the cell is lit.  After this query, the lamp at [0, 0] turns off, and the grid now looks like this:
1 0 0 0 1
0 1 0 0 1
0 0 1 0 1
0 0 0 1 1
1 1 1 1 1
Before performing the second query we have only the lamp [4,4] on.  Now the query at [1,0] returns 0, because the cell is no longer lit.


Note:

1 <= N <= 10^9
0 <= lamps.length <= 20000
0 <= queries.length <= 20000
lamps[i].length == queries[i].length == 2
 *         
 *         思路：
 *          https://leetcode-cn.com/problems/grid-illumination/solution/java-101msji-bai-100-by-purerain/
 *
 */
public class Solution {

    private static final long max = 1000000000L;

    private Map<Integer, Integer> rowMap = new HashMap<>();
    private Map<Integer, Integer> columnMap = new HashMap<>();
    private Map<Integer, Integer> sumMap = new HashMap<>();
    private Map<Integer, Integer> rowColDiffMap = new HashMap<>();

    // 标记某些位置是否有灯，1000000000L * row + col
    private Set<Long> lampSet = new HashSet<>();

    private void setFlagMap(Map<Integer, Integer> flagMap, int key) {
        if (flagMap.containsKey(key)) {
            flagMap.put(key, flagMap.get(key) + 1);
        } else {
            flagMap.put(key, 1);
        }
    }

    private void minusFlagMapCount(Map<Integer, Integer> flagMap, int key) {
        flagMap.put(key, flagMap.get(key) - 1);
    }

    private void closeNeighborLamp(int row, int col) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newRow = row + i;
                int newCol = col + j;
                if (newRow < 0 || newCol < 0) {
                    continue;
                }

                long lamp = max * newRow + newCol;
                if (lampSet.contains(lamp)) {
                    lampSet.remove(lamp);
                    minusFlagMapCount(rowMap, newRow);
                    minusFlagMapCount(columnMap, newCol);
                    minusFlagMapCount(sumMap, newRow + newCol);
                    minusFlagMapCount(rowColDiffMap, newRow - newCol);
                }
            }
        }
    }

    public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
        int queryCount = queries.length;
        if (queryCount == 0) {
            return new int[]{};
        }

        for (int[] lamp : lamps) {
            int row = lamp[0];
            int col = lamp[1];
            int sum = row + col;
            int rowColDiff = row - col;
            setFlagMap(rowMap, row);
            setFlagMap(columnMap, col);
            setFlagMap(sumMap, sum);
            setFlagMap(rowColDiffMap, rowColDiff);
            lampSet.add(max * row + col);
        }

        int[] ansArr = new int[queryCount];
        int count = 0;

        for (int[] query : queries) {
            int row = query[0];
            int col = query[1];
            int sum = row + col;
            int rowColDiff = row - col;

            if (rowMap.containsKey(row) && rowMap.get(row) >= 1 ||
                    columnMap.containsKey(col) && columnMap.get(col) >= 1 ||
                    sumMap.containsKey(sum) && sumMap.get(sum) >= 1 ||
                    rowColDiffMap.containsKey(rowColDiff) && rowColDiffMap.get(rowColDiff) >= 1) {
                ansArr[count++] = 1;
            } else {
                ansArr[count++] = 0;
            }

            // 关掉当前询问位置和周围相邻8个位置的灯
            closeNeighborLamp(row ,col);
        }

        return ansArr;
    }
	
	public static void main(String[] args) {

    }
}
