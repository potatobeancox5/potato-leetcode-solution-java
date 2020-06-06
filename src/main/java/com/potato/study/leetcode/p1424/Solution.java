package com.potato.study.leetcode.p1424;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * @author liuzhao11
 * 
 * 	1424. Diagonal Traverse II
 *  
 *
Given a list of lists of integers, nums, return all elements of nums in diagonal order as shown in the below images.


Example 1:



Input: nums = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,4,2,7,5,3,8,6,9]
Example 2:



Input: nums = [[1,2,3,4,5],[6,7],[8],[9,10,11],[12,13,14,15,16]]
Output: [1,6,2,8,7,3,9,4,12,10,5,13,11,14,15,16]
Example 3:

Input: nums = [[1,2,3],[4],[5,6,7],[8],[9,10,11]]
Output: [1,4,2,5,3,8,6,9,7,10,11]
Example 4:

Input: nums = [[1,2,3,4,5,6]]
Output: [1,2,3,4,5,6]


Constraints:

1 <= nums.length <= 10^5
1 <= nums[i].length <= 10^5
1 <= nums[i][j] <= 10^9
There at most 10^5 elements in nums.
 *         
 *         思路：
 *          https://leetcode-cn.com/problems/diagonal-traverse-ii/solution/treemapan-dui-jiao-xian-ju-he-zhi-by-zuo-zhou-ren/
 *
 *
 */
public class Solution {


    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int len = 0;
        Map<Integer,List<Integer>> map = new TreeMap<>();
        for(int i = 0;i < nums.size();i++) {
            len += nums.get(i).size(); // 获取最后要返回的数组的长度，即元素个数
            for(int j = 0;j < nums.get(i).size();j++) {
                if(map.containsKey(i + j)) {
                    map.get(i + j).add(nums.get(i).get(j));
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums.get(i).get(j));
                    map.put(i + j, list);
                }
            }
        }
        int[] ans = new int[len];
        int index = 0;
        for(int key : map.keySet()) { // 遍历map
            List<Integer> list = map.get(key);
            for(int j = list.size() - 1;j >= 0;j--) { // 根据题目的输出要求确定生成数组中元素的顺序
                ans[index] = list.get(j);
                index++;
            }
        }
        return ans;
    }

}
