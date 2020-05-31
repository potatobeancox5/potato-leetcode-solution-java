package com.potato.study.leetcode.p1128;


import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 * 	1128. Number of Equivalent Domino Pairs
 *  
 *
 * Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j] = [c, d] if and only if either (a==c and b==d), or (a==d and b==c) - that is, one domino can be rotated to be equal to another domino.

Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length, and dominoes[i] is equivalent to dominoes[j].



Example 1:

Input: dominoes = [[1,2],[2,1],[3,4],[5,6]]
Output: 1


Constraints:

1 <= dominoes.length <= 40000
1 <= dominoes[i][j] <= 9
 *
 *
 *      思路：
 *          https://leetcode-cn.com/problems/number-of-equivalent-domino-pairs/solution/zui-jian-javashi-xian-pai-xu-tong-ji-by-cysionliu/
 *
 *
 *
 */
public class Solution {

    public int numEquivDominoPairs(int[][] dominoes) {
        int ans = 0;
        int[] cp = new int[100];
        for(int[] arr:dominoes){
            Arrays.sort(arr);
            ans+=cp[arr[0]*10+arr[1]]++;
        }
        return ans;
    }
}
