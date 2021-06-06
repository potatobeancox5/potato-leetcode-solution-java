package com.potato.study.leetcodecn.p00442.t001;

import com.potato.study.leetcode.domain.ListNode;
import com.potato.study.leetcode.util.ListNodeUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 442. 数组中重复的数据
 *
 * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。

 找到所有出现两次的元素。

 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？

 示例：

 输入:
 [4,3,2,7,8,2,3,1]

 输出:
 [2,3]
 通过次数36,573提交次数52,950
 请问您在哪类招聘中遇到此题？

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/find-all-duplicates-in-an-array
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {


    /**
     * 遍历 nums
     * 因为 1 ≤ a[i] ≤ n
     * 遍历到 ai 将 a【ai-1】 改成负数 如果原来的值是正数 说明 之前没有变过 否则就是遍历过
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> doubleTimeElement = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int key = Math.abs(nums[i]) - 1;
            if (nums[key] < 0) {
                doubleTimeElement.add(Math.abs(nums[i]));
            } else {
                nums[key] = -1 * nums[key];
            }
        }
        return doubleTimeElement;
    }


//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        ListNode l1 = ListNodeUtil.stringToListNode("7 -> 2 -> 4 -> 3");
//        ListNode l2 = ListNodeUtil.stringToListNode("5 -> 6 -> 4");
//        ListNode listNode = solution.addTwoNumbers(l1, l2);
//        ListNodeUtil.printListNode(listNode);
//    }
}
