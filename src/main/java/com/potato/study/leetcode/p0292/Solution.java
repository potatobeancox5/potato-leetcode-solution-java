package com.potato.study.leetcode.p0292;

/**
 * 
 * @author liuzhao11
 * 
 * 
 * 292. Nim Game
 You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first turn to remove the stones.

Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can win the game given the number of stones in the heap.

Example:

Input: 4
Output: false 
Explanation: If there are 4 stones in the heap, then you will never win the game;
             No matter 1, 2, or 3 stones you remove, the last stone will always be 
             removed by your friend.
             1 - win
             2 - win
             3 - win
             4 - lose
             5 - win
             6 - win 
             7 - win
             8 - lose
* 		思路： 对4 取余数   4的倍数一定是输的
* 
 */
public class Solution {
	
	
	public boolean canWinNim(int n) {
        if(n / 4 * 4 == n) {
        	return false;
        }
        return true;
    }
	
	
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	int n = 5;
    	boolean canWin = solution.canWinNim(n);
    	System.out.println(canWin);
	}
}
