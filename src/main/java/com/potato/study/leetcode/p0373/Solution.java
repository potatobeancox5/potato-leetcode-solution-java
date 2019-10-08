package com.potato.study.leetcode.p0373;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * @author liuzhao11
 * 
 *       373. Find K Pairs with Smallest Sums
 * 
 *      You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

Define a pair (u,v) which consists of one element from the first array and one element from the second array.

Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

Example 1:

Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
Output: [[1,2],[1,4],[1,6]]
Explanation: The first 3 pairs are returned from the sequence:
[1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
Example 2:

Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
Output: [1,1],[1,1]
Explanation: The first 2 pairs are returned from the sequence:
[1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
Example 3:

Input: nums1 = [1,2], nums2 = [3], k = 3
Output: [1,3],[2,3]
Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]
 *         
 *         思路：
 *          使用treemap存储 按照和 小到大存储
 *          暴力遍历 将值放入treemap中
 *
 */
public class Solution {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums1 == null || nums2 == null) {
            return res;
        }
        if (nums1.length == 0 || nums2.length == 0) {
            return res;
        }
        Map<Integer, List<List<Integer>>> pairMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                List<List<Integer>> pairs = pairMap.get(nums1[i] + nums2[j]);
                if (pairs == null) {
                    pairs = new ArrayList<>();
                    pairMap.put(nums1[i] + nums2[j], pairs);
                }
                List<Integer> pair = new ArrayList<>();
                pair.add(nums1[i]);
                pair.add(nums2[j]);
                pairs.add(pair);
            }
        }
        // 遍历map 找到最初的梦想
        int len = k;
        for (Map.Entry<Integer, List<List<Integer>>> entry : pairMap.entrySet()) {
            if (k > 0) {
                res.addAll(entry.getValue());
                k -= entry.getValue().size();
            }
        }
        if (res.size() < len) {
            return res;
        }
        return res.subList(0, len);
    }


	
	public static void main(String[] args) {
		Solution solution = new Solution();
        int[] nums1 = {1,7,11};
        int[] nums2 = {2,4,6};
        int k = 3;

        List<List<Integer>> pairs = solution.kSmallestPairs(nums1, nums2, k);
		System.out.println(pairs);

	}
}
