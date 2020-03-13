package com.potato.study.leetcode.p1282;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 * 	1282. Group the People Given the Group Size They Belong To
 *  
 *
There are n people whose IDs go from 0 to n - 1 and each person belongs exactly to one group. Given the array groupSizes of length n telling the group size each person belongs to, return the groups there are and the people's IDs each group includes.

You can return any solution in any order and the same applies for IDs. Also, it is guaranteed that there exists at least one solution.



Example 1:

Input: groupSizes = [3,3,3,3,3,1,3]
Output: [[5],[0,1,2],[3,4,6]]
Explanation:
Other possible solutions are [[2,1,6],[5],[0,4,3]] and [[5],[0,6,2],[4,3,1]].
Example 2:

Input: groupSizes = [2,1,3,3,3,2]
Output: [[1],[0,5],[2,3,4]]


Constraints:

groupSizes.length == n
1 <= n <= 500
1 <= groupSizes[i] <= n
 *         
 *         思路：
 *
 *         // 使用map 计数 key 用户组的大小 相同大小的用户list 分割list 即可
 *
 *
 *

 *
 */
public class Solution {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        // 1. generate map
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            List<Integer> indexList = map.getOrDefault(groupSizes[i], new ArrayList<>());
            indexList.add(i);
            map.put(groupSizes[i], indexList);
        }
        // 2. split map by size
        List<List<Integer>> resultList = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int size = entry.getKey();
            List<Integer> list = entry.getValue();
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                if (i % size == 0) {
                    res = new ArrayList<>();
                    resultList.add(res);
                }
                res.add(list.get(i));
            }
        }
        return resultList;
    }
	
	public static void main(String[] args) {
    }
}
