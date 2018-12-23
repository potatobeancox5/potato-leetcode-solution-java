package com.potato.study.leetcode.p0190;

/**
 * 
 * @author liuzhao11
 * 
 *    190. Reverse Bits
 *         
 *          
 *   Reverse bits of a given 32 bits unsigned integer.



Example 1:

Input: 00000010100101000001111010011100
Output: 00111001011110000010100101000000
Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.
Example 2:

Input: 11111111111111111111111111111101
Output: 10111111111111111111111111111111
Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293, so return 3221225471 which its binary representation is 10101111110010110010011101101001.




 *         思路： 
 *           开个数组交换数组中的🈯️值 然后数组转int
 *
 *         
 *        
 */
public class Solution {

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int[] bitArr = new int[32]; // int 32 位
        this.convertInt2BitArray(n, bitArr);
        this.reverse(bitArr);
        return convertBitArray2Int(bitArr);
    }

    private void convertInt2BitArray(int n, int[] bitArr) {
        for (int i = 0; i < 32; i++) {
            bitArr[31 - i] = n & 1;
            n = n >> 1;
        }
    }

    private int convertBitArray2Int(int[] bitArr) {
        int n = 0;
        for (int i = 0; i < 32; i++) {
            n = n << 1;
            int tmp = bitArr[i];
            n += tmp;
        }
        return n;
    }

    private void reverse (int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }

	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int nums = 0b00000010100101000001111010011100;
        int result = solution.reverseBits(nums);
        System.out.println(result);
    }
}
