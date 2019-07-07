package com.potato.study.leetcode.p0551;

/**
 * 
 * @author liuzhao11
 * 
 *        551. Student Attendance Record I
 * 
 *         You are given a string representing an attendance record for a student. The record only contains the following three characters:
'A' : Absent.
'L' : Late.
'P' : Present.
A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).

You need to return whether the student could be rewarded according to his attendance record.

Example 1:
Input: "PPALLP"
Output: True
Example 2:
Input: "PPALLL"
Output: False

 * 
 * 
 *         思路：
 *
 *       
 *          
 */
public class Solution {

    /**
     * 数组 0 - A 1 - L 2 - P
     * @param s
     * @return
     */
    public boolean checkRecord(String s) {
        int[] statics = new int[3];

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            switch (ch) {
                case 'A':
                    statics[0]++;
                    break;
                case 'L':
                    if (i > 1 && s.charAt(i -1) == 'L' && s.charAt(i -2) == 'L') {
                        return false;
                    }
                    break;
                case 'P':
                    statics[2]++;
                    break;
            }
        }

        if (statics[0] > 1) {
            return false;
        }

        return true;
    }


	
	
	public static void main(String[] args) {
		Solution solution = new Solution();

//		String str = "PPALLP"; //true
//		String str = "PPALLL"; // fasle
		String str = "LALL"; // true

        boolean result = solution.checkRecord(str);
        System.out.println(result);

    }
}
