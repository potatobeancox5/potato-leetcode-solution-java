package com.potato.study.leetcode.p0066;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 *         66. Plus One
 * 
 *         Given a non-negative integer represented as a non-empty array of
 *         digits, plus one to the integer.
 * 
 *         You may assume the integer do not contain any leading zero, except
 *         the number 0 itself.
 * 
 *         The digits are stored such that the most significant digit is at the
 *         head of the list.
 * 
 * 
 *         思路：
 *         	从最后依次加1 大于10 向前面加1 以此类推 某一位出现小于10的情况则不进行计算
 *         	如果到了0位置，还是10，则创建一个新数组 进行数组的copy 
 *         
 * 
 */
public class Solution {

	public int[] plusOne(int[] digits) {
		if(null == digits || digits.length == 0) {
			return digits;
		}
		digits[digits.length - 1]++;
        for(int i = digits.length - 1 ; i > 0 ; i --) {
        	if(digits[i] > 9) {
        		digits[i-1]++;
        		digits[i] -= 10;
        	} else {
        		break;
        	}
        }
        //判断是否需要创建新数组
        if (digits[0] > 9) {
        	digits[0] -= 10;
			int[] newDigits = new int[digits.length + 1];
			System.arraycopy(digits, 0, newDigits, 1, digits.length);
			newDigits[0] = 1;
			return newDigits;
		}
        return digits;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] digits = {9,9};
		int[] newDigis = solution.plusOne(digits);
		System.out.println(Arrays.toString(newDigis));
		
	}
}
