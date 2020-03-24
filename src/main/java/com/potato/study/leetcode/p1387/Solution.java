package com.potato.study.leetcode.p1387;


import org.junit.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 * 	1387. Sort Integers by The Power Value
 *  
 *
The power of an integer x is defined as the number of steps needed to transform x into 1 using the following steps:

if x is even then x = x / 2
if x is odd then x = 3 * x + 1
For example, the power of x = 3 is 7 because 3 needs 7 steps to become 1 (3 --> 10 --> 5 --> 16 --> 8 --> 4 --> 2 --> 1).

Given three integers lo, hi and k. The task is to sort all integers in the interval [lo, hi] by the power value in ascending order, if two or more integers have the same power value sort them by ascending order.

Return the k-th integer in the range [lo, hi] sorted by the power value.

Notice that for any integer x (lo <= x <= hi) it is guaranteed that x will transform into 1 using these steps and that the power of x is will fit in 32 bit signed integer.



Example 1:

Input: lo = 12, hi = 15, k = 2
Output: 13
Explanation: The power of 12 is 9 (12 --> 6 --> 3 --> 10 --> 5 --> 16 --> 8 --> 4 --> 2 --> 1)
The power of 13 is 9
The power of 14 is 17
The power of 15 is 17
The interval sorted by the power value [12,13,14,15]. For k = 2 answer is the second element which is 13.
Notice that 12 and 13 have the same power value and we sorted them in ascending order. Same for 14 and 15.
Example 2:

Input: lo = 1, hi = 1, k = 1
Output: 1
Example 3:

Input: lo = 7, hi = 11, k = 4
Output: 7
Explanation: The power array corresponding to the interval [7, 8, 9, 10, 11] is [16, 3, 19, 6, 14].
The interval sorted by power is [8, 10, 11, 7, 9].
The fourth number in the sorted array is 7.
Example 4:

Input: lo = 10, hi = 20, k = 5
Output: 13
Example 5:

Input: lo = 1, hi = 1000, k = 777
Output: 570


Constraints:

1 <= lo <= hi <= 1000
1 <= k <= hi - lo + 1
Accepted
 *         
 *         思路：
 *          定义一组操作 将一个数 转换成 1
 *          lo 到 hi 按照 power操作数 升序排序 求出 第 k哥数
 *
 *
 */
public class Solution {


    public int getKth(int lo, int hi, int k) {
        // list  int[] 排序
        List<int[]> powerList = new ArrayList<>();
        for (int i = lo; i <= hi; i++) {
            powerList.add(new int[]{i, getPowerTimes(i)});
        }
        Collections.sort(powerList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }

                return o1[1] - o2[1];
            }
        });


        return powerList.get(k-1)[0];
    }

    /**
     * 求 target 经过 几次操作可以达成 1
     * @param target
     * @return
     */
    private int getPowerTimes(int target) {
        int count = 0;
        while (target != 1) {
            if (target % 2 == 1) {
                target = (3 * target + 1);
            } else {
                target /= 2;
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int lo = 12;
        int hi = 15;
        int k = 2;
        Solution solution = new Solution();
        int kth = solution.getKth(lo, hi, k);
        System.out.println(kth);
        Assert.assertEquals(13, kth);



    }
}
