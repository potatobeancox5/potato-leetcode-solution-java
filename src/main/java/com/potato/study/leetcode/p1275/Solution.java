package com.potato.study.leetcode.p1275;


/**
 * 
 * @author liuzhao11
 * 
 * 	1275. Find Winner on a Tic Tac Toe Game
 *  
 *
Tic-tac-toe is played by two players A and B on a 3 x 3 grid.

Here are the rules of Tic-Tac-Toe:

Players take turns placing characters into empty squares (" ").
The first player A always places "X" characters, while the second player B always places "O" characters.
"X" and "O" characters are always placed into empty squares, never on filled ones.
The game ends when there are 3 of the same (non-empty) character filling any row, column, or diagonal.
The game also ends if all squares are non-empty.
No more moves can be played if the game is over.
Given an array moves where each element is another array of size 2 corresponding to the row and column of the grid where they mark their respective character in the order in which A and B play.

Return the winner of the game if it exists (A or B), in case the game ends in a draw return "Draw", if there are still movements to play return "Pending".

You can assume that moves is valid (It follows the rules of Tic-Tac-Toe), the grid is initially empty and A will play first.



Example 1:

Input: moves = [[0,0],[2,0],[1,1],[2,1],[2,2]]
Output: "A"
Explanation: "A" wins, he always plays first.
"X  "    "X  "    "X  "    "X  "    "X  "
"   " -> "   " -> " X " -> " X " -> " X "
"   "    "O  "    "O  "    "OO "    "OOX"
Example 2:

Input: moves = [[0,0],[1,1],[0,1],[0,2],[1,0],[2,0]]
Output: "B"
Explanation: "B" wins.
"X  "    "X  "    "XX "    "XXO"    "XXO"    "XXO"
"   " -> " O " -> " O " -> " O " -> "XO " -> "XO "
"   "    "   "    "   "    "   "    "   "    "O  "
Example 3:

Input: moves = [[0,0],[1,1],[2,0],[1,0],[1,2],[2,1],[0,1],[0,2],[2,2]]
Output: "Draw"
Explanation: The game ends in a draw since there are no moves to make.
"XXO"
"OOX"
"XOX"
Example 4:

Input: moves = [[0,0],[1,1]]
Output: "Pending"
Explanation: The game has not finished yet.
"X  "
" O "
"   "


Constraints:

1 <= moves.length <= 9
moves[i].length == 2
0 <= moves[i][j] <= 2
There are no repeated elements on moves.
moves follow the rules of tic tac toe.
 *         
 *         思路：
 *          https://leetcode-cn.com/problems/find-winner-on-a-tic-tac-toe-game/solution/java-shi-jian-zhan-sheng-100-mu-ce-bi-mu-qian-qi-t/
 *
 *
 *
 *

 *
 */
public class Solution {

    public String tictactoe(int[][] moves) {
        int m = moves.length;
        // 用数组记录0-2行、0-2列、正对角线、副对角线是否已满3个棋子
        // count[0-2]对应0-2行、count[3-5]对应0-2列、count[6]对应正对角线、count[7]对应副对角线
        int[] count = new int[8];
        // 思路第2步已解释为何只需考虑最后一个落棋的人
        // 倒序统计此人走棋情况
        for(int i = m - 1; i >= 0; i -= 2) {
            // 此棋对行的影响
            count[moves[i][0]]++;
            // 此棋对列的影响
            count[moves[i][1] + 3]++;
            // 此棋对正对角线的影响
            if(moves[i][0] == moves[i][1]) {
                count[6]++;
            }
            // 此棋对副对角线的影响 (
            // 此处为3x3的情况，其余大小的棋盘可以类推
            if(moves[i][0] + moves[i][1] == 2) {
                count[7]++;
            }
            // 满3个棋子则胜利
            if(count[moves[i][0]] == 3 || count[moves[i][1] + 3] == 3 ||
                    count[6] == 3 || count[7] == 3) {
                // A先B后 则总长度为偶时 最后为B 反之为A
                return m % 2 == 0 ? "B" : "A";
            }
        }
        // 未胜时，棋盘未下满则继续
        if(moves.length < 9) {
            return "Pending";
        }
        // 未胜时，棋盘下满则平局结束
        return "Draw";
    }
}
