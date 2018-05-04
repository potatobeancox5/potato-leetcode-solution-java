package com.potato.study.leetcode.p0089;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 *         89. Gray Code
 *         
 *         The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
Note:
For a given n, a gray code sequence is not uniquely defined.

For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 * 
 * 
 *         思路：
 * 			从 0 开始 与 2^i 异或 i from 0 到 n-1   然后在从0 到n - 1
 */
public class Solution {

	public List<Integer> grayCode(int n) {
		List<Integer> sequence = new ArrayList<>();
		sequence.add(0);
        if(n <= 0) {
        	return sequence;
        }
        sequence.add(1);
        if(n == 1) {
        	return sequence;
        }
        int bitNum = 2;
        for(int i = 1 ; i < n ; i++ ) { // 控制添加并反转的次数
        	int j = sequence.size() - 1;
        	while(j >= 0) {
        		sequence.add(sequence.get(j) + bitNum);
        		j--;
        	}
        	bitNum *= 2;
        }
        return sequence;
    }
	

	public static void main(String[] args) {
		Solution solution = new Solution();
//		int n = 3;
		int n = 2;
		List<Integer> seq = solution.grayCode(n);
		System.out.println(seq);
	}
}
