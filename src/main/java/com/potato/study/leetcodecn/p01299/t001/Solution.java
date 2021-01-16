package com.potato.study.leetcodecn.p01299.t001;


/**
 * 1299. 将每个元素替换为右侧最大元素
 *
 * 给你一个数组 arr ，请你将每个元素用它右边最大的元素替换，如果是最后一个元素，用 -1 替换。

 完成所有替换操作后，请你返回这个数组。

  

 示例 1：

 输入：arr = [17,18,5,4,6,1]
 输出：[18,6,6,6,1,-1]
 解释：
 - 下标 0 的元素 --> 右侧最大元素是下标 1 的元素 (18)
 - 下标 1 的元素 --> 右侧最大元素是下标 4 的元素 (6)
 - 下标 2 的元素 --> 右侧最大元素是下标 4 的元素 (6)
 - 下标 3 的元素 --> 右侧最大元素是下标 4 的元素 (6)
 - 下标 4 的元素 --> 右侧最大元素是下标 5 的元素 (1)
 - 下标 5 的元素 --> 右侧没有其他元素，替换为 -1
 示例 2：

 输入：arr = [400]
 输出：[-1]
 解释：下标 0 的元素右侧没有其他元素。
  

 提示：

 1 <= arr.length <= 104
 1 <= arr[i] <= 105

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/replace-elements-with-greatest-element-on-right-side
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 从后往前记录当前最大 放到位置
     * @param arr
     * @return
     */
    public int[] replaceElements(int[] arr) {
        if (null == arr) {
            return null;
        }
        int max = -1;
        for (int i = arr.length - 1; i >= 0 ; i--) {
            int tmp = arr[i];
            arr[i] = max;
            max = Math.max(max, tmp);
        }
        return arr;
    }
}