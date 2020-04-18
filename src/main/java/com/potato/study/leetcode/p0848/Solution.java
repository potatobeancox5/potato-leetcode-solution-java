package com.potato.study.leetcode.p0848;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	848. Shifting Letters
 *  
 *         We have a string S of lowercase letters, and an integer array shifts.

Call the shift of a letter, the next letter in the alphabet, (wrapping around so that 'z' becomes 'a').

For example, shift('a') = 'b', shift('t') = 'u', and shift('z') = 'a'.

Now for each shifts[i] = x, we want to shift the first i+1 letters of S, x times.

Return the final string after all such shifts to S are applied.

Example 1:

Input: S = "abc", shifts = [3,5,9]
Output: "rpl"
Explanation:
We start with "abc".
After shifting the first 1 letters of S by 3, we have "dbc".
After shifting the first 2 letters of S by 5, we have "igc".
After shifting the first 3 letters of S by 9, we have "rpl", the answer.
Note:

1 <= S.length = shifts.length <= 20000
0 <= shifts[i] <= 10 ^ 9
 *         
 *         思路：
 *
 *         https://www.cnblogs.com/grandyang/p/10480135.html
 *
 */
public class Solution {

    public String shiftingLetters(String s, int[] shifts) {

        if(s == null || s.length() == 0){
            return s;
        }

        // 累加 shifts 注意 取余数
        int sum = 0;
        for (int i = shifts.length - 1; i >= 0; i--) {
            sum = (sum+shifts[i])%26;
            shifts[i] = sum;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int value = s.charAt(i) - 'a';
            value += shifts[i];
            value %= 26;
            builder.append((char) ('a' + value));
        }
        return builder.toString();
    }


	public static void main(String[] args) {


        Solution solution = new Solution();

        String s = "abc";
        int[] shifts = new int[]{3,5,9};
        String res = solution.shiftingLetters(s, shifts);
        System.out.println(res);
        Assert.assertEquals("rpl", res);


    }
}
