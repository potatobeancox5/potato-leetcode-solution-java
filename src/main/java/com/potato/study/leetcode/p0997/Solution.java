package com.potato.study.leetcode.p0997;


import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	  997. Find the Town Judge
 *  
 *         In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.

If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.



Example 1:

Input: N = 2, trust = [[1,2]]
Output: 2
Example 2:

Input: N = 3, trust = [[1,3],[2,3]]
Output: 3
Example 3:

Input: N = 3, trust = [[1,3],[2,3],[3,1]]
Output: -1
Example 4:

Input: N = 3, trust = [[1,2],[2,3]]
Output: -1
Example 5:

Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
Output: 3


Note:

1 <= N <= 1000
trust.length <= 10000
trust[i] are all different
trust[i][0] != trust[i][1]
1 <= trust[i][0], trust[i][1] <= N
 *         
 *         思路：
 *=
 *
 */
public class Solution {


    public int findJudge(int n, int[][] trust) {
        // count 二维数组 0 出度      1入读
        int[][] count = new int[n+1][2];
        // 入度 为 n-1 除度为 0
        for (int[] t : trust) {
            count[t[0]][0]++;
            count[t[1]][1]++;
        }
        // 遍历 count
        for (int i = 1; i < count.length; i++) {
            if (count[i][0] == 0 && count[i][1] == n-1) {
                return i;
            }
        }
        return -1;
    }

	public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] trust = new int[][]{{1,2}};
        int n = 2;
        int day = solution.findJudge(n, trust);
        System.out.println(day);
        Assert.assertEquals(2, day);

    }
}
