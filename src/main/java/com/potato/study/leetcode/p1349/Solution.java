package com.potato.study.leetcode.p1349;


/**
 * 
 * @author liuzhao11
 * 
 * 	1349. Maximum Students Taking Exam
 *  
 *
Given a m * n matrix seats  that represent seats distributions in a classroom. If a seat is broken, it is denoted by '#' character otherwise it is denoted by a '.' character.

Students can see the answers of those sitting next to the left, right, upper left and upper right, but he cannot see the answers of the student sitting directly in front or behind him. Return the maximum number of students that can take the exam together without any cheating being possible..

Students must be placed in seats in good condition.



Example 1:


Input: seats = [["#",".","#","#",".","#"],
[".","#","#","#","#","."],
["#",".","#","#",".","#"]]
Output: 4
Explanation: Teacher can place 4 students in available seats so they don't cheat on the exam.
Example 2:

Input: seats = [[".","#"],
["#","#"],
["#","."],
["#","#"],
[".","#"]]
Output: 3
Explanation: Place all students in available seats.

Example 3:

Input: seats = [["#",".",".",".","#"],
[".","#",".","#","."],
[".",".","#",".","."],
[".","#",".","#","."],
["#",".",".",".","#"]]
Output: 10
Explanation: Place students in available seats in column 1, 3 and 5.


Constraints:

seats contains only characters '.' and'#'.
m == seats.length
n == seats[i].length
1 <= m <= 8
1 <= n <= 8
 *         
 *         思路：
 *          https://leetcode-cn.com/problems/maximum-students-taking-exam/solution/jian-ji-de-javaban-ben-liang-ge-ji-qiao-jing-jian-/
 *
 *
 */
public class Solution {

    private int ok(char[][] grid, int x, int m, int cur) {
        int cnt = 0;//检查合理性 同时进行1的计数
        for (int i = 0; i < m; i++) {
            int a = x & (1 << i);
            if (a != 0) {
                cnt++;
            }
            if (grid[cur][i] == '#' && (a) != 0)//坏的位置不能有人
                return -1;
            if (i > 0) {
                int b = x & (1 << (i - 1));//一行中连续的位置不能同时有人
                if (a != 0 && b != 0) {
                    return -1;
                }
            }
        }
        return cnt;
    }
    public int maxStudents(char[][] seats) {
        int n = seats.length;
        if (n == 0) return 0;
        int m = seats[0].length;
        int[][] grid = new int[n][m];
        int total = 1 << m;
        int[][] dp = new int[n + 1][total + 1];
        int res = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < total; j++) {
                int one = ok(seats, j, m, i - 1);
                if (one == -1) {
                    continue;
                }
                for (int k = 0; k < total; k++) {
                    //枚举上一个状态，通过左移和右移来判断左前和右前是否冲突
                    if (((j << 1) & k) != 0 || ((j >> 1) & k) != 0) continue;
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + one);
                    res = Math.max(dp[i][j], res);
                }
            }
        }
        return res;
    }
}
