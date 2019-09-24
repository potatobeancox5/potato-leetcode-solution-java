package com.potato.study.leetcode.p0354;

import org.junit.Assert;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * @author liuzhao11
 * 
 *        354. Russian Doll Envelopes
 * 
 *      You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.

What is the maximum number of envelopes can you Russian doll? (put one inside other)

Note:
Rotation is not allowed.

Example:

Input: [[5,4],[6,4],[6,7],[2,3]]
Output: 3
Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 *         
 *         
 *         思路：354. Russian Doll Envelopes

https://www.cnblogs.com/grandyang/p/5568818.html

类似俄罗斯套娃 判断最多的那个套娃套了多少个
首先排序 按照start 升序 再按照end 升序排列
dp i 记录 第i个套娃里边有多少个子套娃 包含自己

dp i = max dp i dp j +1  如果j 能被套在i中时
 *        
 */
public class Solution {


    /**
     *
     * @param envelopes
     * @return
     */
    public int maxEnvelopes(int[][] envelopes) {

        if (null == envelopes || envelopes.length == 0) {
            return 0;
        }
        // 1. 按照index 0 1 进行排序
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });
        // 2. 遍历排序生成dp数组
        int max = 0;
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        // 3. 直接返回结果
        return max;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
        int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
        int maxEnvelopes = solution.maxEnvelopes(envelopes);
        Assert.assertEquals(maxEnvelopes, 3);
        System.out.println(maxEnvelopes);

        int[][] envelopes1 = {{10,8},{1,12},{6,15},{2,18}};
        maxEnvelopes = solution.maxEnvelopes(envelopes1);
        Assert.assertEquals(maxEnvelopes, 2);
        System.out.println(maxEnvelopes);

        int[][] envelopes2 = {{46,89},{50,53},{52,68},{72,45},{77,81}};
        maxEnvelopes = solution.maxEnvelopes(envelopes2);
        Assert.assertEquals(maxEnvelopes, 3);
        System.out.println(maxEnvelopes);
    }
}
