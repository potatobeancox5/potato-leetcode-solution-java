package com.potato.study.leetcode.p1432;


/**
 * 
 * @author liuzhao11
 * 
 * 	1432. Max Difference You Can Get From Changing an Integer
 *  
 *
You are given an integer num. You will apply the following steps exactly two times:

Pick a digit x (0 <= x <= 9).
Pick another digit y (0 <= y <= 9). The digit y can be equal to x.
Replace all the occurrences of x in the decimal representation of num by y.
The new integer cannot have any leading zeros, also the new integer cannot be 0.
Let a and b be the results of applying the operations to num the first and second times, respectively.

Return the max difference between a and b.



Example 1:

Input: num = 555
Output: 888
Explanation: The first time pick x = 5 and y = 9 and store the new integer in a.
The second time pick x = 5 and y = 1 and store the new integer in b.
We have now a = 999 and b = 111 and max difference = 888
Example 2:

Input: num = 9
Output: 8
Explanation: The first time pick x = 9 and y = 9 and store the new integer in a.
The second time pick x = 9 and y = 1 and store the new integer in b.
We have now a = 9 and b = 1 and max difference = 8
Example 3:

Input: num = 123456
Output: 820000
Example 4:

Input: num = 10000
Output: 80000
Example 5:

Input: num = 9288
Output: 8700


Constraints:

1 <= num <= 10^8
 *         
 *
 *
 *
 * 思路：
 *
 *  https://leetcode-cn.com/problems/max-difference-you-can-get-from-changing-an-integer/solution/jian-dan-rong-yi-li-jie-by-qi-xi-5/
 *
 *
 *
 *
 */
public class Solution {


    public int maxDiff(int num) {
        // 将数字转为字符数组存储
        char[] ch1 = String.valueOf(num).toCharArray();
        char[] ch2 = ch1.clone();
        // 保存最大值
        for(int i=0; i<ch1.length; i++){
            // 从第一位判断是否为9
            if(ch1[i] != 57){
                char c = ch1[i];
                // 将后面同样数字赋值为9
                for(int j=i; j<ch1.length; j++){
                    if(ch1[j] == c) {
                        ch1[j] = 57;
                    }
                }
                break;
            }
        }
        // 保存最小值，判断第一位是否为1
        if(ch2[0] != 49){
            char c = ch2[0];
            for(int i=0; i<ch2.length; i++){
                if(ch2[i] == c) {
                    ch2[i] = 49;
                }
            }
        } else{
            for(int i=1; i<ch2.length; i++){
                // 判断后面数字不为0且不为第一位，赋值为0
                if(ch2[i] != 48 && ch2[i] != ch2[0]){
                    char c = ch2[i];
                    for(int j=i; j<ch2.length; j++){
                        if(ch2[j] == c) {
                            ch2[j] = 48;
                        }
                    }
                    break;
                }
            }
        }
        return Integer.parseInt(String.valueOf(ch1))-Integer.parseInt(String.valueOf(ch2));
    }
}
