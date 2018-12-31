package com.potato.study.leetcode.p0168;

/**
 * 
 * @author liuzhao11
 * 
 *     168. Excel Sheet Column Title
 *         
 *          
 *   Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

1 -> A
2 -> B
3 -> C
...
26 -> Z
27 -> AA
28 -> AB
...
Example 1:

Input: 1
Output: "A"
Example 2:

Input: 28
Output: "AB"
Example 3:

Input: 701
Output: "ZY"

 *         题目需求，给一个数字，将其转换成excel的标题形式
 */
public class Solution {

    public String convertToTitle(int n) {
        StringBuilder titleBuilder = new StringBuilder();
        while(n > 26) {
            int remand = n % 26; // 0 - 25
            n /= 26;
            if (remand != 0) {
                titleBuilder.append((char)('A' + remand - 1));
            } else {
                titleBuilder.append('Z');
                n -= 1;
            }
        }
        if(n == 26) {
            titleBuilder.append('Z');
        } else {
            titleBuilder.append((char)('A' + n - 1));
        }
        return titleBuilder.reverse().toString();
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
        String s = solution.convertToTitle(1);
        System.out.println(s); // A
         s = solution.convertToTitle(28);
        System.out.println(s);// AB
         s = solution.convertToTitle(701);
        System.out.println(s); // zY
         s = solution.convertToTitle(52);
         // Bz
        System.out.println(s);
    }
}
