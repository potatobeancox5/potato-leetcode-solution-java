package com.potato.study.leetcodecn.p0004.t001;

import com.potato.study.leetcode.util.ArrayUtil;
import org.junit.Assert;

/**
 * 4. 寻找两个正序数组的中位数
 *
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。

 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？

  

 示例 1：

 输入：nums1 = [1,3], nums2 = [2]
 输出：2.00000
 解释：合并数组 = [1,2,3] ，中位数 2
 示例 2：

 输入：nums1 = [1,2], nums2 = [3,4]
 输出：2.50000
 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 示例 3：

 输入：nums1 = [0,0], nums2 = [0,0]
 输出：0.00000
 示例 4：

 输入：nums1 = [], nums2 = [1]
 输出：1.00000
 示例 5：

 输入：nums1 = [2], nums2 = []
 输出：2.00000
  

 提示：

 nums1.length == m
 nums2.length == n
 0 <= m <= 1000
 0 <= n <= 1000
 1 <= m + n <= 2000
 -106 <= nums1[i], nums2[i] <= 106

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {


    /**
     * 参考：
     * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xun-zhao-liang-ge-you-xu-shu-zu-de-zhong-wei-s-114/
     *
     * 找到中位数，相等于 左右数组中间被画一条线进行分隔，这条线保证左边部分任意元素小于右边部分，且左边个数 》= 右边个数
     * 1 2 3 |4 5
     * -----------
     * 2 3 |4 5 6
     *
     * 1. 首先保证 num1.lenth <= nums.legth 这样能控制 最多只有 nums1 被耗尽的情况
     * 2. 二分法查找 nums1 中的分隔符的位置 left = 0 right = m  mid = (l+r)/2 , 如此 nums被分为 0-mid-1（下标） mid - m-1 （第一个数组左边有mid个元素）
     * 3. 在保证左边mid个元素时，计算出右边分隔的位置  左边元素总个数 len1 + len2 + 1/ 2 , 右边个数可想而知
     * 4. 比较 nums1[mid - 1] 和 nums2 [分隔位置]， 如果 nums1 <= nums2 找到 判断总长奇数偶数，进行返回，否则 往前找 right = mid -1
     * @param nums1
     * @param nums2
     * @return
     */
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        // 1. 首先保证 num1.lenth <= nums.legth 这样能控制 最多只有 nums1 被耗尽的情况
//        if (nums1.length > nums2.length) {
//            return findMedianSortedArrays(nums2, nums1);
//        }
//        // 2. 二分法查找 nums1 中的分隔符的位置 left = 0 right = m  mid = (l+r)/2 , 如此 nums被分为 0-mid-1（下标） mid - m-1 （第一个数组左边有mid个元素）
//        int left = 0;
//        int right = nums1.length;
//        while (left <= right) {
//            int mid = (left + right) / 2;
//            // 3. 在保证左边mid个元素时，计算出右边分隔的位置  左边元素总个数 len1 + len2 + 1/ 2 , 右边个数可想而知
//            int nextIndex = (nums1.length + nums2.length + 1) / 2 - mid;
//            // 4. 比较 nums1[mid - 1] 和 nums2 [分隔位置]， 如果 nums1 <= nums2 找到 判断总长奇数偶数，进行返回，否则 往前找 right = mid -1
//            int leftVal = (mid > 0 ? nums1[mid-1] : nums1[0]);
//            int rightVal = (nums2[nextIndex]);
//            if (leftVal <= rightVal) {
//                int median1;
//
//                return
//            } else {
//                right = mid -1;
//            }
//        }
//        // 没找到
//        return 0.0;
//    }


    /**
     * 放弃了 直接查第中位数个数字吧
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLen = nums1.length + nums2.length;
        int medianIndex = (totalLen - 1)/ 2;
        // 开始遍历 找到第 medianIndex 和 medianNextIndex 个数字
        int count = 0;
        int index1 = 0;
        int index2 = 0;
        while (index1 < nums1.length && index2 < nums2.length && count < medianIndex) {
            if (nums1[index1] <= nums2[index2]) {
                index1++;
            } else {
                index2++;
            }
            count++;
        }
        while (index1 < nums1.length  && count < medianIndex) {
            index1++;
            count++;
        }
        while (index2 < nums2.length  && count < medianIndex) {
            index2++;
            count++;
        }
        // count == medianIndex;
        int median;
        if (index1 < nums1.length && index2 < nums2.length && nums1[index1] <= nums2[index2]) {
            median = nums1[index1];
            index1++;
        } else if (index1 < nums1.length && index2 < nums2.length){
            median = nums2[index2];
            index2++;
        } else if (index1 < nums1.length) {
            median = nums1[index1];
            index1++;
        } else {
            median = nums2[index2];
            index2++;
        }
        int medianNext;
        if (totalLen % 2 == 0) {
            if (index1 < nums1.length && index2 < nums2.length && nums1[index1] <= nums2[index2]) {
                medianNext = nums1[index1];
            } else if (index1 < nums1.length && index2 < nums2.length){
                medianNext = nums2[index2];
            } else if (index1 < nums1.length) {
                medianNext = nums1[index1];
            } else {
                medianNext = nums2[index2];
            }
        } else {
            medianNext = median;
        }
        return (1.0 * medianNext + median)/2;
    }






    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = ArrayUtil.string2ArrayiInt("[1,3]");
        int[] nums2 = ArrayUtil.string2ArrayiInt("[2]");
        double median = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(median);
        Assert.assertEquals(2, median, 0.00000001);

        nums1 = ArrayUtil.string2ArrayiInt("[1,2]");
        nums2 = ArrayUtil.string2ArrayiInt("[3,4]");
        median = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(median);
        Assert.assertEquals(2.5, median, 0.00000001);

        nums1 = ArrayUtil.string2ArrayiInt("[0,0]");
        nums2 = ArrayUtil.string2ArrayiInt("[0,0]");
        median = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(median);
        Assert.assertEquals(0.0, median, 0.00000001);

        nums1 = ArrayUtil.string2ArrayiInt("[]");
        nums2 = ArrayUtil.string2ArrayiInt("[1]");
        median = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(median);
        Assert.assertEquals(1.0, median, 0.00000001);
    }


}
