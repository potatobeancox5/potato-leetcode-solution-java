package com.potato.study.leetcode.p1253;


import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 * 	1253. Reconstruct a 2-Row Binary Matrix
 *  
 *
Given the following details of a matrix with n columns and 2 rows :

The matrix is a binary matrix, which means each element in the matrix can be 0 or 1.
The sum of elements of the 0-th(upper) row is given as upper.
The sum of elements of the 1-st(lower) row is given as lower.
The sum of elements in the i-th column(0-indexed) is colsum[i], where colsum is given as an integer array with length n.
Your task is to reconstruct the matrix with upper, lower and colsum.

Return it as a 2-D integer array.

If there are more than one valid solution, any of them will be accepted.

If no valid solution exists, return an empty 2-D array.



Example 1:

Input: upper = 2, lower = 1, colsum = [1,1,1]
Output: [[1,1,0],[0,0,1]]
Explanation: [[1,0,1],[0,1,0]], and [[0,1,1],[1,0,0]] are also correct answers.
Example 2:

Input: upper = 2, lower = 3, colsum = [2,2,1,1]
Output: []
Example 3:

Input: upper = 5, lower = 5, colsum = [2,1,2,0,1,0,1,2,0,1]
Output: [[1,1,1,0,1,0,0,1,0,0],[1,0,1,0,0,0,1,1,0,1]]


Constraints:

1 <= colsum.length <= 10^5
0 <= upper, lower <= colsum.length
0 <= colsum[i] <= 2
 *         
 *         思路：
 *          https://leetcode-cn.com/problems/reconstruct-a-2-row-binary-matrix/solution/java-tan-xin-suan-fa-xiang-jie-by-amanehayashi/
 *
 *
 */
public class Solution {

    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        // up记录第0行可分配的1个数，lo记录第1行可分配的1个数
        int up = upper, lo = lower, sum = 0, len = colsum.length;
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < len; i ++){
            if(colsum[i] == 2){
                up --;
                lo --;
            }
            else if(colsum[i] == 1){
                sum++;
            }
        }
        // 如果行列元素之和不相等，或行元素之和不够分配
        if(up + lo != sum || up < 0 || lo < 0){
            return list;
        }
        List<Integer> upl = new ArrayList<>();
        List<Integer> lol = new ArrayList<>();
        for(int i = 0; i < len; i ++){
            if(colsum[i] == 2){
                upl.add(1);
                lol.add(1);
            } else if(colsum[i] == 0){
                upl.add(0);
                lol.add(0);
            } else {
                // 先分配上
                if(up-- > 0){
                    upl.add(1);
                    lol.add(0);
                }
                // 再分配下
                else {
                    lol.add(1);
                    upl.add(0);
                }
            }
        }
        list.add(upl);
        list.add(lol);
        return list;
    }
}
