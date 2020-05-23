package com.potato.study.leetcode.p1447;


import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 * 	1447. Simplified Fractions
 *  
 *
Given an integer n, return a list of all simplified fractions between 0 and 1 (exclusive) such that the denominator is less-than-or-equal-to n. The fractions can be in any order.



Example 1:

Input: n = 2
Output: ["1/2"]
Explanation: "1/2" is the only unique fraction with a denominator less-than-or-equal-to 2.
Example 2:

Input: n = 3
Output: ["1/2","1/3","2/3"]
Example 3:

Input: n = 4
Output: ["1/2","1/3","1/4","2/3","3/4"]
Explanation: "2/4" is not a simplified fraction because it can be simplified to "1/2".
Example 4:

Input: n = 1
Output: []


Constraints:

1 <= n <= 100
 *         
 *
 *
 *
 *  思路：
 *  https://leetcode-cn.com/problems/simplified-fractions/solution/bian-li-pan-duan-fen-zi-yu-fen-mu-shi-fou-hu-wei-z/
 *
 *
 */
public class Solution {



    public List<String> simplifiedFractions(int n) {
        // 遍历确定分子和分母
        List<String> result = new ArrayList<>();

        for (int i = n; i >= 1 ; i--) {
            for (int j = i-1; j >= 1 ; j--) {
                if(!isMaxCommonDivisor(i, j) || j == 1){
                    result.add(j + "/" + i);
                }
            }
        }
        return result;
    }

    /**
     * 确定 是否有公约数
     * @param i
     * @param j
     * @return
     */
    private boolean isMaxCommonDivisor(int i, int j) {
        // i 需要比 j 大
        if(i < j){
            int temp = i;
            i = j;
            j = temp;
        }
        if(j == 1){
            return false;
        }
        if(i % j == 0){
            return true;
        }else {
            return isMaxCommonDivisor(j, i % j);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 2;
        List<String> list = solution.simplifiedFractions(n);
        System.out.println(list);
    }
}
