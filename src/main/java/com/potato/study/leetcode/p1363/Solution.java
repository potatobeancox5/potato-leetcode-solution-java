package com.potato.study.leetcode.p1363;


import org.junit.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 * 	1363. Largest Multiple of Three
 *  
 *
Given an integer array of digits, return the largest multiple of three that can be formed by concatenating some of the given digits in any order.

Since the answer may not fit in an integer data type, return the answer as a string.

If there is no answer return an empty string.



Example 1:

Input: digits = [8,1,9]
Output: "981"
Example 2:

Input: digits = [8,6,7,1,0]
Output: "8760"
Example 3:

Input: digits = [1]
Output: ""
Example 4:

Input: digits = [0,0,0,0,0,0]
Output: "0"


Constraints:

1 <= digits.length <= 10^4
0 <= digits[i] <= 9
The returning answer must not contain unnecessary leading zeros.
 *         
 *         思路：
 *
 *          https://leetcode-cn.com/problems/largest-multiple-of-three/solution/tan-xin-pai-xu-dui-ou-ji-qiao-jian-shao-dai-ma-by-/
 *
 *
 *

 *
 */
public class Solution {

    public String largestMultipleOfThree(int[] digits) {
        List<Integer>[] res = new List[3];
        for (int i = 0;i<3;i++) {
            res[i] = new ArrayList<>();
        }
        int sum = 0;
        //求和
        for(int i:digits){
            res[i%3].add(i);
            sum += i;
        }
        //排序
        for(int i=0;i<3;i++) {
            Collections.sort(res[i], Collections.reverseOrder());
        }
        int flag = sum % 3;
        //分情况讨论
        if(flag!=0){
            if(res[flag].size()>0) {
                res[flag].remove(res[flag].size()-1);
            } else if(res[3-flag].size()>1){
                res[3-flag].remove(res[3-flag].size()-1);
                res[3-flag].remove(res[3-flag].size()-1);
            } else {
                res[1].clear();
                res[2].clear();
            }
        }
        //合并求最后的结果
        res[0].addAll(res[1]);
        res[0].addAll(res[2]);
        Collections.sort(res[0], Collections.reverseOrder());
        StringBuilder sn = new StringBuilder();
        for(int i : res[0]){
            sn.append(i);
        }
        //前导零
        if(sn.length() != 0 && sn.charAt(0)=='0') {
            return "0";
        }
        return sn.toString();
    }


	public static void main(String[] args) {
        Solution solution = new Solution();
        int[] digits = new int[]{8,1,9};
        String res = solution.largestMultipleOfThree(digits);
        System.out.println(res);
        Assert.assertEquals("981", res);

    }
}
