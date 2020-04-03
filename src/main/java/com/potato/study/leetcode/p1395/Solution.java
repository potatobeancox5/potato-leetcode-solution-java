package com.potato.study.leetcode.p1395;


import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	1395. Count Number of Teams
 *  
 *
There are n soldiers standing in a line. Each soldier is assigned a unique rating value.

You have to form a team of 3 soldiers amongst them under the following rules:

Choose 3 soldiers with index (i, j, k) with rating (rating[i], rating[j], rating[k]).
A team is valid if:  (rating[i] < rating[j] < rating[k]) or (rating[i] > rating[j] > rating[k]) where (0 <= i < j < k < n).
Return the number of teams you can form given the conditions. (soldiers can be part of multiple teams).



Example 1:

Input: rating = [2,5,3,4,1]
Output: 3
Explanation: We can form three teams given the conditions. (2,3,4), (5,4,1), (5,3,1).
Example 2:

Input: rating = [2,1,3]
Output: 0
Explanation: We can't form any team given the conditions.
Example 3:

Input: rating = [1,2,3,4]
Output: 4


Constraints:

n == rating.length
1 <= n <= 200
1 <= rating[i] <= 10^5
 *         
 *         思路：
 *
 *         1395. Count Number of Teams
https://blog.csdn.net/mapoos/article/details/105190844
for i  1 到len-2
for j 0 到 len -1
如果rate j 大于i
j小于i  smaller0 ++ 否则 1jiajia
else if rate j 小于i
同上 big
end for
ans += 交叉 相乘 small 和big
 *
 */
public class Solution {


    public int numTeams(int[] rating) {
        // 分别存放比当前位置小的 / 大的个数

        // 对于每一个中间位置
        int res = 0;
        for (int i = 1; i < rating.length - 1; i++) {
            // 遍历每个情况
            int[] smaller = new int[2];
            int[] bigger = new int[2];
            for (int j = 0; j < rating.length; j++) {
                if (rating[j] < rating[i]) {
                    if (j < i) {
                        smaller[0]++;
                    } else {
                        smaller[1]++;
                    }
                } else if (rating[j] > rating[i]){
                    if (j < i) {
                        bigger[0]++;
                    } else {
                        bigger[1]++;
                    }
                }
                // 相等情况 排除 可能是相同位置
            }
            res += (smaller[0] * bigger[1] + bigger[0] * smaller[1]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] rating = new int[]{2,5,3,4,1};
        int res = solution.numTeams(rating);
        System.out.println(res);
        Assert.assertEquals(3, res);

        rating = new int[]{2,1,3};
        res = solution.numTeams(rating);
        System.out.println(res);
        Assert.assertEquals(0, res);

        rating = new int[]{1,2,3,4};
        res = solution.numTeams(rating);
        System.out.println(res);
        Assert.assertEquals(4, res);
    }
}
