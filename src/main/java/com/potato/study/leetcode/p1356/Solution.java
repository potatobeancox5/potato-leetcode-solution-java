package com.potato.study.leetcode.p1356;


import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * @author liuzhao11
 * 
 * 	1356. Sort Integers by The Number of 1 Bits
 *  
 *  Given an integer array arr. You have to sort the integers in the array in ascending order by the number of 1's in their binary representation and in case of two or more integers have the same number of 1's you have to sort them in ascending order.

Return the sorted array.



Example 1:

Input: arr = [0,1,2,3,4,5,6,7,8]
Output: [0,1,2,4,8,3,5,6,7]
Explantion: [0] is the only integer with 0 bits.
[1,2,4,8] all have 1 bit.
[3,5,6] have 2 bits.
[7] has 3 bits.
The sorted array by bits is [0,1,2,4,8,3,5,6,7]
Example 2:

Input: arr = [1024,512,256,128,64,32,16,8,4,2,1]
Output: [1,2,4,8,16,32,64,128,256,512,1024]
Explantion: All integers have 1 bit in the binary representation, you should just sort them in ascending order.
Example 3:

Input: arr = [10000,10000]
Output: [10000,10000]
Example 4:

Input: arr = [2,3,5,7,11,13,17,19]
Output: [2,3,5,17,7,11,13,19]
Example 5:

Input: arr = [10,100,1000,10000]
Output: [10,100,10000,1000]


Constraints:

1 <= arr.length <= 500
0 <= arr[i] <= 10^4
 *         
 *         思路：
 *
 *
 *
 *
 */
public class Solution {

    public int[] sortByBits(int[] arr) {

        Integer[] target = new Integer[arr.length];

        for (int i = 0; i < arr.length; i++) {
            target[i] = arr[i];
        }

        Arrays.sort(target, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int count1 = getBinaryCountOne(o1);
                int count2 = getBinaryCountOne(o2);
                if (count1 == count2) {
                    return o1 - o2;
                }
                return count1 - count2;
            }
        });

        for (int i = 0; i < arr.length; i++) {
            arr[i] = target[i];
        }

        return arr;
    }


    /**
     * 返回数字 num 中 1的数量
     * @param num
     * @return
     */
    private int getBinaryCountOne(int num) {
        int count = 0;
        while (num > 0) {
            if (num % 2 == 1) {
                count++;
            }
            num /= 2;
        }
        return count;
    }

	public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{0,1,2,3,4,5,6,7,8};
        int[] res = solution.sortByBits(arr);
        System.out.println(Arrays.toString(res));

        arr = new int[]{1024,512,256,128,64,32,16,8,4,2,1};
        res = solution.sortByBits(arr);
        System.out.println(Arrays.toString(res));




    }
}
