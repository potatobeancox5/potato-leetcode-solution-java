package com.potato.study.leetcode.p1267;


import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	1267. Count Servers that Communicate
 *  
 *
You are given a map of a server center, represented as a m * n integer matrix grid, where 1 means that on that cell there is a server and 0 means that it is no server. Two servers are said to communicate if they are on the same row or on the same column.

Return the number of servers that communicate with any other server.



Example 1:



Input: grid = [[1,0],[0,1]]
Output: 0
Explanation: No servers can communicate with others.
Example 2:



Input: grid = [[1,0],[1,1]]
Output: 3
Explanation: All three servers can communicate with at least one other server.
Example 3:



Input: grid = [[1,1,0,0],[0,0,1,0],[0,0,1,0],[0,0,0,1]]
Output: 4
Explanation: The two servers in the first row can communicate with each other. The two servers in the third column can communicate with each other. The server at right bottom corner can't communicate with any other server.


Constraints:

m == grid.length
n == grid[i].length
1 <= m <= 250
1 <= n <= 250
grid[i][j] == 0 or 1
 *         
 *         思路： 计算记录 横竖差 小的那个 + 大减去 小
 *
 *          https://leetcode-cn.com/problems/count-servers-that-communicate/solution/java-jian-dan-yi-dong-by-copyreadmachine/
 *
 */
public class Solution {


    public int countServers(int[][] grid) {
        // 统计某行 和某列 server数量
        int[] line = new int[grid.length];
        int[] row = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    line[i]++;
                    row[j]++;
                }
            }
        }
        // 再次遍历，如果这行与 这列 都只有一个服务器 continue 否则计数
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 0) {
                    continue;
                }

                if (line[i] == 1 && row[j] == 1) {
                    continue;
                }
                count++;
            }
        }
        return count;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();

        int[][] grid = new int[][]{{1,1,0,0},{0,0,1,0},{0,0,0,1}};
        int res = solution.countServers(grid);
        System.out.println(res);
        Assert.assertEquals(2, res);


        grid = new int[][]{{1,0},{1,1}};
        res = solution.countServers(grid);
        System.out.println(res);
        Assert.assertEquals(3, res);

    }
}
