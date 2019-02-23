package com.potato.study.leetcode.p0917;

/**
 * 
 * @author liuzhao11
 * 
 * 	917. Reverse Only Letters
 *  
 *      Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place, and all letters reverse their positions.



Example 1:

Input: "ab-cd"
Output: "dc-ba"
Example 2:

Input: "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"
Example 3:

Input: "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"


Note:

S.length <= 100
33 <= S[i].ASCIIcode <= 122
S doesn't contain \ or "

 *         
 *         题目含义：
 *
 *         思路：
 *
 *
 *
 *
 */
public class Solution {

    public String reverseOnlyLetters(String str) {
        char[] charArray = str.toCharArray();
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            // 找到left
            while (left < right && !isCharactor(charArray[left])) {
                left++;
            }
            // 找到 right
            while (left < right && !isCharactor(charArray[right])) {
                right--;
            }
            if (left < right) { // swap
                char ch = charArray[left];
                charArray[left] = charArray[right];
                charArray[right] = ch;
                left++;
                right--;
            }
        }
        return new String(charArray);
    }

    private boolean isCharactor(char ch) {
        if (ch >= 'a' && ch <= 'z') {
            return true;
        }
        if (ch >= 'A' && ch <= 'Z') {
            return true;
        }
        return false;
    }




    public static void main(String[] args) {
		Solution solution = new Solution();
    }
}
