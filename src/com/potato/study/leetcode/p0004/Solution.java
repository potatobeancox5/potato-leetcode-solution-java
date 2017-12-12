package com.potato.study.leetcode.p0004;

/**
 * 
 * @author liuzhao11
 * 
 * 
 *         4. Median of Two Sorted Arrays 
 *         There are two sorted arrays nums1 and
 *         nums2 of size m and n respectively.
 * 
 *         Find the median of the two sorted arrays. The overall run time
 *         complexity should be O(log (m+n)).
 *
 *         思路：计算当前数列长度和 得到中位数下标 
 *         		长度为奇数 中位数下标 = length / 2 
 *         		长度为偶数 中位数下标 = length / 2 - 1  , length / 2  求均值 
 *         	直接找第 length / 2  个数
 *         	两个指针index1 = 0 index2 = 0 countIndex = 0
 *         	若 countIndex < length / 2
 *         		若nums1[index1]  <= nums2[index2] index1 ++;  countIndex++
 *         		否则 index2++   countIndex++
 *         否则  countIndex == length / 2  取出当前 nums1[index1]  <= nums2[index2] 中较小的数min
 *         	
 *         若总长为奇数 直接返回
 *         否则返回 （min + xxx） / 2    xxx = min{ nums1[index1 - 1]  <= nums2[index2 - 1]}（记得判断下标是否存在）
 * 
 */
public class Solution {
	

	public static boolean isBlank(int[] arr) {
		if(null == arr || arr.length == 0) {
			return true;
		}
		return false;
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if( Solution.isBlank(nums1) && Solution.isBlank(nums2)) {
			return 0.0;
		} else if((Solution.isBlank(nums1))||(Solution.isBlank(nums2))) {
			if(Solution.isBlank(nums1)) {
				nums1 = nums2;
			}
			int totalLength = nums1.length;
			if(totalLength % 2 == 1) {
				return nums1[totalLength / 2];
			} else {
				return (nums1[totalLength / 2 - 1] + nums1[totalLength / 2]) / 2.0;
			}
		} else {//两个数列都存在
			int totalLength = nums1.length + nums2.length;
			int midIndex = totalLength / 2;
			int temp =  0;
			for(int index1 = 0 ,index2 = 0,countIndex = 0; index1 < nums1.length || index2 < nums2.length ; ) {
				if (countIndex < midIndex) {
//					若nums1[index1]  <= nums2[index2] index1 ++;  countIndex++
					if (index1 < nums1.length && index2 < nums2.length && nums1[index1]  <= nums2[index2]) {
						temp = nums1[index1++];
					} else if(index1 < nums1.length && index2 < nums2.length && nums1[index1]  > nums2[index2]){
//					否则 index2++   countIndex++
						temp = nums2[index2++];
					} else if (index1 < nums1.length) {
						temp = nums1[index1++];
					} else if (index2 < nums2.length) {
						temp = nums2[index2++];
					}
					countIndex++;
				} else {//countIndex == midIndex
					if(totalLength % 2 == 1) {
						if(index1 < nums1.length && index2 < nums2.length) {							
							return nums1[index1] <= nums2[index2] ? nums1[index1] * 1.0 : nums2[index2] * 1.0;
						} else if(index1 < nums1.length){
							return nums1[index1];
						} else if(index2 < nums2.length){//index2 < nums2.length
							return nums2[index2];
						}
					} else {//偶数
						if(index1 < nums1.length && index2 < nums2.length) {
							int a = nums1[index1] <= nums2[index2] ? nums1[index1] : nums2[index2];
							return (a + temp) / 2.0;
						} else if(index1 < nums1.length){
							int a = nums1[index1];
							return (a + temp) / 2.0;
						} else if(index2 < nums2.length){//index2 < nums2.length
							int a = nums2[index2];
							return (a + temp) / 2.0;
						}
					}
				}
			}
			return Double.MAX_VALUE;//出错
		}
		
	}
	

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums1 = {1};
		int[] nums2 = {2,3,4};
		double result = solution.findMedianSortedArrays(nums1, nums2);
		System.out.println("resule = " + result);
		
	}
}
