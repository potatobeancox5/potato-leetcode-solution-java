package com.potato.study.leetcode.p1300;


/**
 * 
 * @author liuzhao11
 * 
 * 	1300. Sum of Mutated Array Closest to Target
 *  
 *Given an integer array arr and a target value target, return the integer value such that when we change all the integers larger than value in the given array to be equal to value, the sum of the array gets as close as possible (in absolute difference) to target.

In case of a tie, return the minimum such integer.

Notice that the answer is not neccesarilly a number from arr.



Example 1:

Input: arr = [4,9,3], target = 10
Output: 3
Explanation: When using 3 arr converts to [3, 3, 3] which sums 9 and that's the optimal answer.
Example 2:

Input: arr = [2,3,5], target = 10
Output: 5
Example 3:

Input: arr = [60864,25176,27249,21296,20204], target = 56803
Output: 11361


Constraints:

1 <= arr.length <= 10^4
1 <= arr[i], target <= 10^5
 *         
 *
 *         思路：
 *          https://leetcode-cn.com/problems/number-of-paths-with-max-score/solution/dong-tai-gui-hua-chang-gui-tao-lu-by-william-43/
 *
 *
 *
 *
 */
public class Solution {

    public int findBestValue(int[] arr, int target) {//待查找区间是所有可能的value从小到大排好的数组，要查的目标是能使距离更小的那个value的左边界
        int sum=0,max_arr=arr[0];
        for (int a: arr) {
            if(a>max_arr) {
                max_arr=a;
            }
            sum+=a;
        }
        if(sum<=target) {
            return max_arr;
        }
        //依题意改变arr，只会让sum(arr)不变或变得更小，当target本身就大于等于sum(arr)时，取arr的最大元素，不改变arr
        int left=0;//能取到的最小值,即待查找区间起始点
        int right=max_arr;//能取到的最大值，即待查找区间终结点，实际上更大也可以，但是没有意义，都不改变arr

        int mid=-1;
        while (left<=right){
            mid=(left+right)/2;
            int temp= getSum(arr,mid);
            if(temp-target==0) {
                return mid;
            }
            else if(temp<target) {
                left=mid+1;
            } else {
                right=mid-1;
            }
        }
        if(Math.abs(getSum(arr,left)-target)<Math.abs(getSum(arr,left-1)-target)) {
            return left;
        } else {
            return left-1;
        }


    }
    public int getSum(int [] arr, int value){//二分的判断函数，用于判断是否距离更小
        int sum=0;
        for (int a: arr) {
            if(a>value) {
                sum+=value;
            }
            else {
                sum+=a;
            }
        }
        return sum;
    }
}
