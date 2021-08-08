package com.potato.study.leetcodecn.p01640.t001;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

/**
 * 1640. 能否连接形成数组
 *
 * 给你一个整数数组 arr ，数组中的每个整数 互不相同 。另有一个由整数数组构成的数组 pieces，其中的整数也 互不相同 。请你以 任意顺序 连接 pieces 中的数组以形成 arr 。但是，不允许 对每个数组
 * pieces[i] 中的整数重新排序。
 *
 * 如果可以连接 pieces 中的数组形成 arr ，返回 true ；否则，返回 false 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [85], pieces = [[85]]
 * 输出：true
 * 示例 2：
 *
 * 输入：arr = [15,88], pieces = [[88],[15]]
 * 输出：true
 * 解释：依次连接 [15] 和 [88]
 * 示例 3：
 *
 * 输入：arr = [49,18,16], pieces = [[16,18,49]]
 * 输出：false
 * 解释：即便数字相符，也不能重新排列 pieces[0]
 * 示例 4：
 *
 * 输入：arr = [91,4,64,78], pieces = [[78],[4,64],[91]]
 * 输出：true
 * 解释：依次连接 [91]、[4,64] 和 [78]
 * 示例 5：
 *
 * 输入：arr = [1,3,5,7], pieces = [[2,4,6,8]]
 * 输出：false
 *  
 *
 * 提示：
 *
 * 1 <= pieces.length <= arr.length <= 100
 * sum(pieces[i].length) == arr.length
 * 1 <= pieces[i].length <= arr.length
 * 1 <= arr[i], pieces[i][j] <= 100
 * arr 中的整数 互不相同
 * pieces 中的整数 互不相同（也就是说，如果将 pieces 扁平化成一维数组，数组中的所有整数互不相同）
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-array-formation-through-concatenation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     *
     * @param arr
     * @param pieces
     * @return
     */
    public boolean canFormArray(int[] arr, int[][] pieces) {
        // 用map 记录 piece key 是 第一个数字 value 是 int[] 值
        Map<Integer, int[]> startNumMap = new HashMap<>();
        for (int[] nums : pieces) {
            if (nums == null) {
                continue;
            }
            startNumMap.put(nums[0], nums);
        }
        // 遍历 arr 对于 i 从 piece 中过去 int[] 然后比较 不匹配 直接返回false
        int index = 0;
        while (index < arr.length) {
            int[] ints = startNumMap.get(arr[index]);
            if (null == ints) {
                return false;
            }
            for (int i = 0; i < ints.length; i++) {
                if (ints[i] != arr[index]) {
                    return false;
                }
                index++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int n = 1;
//        int i = solution.countVowelStrings(n);
//        System.out.println(i);
//        Assert.assertSame(5, i);
    }
}
