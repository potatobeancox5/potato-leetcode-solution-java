package com.potato.study.leetcodecn.p01460.t001;

import java.util.HashMap;
import java.util.Map;

/**
 * 1460. 通过翻转子数组使两个数组相等
 *
 * 给你两个长度相同的整数数组 target 和 arr 。

 每一步中，你可以选择 arr 的任意 非空子数组 并将它翻转。你可以执行此过程任意次。

 如果你能让 arr 变得与 target 相同，返回 True；否则，返回 False 。

  

 示例 1：

 输入：target = [1,2,3,4], arr = [2,4,1,3]
 输出：true
 解释：你可以按照如下步骤使 arr 变成 target：
 1- 翻转子数组 [2,4,1] ，arr 变成 [1,4,2,3]
 2- 翻转子数组 [4,2] ，arr 变成 [1,2,4,3]
 3- 翻转子数组 [4,3] ，arr 变成 [1,2,3,4]
 上述方法并不是唯一的，还存在多种将 arr 变成 target 的方法。
 示例 2：

 输入：target = [7], arr = [7]
 输出：true
 解释：arr 不需要做任何翻转已经与 target 相等。
 示例 3：

 输入：target = [1,12], arr = [12,1]
 输出：true
 示例 4：

 输入：target = [3,7,9], arr = [3,7,11]
 输出：false
 解释：arr 没有数字 9 ，所以无论如何也无法变成 target 。
 示例 5：

 输入：target = [1,1,1,1,1], arr = [1,1,1,1,1]
 输出：true
  

 提示：

 target.length == arr.length
 1 <= target.length <= 1000
 1 <= target[i] <= 1000
 1 <= arr[i] <= 1000

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/make-two-arrays-equal-by-reversing-sub-arrays
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * map 遍历 计数 target
     *
     * 然后 遍历 arr 计数--
     *
     * 最终返回map 是不是为空
     * @param target
     * @param arr
     * @return
     */
    public boolean canBeEqual(int[] target, int[] arr) {
        // 存个数
        Map<Integer, Integer> countMap = new HashMap<>();
        // 遍历 target
        for (int i = 0; i < target.length; i++) {
            Integer count = countMap.getOrDefault(target[i], 0);
            count++;
            countMap.put(target[i], count);
        }
        // 遍历 arr
        for (int i = 0; i < arr.length; i++) {
            Integer count = countMap.get(arr[i]);
            if (count == null) {
                return false;
            }
            count--;
            if (count < 0) {
                return false;
            } else if (count == 0) {
                countMap.remove(arr[i]);
            } else {
                countMap.put(arr[i], count);
            }
        }
        return countMap.isEmpty();
    }

    public static void main(String[] args) {

//        Solution solution = new Solution();
//        int[] nums = new int[]{2,5,1,3,4,7};
//        int n = 3;
//        int[] shuffle = solution.shuffle(nums, n);
//        System.out.println(Arrays.toString(shuffle));
//        Assert.assertEquals("[2, 3, 5, 4, 1, 7]", Arrays.toString(shuffle));
    }
}
