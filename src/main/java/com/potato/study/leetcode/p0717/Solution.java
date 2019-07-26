package com.potato.study.leetcode.p0717;

/**
 * 
 * @author liuzhao11
 * 
 * 	717. 1-bit and 2-bit Characters
 *  
 *         We have two special characters. The first character can be represented by one bit 0. The second character can be represented by two bits (10 or 11).

Now given a string represented by several bits. Return whether the last character must be a one-bit character or not. The given string will always end with a zero.

Example 1:
Input:
bits = [1, 0, 0]
Output: True
Explanation:
The only way to decode it is two-bit character and one-bit character. So the last character is one-bit character.
Example 2:
Input:
bits = [1, 1, 1, 0]
Output: False
Explanation:
The only way to decode it is two-bit character and two-bit character. So the last character is NOT one-bit character.
Note:

1 <= len(bits) <= 1000.
bits[i] is always 0 or 1.

 *         
 *         思路:
 *          https://blog.csdn.net/koala_tree/article/details/78472100
 *
 *          leetCode-717：1-bit and 2-bit Characters （1位和2位编码元素）-- easy

            遍历数组 至index len -1
            如果当前数字是0     index+1
            否则   index = index +2
            return index == len - 1

            隐含always zero

 *         动态方程:
 *
 * 
 */
public class Solution {

    public boolean isOneBitCharacter(int[] bits) {
        // 遍历数组 判断是否是最后一个位置  如果是的话 且为0 返回true
            // 如果当前位置是1 +2 ，如果是0
        int index = 0;
        while (index < bits.length) {
            if (index == bits.length - 1 && bits[index] == 0) {
                return true;
            }
            if (bits[index] == 0) {
                index++;
            } else {
                index = index + 2;
            }
        }
        return false;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
        int[] bits = {1, 0, 0};
        boolean res = solution.isOneBitCharacter(bits);
        System.out.println(res);
    }
}
