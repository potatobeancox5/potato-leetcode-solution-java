package com.potato.study.leetcode.p0093;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 *         93. Restore IP Addresses
 *         
 *         
 *        Given a string containing only digits, restore it by returning all possible valid IP address combinations.

Example:

Input: "25525511135"
Output: ["255.255.11.135", "255.255.111.35"]


 * 
 *
 *         思路：递归记录 当前字符串 递归到最后一个位置的时候 判断是否合法 合法 就将历史记录放到 总的记录中
 *         
 *         
 *         注意事项 不要添加先导入零  和后缀0 遇到0开头的时候 只能 切割一个字符串 
 *         
 */
public class Solution {

	public List<String> restoreIpAddresses(String s) {
		List<String> result = new ArrayList<>();
		findLegalIP(result, "", s, 1);
		return result;
    }
	
	/**
	 * 
	 * 在当前剩下来的字符串中遍历合适的ip 段
	 * @param result		最终结果
	 * @param temp			ip字符串中间结果
	 * @param remandStr		当前剩余的字符串
	 * @param partIndex     当前ip段的index
	 */
	private void findLegalIP(List<String> result, String temp, String remandStr, int partIndex) {
		if(partIndex == 4) {
			// 必须将 之前的字符转完全使用
			if(isLegalIPPart(remandStr)) {
				//处理 tmp最开始的，
				temp = temp.substring(1);
				result.add(temp + "." + remandStr);
			}
			return;
		} else if(partIndex < 4) {
			//  处理当前段
			if(remandStr == null || remandStr.length() == 0) {
				return ;
			}
			if(!remandStr.startsWith("0")) { // 以0开始的字符串 只能切割成一个字符串				
				String oneSub = remandStr.substring(0, 1);
				findLegalIP(result, temp + "." + oneSub, 
						remandStr.substring(1), partIndex + 1);
				if(remandStr.length() < 2) {
					return;
				}
				String twoSub = remandStr.substring(0, 2);
				findLegalIP(result, temp + "." + twoSub, 
						remandStr.substring(2), partIndex + 1);
				if(remandStr.length() < 3) {
					return;
				}
				String threeSub = remandStr.substring(0, 3);
				if(!isLegalIPPart(threeSub)) {
					return ;
				}
				findLegalIP(result, temp + "." + threeSub, 
						remandStr.substring(3), partIndex + 1);	
			} else {// 以0开始的字符串 只能切割成一个字符串
				String oneSub = remandStr.substring(0, 1);
				findLegalIP(result, temp + "." + oneSub, 
						remandStr.substring(1), partIndex + 1);
			}
		} 
		return; 
	}
	
	/**
	 * 判断字符串时候是合法字符串 
	 * 注意：00 ， 01  类似这样的 也不合法 
	 * @param part
	 * @return
	 */
	private boolean isLegalIPPart(String part) {
		if(part == null || "".equals(part)) {
			return false;
		}
		if(part.length() > 3) {
			return false;
		}
		if(part.startsWith("0") && part.length() > 1) {
			return false;
		}
		int partInt = Integer.parseInt(part);
		if(0 <= partInt && partInt < 256) {
			return true;
		}
		return false;
	}
	

	public static void main(String[] args) {
		Solution solution = new Solution();
		String s = "25525511135";
//		String s = "0000";
//		String s = "1111";
//		String s = "010010";
		List<String> result = solution.restoreIpAddresses(s);
		System.out.println(result);
	}
}
