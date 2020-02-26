package com.potato.study.leetcode.p0777;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	777. Swap Adjacent in LR String
 *  
 *         In a string composed of 'L', 'R', and 'X' characters, like "RXXLRXRXL", a move consists of either replacing one occurrence of "XL" with "LX", or replacing one occurrence of "RX" with "XR". Given the starting string start and the ending string end, return True if and only if there exists a sequence of moves to transform one string to the other.

Example:

Input: start = "RXXLRXRXL", end = "XRLXXRRLX"
Output: True
Explanation:
We can transform start to end following these steps:
RXXLRXRXL ->
XRXLRXRXL ->
XRLXRXRXL ->
XRLXXRRXL ->
XRLXXRRLX
Note:

1 <= len(start) = len(end) <= 10000.
Both start and end will only consist of characters in {'L', 'R', 'X'}.
 *         
 *         思路：
 *
 *          https://www.cnblogs.com/ctrlzhang/p/8419318.html
 *
 *          bfs
 *
 *          直接做技术器 countl count r 如果小于0 或者  countl * countr ！= 0 false
 *
 *
 * 
 */
public class Solution {

    public boolean canTransform(String start, String end) {

        int countL = 0;
        int countR = 0;

        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) == 'L') {
                countL--;
            }
            if (start.charAt(i) == 'R') {
                countR++;
            }
            if (end.charAt(i) == 'L') {
                countL++;
            }
            if (end.charAt(i) == 'R') {
                countR--;
            }
            // 两个都不为0 就是遇到了 L R 的情况
            if (countL < 0 || countR < 0 || countL * countR != 0) {
                return false;
            }
        }

        return countL == 0 && countR == 0;
    }
	

	public static void main(String[] args) {
		Solution solution = new Solution();

        String start = "RXXLRXRXL";
        String end = "XRLXXRRLX";
        boolean res = solution.canTransform(start, end);
        System.out.println(res);
        Assert.assertEquals(true, res);



    }
}
