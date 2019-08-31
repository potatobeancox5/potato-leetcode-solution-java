package com.potato.study.leetcode.p1108;


/**
 * 
 * @author liuzhao11
 * 
 * 	1108. Defanging an IP Address
 *  
 *         Given a valid (IPv4) IP address, return a defanged version of that IP address.

A defanged IP address replaces every period "." with "[.]".



Example 1:

Input: address = "1.1.1.1"
Output: "1[.]1[.]1[.]1"
Example 2:

Input: address = "255.100.50.0"
Output: "255[.]100[.]50[.]0"


Constraints:

The given address is a valid IPv4 address.
 *         
 *         思路：
 *
 *

 *
 */
public class Solution {

    public String defangIPaddr(String address) {
        if (null == address || address.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : address.toCharArray()) {
            // . 两侧添加字符
            if ('.' == ch) {
                sb.append("[");
                sb.append(ch);
                sb.append("]");
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
        String address = "255.100.50.0";
//        assert address.equals("1[.]1[.]1[.]1");
        String res = solution.defangIPaddr(address);
        System.out.println(res);
    }
}
