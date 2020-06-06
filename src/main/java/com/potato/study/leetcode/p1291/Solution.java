package com.potato.study.leetcode.p1291;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 * 	1291. Sequential Digits
 *  
 *
An integer has sequential digits if and only if each digit in the number is one more than the previous digit.

Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.



Example 1:

Input: low = 100, high = 300
Output: [123,234]
Example 2:

Input: low = 1000, high = 13000
Output: [1234,2345,3456,4567,5678,6789,12345]


Constraints:

10 <= low <= high <= 10^9
 *         
 *         思路：
 *
 *          https://leetcode-cn.com/problems/sequential-digits/solution/zhu-jian-gai-bian-si-wei-fang-shi-by-bigsaobi/
 *
 */
public class Solution {

    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        for(int i = 1; i <= 9; i++){
            int num = i;
            for(int j = i+1;j <= 9; j++){
                num = num*10+j;
                if(num>= low && num<= high){
                    res.add(num);
                }
                if(num>=high){
                    break;
                }
            }
        }
        Collections.sort(res);
        return res;
    }

}
