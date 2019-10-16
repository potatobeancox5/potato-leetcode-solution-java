package com.potato.study.leetcode.p0440;


import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 *   440. K-th Smallest in Lexicographical Order
 * 
 *    Given integers n and k, find the lexicographically k-th smallest integer in the range from 1 to n.

Note: 1 ≤ k ≤ n ≤ 109.

Example:

Input:
n: 13   k: 2

Output:
10

Explanation:
The lexicographical order is [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9], so the second smallest number is 10.
 * 			
 *     思路：
 *
 *     440. K-th Smallest in Lexicographical Order
 *     
 * 			https://blog.csdn.net/excellentlizhensbfhw/article/details/81103616
 *
 * 	        从 i= 1 开始
 *
 * 	          while
 * 	            获取 i作为前缀 到 i+1位置 有多少个 小于 n的值 count
 * 	            if count < k
 * 	                说明 kth 位置不在 i作为前缀的路子里 往i+1找
 * 	            否则 kth 就在 i的 前缀中
 * 	                那么下一个找的就是 i0 - ii
 *
 *
 *
 *
 * 	
 */	
public class Solution {

    public int findKthNumber(int n, int k) {
        int target = 1;
        while (k > 1) {
            int curentCount = this.getCount(target, target + 1, n);
            if (curentCount < k) {
                k -= curentCount;
                target++;
            } else {
                target *= 10;
                // target 这个数用完了
                k--;
            }
        }
        return target;
    }


    /**
     * 找到 start为前缀 到 end为前缀之前 小于n 的个数
     * @param start
     * @param end
     * @param n
     * @return
     */
    private int getCount (long start, long end, int n) {
        int count = 0;
        while (start <= n) {
            count += Math.min(n+1, end) - start;
            end *= 10;
            start *= 10;
        }
        return count;
    }
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int n = 13;
		int k = 2;
		int num = solution.findKthNumber(n, k);
		System.out.println(num);
        Assert.assertEquals(10, num);

        n = 10;
        k = 3;
        num = solution.findKthNumber(n, k);
        System.out.println(num);
        Assert.assertEquals(2, num);


        n = 100;
        k = 90;
        num = solution.findKthNumber(n, k);
        System.out.println(num);
        Assert.assertEquals(9, num);
	}
}
