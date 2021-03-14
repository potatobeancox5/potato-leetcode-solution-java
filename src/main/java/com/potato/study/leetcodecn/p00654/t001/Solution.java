package com.potato.study.leetcodecn.p00654.t001;

import com.potato.study.leetcode.domain.TreeNode;

import java.util.Arrays;

/**
 * 654. 最大二叉树
 *
 * 给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下：

 二叉树的根是数组 nums 中的最大元素。
 左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
 右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
 返回有给定数组 nums 构建的 最大二叉树 。

  

 示例 1：


 输入：nums = [3,2,1,6,0,5]
 输出：[6,3,5,null,2,0,null,null,1]
 解释：递归调用如下所示：
 - [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
 - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
 - 空数组，无子节点。
 - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
 - 空数组，无子节点。
 - 只有一个元素，所以子节点是一个值为 1 的节点。
 - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
 - 只有一个元素，所以子节点是一个值为 0 的节点。
 - 空数组，无子节点。
 示例 2：


 输入：nums = [3,2,1]
 输出：[3,null,2,null,1]
  

 提示：

 1 <= nums.length <= 1000
 0 <= nums[i] <= 1000
 nums 中的所有整数 互不相同

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/maximum-binary-tree
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (null == nums || nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            TreeNode node = new TreeNode(nums[0]);
            return node;
        }
        // 找到最大值
        int maxIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        int val = nums[maxIndex];
        TreeNode root = new TreeNode(val);
        int[][] pairPart = getLeftAndRightPartByMaxIndex(nums, maxIndex);
        // 构造左子树
        root.left = constructMaximumBinaryTree(pairPart[0]);
        // 构造右子树
        root.right = constructMaximumBinaryTree(pairPart[1]);
        return root;
    }

    /**
     * 已 maxIndex 将 nums 分割
     * @param nums
     * @param maxIndex
     * @return
     */
    private int[][] getLeftAndRightPartByMaxIndex(int[] nums, int maxIndex) {
        int[][] result = new int[2][];
        if (maxIndex > 0) {
            result[0] = Arrays.copyOfRange(nums, 0, maxIndex);
        } else {
            result[0] = new int[0];
        }
        if (maxIndex + 1 < nums.length) {
            result[1] = Arrays.copyOfRange(nums, maxIndex + 1, nums.length);
        } else {
            result[1] = new int[0];
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] {3,2,1,6,0,5};
        TreeNode node1 = solution.constructMaximumBinaryTree(nums);
//        TreePrintUtil.pirnt(node1);
    }


}
