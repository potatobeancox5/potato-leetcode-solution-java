package com.potato.study.leetcode.p0315;


import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Administrator
 *
 *         315. Count of Smaller Numbers After Self
 *         
 *          
 *         You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

Example:

Input: [5,2,6,1]
Output: [2,1,1,0]
Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.
 *         
 *         
 *
 *
 *         题目含义：
 *         找到一个数据的逆序数, 不太好找
 *         思路：
 *         https://blog.csdn.net/u012528000/article/details/78545815

            从后往前遍历数组
            对于已经遍历的 建立有序列表 二分法查找当前i 的插入位置 返回这个位置上前一个树 病将当前数 插入到right 位置
 *
 *
 *
 *         
 *         
 *         
 *         
 *         
 */
public class Solution {

    public List<Integer> countSmaller(int[] nums) {
        // 存放结果
        int[] smaller = new int[nums.length];
        // 从后向前遍历数组， 每次使用二分法查找应该放置的位置，
        // 这个位置之后的数字就是逆序数 然后排序（不用移动的数就是逆序数）
        if (null != nums && nums.length > 0) {
            for (int i = nums.length - 2; i >= 0 ; i--) {
                // 找到插入位置
                int left = i + 1;
                int right = nums.length - 1;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (nums[mid] >= nums[i]) { // 往后面找
                        left = mid + 1;
                    } else { // 往前边找
                        right = mid - 1;
                    }
                }
                // 计算出多少
                smaller[i] = smaller.length - left;
                // 之前的数字向前移动
                int tmp = nums[i];
                for (int j = i; j < right; j++) {
                     nums[j] = nums[j + 1];
                }
                nums[right] = tmp;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int num : smaller) {
            list.add(num);
        }
        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {5,2,6,1};
        System.out.println(solution.countSmaller(nums));
    }
}
