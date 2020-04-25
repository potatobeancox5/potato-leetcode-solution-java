package com.potato.study.leetcode.p1320;


import org.junit.Assert;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 * 	1320. Minimum Distance to Type a Word Using Two Fingers
 *  
 *
You have a keyboard layout as shown above in the XY plane, where each English uppercase letter is located at some coordinate, for example, the letter A is located at coordinate (0,0), the letter B is located at coordinate (0,1), the letter P is located at coordinate (2,3) and the letter Z is located at coordinate (4,1).

Given the string word, return the minimum total distance to type such string using only two fingers. The distance between coordinates (x1,y1) and (x2,y2) is |x1 - x2| + |y1 - y2|.

Note that the initial positions of your two fingers are considered free so don't count towards your total distance, also your two fingers do not have to start at the first letter or the first two letters.



Example 1:

Input: word = "CAKE"
Output: 3
Explanation:
Using two fingers, one optimal way to type "CAKE" is:
Finger 1 on letter 'C' -> cost = 0
Finger 1 on letter 'A' -> cost = Distance from letter 'C' to letter 'A' = 2
Finger 2 on letter 'K' -> cost = 0
Finger 2 on letter 'E' -> cost = Distance from letter 'K' to letter 'E' = 1
Total distance = 3
Example 2:

Input: word = "HAPPY"
Output: 6
Explanation:
Using two fingers, one optimal way to type "HAPPY" is:
Finger 1 on letter 'H' -> cost = 0
Finger 1 on letter 'A' -> cost = Distance from letter 'H' to letter 'A' = 2
Finger 2 on letter 'P' -> cost = 0
Finger 2 on letter 'P' -> cost = Distance from letter 'P' to letter 'P' = 0
Finger 1 on letter 'Y' -> cost = Distance from letter 'A' to letter 'Y' = 4
Total distance = 6
Example 3:

Input: word = "NEW"
Output: 3
Example 4:

Input: word = "YEAR"
Output: 7


Constraints:

2 <= word.length <= 300
Each word[i] is an English uppercase letter.
 *         
 *         思路：
 *
 *
 *          https://leetcode-cn.com/problems/minimum-distance-to-type-a-word-using-two-fingers/solution/qing-xi-tu-jie-qiao-miao-de-dong-tai-gui-hua-by-hl/
 *
 *

 *
 */
public class Solution {

    public int minimumDistance(String word) {
        // 当前输入的字符数字，左手停留的位置和右手停的位置
        int[][][] dp = new int[301][26][26];

        for (int i = 1; i <= 300; i++) {
            for (int j = 0; j < 26; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= word.length() ; i++) {
            int val = word.charAt(i-1) - 'A';

            // left
            for (int l = 0; l < 26; l++) {
                // right
                for (int r = 0; r < 26; r++) {
                    // 这个位置没有设置过值
                    if (dp[i - 1][l][r] != Integer.MAX_VALUE) {
                        // 移动左指
                        dp[i][val][r] = Math.min(dp[i][val][r], dp[i - 1][l][r] + distance(l, val));
                        // 移动右指
                        dp[i][l][val] = Math.min(dp[i][l][val], dp[i - 1][l][r] + distance(r, val));
                    }
                    if (i == word.length()) {
                        min = Math.min(min, dp[i][val][r]);
                        min = Math.min(min, dp[i][l][val]);
                    }
                }
            }

        }

        return min;
    }

    /**
     * a b 均是数字 1- 26 代表字母
     * @param a
     * @param b
     * @return
     */
    private int distance(int a, int b) {
        int x1 = a/6;
        int y1 = a%6;
        int x2 = b/6;
        int y2 = b%6;
        return  Math.abs(x1 - x2) +  Math.abs(y1 - y2);
    }

	public static void main(String[] args) {
        Solution solution = new Solution();

        String word = "CAKE";
        int number = solution.minimumDistance(word);
        System.out.println(number);
        Assert.assertEquals(3, number);

        word = "HAPPY";
        number = solution.minimumDistance(word);
        System.out.println(number);
        Assert.assertEquals(6, number);

        word = "NEW";
        number = solution.minimumDistance(word);
        System.out.println(number);
        Assert.assertEquals(3, number);

        word = "YEAR";
        number = solution.minimumDistance(word);
        System.out.println(number);
        Assert.assertEquals(7, number);
    }
}
