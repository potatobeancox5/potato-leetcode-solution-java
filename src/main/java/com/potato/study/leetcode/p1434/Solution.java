package com.potato.study.leetcode.p1434;


import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 * 	1434. Number of Ways to Wear Different Hats to Each Other
 *  
 *
There are n people and 40 types of hats labeled from 1 to 40.

Given a list of list of integers hats, where hats[i] is a list of all hats preferred by the i-th person.

Return the number of ways that the n people wear different hats to each other.

Since the answer may be too large, return it modulo 10^9 + 7.



Example 1:

Input: hats = [[3,4],[4,5],[5]]
Output: 1
Explanation: There is only one way to choose hats given the conditions.
First person choose hat 3, Second person choose hat 4 and last one hat 5.
Example 2:

Input: hats = [[3,5,1],[3,5]]
Output: 4
Explanation: There are 4 ways to choose hats
(3,5), (5,3), (1,3) and (1,5)
Example 3:

Input: hats = [[1,2,3,4],[1,2,3,4],[1,2,3,4],[1,2,3,4]]
Output: 24
Explanation: Each person can choose hats labeled from 1 to 4.
Number of Permutations of (1,2,3,4) = 24.
Example 4:

Input: hats = [[1,2,3],[2,3,5,6],[1,3,7,9],[1,8,9],[2,5,7]]
Output: 111


Constraints:

n == hats.length
1 <= n <= 10
1 <= hats[i].length <= 40
1 <= hats[i][j] <= 40
hats[i] contains a list of unique integers.
 *         
 *
 *
 *
 * 思路：
 *      https://leetcode-cn.com/problems/number-of-ways-to-wear-different-hats-to-each-other/solution/java-ti-jie-can-kao-httpsleetcode-cncomproblemsnum/
 *
 *
 */
public class Solution {


    // 有状态压缩，有记忆优化
    // 状态压缩作用即是完成记忆化
    // 帽子找人，状态空间为2^10 - 1
    private int mod = 1000000000 + 7;
    private int personNum = 0;
    // 状态由戴帽子的人和当前分配的帽子index共同决定
    // 在此类改写时，需要让dfs返回一个int值
    private Integer[][] memo;
    public int numberWays(List<List<Integer>> hats) {
        personNum = hats.size();
        // hat编号由1到41
        List<Integer>[] hat2Person = new List[41];
        for (int i = 0; i < personNum; i++) {
            List<Integer> hatsNums = hats.get(i);
            for (int j = 0; j < hatsNums.size(); j++) {
                if (hat2Person[hatsNums.get(j)] == null) {
                    hat2Person[hatsNums.get(j)] = new ArrayList<>();
                }
                hat2Person[hatsNums.get(j)].add(i);
            }
        }
        memo = new Integer[1<<personNum][41];
        // marked标识整个状态空间，可以由整数替代
        int marked = 0;
        return dfsVisit(hat2Person, marked, 1);
    }

    private int dfsVisit(List<Integer>[] hat2Person, int marked, int hatIndex) {
        int cnt = 0;
        if (hatIndex == 41) {
            //所有人都已经戴上了帽子
            if(marked == (1 << personNum) - 1) {
                return 1;
            }
            return 0;
        }
        if (memo[marked][hatIndex] != null) {
            return memo[marked][hatIndex];
        }
        // 此帽子不分配
        cnt +=dfsVisit(hat2Person, marked, hatIndex + 1);
        cnt = cnt % mod;
        // 此帽子没人可戴
        if (hat2Person[hatIndex] == null) {
            memo[marked][hatIndex] = cnt;
            return cnt;
        }
        for (int i = 0; i < hat2Person[hatIndex].size(); i++) {
            if ((marked >> hat2Person[hatIndex].get(i) & 1) == 1 ) {
                continue;
            }
            cnt += dfsVisit(hat2Person, marked | 1 << hat2Person[hatIndex].get(i), hatIndex + 1);
            cnt = cnt % mod;
        }
        memo[marked][hatIndex] = cnt;
        return cnt;
    }


}
