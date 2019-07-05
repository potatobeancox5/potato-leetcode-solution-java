package com.potato.study.leetcode.p0443;

/**
 * 
 * @author liuzhao11
 * 
 *   443. String Compression
 * 
 *    Given an array of characters, compress it in-place.

The length after compression must always be smaller than or equal to the original array.

Every element of the array should be a character (not int) of length 1.

After you are done modifying the input array in-place, return the new length of the array.


Follow up:
Could you solve it using only O(1) extra space?


Example 1:

Input:
["a","a","b","b","c","c","c"]

Output:
Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]

Explanation:
"aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".


Example 2:

Input:
["a"]

Output:
Return 1, and the first 1 characters of the input array should be: ["a"]

Explanation:
Nothing is replaced.


Example 3:

Input:
["a","b","b","b","b","b","b","b","b","b","b","b","b"]

Output:
Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].

Explanation:
Since the character "a" does not repeat, it is not compressed. "bbbbbbbbbbbb" is replaced by "b12".
Notice each digit has it's own entry in the array.


Note:

All characters have an ASCII value in [35, 126].
1 <= len(chars) <= 1000.

 *
 *     思路：
 *
 *     
 * 			
 * 	
 */	
public class Solution {

    // 压缩 数组也得变
    public int compress(char[] chars) {

        if (null == chars || chars.length == 0) {
            return 0;
        }

        char lastCh = chars[0];
        int currentCount = 0;
        int lenth = 0;

        int editIndex = 0;

        for (int i = 0; i < chars.length; i++) {
            if (i == 0) {
                lastCh = chars[i];
                currentCount++;

            } else {

                if (lastCh == chars[i]) {
                    currentCount++;
                } else {
                    lenth++;
                    chars[editIndex++] = lastCh;
                    if (currentCount != 1) {
                        String numStr = "" + currentCount;
                        int numLen = numStr.length();
                        for (int j = 0; j < numLen; j++) {
                            chars[editIndex++] = numStr.charAt(j);
                        }
                        lenth += numLen;
                    }
                    lastCh = chars[i];
                    currentCount = 1;
                }
            }



            // last
            if (i == chars.length - 1) {
                lenth++;
                chars[editIndex++] = lastCh;
                if (currentCount != 1) {
                    String numStr = "" + currentCount;
                    int numLen = numStr.length();
                    for (int j = 0; j < numLen; j++) {
                        chars[editIndex++] = numStr.charAt(j);
                    }
                    lenth += numLen;
                }
            }
        }

        return lenth;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        char[] nums = {'a'};

//        String str = "abbbbbbbbbbbb";// 4
        String str = "aabbccc";// 6

        int len = solution.compress(str.toCharArray());
        System.out.println(len);
    }
}
