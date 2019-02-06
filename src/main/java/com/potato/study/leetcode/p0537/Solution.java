package com.potato.study.leetcode.p0537;

/**
 * 
 * @author liuzhao11
 * 
 *         539. Minimum Time Difference
 * 
 *         Given two strings representing two complex numbers.

You need to return a string representing their multiplication. Note i2 = -1 according to the definition.

Example 1:
Input: "1+1i", "1+1i"
Output: "0+2i"
Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
Example 2:
Input: "1+-1i", "1+-1i"
Output: "0+-2i"
Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
Note:

The input strings will not have extra blank.
The input strings will be given in the form of a+bi, where the integer a and b will both belong to the range of [-100, 100]. And the output should be also in this form.
 * 
 * 
 *         思路：分割字符串 二项式定理计算然后求和
 *          
 */
public class Solution {

    public String complexNumberMultiply(String a, String b) {
        String[] split1 = a.split("\\+");
        String[] split2 = b.split("\\+");

        int a1 = Integer.parseInt(split1[0]);
        int a2 = Integer.parseInt(split2[0]);

        int b1 = Integer.parseInt(split1[1].substring(0, split1[1].length() - 1));
        int b2 = Integer.parseInt(split2[1].substring(0, split2[1].length() - 1));

        int sum1 = a1 * a2 - b1 * b2;
        int sum2 = a1 * b2 + a2 * b1;

        StringBuilder sb = new StringBuilder();
        sb.append(sum1).append("+").append(sum2).append("i");

        return sb.toString();
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();

		String a = "1+-1i";
		String b = "1+-1i";

        String s = solution.complexNumberMultiply(a, b);
        System.out.println(s);
    }
}
