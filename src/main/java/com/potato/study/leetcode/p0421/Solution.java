package com.potato.study.leetcode.p0421;

import org.junit.Assert;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author liuzhao11
 * 
 *         421. Maximum XOR of Two Numbers in an Array
 * 
 *         Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.

Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.

Could you do this in O(n) runtime?

Example:

Input: [3, 10, 5, 25, 2, 8]

Output: 28

Explanation: The maximum result is 5 ^ 25 = 28.
 *
 *
 *         题目含义：给一个数组，求这个数组中向异或能得到的最大值
 * 
 *         思路：
 *         https://www.jianshu.com/p/2af9296a6b0b
 *
 *         max 记录当前最大值
 *
 *
 *         对于mask 32位，从 第32位为1 来进行比较
 *
 *          mask 为目前为止可能的最大值的前缀
 *          a or b = tmp
 *          a or tmp = b  用到这个， 如果 a的最高为 xor tmp 存在于
 *          b or tmp = a
 *
 *          mask用来获取a的最高位
 *
 *          相同的位置 xor 一定为0 说明 每次从高位开始比较，对于每次的 tmpmask  高位max + 1， 使用 max 记录最大值
 *
 *         for i 0 - 32
 *              每次计算当前mask
 *
 *
 *         https://www.jianshu.com/p/5575af8edaa1
 *
 *
 * 
 */
public class Solution {

    public int findMaximumXOR(int[] nums) {
        // 用于获取某个数字的最高位
        int mask = 0;
        int max = 0;
        int tmp;
        for (int i = 31; i >=0; i--) {
            // 1. 生成当前的mask
            mask = mask | (1 << i);
            // 2. 计算一个set 存储当前位置都有哪些值
            Set<Integer> prefixNumSet = new HashSet<>();
            for (int num : nums) {
                prefixNumSet.add(num & mask);
            }
            // 3. 生成当前可能的最大值
            tmp = (max|(1 << i));
            for (int prefix : prefixNumSet) {
                if (prefixNumSet.contains(prefix ^ tmp)) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
        int[] nums = {3, 10, 5, 25, 2, 8};
        int count = solution.findMaximumXOR(nums);
        System.out.println(count);
        Assert.assertEquals(28, count);

    }
}
