package com.potato.study.leetcode.p1122;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author liuzhao11
 * 
 * 	1122. Relative Sort Array
 *  
 *         Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.

Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.  Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.



Example 1:

Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
Output: [2,2,2,1,4,3,3,9,6,7,19]


Constraints:

arr1.length, arr2.length <= 1000
0 <= arr1[i], arr2[i] <= 1000
Each arr2[i] is distinct.
Each arr2[i] is in arr1.
 *         
 *         思路：
 *          Map计数 没有计数的使用list 存储
 *
 *

 *
 */
public class Solution {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Set<Integer> keySet = new HashSet<>();
        for (int num : arr2) {
            keySet.add(num);
        }
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> remindList = new ArrayList<>();
        for (int num : arr1) {
            if (keySet.contains(num)) {
                Integer count = map.get(num);
                if (count == null) {
                    map.put(num, 1);
                } else {
                    map.put(num, count + 1);
                }
            } else {
                remindList.add(num);
            }
        }
        // 升序排列升序数组
        remindList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        int index = 0;
        for (int i = 0; i < arr2.length; i++) {
            Integer count = map.get(arr2[i]);
            if (count != null) {
                Arrays.fill(arr1, index, index + count, arr2[i]);
                index += count;
            }
        }
        for (int i = index; i < arr1.length; i++) {
            arr1[i] = remindList.get(i - index);
        }
        return arr1;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};

        int[] array = solution.relativeSortArray(arr1, arr2);
        System.out.println(Arrays.toString(array));
    }
}
