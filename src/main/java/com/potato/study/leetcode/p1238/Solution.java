package com.potato.study.leetcode.p1238;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author liuzhao11
 * 
 * 	1238. Circular Permutation in Binary Representation
 *  
 *      Given 2 integers n and start. Your task is return any permutation p of (0,1,2.....,2^n -1) such that :

p[0] = start
p[i] and p[i+1] differ by only one bit in their binary representation.
p[0] and p[2^n -1] must also differ by only one bit in their binary representation.


Example 1:

Input: n = 2, start = 3
Output: [3,2,0,1]
Explanation: The binary representation of the permutation is (11,10,00,01).
All the adjacent element differ by one bit. Another valid permutation is [3,1,0,2]
Example 2:

Input: n = 3, start = 2
Output: [2,6,7,5,4,0,1,3]
Explanation: The binary representation of the permutation is (010,110,111,101,100,000,001,011).


Constraints:

1 <= n <= 16
0 <= start < 2 ^ n
 *         
 *
 *
 *         思路：
 *          https://blog.csdn.net/bzxxzb/article/details/102767021
 *
 *          生成数字 函数 使用 异或 算法 每次找到一个位置进行 xor
 *          如果异或之后的数字没有出现过 放入map 返回 否则 还原数字 在下一个位置进行异或
 *
 *
 *          https://blog.csdn.net/bzxxzb/article/details/102767021

 *
 */
public class Solution {

    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> res = new ArrayList<>();
        res.add(start);
        Set<Integer> set = new HashSet<>();
        set.add(start);
        for (int i = 0; i < Math.pow(2, n) - 1; i++) {
            start = getNext(start, set);
            res.add(start);
        }
        return res;
    }

    private int getNext (int rawNum, Set<Integer> set) {
        int tmp = 1;
        while (true) {
            rawNum = rawNum ^ tmp;
            if (!set.contains(rawNum)) {
                set.add(rawNum);
                return rawNum;
            }
            rawNum ^= tmp;
            tmp <<= 1;
        }
    }
	
	public static void main(String[] args) {
    }
}
