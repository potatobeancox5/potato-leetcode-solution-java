package com.potato.study.leetcode.p0526;

import org.junit.Assert;


/**
 * 
 * @author liuzhao11
 * 
 *         526. Beautiful Arrangement
 * 
 *        Suppose you have N integers from 1 to N. We define a beautiful arrangement as an array that is constructed by these N numbers successfully if one of the following is true for the ith position (1 <= i <= N) in this array:

The number at the ith position is divisible by i.
i is divisible by the number at the ith position.


Now given N, how many beautiful arrangements can you construct?

Example 1:

Input: 2
Output: 2
Explanation:

The first beautiful arrangement is [1, 2]:

Number at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).

Number at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).

The second beautiful arrangement is [2, 1]:

Number at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).

Number at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.


Note:

N is a positive integer and will not exceed 15.


 * 
 * 
 *         思路：
 *
 *         526. Beautiful Arrangement

https://blog.csdn.net/cloudox_/article/details/62037082

数组 num 记录 数字有没有访问过

0 可用 1已经使用
每次设置一个数
index 是当前使用数字index 0 开始
dfs visited index

if index == nums len return 1
int totalkind 0=
for i  0 len-1
if visited
continue
判断条件
val = i+1
if index整除 val 或 val整除 index
num i =1
total += 递归 new nums index +1


return total
 *
 *
 *
 *
 *
 *          
 */
public class Solution {



    public int countArrangement(int n) {
        int[] visited = new int[n];
        return this.dfsCountArrangement(visited, 1);
    }

    /**
     *
     * @param visited   当前影安排好的数字标志 1 为已经安排好
     * @param index     当前安排到哪个位置的数字了，从1开始
     * @return
     */
    private int dfsCountArrangement(int[] visited, int index) {
        int n = visited.length;
        // 安排好了一个数字
        if (index == n + 1) {
            return 1;
        }
        // 安排当前数字 index
        int totalArrangemen = 0;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 1) {
                continue;
            }
            int val = i + 1;
            // 当前位置满足条件，查找下一个位置
            if (val % index == 0 || index % val == 0) {
                visited[i] = 1;
                totalArrangemen += dfsCountArrangement(visited, index + 1);
                visited[i] = 0;
            }
        }
        return totalArrangemen;
    }

	
	public static void main(String[] args) {

        Solution solution = new Solution();

        int n = 2;
        int res = solution.countArrangement(n);
        System.out.println(res);
        Assert.assertEquals(2, res);


    }
}
