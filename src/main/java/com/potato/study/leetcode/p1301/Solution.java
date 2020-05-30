package com.potato.study.leetcode.p1301;


import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 * 	1301. Number of Paths with Max Score
 *  
 *You are given a square board of characters. You can move on the board starting at the bottom right square marked with the character 'S'.

You need to reach the top left square marked with the character 'E'. The rest of the squares are labeled either with a numeric character 1, 2, ..., 9 or with an obstacle 'X'. In one move you can go up, left or up-left (diagonally) only if there is no obstacle there.

Return a list of two integers: the first integer is the maximum sum of numeric characters you can collect, and the second is the number of such paths that you can take to get that maximum sum, taken modulo 10^9 + 7.

In case there is no path, return [0, 0].



Example 1:

Input: board = ["E23","2X2","12S"]
Output: [7,1]
Example 2:

Input: board = ["E12","1X1","21S"]
Output: [4,2]
Example 3:

Input: board = ["E11","XXX","11S"]
Output: [0,0]


Constraints:

2 <= board.length == board[i].length <= 100
 *         
 *
 *         思路：
 *          https://leetcode-cn.com/problems/number-of-paths-with-max-score/solution/dong-tai-gui-hua-chang-gui-tao-lu-by-william-43/
 *
 *
 *
 *
 */
public class Solution {

    public int[] pathsWithMaxScore(List<String> board) {
        int row = board.size();
        if (row == 0) {
            return new int[]{0, 0};
        }
        int modNum = 1000000007;
        int col = board.get(0).length();
        int[][] dpScore = new int[row+1][col+1];
        int[][] dpPath = new int[row+1][col+1];
        //从右下角开始走，初始路径为1条
        dpPath[row-1][col-1] = 1;
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                //如果board[i][j] == 'X', 即为障碍
                //如果dpPath[i+1][j],dpPath[i][j+1]和dpPath[i+1][j+1]都等于0，就是路径被障碍'X'封死了
                if (board.get(i).charAt(j) != 'X' &&
                        (dpPath[i + 1][j] != 0 || dpPath[i][j + 1] != 0 || dpPath[i + 1][j + 1] != 0)) {
                    int maxScore = Math.max(Math.max(dpScore[i + 1][j], dpScore[i][j + 1]), dpScore[i + 1][j + 1]);
                    dpScore[i][j] = maxScore + board.get(i).charAt(j) - '0';
                    if (dpScore[i + 1][j] == maxScore) {
                        dpPath[i][j] = (dpPath[i][j] + dpPath[i + 1][j]) % modNum;
                    }
                    if (dpScore[i][j + 1] == maxScore) {
                        dpPath[i][j] = (dpPath[i][j] + dpPath[i][j + 1]) % modNum;
                    }
                    if (dpScore[i + 1][j + 1] == maxScore) {
                        dpPath[i][j] = (dpPath[i][j] + dpPath[i + 1][j + 1]) % modNum;
                    }
                }
            }
        }
        //dpScore[0][0] - ('E' - '0'),是因为结束时候为'E'，上面加了，所以要减去
        int maxScore = dpScore[0][0] == 0 ? 0 : dpScore[0][0] - ('E' - '0');
        return new int[]{maxScore, dpPath[0][0]};
    }

	public static void main(String[] args) {
    }
}
