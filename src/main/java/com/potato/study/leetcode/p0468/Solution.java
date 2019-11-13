package com.potato.study.leetcode.p0468;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 *         468. Validate IP Address
 * 
 *         Write a function to check whether an input string is a valid IPv4 address or IPv6 address or neither.

IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers, each ranging from 0 to 255, separated by dots ("."), e.g.,172.16.254.1;

Besides, leading zeros in the IPv4 is invalid. For example, the address 172.16.254.01 is invalid.

IPv6 addresses are represented as eight groups of four hexadecimal digits, each group representing 16 bits. The groups are separated by colons (":"). For example, the address 2001:0db8:85a3:0000:0000:8a2e:0370:7334 is a valid one. Also, we could omit some leading zeros among four hexadecimal digits and some low-case characters in the address to upper-case ones, so 2001:db8:85a3:0:0:8A2E:0370:7334 is also a valid IPv6 address(Omit leading zeros and using upper cases).

However, we don't replace a consecutive group of zero value with a single empty group using two consecutive colons (::) to pursue simplicity. For example, 2001:0db8:85a3::8A2E:0370:7334 is an invalid IPv6 address.

Besides, extra leading zeros in the IPv6 is also invalid. For example, the address 02001:0db8:85a3:0000:0000:8a2e:0370:7334 is invalid.

Note: You may assume there is no extra space or special characters in the input string.

Example 1:
Input: "172.16.254.1"

Output: "IPv4"

Explanation: This is a valid IPv4 address, return "IPv4".
Example 2:
Input: "2001:0db8:85a3:0:0:8A2E:0370:7334"

Output: "IPv6"

Explanation: This is a valid IPv6 address, return "IPv6".
Example 3:
Input: "256.256.256.256"

Output: "Neither"

Explanation: This is neither a IPv4 address nor a IPv6 address.
 * 
 * 
 *         思路：
 *          468. Validate IP Address

空 返回neither
if  包含 ：v6 判断
split   ：
小于 8节 false
对于每个part
大于 4字母 有问题
if 16位parse 有问题false
parse 出来超限制了 有问题 16^16




else   v4
分割
不是4节有问题
parse 不出来falese
parse 出来不在0-255 间有问题
大于1的小节 从0开始 有问题
 *
 *
 * 				
 */	
public class Solution {

    public String validIPAddress(String ip) {
        // 空 返回neither
        if (null == ip || "".equals(ip.trim())) {
            return "Neither";
        }
        if (ip.contains("-")) {
            return "Neither";
        }
        if (ip.startsWith(":") || ip.endsWith(":") || ip.startsWith(".") || ip.endsWith(".")) {
            return "Neither";
        }
        if (ip.contains(":")) {
            String[] ipParts = ip.split(":");
            // 小于 8节 false
            if (ipParts.length != 8) {
                return "Neither";
            }
            for (String ipPart : ipParts) {
                // 大于 4字母 有问题
                if (ipPart.length() > 4) {
                    return "Neither";
                }
                try {
                    int num = Integer.parseInt(ipPart, 16);
                    // parse 出来超限制了 有问题 16^16
                    if (num >= 0xFFFF || num < 0) {
                        return "Neither";
                    }
                    // 先导0
//                    if (num != 0 && !ipPart.equals("" + num)) {
//                        return "Neither";
//                    }
                } catch (Exception e) {
                    // 16位parse 有问题false
                    return "Neither";
                }
            }
            return "IPv6";
        } else if (ip.contains(".")) {
            String[] ipParts = ip.split("\\.");
            // 小于 4节 false
            if (ipParts.length != 4) {
                return "Neither";
            }
            for (String ipPart : ipParts) {
                // 大于 4字母 有问题
                if (ipPart.length() > 3) {
                    return "Neither";
                }
                try {
                    int num = Integer.parseInt(ipPart);
                    // parse 出来超限制了 有问题 256
                    if (num >= 256 || num < 0) {
                        return "Neither";
                    }
                    // 先导0
                    if (!ipPart.equals("" + num)) {
                        return "Neither";
                    }

                } catch (Exception e) {
                    // 16位parse 有问题false
                    return "Neither";
                }
            }
            return "IPv4";
        }
        return "Neither";
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
        String ip = "172.16.254.1";
        String res = solution.validIPAddress(ip);
		System.out.println(res);
        Assert.assertEquals("IPv4", res);

        ip = "2001:0db8:85a3:0:0:8A2E:0370:7334";
        res = solution.validIPAddress(ip);
        System.out.println(res);
        Assert.assertEquals("IPv6", res);

        ip = "256.256.256.256";
        res = solution.validIPAddress(ip);
        System.out.println(res);
        Assert.assertEquals("Neither", res);


        ip = "1081:db8:85a3:01:-0:8A2E:0370:7334";
        res = solution.validIPAddress(ip);
        System.out.println(res);
        Assert.assertEquals("Neither", res);
    }
}
