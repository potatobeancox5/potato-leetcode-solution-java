package com.potato.study.leetcode.p1304;



import java.util.Arrays;


/**
 * 
 * @author liuzhao11
 * 
 * 	1304. Find N Unique Integers Sum up to Zero
 *  
 *
Given an integer n, return any array containing n unique integers such that they add up to 0.



Example 1:

Input: n = 5
Output: [-7,-1,1,3,4]
Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
Example 2:

Input: n = 3
Output: [-1,0,1]
Example 3:

Input: n = 1
Output: [0]


Constraints:

1 <= n <= 1000
 *         
 *         思路：
 *
 *
 *
 *
 *

 *
 */
public class Solution {

    public int[] sumZero(int n) {
        // 奇数带 0 偶数不带0
        int[] res = new int[n];
        int index = 0;
        if (n % 2 == 1) {
            res[0] = 0;
            index++;
        }
        int num = 1;
        while (index < n) {
            res[index] = num;
            res[index+1] = -num;
            num++;
            index+=2;
        }
        return res;
    }

	public static void main(String[] args) {
        Solution solution = new Solution();

        int n = 5;
        int[] res = solution.sumZero(n);
        System.out.println(Arrays.toString(res)); // -7,-1,1,3,4

        n = 3;
        res = solution.sumZero(n);
        System.out.println(Arrays.toString(res)); // -1,0,1

        n = 1;
        res = solution.sumZero(n);
        System.out.println(Arrays.toString(res)); // 0


    }
}
