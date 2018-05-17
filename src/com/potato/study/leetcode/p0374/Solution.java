package com.potato.study.leetcode.p0374;

/**
 * 
 * @author liuzhao11
 * 
 *       374. Guess Number Higher or Lower
 * 
 *      We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I'll tell you whether the number is higher or lower.

You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

-1 : My number is lower
 1 : My number is higher
 0 : Congrats! You got it!
Example:
n = 10, I pick 6.

Return 6.      
 *         
 *         思路：
 *         https://blog.csdn.net/y12345678904/article/details/51898958
 */
/* 调用api
 * The guess API is defined in the parent class GuessGame.
@param num, your guess
@return -1 if my number is lower, 1 if my number is higher, otherwise return 0
   int guess(int num); */
public class Solution extends GuessGame {
	
	public int guessNumber(int n) {
		int low = 1;
		int high = n;
		while(low < high) {
//			int tmp = (low + high) / 2;
			int tmp = low + (high - low) / 2; 
			int res = guess(tmp);
			if(res == 0) {
				return tmp;
			} else if (res == 1) {
				low = tmp + 1;
//				high = tmp - 1;
			} else { // res < 0
//				low = tmp + 1;
				high = tmp - 1;
			}
		}
		return low;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int n = 10;
		int sum = solution.guessNumber(n);
		System.out.println(sum);
	}
}

class GuessGame{
	public int guess(int num) {
		if(num - 6 > 0) {
			return 1;
		} else if(num - 6 < 0) {
			return -1;
		} else {
			return 0;
		}
	}
}
