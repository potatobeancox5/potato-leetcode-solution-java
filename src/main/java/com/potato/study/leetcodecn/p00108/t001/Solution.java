package com.potato.study.leetcodecn.p00108.t001;

import com.potato.study.leetcode.domain.TreeNode;
import com.potato.study.leetcode.util.TreePrintUtil;

import java.util.Arrays;

/**
 * 108. 将有序数组转换为二叉搜索树
 *
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。

 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。

  

 示例 1：


 输入：nums = [-10,-3,0,5,9]
 输出：[0,-3,9,-10,null,5]
 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：

 示例 2：


 输入：nums = [1,3]
 输出：[3,1]
 解释：[1,3] 和 [3,1] 都是高度平衡二叉搜索树。
  

 提示：

 1 <= nums.length <= 104
 -104 <= nums[i] <= 104
 nums 按 严格递增 顺序排列

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 递归生成 每次 将数组分成相等的两部分，如果不相等 按照后边比前边多形式拆分
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums);
    }

    /**
     * 有序数字 转换成 树
     * @param nums
     * @return
     */
    private TreeNode buildTree(int[] nums) {
        // 终止条件 nums 只有一个 元素
        if (nums == null || nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        // 偶数个元素 4-2 去 len/2  点 作为开始元素 奇数个元素 使用 len/2 作为开始点 3 - 1
        int index = nums.length / 2;
        TreeNode root = new TreeNode(nums[index]);
        root.left = buildTree(Arrays.copyOfRange(nums, 0, index));
        root.right = buildTree(Arrays.copyOfRange(nums, index + 1, nums.length));
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-10,-3,0,5,9};
        TreeNode node = solution.sortedArrayToBST(nums);
        TreePrintUtil.pirnt(node);
    }
}
