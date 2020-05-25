package com.potato.study.leetcode.p1095;


/**
 * 
 * @author liuzhao11
 * 
 * 	1095. Find in Mountain Array
 *  
 *       (This problem is an interactive problem.)

You may recall that an array A is a mountain array if and only if:

A.length >= 3
There exists some i with 0 < i < A.length - 1 such that:
A[0] < A[1] < ... A[i-1] < A[i]
A[i] > A[i+1] > ... > A[A.length - 1]
Given a mountain array mountainArr, return the minimum index such that mountainArr.get(index) == target.  If such an index doesn't exist, return -1.

You can't access the mountain array directly.  You may only access the array using a MountainArray interface:

MountainArray.get(k) returns the element of the array at index k (0-indexed).
MountainArray.length() returns the length of the array.
Submissions making more than 100 calls to MountainArray.get will be judged Wrong Answer.  Also, any solutions that attempt to circumvent the judge will result in disqualification.



Example 1:

Input: array = [1,2,3,4,5,3,1], target = 3
Output: 2
Explanation: 3 exists in the array, at index=2 and index=5. Return the minimum index, which is 2.
Example 2:

Input: array = [0,1,2,4,2,1], target = 3
Output: -1
Explanation: 3 does not exist in the array, so we return -1.


Constraints:

3 <= mountain_arr.length() <= 10000
0 <= target <= 10^9
0 <= mountain_arr.get(index) <= 10^9
 *         
 *
 *
 *
 *         思路：
 *         https://leetcode-cn.com/problems/find-in-mountain-array/solution/shi-shi-hou-ji-chu-wo-de-mo-neng-er-fen-mo-ban-lia/
 *
 *
 *
 */
public class Solution {

    public int findInMountainArray(int target, MountainArray mountainArr) {
        // 先找到峰顶索引 peakIdx
        int lo = 0, hi = mountainArr.length() - 1;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            int midVal = mountainArr.get(mid);

            if (midVal > mountainArr.get(mid - 1)) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        int peakIdx = mountainArr.get(lo) > mountainArr.get(hi)? lo: hi;


        // 根据峰顶将山脉数组分为「升序数组」和「降序数组」两段，分别进行二分查找
        int idx = binSearch(mountainArr, 0, peakIdx, target, true);
        return idx != -1? idx: binSearch(mountainArr, peakIdx + 1, mountainArr.length() - 1, target, false);
    }

    private int binSearch(MountainArray mountainArr, int lo, int hi, int target, boolean asc) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int midVal = mountainArr.get(mid);

            if (midVal == target) {
                return mid;
            }
            if (midVal < target) {
                lo = asc? mid + 1: lo;
                hi = asc? hi: mid - 1;
            } else {
                hi = asc? mid - 1: hi;
                lo = asc? lo: mid + 1;
            }
        }
        return -1;
    }


    interface MountainArray {
        int get(int index);
        int length();
    }


	public static void main(String[] args) {

    }
}
