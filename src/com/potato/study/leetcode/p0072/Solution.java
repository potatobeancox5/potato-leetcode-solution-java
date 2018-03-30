package com.potato.study.leetcode.p0072;

/**
 * 
 * @author liuzhao11
 * 
 *         72. Edit Distance
 * 
 *         Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character
 *         思路：
 * 			
 *   可以用动态规划解题
 *   path [i+1][j+1] 代表 i位置 和 j 之前的字符串需要最少几次改变才能变成一致，
 *   i j 位置不同
 *    path [i+1][j+1]  = min {path [i][j] , path [i+1][j],path [i][j+1]}
 *   i j 位置相同
 *   	path [i+1][j+1] = path [i][j];
 * 
 * 
 */
public class Solution {

	public int minDistance(String word1, String word2) {
		if(word1 == null && word2 == null) {
			return 0;
		} else if(word1 == null) {
			return word2.length();
		} else if (word2 == null) {
			return word1.length();
		}
		int [][] times = new int[word1.length()][word2.length()];
		for(int i = 0 ; i < word1.length() ; i++) {
			for(int j = 0 ; j < word2.length() ; j++) {
				times[i][j] = Integer.MAX_VALUE;
			}
		}
		return getMinDistance(word1, word2, 0, 0, times);
    }
	
	private int getMinDistance(String word1, String word2, int index1, int index2, int[][] times) {
		if(index1 >= word1.length() && index2 >= word2.length()) {
			return 0;
		} else if(index1 >= word1.length()) {
			return word2.length() - index2;
		} else if(index2 >= word2.length()) {
			return word1.length() - index1;
		} 
		if(times[index1][index2] != Integer.MAX_VALUE) {
			return times[index1][index2];
		}
		String subWord1 = word1.substring(index1); 
		String subWord2 = word2.substring(index2); 
		if(subWord1.equals(subWord2)) {
			times[index1][index2] = 0;
			return 0;
		} else {
			int i;
			for(i = 0 ; i < subWord1.length() && i < subWord2.length() ; i++) {
				if(subWord1.charAt(i) != subWord2.charAt(i)) {
					break;
				}
			}
			//替换
			int a = getMinDistance(word1, word2, index1 + 1 + i, index2 + 1 + i, times) + 1;
			//word2 当前位置删除字母
			int b = getMinDistance(word1, word2, index1 + i, index2 + 1 + i , times) + 1;
			//word2 当前位置添加字母
			int c = getMinDistance(word1, word2, index1 + 1 + i,  index2 + i , times) + 1;
			int[] nums = {a,b,c};
			times[index1][index2] =  minValuePositive(nums);
			return times[index1][index2];
		}
	}
	
	private int minValuePositive(int ... nums) {
		int min = Integer.MAX_VALUE;
		for (int i : nums) {
			if(i >= 0 && i < min) {
				min = i;
			}
		}
		return min;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
//		String word1 = "mart";
//		String word2 = "karma";
		String word1 = "dinitrophenylhydrazine";
				String word2 = "acetylphenylhydrazine";
		int num = solution.minDistance(word1, word2);
		System.out.println(num);
	}
}
