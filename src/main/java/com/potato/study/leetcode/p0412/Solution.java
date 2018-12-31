package com.potato.study.leetcode.p0412;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 *         412. Fizz Buzz
 * 
 *         Write a program that outputs the string representation of numbers from 1 to n.

But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.

Example:

n = 15,

Return:
[
    "1",
    "2",
    "Fizz",
    "4",
    "Buzz",
    "Fizz",
    "7",
    "8",
    "Fizz",
    "Buzz",
    "11",
    "Fizz",
    "13",
    "14",
    "FizzBuzz"
]
 * 
 * 
 *         思路： 遇到3的倍数 输出 Fizz 遇到5的倍数 输出 Buzz 遇到15的倍数 输出 FizzBuzz
 *         i / 3 * 3 == i 这样判断是否能整除
 * 
 */
public class Solution {
	
	public List<String> fizzBuzz(int n) {
		List<String> list = new ArrayList<>();
        for(int i = 1 ; i <= n ; i++) {
        	if(i % 15 == 0) {
        		list.add("FizzBuzz");
        	} else if(i % 5 ==0) {
        		list.add("Buzz");
        	} else if(i % 3 == 0) {
        		list.add("Fizz");
    		} else {
    			list.add("" + i);
    		}
        }
        return list;
    }
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int n = 15;
		List<String> list = solution.fizzBuzz(n);
		System.out.println(list);
	}
}
