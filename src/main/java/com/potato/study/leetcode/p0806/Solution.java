package com.potato.study.leetcode.p0806;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 * 	806. Number of Lines To Write String
 *  
 *         We are to write the letters of a given string S, from left to right into lines. Each line has maximum width 100 units, and if writing a letter would cause the width of the line to exceed 100 units, it is written on the next line. We are given an array widths, an array where widths[0] is the width of 'a', widths[1] is the width of 'b', ..., and widths[25] is the width of 'z'.

Now answer two questions: how many lines have at least one character from S, and what is the width used by the last such line? Return your answer as an integer list of length 2.



Example :
Input:
widths = [10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10]
S = "abcdefghijklmnopqrstuvwxyz"
Output: [3, 60]
Explanation:
All letters have the same length of 10. To write all 26 letters,
we need two full lines and one line with 60 units.
Example :
Input:
widths = [4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10]
S = "bbbcccdddaaa"
Output: [2, 4]
Explanation:
All letters except 'a' have the same length of 10, and
"bbbcccdddaa" will cover 9 * 10 + 2 * 4 = 98 units.
For the last 'a', it is written on the second line because
there is only 2 units left in the first line.
So the answer is 2 lines, plus 4 units in the second line.


Note:

The length of S will be in the range [1, 1000].
S will only contain lowercase letters.
widths is an array of length 26.
widths[i] will be in the range of [2, 10]. *
 *         思路：
 *          设置一个pos 记录当前 位置 pos + len > 100 写入下一行 line 记录当前行数
 *
https://blog.csdn.net/yuweiming70/article/details/79684506
 * 
 */
public class Solution {

    public int[] numberOfLines(int[] widths, String s) {
        int pos = 0;
        int line = 1;
        for (char ch : s.toCharArray()) {
            if (pos + widths[ch - 'a'] > 100) {
                pos = 0;
                line++;
            }
            pos += widths[ch - 'a'];
        }
        return new int[]{line, pos};
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
        String s = "abcdefghijklmnopqrstuvwxyz";
		int[] widths = {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
        int[] result = solution.numberOfLines(widths, s);
        System.out.println(Arrays.toString(result));
    }
}
