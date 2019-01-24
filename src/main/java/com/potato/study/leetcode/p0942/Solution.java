package com.potato.study.leetcode.p0942;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 * 	942. DI String Match
 *  
 *       Given a string S that only contains "I" (increase) or "D" (decrease), let N = S.length.

Return any permutation A of [0, 1, ..., N] such that for all i = 0, ..., N-1:

If S[i] == "I", then A[i] < A[i+1]
If S[i] == "D", then A[i] > A[i+1]


Example 1:

Input: "IDID"
Output: [0,4,1,3,2]
Example 2:

Input: "III"
Output: [0,1,2,3]
Example 3:

Input: "DDI"
Output: [3,2,0,1]


Note:

1 <= S.length <= 10000
S only contains characters "I" or "D".
 *         
 *         题目含义：
 *
 *
 *         思路：
 *          https://blog.csdn.net/iwts_24/article/details/84436773
 *          出现i选择当前最小的值，出现d选择当前最大的值
 *
 *
 * 
 */
public class Solution {

    public int[] diStringMatch(String s) {
        int max = s.length();
        int min = 0;
        int[] result = new int[s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                result[i] = min++;
            } else if (s.charAt(i) == 'D') {
                result[i] = max--;
            }
        }
        // 最终max == min
        if (min == max) {
            result[s.length()] = min;
        }
        return result;
    }


    public static void main(String[] args) {
		Solution solution = new Solution();
//		String str ="DDI";
		String str ="IDID";
        int[] arr = solution.diStringMatch(str);
        System.out.println(Arrays.toString(arr));
    }
}
