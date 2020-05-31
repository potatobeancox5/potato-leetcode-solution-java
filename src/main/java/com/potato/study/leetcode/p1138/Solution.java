package com.potato.study.leetcode.p1138;


/**
 * 
 * @author liuzhao11
 * 
 * 	1138. Alphabet Board Path
 *  
 *
 * On an alphabet board, we start at position (0, 0), corresponding to character board[0][0].

Here, board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"], as shown in the diagram below.



We may make the following moves:

'U' moves our position up one row, if the position exists on the board;
'D' moves our position down one row, if the position exists on the board;
'L' moves our position left one column, if the position exists on the board;
'R' moves our position right one column, if the position exists on the board;
'!' adds the character board[r][c] at our current position (r, c) to the answer.
(Here, the only positions that exist on the board are positions with letters on them.)

Return a sequence of moves that makes our answer equal to target in the minimum number of moves.  You may return any path that does so.



Example 1:

Input: target = "leet"
Output: "DDR!UURRR!!DDD!"
Example 2:

Input: target = "code"
Output: "RR!DDRR!UUL!R!"


Constraints:

1 <= target.length <= 100
target consists only of English lowercase letters.
 *         
 *      思路：
 *
 *
 *      https://leetcode-cn.com/problems/alphabet-board-path/solution/javagen-ju-zuo-biao-jie-da-by-qi-xi-5/
 *
 */
public class Solution {

    public String alphabetBoardPath(String target) {
        // 起始点坐标x轴0，y轴0
        int startx = 0,starty = 0;
        char[] ch = target.toCharArray();
        int x,y;
        StringBuilder stb = new StringBuilder();
        for(char c : ch) {
            // 根据字符a计算当前字符的位置
            int cc = c - 97;
            // 当前字符x轴位置
            x = cc % 5;
            // 当前字符y轴位置
            y = cc / 5;
            int sx = x - startx;
            int sy = y - starty;
            // 起始点在z有独特性，先上后右
            if(starty == 5){
                for(; sy < 0; sy++) {
                    // 因为起点z，所以必定往上，sy小于等于0，85为U的ASCII码
                    stb.append((char)85);
                }
                for(; sx > 0; sx--) {
                    // 同上，往右，82为R的ASCII码
                    stb.append((char)82);
                }
            } else{
                // 除z外，都是先左右在上下
                if(sx > 0){
                    for(; sx > 0; sx--)
                        // 右
                        stb.append((char)82);
                }
                else if(sx < 0){
                    for(; sx < 0; sx++)
                        // 左
                        stb.append((char)76);
                }
                if(sy > 0){
                    for(; sy > 0; sy--)
                        // 下
                        stb.append((char)68);
                }
                else if(sy < 0){
                    for(; sy < 0; sy++)
                        // 上
                        stb.append((char)85);
                }
            }
            // 指令'!'
            stb.append((char)33);
            // 保存当前坐标
            startx = x;
            starty = y;
        }
        return stb.toString();
    }
}
