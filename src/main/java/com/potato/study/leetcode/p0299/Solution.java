package com.potato.study.leetcode.p0299;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 * 
 * 299. Bulls and Cows
 You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints to eventually derive the secret number.

Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows. 

Please note that both secret number and friend's guess may contain duplicate digits.

Example 1:

Input: secret = "1807", guess = "7810"

Output: "1A3B"

Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.
Example 2:

Input: secret = "1123", guess = "0111"

Output: "1A1B"

Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.
Note: You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.
* 		
* 
* 
* 思路：
* b 位置和数字都对 是b
* c 只有数字对 位置不对是c
* 先确定有几个b 剩下的字母进行排序 然后 用一个map 存剩下的字符串 在用guess 的减去
* 
 */
public class Solution {
	
	public String getHint(String secret, String guess) {
		int countB = 0;
		int countC = 0;
		Map<Character, Integer> mapS = new HashMap<>();
		Map<Character, Integer> mapG = new HashMap<>();
        for(int i = 0 ; i < secret.length() ; i++) {
        	if(secret.charAt(i) == guess.charAt(i)) {
        		countB++;
        	} else { // 统计数量 两个map中的字母能够构成c
        		if(mapS.containsKey(secret.charAt(i))) {
        			mapS.put(secret.charAt(i), mapS.get(secret.charAt(i)) + 1);
        		} else {
        			mapS.put(secret.charAt(i), 1);
        		}
        		if(mapG.containsKey(guess.charAt(i))) {
        			mapG.put(guess.charAt(i), mapG.get(guess.charAt(i)) + 1);
        		} else {
        			mapG.put(guess.charAt(i), 1);
        		}
        	}
        }
        // 遍历 mapS 然后 到mapG 中找  记录次数
        for (Character ch : mapS.keySet()) {
			if(mapG.containsKey(ch)) {
				int tmp = mapS.get(ch) > mapG.get(ch) ? mapG.get(ch) : mapS.get(ch);
				countC += tmp;
			}
		}
        return countB + "A" + countC + "B";//1A1B
    }
	
	
    public static void main(String[] args) {
    	Solution solution = new Solution();
//    	String secret = "1807";
//    	String guess = "7810";
//    	String secret = "1123";
//    	String guess = "0111";
    	String secret = "1122";
    	String guess = "2211";
    	String string = solution.getHint(secret, guess);
    	System.out.println(string);
	}
}
