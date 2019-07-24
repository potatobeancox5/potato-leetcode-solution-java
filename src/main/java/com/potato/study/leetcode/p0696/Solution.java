package com.potato.study.leetcode.p0696;

/**
 * 
 * @author liuzhao11
 * 
 * 	696. Count Binary Substrings
 *  
 *        Give a string s, count the number of non-empty (contiguous) substrings that have the same number of 0's and 1's, and all the 0's and all the 1's in these substrings are grouped consecutively.

Substrings that occur multiple times are counted the number of times they occur.

Example 1:
Input: "00110011"
Output: 6
Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".

Notice that some of these substrings repeat and are counted the number of times they occur.

Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
Example 2:
Input: "10101"
Output: 4
Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.
Note:

s.length will be between 1 and 50,000.
s will only consist of "0" or "1" characters.
 *         题目解释：
 *          https://blog.csdn.net/vickyruirui/article/details/78284872
 *
 *         比较字符串中01连续 且 相等的类别
 *         
 *
 *
 * 
 */
public class Solution {


    public int countBinarySubstrings(String s) {

        int kindsNum = 0;

        if (null == s || s.length() == 0) {
            return 0;
        }

        int firstNumCount = 1;
        char firstCh = s.charAt(0);

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == firstCh) {
                firstNumCount++;
            } else {
                // 出现第二个数字的位，记录
                int secondNumCount = 1;
                char secondCh = s.charAt(i);
                while (i + 1 < s.length() && s.charAt(i + 1) == secondCh) {
                    secondNumCount++;
                    i++;
                }
                kindsNum += Math.min(firstNumCount, secondNumCount);
                firstNumCount = secondNumCount;
                firstCh = s.charAt(i);
            }
        }
        return kindsNum;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
//        String str = "00110011"; // 6
        String str = "10101"; // 4
        int num = solution.countBinarySubstrings(str);
        System.out.println(num);
    }
}
