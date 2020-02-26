package com.potato.study.leetcode.p0779;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	779. K-th Symbol in Grammar
 *  
 *         On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.

Given row N and index K, return the K-th indexed symbol in row N. (The values of K are 1-indexed.) (1 indexed).

Examples:
Input: N = 1, K = 1
Output: 0

Input: N = 2, K = 1
Output: 0

Input: N = 2, K = 2
Output: 1

Input: N = 4, K = 5
Output: 1

Explanation:
row 1: 0
row 2: 01
row 3: 0110
row 4: 01101001
Note:

N will be an integer in the range [1, 30].
K will be an integer in the range [1, 2^(N-1)].
 *         
 *         思路：结果跟行数 N 无关，因为每一行都是由上一行在末尾加上数字得到的。
 *
 *
 *      比如第7个数是由第4个数算出来的，且数字等于第4个数。 第8个数是由第4个数算出来的，且数字与第4个数相反
 *      https://blog.csdn.net/xdhc304/article/details/79771031
 *
 *
 *
 * 
 */
public class Solution {

    public int kthGrammar(int n, int k) {

        if (k == 1) {
            return 0;
        }
        if (k == 2) {
            return 1;
        }

        if (k % 2 == 1) {
            return kthGrammar(-1, (k + 1 )/ 2);
        } else {
            return 1 - kthGrammar(-1, k / 2);
        }
    }
	

	public static void main(String[] args) {
		Solution solution = new Solution();

        int n = 1;
        int k = 1;
        int steps = solution.kthGrammar(n, k);
        System.out.println(steps);
        Assert.assertEquals(0, steps);


        n = 2;
        k = 1;
        steps = solution.kthGrammar(n, k);
        System.out.println(steps);
        Assert.assertEquals(0, steps);

        n = 2;
        k = 2;
        steps = solution.kthGrammar(n, k);
        System.out.println(steps);
        Assert.assertEquals(1, steps);

        n = 4;
        k = 5;
        steps = solution.kthGrammar(n, k);
        System.out.println(steps);
        Assert.assertEquals(1, steps);


    }
}
