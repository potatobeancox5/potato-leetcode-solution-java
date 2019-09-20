package com.potato.study.leetcode.p0982;


import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 * 	982. Triples with Bitwise AND Equal To Zero
 *  
 *         Given an array of integers A, find the number of triples of indices (i, j, k) such that:

0 <= i < A.length
0 <= j < A.length
0 <= k < A.length
A[i] & A[j] & A[k] == 0, where & represents the bitwise-AND operator.


Example 1:

Input: [2,1,3]
Output: 12
Explanation: We could choose the following i, j, k triples:
(i=0, j=0, k=1) : 2 & 2 & 1
(i=0, j=1, k=0) : 2 & 1 & 2
(i=0, j=1, k=1) : 2 & 1 & 1
(i=0, j=1, k=2) : 2 & 1 & 3
(i=0, j=2, k=1) : 2 & 3 & 1
(i=1, j=0, k=0) : 1 & 2 & 2
(i=1, j=0, k=1) : 1 & 2 & 1
(i=1, j=0, k=2) : 1 & 2 & 3
(i=1, j=1, k=0) : 1 & 1 & 2
(i=1, j=2, k=0) : 1 & 3 & 2
(i=2, j=0, k=1) : 3 & 2 & 1
(i=2, j=1, k=0) : 3 & 1 & 2


Note:

1 <= A.length <= 1000
0 <= A[i] < 2^16


        题目含义
            给一个数组，在数组中找3个数，使得三个数字之间进行 & 记过是0
 *
 *      思路：
 *      https://blog.csdn.net/M_sdn/article/details/86665174
https://blog.csdn.net/fuxuemingzhu/article/details/86667263
双重循环 求出两个数的& 然后使用map 记录 key &的值，value 出现的次数
然后单重循环遍历剩下的数字 和mapkey 求出最终为0的个数

  因为最终返回的也是次数 = 每个key 出现的次数的和 所以需要记录 每个key 出现的次数

 */
public class Solution {

    /**
     *
     * @param array
     * @return
     */
    public int countTriplets(int[] array) {
        Map<Integer, Integer> doubleOperandAndTimes = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                int key = array[i] & array[j];
                Integer times = doubleOperandAndTimes.get(key);
                if (times == null) {
                    doubleOperandAndTimes.put(key, 1);
                } else {
                    doubleOperandAndTimes.put(key, times + 1);
                }
            }
        }
        // 最终计算次数
        int totalCount = 0;
        for (int i = 0; i < array.length; i++) {
            // 遍历map
            for (Map.Entry<Integer, Integer> entry : doubleOperandAndTimes.entrySet()) {
                if ((entry.getKey() & array[i]) == 0) {
                    totalCount += entry.getValue();
                }
            }
        }
        return totalCount;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {2,1,3};
        int tripletNum = solution.countTriplets(array);
        Assert.assertEquals(12, tripletNum);

        System.out.println(tripletNum);
    }
}
