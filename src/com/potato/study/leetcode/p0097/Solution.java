package com.potato.study.leetcode.p0097;

/**
 * 
 * @author liuzhao11
 * 
 *         97. Interleaving String
 *         
Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

Example 1:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
Output: true
Example 2:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
Output: false
 * 
 *   思路： 
 * 		判断s3 是不是由s1 和s2 的部分拼接构成
 * 
 * 		可以压缩状态量 但 每次都需要对isInterleave[0][j] 进行判断 比较麻烦
 * 采用压缩状态量的方式进行吧
 * 		
 * 		boolean isInterleave[i][j] 表示 0 到 ij 这个的这个字符串 能不能由 s1[0-i](不包含i) s2[0-j]构成
 * 
 * 		isInterleave[i][j] = isInterleave[i-1][j]（当前字母与s1【i-1】一致） 
 * 或者   isInterleave[i][j-1]（当前字母与s2【j-1】一致） 
 * 
 * j==0 重新进行判断
 * 
 * j！= 0
 * isInterleave[j] = isInterleave[j]（当前字母与s1【i】一致） 
 * 或者   isInterleave[j-1]（当前字母与s2【j】一致）
 *		初值 设置 isInterleave[0][j]  与 s2 比较
 *			设置isInterleave[i][j] 与 s1 最大匹配多少个字符
 */
public class Solution {

	public boolean isInterleave(String s1, String s2, String s3) {
		if(null == s1 || s2 == null || s3 == null) {
			return false;
		}
		if(s1.length() + s2.length() != s3.length()) {
			return false;
		}
		if("".equals(s1)) {
			return s3.equals(s2);
		} 
		if("".equals(s2)) {
			return s3.equals(s1);
		}
        boolean[] isInterleave = new boolean[s2.length() + 1];
        isInterleave[0] = true;
        //与s2 比较设置初始量
        for(int i = 1 ; i <= s2.length() ; i++) {
        	if(s3.charAt(i-1) == s2.charAt(i-1)) {
        		isInterleave[i] = true;
        	} else {
        		break;
        	}
        }
        for(int i = 1 ; i <= s1.length() ; i++) { // 控制与s1比较
        	for(int j = 1 ; j <= s2.length() ; j++) {
        		if(j == 1) {
        			isInterleave[0] = s1.substring(0,i).equals(s3.substring(0,i));
        		}
        		if(isInterleave[j-1] && s2.charAt(j-1) == s3.charAt(i + j - 1)) {
        			isInterleave[j] = true;
        		} else if (isInterleave[j] && s1.charAt(i-1) == s3.charAt(i + j - 1)) {
        			isInterleave[j] = true;
        		} else {
        			isInterleave[j] = false;
        		}
        	}
        }
        return isInterleave[s2.length()];
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		String s1 = "aabcc";
		String s2 = "dbbca";
//		String s3 = "aadbbcbcac";
		String s3 = "aadbbbaccc";
		boolean result = solution.isInterleave(s1, s2, s3);
		System.out.println(result);
	}
}
