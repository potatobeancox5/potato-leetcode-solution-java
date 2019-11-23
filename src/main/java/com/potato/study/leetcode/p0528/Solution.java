package com.potato.study.leetcode.p0528;


import java.util.Random;

/**
 * 
 * @author liuzhao11
 * 
 *         528. Random Pick with Weight
 * 
 *        Given an array w of positive integers, where w[i] describes the weight of index i, write a function pickIndex which randomly picks an index in proportion to its weight.

Note:

1 <= w.length <= 10000
1 <= w[i] <= 10^5
pickIndex will be called at most 10000 times.
Example 1:

Input:
["Solution","pickIndex"]
[[[1]],[]]
Output: [null,0]
Example 2:

Input:
["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
[[[1,3]],[],[],[],[],[]]
Output: [null,0,1,1,1,0]
Explanation of Input Syntax:

The input is two lists: the subroutines called and their arguments. Solution's constructor has one argument, the array w. pickIndex has no arguments. Arguments are always wrapped with a list, even if there aren't any.

 * 
 * 
 *         思路：
 *
 *        528. Random Pick with Weight

按照权重 随机选择数

累加 二分法查找随机到的数字在哪个区间里

https://blog.csdn.net/BigFatSheep/article/details/83318061

求sum
随机拿到val
while left 《 right
求mid
if val== sum mid return mid
else if val 小于 sum mid
right 等于mid
else
left 等于mid 加1


return left
 *
 *
 *
 *
 *
 *          
 */
public class Solution {

    private int[] sum;
    private Random random;



    public Solution(int[] w) {
        random = new Random();
        sum = new int[w.length];
        for (int i = 0; i < w.length; i++) {
            if (i == 0) {
                sum[i] = w[i];
                continue;
            }
            sum[i] = sum[i -1] + w[i];
        }
    }

    public int pickIndex() {
        int val = random.nextInt(sum[sum.length - 1]) + 1;
        // find the index
        int left = 0;
        int right = sum.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (val == sum[mid]) {
                return mid;
            } else if (val < sum[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

	
	public static void main(String[] args) {

//
//        int n = 2;
//        int res = solution.countArrangement(n);
//        System.out.println(res);
//        Assert.assertEquals(2, res);

    }
}
