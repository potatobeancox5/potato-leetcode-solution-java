package com.potato.study.leetcode.p0038;

/**
 * 
 * @author liuzhao11
 * 
 *         38. Count and Say
 * 
 * 
 *         The count-and-say sequence is the sequence of integers with the first
 *         five terms as following:
 * 
 *         1. 1 2. 11 3. 21 4. 1211 5. 111221 1 is read off as "one 1" or 11. 11
 *         is read off as "two 1s" or 21. 21 is read off as "one 2, then one 1"
 *         or 1211. Given an integer n, generate the nth term of the
 *         count-and-say sequence.
 * 
 *         Note: Each term of the sequence of integers will be represented as a
 *         string.
 * 
 *         Example 1:
 * 
 *         Input: 1 Output: "1"
 *         
 *          Example 2:
 * 
 *         Input: 4 Output: "1211"
 * 
 * 
 *         思路：
 *         给定 数组 按照上面规则 数数
 *         1 1个1 11
 *         2 2个1 21
 *         3 1个2 1个1 1211
 *         4 1个1 1个2 2个1 111221
 *         获取上一个字符串（n-1）时候的字符串 str 
 *         		使用递归获取字符字符串 1 返回 "1"
 *         对 str 进行遍历计数 每个位置和前一个位置不相同 结算最终的count和数字 并新数字 的count=1，相同count++
 * 
 */
public class Solution {
	
	/**
	 * 递归方法获取上一个位置字符串，并对获取的字符串进行数数
	 * 
	 * @param n
	 * @return
	 */
	public String countAndSay(int n) {
        if(n <= 0) {
        	return "";
        } 
        if(n == 1) { // 初值条件
        	return "1";
        } 
        // 不为1情形 , 获取上一个位置的字符串
        String preString = countAndSay(n-1);
        StringBuilder sBuilder = new StringBuilder();// 用于结算字符串
        // 计算当前字符串
        int count = 0;// 前一个位置的字符出现的次数
        for(int i = 0 ; i < preString.length() ; i++) {
        	if(i == 0) {
        		count++;
        		continue;
        	} 
        	//不为0的情况
        	//char currentChar = preString.charAt(i);
        	if(preString.charAt(i) == preString.charAt(i-1)) {
        		count++;
        	} else { // 结算之前的字符
        		sBuilder.append(count).append(preString.charAt(i - 1));
        		count = 1;
        	}
        }
        //结算最后一个字符
        sBuilder.append(count).append(preString.charAt(preString.length() - 1));
        return sBuilder.toString();
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
		int n = 5;
		String result = solution.countAndSay(n);
		System.out.println(result);
	}
}
